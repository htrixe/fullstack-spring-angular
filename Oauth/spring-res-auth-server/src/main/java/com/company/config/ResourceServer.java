package com.company.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
class ResourceServer extends ResourceServerConfigurerAdapter {

	// Here we are configuring the URL pattern and the access scope as 'read'.
	// Client application can send requests that match with this URL pattern to get
	// read only access to that resource

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/user/getImagesList/**").and().authorizeRequests().anyRequest()
				.access("#oauth2.hasScope('read')");
	}
}