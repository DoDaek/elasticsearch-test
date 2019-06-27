package com.taek.elasticsearchtest.elasticsearchtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taek.elasticsearchtest.elasticsearchtest.api.ElasticSearchAPI;
import com.taek.elasticsearchtest.elasticsearchtest.domain.ElasticSearchData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTestApplicationTests {
	@Autowired
	ElasticSearchAPI elasticSearchAPI;

	@Test
	public void 엘라스틱서치_POST_테스트() throws IOException, NoSuchAlgorithmException {
		String id = "TAEK";
		String url = "/test/searchData/" + id;
		ElasticSearchData elasticSearchData = new ElasticSearchData(id, "C:/Users/user/Downloads/elasticsearch-7.2.0.msi");
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(elasticSearchData);
		Map<String, Object> result = elasticSearchAPI.callElasticSearchApi("POST", url, jsonData);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}

	@Test
	public void 앨라스틱서치_GET_전송() {
		String id = "TAEK";
		String url = "/test/searchData/" + id;
		Map<String, Object> result = elasticSearchAPI.callElasticSearchApi("GET", url, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}
}
