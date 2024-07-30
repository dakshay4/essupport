package com.dakshay;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ElasticServiceImpl {

    private final ElasticsearchClient elasticsearchClient;


    public ElasticServiceImpl(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }


    public HitsMetadata<Article> search(String query) {
        SearchResponse<Article> search = null;
        try {
            search = elasticsearchClient.search(s -> s
                            .index("")
                            .query(q -> q
                                    .term(t -> t
                                            .field(Article.Fields.title)
                                            .value(v -> v.stringValue(query))
                                    )),
                    Article.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return search.hits();
    }


}
