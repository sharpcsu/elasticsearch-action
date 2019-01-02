package com.csu.api;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.action.admin.indices.segments.IndicesSegmentResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

/**
 * Create by @author BG331145 杨威 on 2019/1/2 0002 - 17:22
 */
@Service
public class 索引管理 {
    TransportClient client;
    
    public void method() throws UnknownHostException {
        client = TransportClientUtil.getSingleClient();
    
        IndicesAdminClient indices = client.admin().indices();
        
        //判断索引是否存在
        IndicesExistsResponse indicesExistsResponse = indices.prepareExists("indexName").get();
        
        //判断type是否存在
        TypesExistsResponse typesExistsResponse = indices.prepareTypesExists("indexName").setTypes("t1", "t2").get();
        
        //创建一个索引
        CreateIndexResponse createIndexResponse = indices.prepareCreate("indexName").get();
        
        //创建索引并设置settings
        CreateIndexResponse createIndexResponse1 = indices.prepareCreate("indexName").setSettings(Settings.builder()
                .put("index.number_of_shards", 3)
        ).get();
        
        
    }
}
