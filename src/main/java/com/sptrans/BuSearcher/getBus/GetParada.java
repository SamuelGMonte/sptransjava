package com.sptrans.BuSearcher.getBus;

import com.sptrans.BuSearcher.api.Auth;
import com.sptrans.BuSearcher.model.Parada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@RestController
public class GetParada {
    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.token}")
    private String token;
    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    Auth auth = new Auth();
    @GetMapping("/parada")
    public Parada[] getParada(@RequestParam String param) {
        String url = apiUrl + "/Parada/Buscar?termosBusca=" + param;
        HttpEntity<String> authEntity = auth.authenticate(this.token);
        ResponseEntity<Parada[]> response = restTemplate.exchange(url, HttpMethod.GET, authEntity, Parada[].class);

        return response.getBody();

    }


}
