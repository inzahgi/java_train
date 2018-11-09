package com.iflytek.fwpt.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ListIterator;
import java.util.Map;

public class JsoupUtil {

    public static Table<String, String, String> getPcStation(String filePath) {
        File input = new File(filePath);
        return getPcStation(input);
    }

    public static Table<String, String, String> getPcStation(File file) {
        Table<String, String, String> table = HashBasedTable.create();
        Preconditions.checkArgument(file.exists()&& file.isFile());
        //Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        try {
            Document doc = Jsoup.parse(file, "UTF-8");


            Element content = doc.getElementById("bo");
            String area = content.selectFirst("strong").text().trim();
            ListIterator<Element> li = content.select("tr").listIterator();
            boolean flag = false;
            while (li.hasNext()) {
                Element e = li.next();
                if (e.getElementsByAttributeValue("colspan", "2").size() == 0)
                    continue;
                String name = e.getElementsByAttributeValue("colspan", "2").get(0).text();
                String address = null;
                if (name.indexOf("派出所") != -1 &&
                        e.getElementsByAttributeValue("colspan", "3").size() != 0) {
                    if (!flag) {
                        flag = true;
                        continue;
                    }
                    address = e.getElementsByAttributeValue("colspan", "3").get(0).text();
                    //System.out.println(name + " ------ " + address);
                    //resMap.put(name, address);
                    table.put(area, name, address);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return table;
    }


    public static Table<String, String, String> getByDir(String dirPath){
        Table<String, String, String> table = HashBasedTable.create();
        File file = new File(dirPath);
        if(file.exists() && file.isDirectory()){
            File[] files = file.listFiles();
            for (File fileTmp : files){
                table.putAll(getPcStation(fileTmp));
            }
        }
        return table;
    }

    public static void main(String[] args) throws Exception{
        //String filePath = "C:\\Users\\admin\\Desktop\\1\\1.html";
        String dirPath = "C:\\Users\\admin\\Desktop\\1\\html";
        //Table<String, String, String> table = getPcStation(filePath);
        Table<String, String, String> table = getByDir(dirPath);
        for (Table.Cell<String, String, String> cell : table.cellSet()){
            System.out.println(cell.toString());
        }
    }







}
