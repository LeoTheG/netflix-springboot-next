package com.leonargharib.netflix.MediaItem;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdBaseUrlProvider implements BaseUrlProvider {

    @Override
    public String getBaseUrl() {
        return "https://leog-netflix-backend.fly.dev";
    }
}