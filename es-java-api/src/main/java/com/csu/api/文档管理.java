package com.csu.api;

import org.elasticsearch.client.transport.TransportClient;

import java.net.UnknownHostException;

import sun.misc.Cleaner;

/**
 * Create by @author BG331145 杨威 on 2019/1/2 0002 - 17:30
 */
public class 文档管理 {
    TransportClient client;
    
    public void method() throws UnknownHostException {
        client = TransportClientUtil.getSingleClient();
        
        //新建文档
//        client.prepareIndex("")
    }
}
