package com.ews.idc_rest_client.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

@Configuration
public class RestTemplateConfig {

    @Value("${service.client.keyStore}")
    String keyStore;

    @Value("${service.client.keyStorePassword}")
    String keyStorePassword;

    @Bean
    public RestTemplate restTemplate() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {

        KeyStore clientStore = KeyStore.getInstance(KeyStore.getDefaultType());

        InputStream keyStoreStream = getClass().getClassLoader().getResourceAsStream(keyStore);

        clientStore.load(keyStoreStream, keyStorePassword.toCharArray());

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadKeyMaterial(clientStore, keyStorePassword.toCharArray())
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLContext(sslContext)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplate(requestFactory);
    }

}
