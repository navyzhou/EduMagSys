function openWebSocket(sid) { // sid为当前登录用户的id
	var socket;
	if(typeof(WebSocket) == undefined) {
		console.log("您的浏览器不支持WebSocket");
	}else{
		//实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
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
