package com.iflytek.fwpt.hbase;

import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class PeopleRowMapper implements RowMapper<PeopleDto> {

    private static byte[] COLUMNFAMILY = "info".getBytes();
    private static byte[] NAME = "name".getBytes();
    private static byte[] AGE = "age".getBytes();

    @Override
    public PeopleDto mapRow(Result result, int rowNum) throws Exception {
        PeopleDto dto = new PeopleDto();
        // TODO: 设置相关的属性值
        String name = Bytes.toString(result.getValue(COLUMNFAMILY, NAME));
        int age = Integer.valueOf(Bytes.toString(result.getValue(COLUMNFAMILY, AGE)));

        return dto.setName(name).setAge(age);
    }
}