package com.taek.elasticsearchtest.elasticsearchtest.api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ElasticSearchAPI {

    public Map<String, Object> callElasticSearchApi(String method, String url, String jsonData) {
        Map<String, Object> result = new HashMap<>();

        try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build()){
            Response response;
            Request request = new Request(method, url);

            if (method.equals("GET") || method.equals("DELETE")) {
                request.addParameter("pretty", "true");
                response = restClient.performRequest(request);
            } else {
                HttpEntity entity = new NStringEntity(jsonData, ContentType.APPLICATION_JSON);
                request.setEntity(entity);
                response = restClient.performRequest(request);
            }

            int statusCode = response.getStatusLine().getStatusCode();

            String responseBody = EntityUtils.toString(response.getEntity());
            result.put("resultCode", statusCode);
            result.put("resultBody", responseBody);
        } catch (IOException e) {
            result.put("resultCode", -1);
            result.put("resultBody", e.toString());
        }

        return result;
    }

}
