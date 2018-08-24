1.环境需要jdk1.8或以上

SpringBoot项目的Bean装配默认规则是根据Application类所在的包位置从上往下扫描！
"Application类"是指SpringBoot项目入口类。这个类的位置很关键：
	如果Application类所在的包为：com.yc.springboot,则只会扫描com.yc.springboot包及其所有子包，如果service或dao所在包不在com.yc.springboot及其子包下，则不会被扫描！
	即, 把Application类放到dao、service所在包的上级com.yc.springboot知道这一点非常关键，不知道spring文档里有没有给出说明，如果不知道还真是无从解决。
	
	
spring boot因为内嵌tomcat容器，所以可以通过打包为jar包的方法将项目发布，但是如何将spring boot项目打包成可发布到tomcat中的war包项目呢？
第 1 步：将这个 Spring Boot 项目的打包方式设置为 war。
第 2 步：修改pom.xml， SpringBoot 默认有内嵌的 tomcat 模块，因此，我们要把这一部分排除掉。 
 	即：我们在 spring-boot-starter-web 里面排除了 spring-boot-starter-tomcat ，但是我们为了在本机测试方便，我们还要引入它，所以我们这样写：
<dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <!-- 打包部署到tomcat上面时，不需要打包tmocat相关的jar包，否则会引起jar包冲突 -->
      <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>
第 3 步：提供一个 SpringBootServletInitializer 子类，并覆盖它的 configure 方法。我们可以把应用的主类改为继承 SpringBootServletInitializer。或者另外写一个类。
注意：部署到 tomcat 以后，访问这个项目的时候，须要带上这个项目的 war 包名。 
 另外，我们还可以使用 war 插件来定义打包以后的 war 包名称，以免 maven 为我们默认地起了一个带版本号的 war 包名称。例如：
 <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <configuration>
        <warName>SpringBoot02</warName>
    </configuration>
</plugin>


添加websocket实现单点登录
1、添加依赖包
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-websocket</artifactId>
    </dependency>

 2、启用websocket的支持
 package com.yc.edusys.websocket;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import com.yc.edusys.util.LogUtil;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ServerEndpoint("/websocket/{sid}")
@Component  // 成分、组件
public class WebSocketServer {
	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	
	//用来存放每个客户端对应的WebSocket对象。
	private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	//接收sid
	private String sid="";
	
	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session,@PathParam("sid") String sid) {
		this.sid=sid;
		this.session = session;
		webSocketSet.add(this);     //加入set中
		addOnlineCount();           //在线数加1
		LogUtil.log.info("有新窗口开始监听:"+sid+",当前在线人数为" + getOnlineCount());
		
		try {
			sendMessage("连接成功...");
		} catch (IOException e) {
			LogUtil.log.error("websocket IO异常");
		}
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);  //从set中删除
		subOnlineCount();           //在线数减1
		LogUtil.log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		LogUtil.log.info("收到来自窗口"+sid+"的信息:"+message);
		//群发消息
		for (WebSocketServer item : webSocketSet) {
			try {
				item.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		LogUtil.log.error("发生错误");
		error.printStackTrace();
	}
	
	/**
	 * 实现服务器主动推送
	 */
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	/**
	 * 群发自定义消息
	 */
	public static void sendInfo(String message,@PathParam("sid") String sid) throws IOException {
		LogUtil.log.info("推送消息到窗口"+sid+"，推送内容:"+message);
		for (WebSocketServer item : webSocketSet) {
			try {
				//这里可以设定只推送给这个sid的，为null则全部推送
				if(sid==null) {
					item.sendMessage(message);
				}else if(item.sid.equals(sid)){
					item.sendMessage(message);
				}
			} catch (IOException e) {
				continue;
			}
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}

	public static WebSocketServer getWebSocket(String sid) {
		if (webSocketSet == null || webSocketSet.size() <= 0) {
			return null;
		}
		
		for (WebSocketServer item : webSocketSet) {
			if (sid.equals(item.sid)) {
				return item;
			}
		}
		return null;
	}
}
3、当用户登录成功后，发送连接信息
function openWebSocket(sid) {
	var socket;
	if(typeof(WebSocket) == undefined) {
		console.log("您的浏览器不支持WebSocket");
	}else{
		//实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
		//socket = new WebSocket("ws://localhost:9094/starManager/websocket/张三"

		socket = new WebSocket("ws://127.0.0.1:8080/EduMagSys/websocket/"+sid);

		//打开事件
		socket.onopen = function() {
			console.log("Socket 已打开");
			//socket.send("这是来自客户端的消息" + location.href + new Date());
		};

		//获得消息事件
		socket.onmessage = function(msg) {
			if (msg.data == "101") {
				alert("对不起，你的账号已经在其它地方登录，若非本人操作，请及时更换密码...");
				location.href="../login.html";
				return;
			}
			//发现消息进入    调后台获取
			getCallingList();
		};

		//关闭事件
		socket.onclose = function() {
			console.log("Socket已关闭");
		};

		//发生了错误事件
		socket.onerror = function() {
			alert("Socket发生了错误");
		};

		$(window).unload(function(){
			socket.close();
		});
	}
}

4、用户登录时，判断该用户是否已经登录
WebSocketServer wss = WebSocketServer.getWebSocket(String.valueOf(adminInfo.getAid()));
if (wss != null) { // 如果已经登录，则发送挤退信息
	try { 
		wss.sendMessage("101");
	} catch (IOException e) {
		e.printStackTrace();
	}
}
 