package com.dakshay;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }



    @Bean
    public ElasticsearchClient elasticsearchClient() {
        String serverUrl = "https://localhost:9200";
        String apiKey = "bkxsNFFaQUJLUlg2Z3NTTFFYOG86SGtFWnowQUtUektIZm1nWXpTSXkwUQ==";

// Create the low-level client
        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .build();

// Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

// And create the API client
        return new ElasticsearchClient(transport);
    }
}