package com.taek.elasticsearchtest.elasticsearchtest.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchAPI {
    @Value ("${elasticsearch.host}")
    private String host;
    @Value ("${elasticsearch.port}")
    private int port;


}
