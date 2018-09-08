package com.hceris.recorder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfiguration {
    @Value("${serverUrl}")
    private String serverUrl;

    @Bean
    RestTemplate defaultTemplate() {
        RestTemplate template = new RestTemplate();
        return setBaseUrl(template);
    }

    private RestTemplate setBaseUrl(RestTemplate template) {
        DefaultUriBuilderFactory handler = new DefaultUriBuilderFactory(serverUrl);
        template.setUriTemplateHandler(handler);
        return template;
    }
}
