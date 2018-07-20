package com.monster.demo.util;

import javax.net.ssl.SSLContext;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

public class EncryPtHttpClientUtil {
	
	public static void main(String[] args) {
		
		ConnectionSocketFactory plainSF=null;
		LayeredConnectionSocketFactory ssltlsCSF=null;
		

		SSLContext sslContext=SSLContexts.createSystemDefault();
		
		
		SSLConnectionSocketFactory sslsf=new SSLConnectionSocketFactory(sslContext,NoopHostnameVerifier.INSTANCE);
		
		Registry<ConnectionSocketFactory> a=RegistryBuilder.<ConnectionSocketFactory>create().register("http", plainSF).register("https", ssltlsCSF).build();
		
		
		
		
		//new PoolingHttpClientConnectionManager(socketFactoryRegistry);
	}

}
