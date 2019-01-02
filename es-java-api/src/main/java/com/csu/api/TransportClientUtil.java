package com.csu.api;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * Create by @author BG331145 杨威 on 2019/1/2 0002 - 16:31
 */
public class TransportClientUtil {
    public static String CLUSTER_NAME = "elasticsearch";
    public static String HOST_IP = "localhost";
    public static int TCP_PORT = 9300;
    
    private volatile static TransportClient client;
    static Settings settings = Settings.builder()
            .put("cluster.name", CLUSTER_NAME)
            .build();
    
    public static TransportClient getSingleClient() throws UnknownHostException {
        if (Objects.isNull(client)) {
            synchronized (TransportClient.class) {
                client = new PreBuiltTransportClient(settings)
                        .addTransportAddress(new TransportAddress(InetAddress.getByName(HOST_IP), TCP_PORT));
            }
        }
        
        return client;
    }
    
}
