package com.monster.demo.util;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientPoolUtil {
	
	public static void main(String[] args) {
		
		PoolingHttpClientConnectionManager cm=new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(200);
		cm.setDefaultMaxPerRoute(20);
		
		CloseableHttpClient httpClient=HttpClients.custom().setConnectionManager(cm).build();
		
	}

}
