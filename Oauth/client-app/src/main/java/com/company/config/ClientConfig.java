package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableOAuth2Client
@Configuration
class ClientConfig extends ResourceServerConfigurerAdapter {

    @Bean
    protected AuthorizationCodeAccessTokenProvider provider() {
    	AuthorizationCodeAccessTokenProvider provider = new AuthorizationCodeAccessTokenProvider();

    	provider.setStateMandatory(false);
    	
        return provider;
    }
    
}