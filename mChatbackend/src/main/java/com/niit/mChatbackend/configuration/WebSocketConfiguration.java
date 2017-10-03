package com.niit.mChatbackend.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages="com.niit")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

	public void configureClientInboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void configureClientOutboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// TODO Auto-generated method stub
		

		registry.enableSimpleBroker("/queue/","/topic/");
		registry.setApplicationDestinationPrefixes("/app");
	}

	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addEndpoint("/portfolio").withSockJS();
	}

	
/*	public void registerStompEndpoints(StompEndpointResgistry registry){
		
	System.out.println(""inside registery stomp);
	
	registry.addEndpoint("/portfolio").withSockJS();
	
	}

	public void configureClientInboundChannel(ChannelRegistration registration){
		
	}
	
	public void configureClientOutboundChannel(ChannelRegistration registration){
		
		
	}
	
	public void configureMessageBroker(MessageBrokerRegistry registry){
		
		System.out.println("CONFIGURE MESSAGE BROKER");
		
		registry.enableSimpleBroker("/queue/","/topic/");
		registry.setApplicationDestinationPrefixes("/app");
		
	}
*/
	
}
