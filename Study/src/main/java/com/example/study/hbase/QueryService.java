package com.example.study.hbase;

import com.github.inzahgi.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class QueryService {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    public List<PeopleDto> batchQuery(String startRow, String endRow) {
        Scan scan = null;
        if(StringUtils.isNotEmpty(startRow) && StringUtils.isNotEmpty(endRow)) {
            scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(endRow));
        }else {
            scan = new Scan();
        }
        scan.setCaching(5000);
        List<PeopleDto> dtos = this.hbaseTemplate.find("people_table", scan, new PeopleRowMapper());
        return dtos;
    }

    public List<PeopleDto> query(String startRow, String stopRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow));
        scan.setCaching(5000);
        List<PeopleDto> dtos = this.hbaseTemplate.find("people_table", scan, new PeopleRowMapper());
        return dtos;
    }

    public PeopleDto query(String row) {
        PeopleDto dto = this.hbaseTemplate.get("people_table", row, new PeopleRowMapper());
        return dto;
    }

    public void saveOrUpdates() {
        List<Mutation> puts = new ArrayList<>();
        // 设值
        Put put = new Put(Bytes.toBytes(String.valueOf(System.currentTimeMillis())));
        Random random = new Random();
        put.addColumn("info".getBytes(), "age".getBytes(), Bytes.toBytes(random.nextInt(100) + 1));
        put.addColumn("info".getBytes(), "name".getBytes(), UUID.randomUUID().toString().getBytes());

        puts.add(put);
        this.hbaseTemplate.saveOrUpdates("people_table", puts);
    }

    public void saveOrUpdateForOne() {
        Mutation delete = new Delete(Bytes.toBytes(""));
        this.hbaseTemplate.saveOrUpdate("people_table", delete);
    }

    public void saveOrUpdateForList() {
        List<Mutation> saveOrUpdates = new ArrayList<>();
        Put put = new Put(Bytes.toBytes("135xxxxxx"));
        put.addColumn(Bytes.toBytes("people"), Bytes.toBytes("name"), Bytes.toBytes("JThink"));
        saveOrUpdates.add(put);

        Delete delete = new Delete(Bytes.toBytes("136xxxxxx"));
        saveOrUpdates.add(delete);

        // 继续add

        this.hbaseTemplate.saveOrUpdates("people_table", saveOrUpdates);
    }
}