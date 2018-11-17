package com.iflytek.fwpt.hbase;

import com.github.inzahgi.spring.boot.starter.hbase.api.HbaseTemplate;
import com.google.common.collect.Lists;
import com.iflytek.fwpt.Application;
import org.apache.commons.lang.CharSet;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.BitComparator;
import org.apache.hadoop.hbase.filter.ColumnCountGetFilter;
import org.apache.hadoop.hbase.filter.ColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.ColumnRangeFilter;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FirstKeyOnlyFilter;
import org.apache.hadoop.hbase.filter.MultiRowRangeFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueExcludeFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.ValueFilter;
import org.apache.hadoop.hbase.protobuf.generated.FilterProtos;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.BeforeClass;
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

    private final static String DAILY_TABLE = "test1";

    private Connection getConn(){
        return hbaseTemplate.getConnection();
    }


    public void printEmpty(){
        System.out.println("\n\n");
    }

    public Table getTable() throws Exception{
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        return table;
    }

    @Test
    public void getTables()throws Exception{
        Connection conn = getConn();
        TableName[] tableNames = conn.getAdmin().listTableNames();
        for (TableName tableName : tableNames){
            System.out.println(tableName.getNameAsString());
        }
    }

    //精确查找rowKey
    @Test
    public void scanBinaryComparatorTest()throws Exception{

        Table table = getTable();
        Scan scan = new Scan();
        scan.setCaching(1000);

        try{
            Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,
                    new BinaryComparator(Bytes.toBytes("user1|te1")));
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //按column range 过滤
    @Test
    public void scanColumnRangeTest()throws Exception{
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan(Bytes.toBytes("user1|te1"),
                Bytes.toBytes("user2|ts6"));
        scan.setCaching(1000);
        scan.addFamily(Bytes.toBytes("sf"));
        try{
//            Filter filter =
//            new ColumnRangeFilter(Bytes.toBytes("000110507991501032_20181108_00000"), true,
//                    Bytes.toBytes("000110507991501032_20181110_99999"), true);
            Filter filter =
                    new ColumnRangeFilter(Bytes.toBytes("c0"), true,
                            Bytes.toBytes("c9"), true);
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //比较行键前缀
    @Test
    public void RowPrefixRangeTest()throws Exception{
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan(Bytes.toBytes("user1|te1"),
                Bytes.toBytes("user2|ts6"));
        scan.setCaching(1000);
        scan.addFamily(Bytes.toBytes("sf"));
        try{
            Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,
                    new BinaryPrefixComparator(Bytes.toBytes("user2")));
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //比较单列值排除过滤
    @Test
    public void singleColumnExcludeValueRangeTest()throws Exception{
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan();
        scan.setCaching(1000);
        scan.addFamily(Bytes.toBytes("sf"));
        try{
            SingleColumnValueExcludeFilter filter = new SingleColumnValueExcludeFilter(
                    Bytes.toBytes("sf"),
                    Bytes.toBytes("c1"), CompareFilter.CompareOp.EQUAL,
                    new BinaryComparator(Bytes.toBytes("sku1")));
            //filter.setFilterIfMissing(true);

                    //RowFilter(CompareFilter.CompareOp.EQUAL,
                    //new BinaryPrefixComparator(Bytes.toBytes("000110507991501032_20181108")));
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //比较单列值过滤
    @Test
    public void singleColumnValueRangeTest()throws Exception{
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan(Bytes.toBytes("user1|te1"),
                Bytes.toBytes("user2|ts6"));
        scan.setCaching(1000);
        scan.addFamily(Bytes.toBytes("sf"));
        try{
            SingleColumnValueFilter filter = new SingleColumnValueFilter(Bytes.toBytes("sf"),
                    Bytes.toBytes("c1"), CompareFilter.CompareOp.EQUAL,
                    Bytes.toBytes("sku1"));
            //true 跳过该行;false 通过该行
            filter.setFilterIfMissing(true);
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //每一行的第一列数据
    @Test
    public void firstKeyRangeTest()throws Exception {
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan(Bytes.toBytes("user1|te1"),
                Bytes.toBytes("user2|ts6"));
        scan.setCaching(1000);
        scan.addFamily(Bytes.toBytes("sf"));
        try {
            FirstKeyOnlyFilter filter = new FirstKeyOnlyFilter();
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void columnPrefixTest()throws Exception {
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan(Bytes.toBytes("user1|te1"),
                Bytes.toBytes("user2|ts6"));
        scan.setCaching(1000);
        scan.addFamily(Bytes.toBytes("sf"));
        try {
            ColumnPrefixFilter filter = new ColumnPrefixFilter(Bytes.toBytes("c"));
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vlaueFilterTest()throws Exception {
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan(Bytes.toBytes("user1|te1"),
                Bytes.toBytes("user2|ts6"));
        scan.setCaching(1000);
        scan.addFamily(Bytes.toBytes("sf"));
        try {
//            Filter filter = new ValueFilter(CompareFilter.CompareOp.EQUAL,
//                    new BinaryComparator(Bytes.toBytes("sku1")));
            Filter filter = new ValueFilter(CompareFilter.CompareOp.EQUAL,
                    new SubstringComparator("ku1"));
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void columnCntFilterTest()throws Exception {
        printEmpty();
        Connection conn = getConn();
        Table table = conn.getTable(TableName.valueOf(DAILY_TABLE));
        Scan scan = new Scan(Bytes.toBytes("user1|te1"),
                Bytes.toBytes("user2|ts6"));
        scan.setCaching(1000);
        scan.addFamily(Bytes.toBytes("sf"));
        try {
            Filter filter = new ColumnCountGetFilter(2);
            ResultScanner rs = table.getScanner(scan.setFilter(filter));
            printRes(rs);
            table.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private void printRes(ResultScanner rs){
        System.out.println("\n\n----start-------");
//        Iterator<Result> iter= rs.iterator();
//        while (iter.hasNext()){
//            Result res = iter.next();
//            if(res.isEmpty()){
//                continue;
//            }
//            System.out.println(Bytes.toString(res.value()));
//
//            Cell[] cells = res.rawCells();
//            for (Cell cell:cells){
//                logger.info("\n\n {}",Bytes.toString(cell.getValueArray()));
//            }
//        }
        for (Result r : rs){
            logger.info("res = {}\n {}", r, Bytes.toString(r.value()));
        }
        System.out.println("---------end--------");
    }


    @Test
    public void getCnt(){
        System.out.println("\n\ncnt = " + getTotalRecord(TableName.valueOf("dqjc_credit_daily")));
    }

    private int getTotalRecord(TableName tableName ){
        int count=0;
        AggregationClient aggregationClient = new AggregationClient(hbaseTemplate.getConfiguration());
        Scan scan=new Scan();
        //scan.setStopRow(nowTime.getBytes());//小于当前时间
        try {
            Long rowCount = aggregationClient.rowCount(tableName, new LongColumnInterpreter(), scan);
            aggregationClient.close();
            count=rowCount.intValue();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return count;
    }


}
