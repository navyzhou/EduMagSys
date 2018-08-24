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