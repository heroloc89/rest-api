package com.example.restapi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "loc")
public class LodaAppProperties {
	private String email;
	private String googleAnalyticsId;
}
