package com.iflytek.fwpt.hbase;

import com.github.inzahgi.spring.boot.starter.hbase.api.HbaseTemplate;
import com.google.common.collect.Lists;
import com.iflytek.fwpt.Application;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.BitComparator;
import org.apache.hadoop.hbase.filter.ColumnRangeFilter;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class HbaseNewTest {

    private final static Logger logger = LoggerFactory.getLogger(HbaseNewTest.class);

    @Autowired
    private HbaseTemplate hbaseTemplate;

    private final static String DAILY_TABLE = "dqjc_credit_daily";

    private Connection getConn(){
        return hbaseTemplate.getConnection();
    }


    public void printEmpty(){
        System.out.println("\n\n");
    }

    @Test
    public void getTables()throws Exception{
        Connection conn = getConn();
        TableName[] tableNames = conn.getAdmin().listTableNames();
        for (TableName tableName : tableNames){
            System.out.println(tableName.getNameAsString());
        }
    }

    @Test
    public void scanTest()throws Exception{
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan();
        scan.setCaching(1000);
        try{
            Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,
                    new BinaryComparator(Bytes.toBytes("000110507991501032_20181109_00000")));
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            Iterator<Result> iter= rs.iterator();
            while (iter.hasNext()){
                Result res = iter.next();
                if(res.isEmpty()){

                    continue;
                }
                System.out.println(Bytes.toString(res.value()));

                Cell[] cells = res.rawCells();
                for (Cell cell:cells){
                    logger.info("\n\n {}",Bytes.toString(cell.getValueArray()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void scanOneTest()throws Exception{
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan();
        scan.setCaching(1000);
        try{
            Filter filter =
            new ColumnRangeFilter(Bytes.toBytes("000110507991501032_20181108_00000"), true,
                    Bytes.toBytes("000110507991501032_20181110_99999"), true);
            ResultScanner rs = table.getScanner(scan.setFilter(filter));

            Iterator<Result> iter= rs.iterator();
            while (iter.hasNext()){
                Result res = iter.next();
                if(res.isEmpty()){

                    continue;
                }
                System.out.println(Bytes.toString(res.value()));

                Cell[] cells = res.rawCells();
                for (Cell cell:cells){
                    logger.info("\n\n {}",Bytes.toString(cell.getValueArray()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private void printRes(){

    }


}
