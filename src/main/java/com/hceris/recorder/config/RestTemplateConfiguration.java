package com.hceris.recorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    RestTemplate defaultTemplate() {
        RestTemplate template = new RestTemplate();
        return setBaseUrl(template);
    }

    private RestTemplate setBaseUrl(RestTemplate template) {
        DefaultUriBuilderFactory handler = new DefaultUriBuilderFactory("http://localhost:8080");
        template.setUriTemplateHandler(handler);
        return template;
    }
}
