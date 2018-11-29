package com.perfectsolution.Clinique.Configs;

import org.springframework.context.annotation.*;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer
{
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint(new String[] { "/ws" }).setAllowedOrigins(new String[] { "*" }).withSockJS();
    }
}
