package com.example.demo.Service;


import com.example.demo.model.Transaction;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {

    private final String URI = "http://localhost:8081/api/transactions";
    public String getMsg(){
        RestTemplate restTemplate = new RestTemplate();
        String msg = restTemplate.getForObject(URI+"/test", String.class);
        return msg;
    }

    public ResponseEntity<Transaction> save(Transaction transaction){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Transaction> transaction1 = restTemplate.postForEntity(URI, transaction, Transaction.class);
        return transaction1;
    }

    public List<Transaction> getAll(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List> listHttpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI+"/test", HttpMethod.GET,listHttpEntity, List.class).getBody();
    }
    public Transaction saveExch(Transaction transaction){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Transaction> listHttpEntity = new HttpEntity<>(transaction, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI, HttpMethod.POST,listHttpEntity, Transaction.class).getBody();
    }
    public Transaction update(Transaction transaction){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Transaction> listHttpEntity = new HttpEntity<>(transaction, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI, HttpMethod.PUT,listHttpEntity, Transaction.class).getBody();
    }
}
