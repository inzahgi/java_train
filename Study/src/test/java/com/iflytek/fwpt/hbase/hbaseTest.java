package com.iflytek.fwpt.hbase;

import com.google.common.collect.Lists;
import com.iflytek.fwpt.Application;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class hbaseTest {

    @Autowired
    private QueryService queryService;

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Test
    public void testScan(){
        System.out.println("\n\n\n\n\n--------------start---------");
        List<PeopleDto> pList = queryService.query("1540802975130", "1540802975150");
        for (PeopleDto p : pList){
            System.out.println(p);
        }
        System.out.println("\n\n\n\n\n ------------ end------------");
    }

    @Test
    public void testOne() throws Exception{
        TableName tableName = TableName.valueOf("credit_daily");
        Table table = hbaseTemplate.getConnection().getTable(tableName);
        Scan scan = new Scan();
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> iter = rs.iterator();
        List<Delete> deleteList = Lists.newArrayList();
        while (iter.hasNext()){
            Result res = iter.next();
            System.out.println(Bytes.toString(res.getRow()));
            System.out.println(res.toString());
            Delete delete = new Delete(res.getRow());
            deleteList.add(delete);
        }

        if(deleteList.size() > 0) {
            table.delete(deleteList);

        }
    }


    @Test
    public void testInsert(){
        List<Mutation> puts = Lists.newArrayList();
        long curUtcTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {

            Put put = new Put(Bytes.toBytes(String.valueOf(curUtcTime + i)));

            put.addColumn("info".getBytes(), "age".getBytes(), Bytes.toBytes(String.valueOf(random.nextInt(100))));
            put.addColumn("info".getBytes(), "name".getBytes(), UUID.randomUUID().toString().getBytes());

            puts.add(put);
        }
        this.hbaseTemplate.saveOrUpdates("credit_daily", puts);

        List<PeopleDto> pList = queryService.batchQuery(null,null);
        System.out.println("\n\n\n\n\n--------------start---------");
        for (PeopleDto p : pList){
            System.out.println(p);
        }
        System.out.println("\n\n\n\n\n ------------ end------------");

    }

    @Test
    public void testQuery(){

    }

}
