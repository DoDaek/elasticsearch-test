package com.taek.elasticsearchtest.elasticsearchtest.api;

import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ElasticSearchAPI {

    private RestClient restClient;

    public Map<String, Object> callElasticSearchApi(String method, String url, String jsonData) {
        return null;
    }

}
