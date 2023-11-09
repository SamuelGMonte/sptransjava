package com.sptrans.BuSearcher.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.stream.Collectors;
@Service
public class Auth {
    @Value("${api.url}")
    private String base_url;
    @Autowired
    RestTemplate restTemplate = new RestTemplate();
    public static HttpEntity<String> entity;

    public HttpEntity<String> authenticate(String token) {
        try {
            String url = base_url + "/Login/Autenticar?token=" + token;
            ResponseEntity<String> forEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Cookie", forEntity.getHeaders().get("Set-Cookie").stream().collect(Collectors.joining(";")));
            return new HttpEntity<>(headers);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Handle exceptions here (e.g., log the error, throw a custom exception)
            e.printStackTrace();
            throw new RuntimeException("Authentication failed");
        }

    }



}
