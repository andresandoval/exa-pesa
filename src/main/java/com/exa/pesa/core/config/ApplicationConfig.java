package com.exa.pesa.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Andres on 28/10/2017.
 */
@ConfigurationProperties(prefix = "exa")
@Configuration
public class ApplicationConfig {

    private Integer siteId;
    private String[] clientOrigin;
    private String[] clientAllowedMethods;
    private String clientAllowedPattern;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String[] getClientOrigin() {
        return clientOrigin;
    }

    public void setClientOrigin(String[] clientOrigin) {
        this.clientOrigin = clientOrigin;
    }

    public String[] getClientAllowedMethods() {
        return clientAllowedMethods;
    }

    public void setClientAllowedMethods(String[] clientAllowedMethods) {
        this.clientAllowedMethods = clientAllowedMethods;
    }

    public String getClientAllowedPattern() {
        return clientAllowedPattern;
    }

    public void setClientAllowedPattern(String clientAllowedPattern) {
        this.clientAllowedPattern = clientAllowedPattern;
    }
}
