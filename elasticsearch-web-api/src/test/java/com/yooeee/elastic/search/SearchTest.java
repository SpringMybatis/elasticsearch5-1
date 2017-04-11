package com.yooeee.elastic.search;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.xcontent.*;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.ScriptSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortMode;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/6.
 */
public class SearchTest {

    private static final Logger logger = LoggerFactory.getLogger(SearchTest.class);

    private TransportClient client;

    @Before
    public void setUp() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.0.215"), 9300));
    }


    @After
    public void tearDown() {
        client.close();
    }


    @Test
    public void testGet() throws UnknownHostException {

        GetResponse response = client.prepareGet("merchants", "merchant", "159").get();
        String sss = Strings.toString(response, false);
        System.out.println(sss);


    }


    @Test
    public void multiGet() {
        MultiGetResponse multiGetItemResponses = client.prepareMultiGet()
                .add("merchants", "merchant", "159", "158", "192", "249")
                .get();

        for (MultiGetItemResponse itemResponse : multiGetItemResponses) {
            GetResponse response = itemResponse.getResponse();
            if (response.isExists()) {
                String json = response.getSourceAsString();
                System.out.println("=======================");
                System.out.println(json);
            }
        }
    }


    @Test
    public void searchTemplate() {

        Map<String,Object> scriptMap = new HashMap<>();
        scriptMap.put("time",44444);

        QueryBuilder queryBuilder = QueryBuilders
                .boolQuery()
                .must(QueryBuilders.matchQuery("name", "国际"))
                .filter(QueryBuilders.geoDistanceQuery("location").distance("20000km").point(-70d, 40d));
        SearchResponse searchResponse = client
                .prepareSearch("merchants")
                .addSort(SortBuilders.geoDistanceSort("location",new GeoPoint(-70d,40d)).sortMode(SortMode.MIN).unit(DistanceUnit.KILOMETERS).order(SortOrder.DESC))
                .addSort(SortBuilders.scriptSort(new Script(ScriptType.INLINE,"painless","(params.time>doc['startTime'].value && params.time < doc['endTime'].value)?doc['fx'].value:doc['tsfx'].value",scriptMap), ScriptSortBuilder.ScriptSortType.NUMBER))
                .setQuery(queryBuilder)
                .execute()
                .actionGet();

        SearchHits searchHits = searchResponse.getHits();
        System.out.println("-----------------boolQuery---------------------");
        System.out.println("共匹配到:" + searchHits.getTotalHits() + "条记录!");


        System.out.println(searchResponse);

        SearchHit[] hits = searchHits.getHits();
        for (SearchHit searchHit : hits) {
            Map<String, Object> sourceAsMap = searchHit.sourceAsMap();

            Set<String> keySet = sourceAsMap.keySet();
            for (String string : keySet) {
                System.out.println(""+string+":"+sourceAsMap.get(string));
            }
            System.out.println();
        }




    }

    @Test
    public  void testJson() throws IOException {
        XContentBuilder json = XContentFactory.jsonBuilder().prettyPrint()
                .startObject()
                .field("id").value("2123")
                .field("lastCommentTime", new Date())
                .nullField("published")
                .field("chapters").map(new HashMap<>())
                .field("title", "Mastering ElasticSearch")
                .array("tags", "search", "ElasticSearch", "nosql")
                .field("values")
                .startArray()
                .value(1)
                .value(10)
                .endArray()
                .endObject();


        System.out.println(json.string());
    }


}
