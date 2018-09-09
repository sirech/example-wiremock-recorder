package com.hceris.recorder.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MockServerInitializer {
    @Value("${mock.active}")
    boolean active;

    @Value("${mock.port}")
    int port;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(active) {
            WireMockServer server = new WireMockServer(port);
            server.start();
        }
    }
}
