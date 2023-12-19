package com.company.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.company.model.Image;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class ImageController {

	@Autowired
	AuthorizationCodeAccessTokenProvider provider;

	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@RequestMapping(value = "/getImages", method = RequestMethod.GET)
	public ModelAndView getImageInfo() {
		return new ModelAndView("getImages");
	}

	@RequestMapping(value = "/showImages", method = RequestMethod.GET)
	public ModelAndView showImages(@RequestParam("code") String code) throws JsonProcessingException, IOException {

		System.out.println("Authorization Ccode------" + code);

		RestTemplate restTemplate = new RestTemplate();

		OAuth2ProtectedResourceDetails details = resourceDetails();
		AccessTokenRequest accessTokenRequest = new DefaultAccessTokenRequest();
		accessTokenRequest.setAuthorizationCode(code);

		OAuth2AccessToken oAuth2AccessToken = provider.obtainAccessToken(details, accessTokenRequest);

		System.out.println("Access Token Response ---------" + oAuth2AccessToken);

		String url = "http://localhost:8080/user/getImagesList";

		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + oAuth2AccessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers1);

		ResponseEntity<Image[]> images = restTemplate.exchange(url, HttpMethod.GET, entity, Image[].class);
		
		Image[] imageArray = images.getBody();

		ModelAndView model = new ModelAndView("showImages");
		System.out.println("Images : "+Arrays.asList(imageArray));
		model.addObject("images", Arrays.asList(imageArray));
		return model;

	}

	private OAuth2ProtectedResourceDetails resourceDetails() {

		AuthorizationCodeResourceDetails authorizationCodeResourceDetails = new AuthorizationCodeResourceDetails();
		authorizationCodeResourceDetails.setClientId("photoclient");
		authorizationCodeResourceDetails.setClientSecret("clientsecret");
		authorizationCodeResourceDetails.setAccessTokenUri("http://localhost:8080/oauth/token");
		authorizationCodeResourceDetails.setPreEstablishedRedirectUri("http://localhost:8081/showImages");
		return authorizationCodeResourceDetails;
	}
}