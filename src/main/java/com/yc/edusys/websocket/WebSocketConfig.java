package com.yc.edusys.websocket;

import org.springframework.context.annotation.Configuration;

/**
 * 开启WebSocket支持
 * @author navy
 * @company 源辰信息
 * 使用@SpringBootApplication启动类进行启动时需要下面这段代码，但生成war包部署在tomcat中不需要这段
 */
@Configuration
public class WebSocketConfig {
//	@Bean
//	public ServerEndpointExporter serverEndpointExporter() {
//		return new ServerEndpointExporter();
//	}
}
