package com.sptrans.BuSearcher.getBus;

import com.sptrans.BuSearcher.api.Auth;
import com.sptrans.BuSearcher.model.Linha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class GetLinha {
    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.token}")
    private String token;
    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    Auth auth = new Auth();

    @GetMapping("/linhas")
    public Linha[] getLinhas(@RequestParam String param) {

        String url = apiUrl + "/Linha/Buscar?termosBusca=" + param;
        HttpEntity<String> authEntity = auth.authenticate(this.token);
        ResponseEntity<Linha[]> response = restTemplate.exchange(url, HttpMethod.GET, authEntity, Linha[].class);

        return response.getBody();
    }
}
