package com.ynz.oauth2demo;

import com.ynz.oauth2demo.invoker.GuestServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;

@SpringBootApplication
@EnableOAuth2Client
@Slf4j
public class GuestAppApplication {
    private static final String AUTH_TOKEN_URL = "/oauth/token";

    @Value("${guests.host}")
    private String guestServiceHost;

    @Autowired
    private GuestServiceClient client;

    public static void main(String[] args) {
        SpringApplication.run(GuestAppApplication.class, args);
    }

    @Bean
    public OAuth2RestTemplate restTemplate() {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setAccessTokenUri(guestServiceHost + AUTH_TOKEN_URL);
        resourceDetails.setClientId("guest_app");
        resourceDetails.setClientSecret("secret");
        resourceDetails.setGrantType("client_credentials");
        resourceDetails.setScope(Arrays.asList("READ_ALL_GUESTS", "WRITE_GUEST", "UPDATE_GUEST"));
        resourceDetails.setAuthenticationScheme(AuthenticationScheme.form);
        AccessTokenRequest request = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resourceDetails, new DefaultOAuth2ClientContext(request));
    }

}
