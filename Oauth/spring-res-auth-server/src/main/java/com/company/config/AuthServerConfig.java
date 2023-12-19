package com.company.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	// Here we are registering the client details with the Auth server
	
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("photoclient").secret("{noop}clientsecret").authorizedGrantTypes("authorization_code")
            .scopes("read").authorities("CLIENT").redirectUris("http://localhost:8081/showImages");
    }
}