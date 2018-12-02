package com.jajian.search.common;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class ElasticSearchConfig {

    @Value("${elasticSearch.host}")
    private String[] ipAddress;
    @Value("${elasticSearch.maxRetryTimeout}")
    private Integer maxRetryTimeout;
    @Value("${elasticSearch.sql.host}")
    private String[] esSqlAddress;

    @Bean
    public TransportClient transportClient() {

        Settings settings = Settings.builder()
                // 不允许自动刷新地址列表
                .put("client.transport.sniff", false)
                .put("client.transport.ignore_cluster_name", true)
                .build();

        // 初始化地址
        TransportAddress[] transportAddresses = new TransportAddress[esSqlAddress.length];
        for (int i = 0; i < esSqlAddress.length; i++) {
            String[] addressItems = esSqlAddress[i].split(":");
            try {
                transportAddresses[i] = new InetSocketTransportAddress(InetAddress.getByName(addressItems[0]),
                        Integer.valueOf(addressItems[1]));
            } catch (Exception e) {
//                throw new EsOperationException(e);
            }
        }

        PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(settings);

        TransportClient client = preBuiltTransportClient
                .addTransportAddresses(transportAddresses);
        return client;
    }

    public String[] getEsSqlAddress() {
        return esSqlAddress;
    }

    public void setEsSqlAddress(String[] esSqlAddress) {
        this.esSqlAddress = esSqlAddress;
    }
}