package com.ludisy.ludisygateway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("v1/api")
public class GatewayController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/welcome")
    public String welcome() {
       return "Welcome at Ludisy!";
    }

    @GetMapping("/secure")
    public String secure() {
        return "Secured page!";
    }


    @GetMapping("/loginSuccess")
    public String getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService
                .loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());

        String userInfoEndpointUri = client.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUri();

        Map userAttributes = new HashMap();
        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
                    .getTokenValue());
            HttpEntity entity = new HttpEntity("", headers);
            ResponseEntity <Map>response = restTemplate
                    .exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            userAttributes = response.getBody();
            model.addAttribute("name", userAttributes.get("name"));
        }

        return "loginSuccess:" + userAttributes.get("name") ;
    }

}
