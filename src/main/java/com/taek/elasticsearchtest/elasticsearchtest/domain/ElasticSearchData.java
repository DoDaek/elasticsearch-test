package com.taek.elasticsearchtest.elasticsearchtest.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data
public class ElasticSearchData {
    @Id
    private String id;
    private String fileName;
    private String filePath;
    // MD5 Hash value in here
    private String md5Hash;
    private Metadata metadata;

    @Data
    public static class Metadata {
        // Metadata's values in here
    }

    public ElasticSearchData() { }
    public ElasticSearchData(String id, String filePath) throws IOException, NoSuchAlgorithmException {
        setId(id);
        setFilePath(filePath);
        init();
    }

    private void init() throws IOException, NoSuchAlgorithmException {
        File file = new File(getFilePath());
        setMd5Hash(ElasticSearchData.generate(file));
    }

    private static String generate(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(Files.readAllBytes(file.toPath()));
        byte[] hash = messageDigest.digest();
        return DatatypeConverter.printHexBinary(hash).toUpperCase();
    }
}
