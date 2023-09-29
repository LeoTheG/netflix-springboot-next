package com.leonargharib.netflix.MediaItem;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class DevBaseUrlProvider implements BaseUrlProvider {

    @Override
    public String getBaseUrl() {
        return "http://localhost:8080";
    }
}
