package com.taek.elasticsearchtest.elasticsearchtest.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ElasticSearchData {
    @Id
    private String id;
    private String fileName;
    private String filePath;
    // MD5 Hash value in here
    private Metadata metadata;

    @Data
    public static class Metadata {
        // Metadata's values in here
    }
}
