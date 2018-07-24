package com.monster.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class HttpClientPoolUtil {
	
	public static void main(String[] args) {
		
		PoolingHttpClientConnectionManager cm=new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(200);
		cm.setDefaultMaxPerRoute(20);
		
		HttpClientBuilder httpClientBuilder=HttpClients.custom();
		httpClientBuilder.setConnectionManager(cm);
		httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
		
		List<Header> defaultHeaders=new ArrayList<>();
		defaultHeaders.add(new BasicHeader("User-Agent", ""));
		defaultHeaders.add(new BasicHeader("", ""));
		httpClientBuilder.setDefaultHeaders(defaultHeaders);
		
		
		//CloseableHttpClient httpClient=HttpClients.custom().setConnectionManager(cm).build();
		HttpClient httpClient=httpClientBuilder.build();
		
		new HttpComponentsClientHttpRequestFactory(httpClient);
		
		RestTemplate template=new RestTemplate();
		//template.setRequestFactory(requestFactory);
		
		
	}

}
