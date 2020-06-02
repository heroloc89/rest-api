package com.example.restapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@Getter
@Setter
public class GoogleDriveConfig {
    @Value("${google.oauth.callback.uri}")
    private String callback_uri;

    @Value("${google.secret.key}")
    private Resource driveSecretKey;

    @Value("${google.client.id}")
    private Resource driveClientId;

    @Value("${google.credentials.folder.path}")
    private Resource credentialsFolder;

    @Value("${myapp.temp.path}")
    private String temporaryFolder;
}
