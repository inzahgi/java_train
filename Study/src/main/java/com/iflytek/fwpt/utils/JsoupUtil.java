package com.iflytek.fwpt.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
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

    public static Multimap<String, String> getAllPcStation(File file) {
        Multimap<String, String> map= HashMultimap.create();
        Preconditions.checkArgument(file.exists()&& file.isFile());
        //Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        try {
            Document doc = Jsoup.parse(file, "UTF-8");


            Element content = doc.getElementById("listContent");
            ListIterator<Element> liIter = content.select("ul").listIterator();
            boolean flag = false;
            while (liIter.hasNext()) {
                Element e = liIter.next();
                String pcsName = e.select("li").get(0).text();
                String address = e.select("li").get(1).text();

                map.put(pcsName, address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    public static Table<String, String, String> getPcStation(File file){
        Table<String, String, String> table = HashBasedTable.create();
        Preconditions.checkArgument(file.exists()&& file.isFile());
        //Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        try {
            Document doc = Jsoup.parse(file, "UTF-8");
            String title = doc.getElementsByTag("title").text();
            int index = title.indexOf("派出所");
            String areaName = title.substring(0, index).substring(2);
            System.out.println(title + "\n------" + areaName);
            Element content = doc.getElementById("listContent");
            ListIterator<Element> liIter = content.select("ul").listIterator();
            boolean flag = false;
            while (liIter.hasNext()) {
                Element e = liIter.next();
                String pcsName = e.select("li").get(0).text();
                String address = e.select("li").get(1).text();
                System.out.println("\t\torigin name : " + pcsName);
                if(pcsName.contains(areaName)){
                    int i = pcsName.indexOf(areaName);
                    pcsName = pcsName.substring(i+areaName.length());
                    System.out.println("line = 70  " + pcsName);
                }else {
                    String areaNewName = areaName.substring(0, areaName.length() -1);
                    int i = pcsName.indexOf(areaNewName);
                    if(i != -1) {
                        pcsName = pcsName.substring(i + areaNewName.length());
                        System.out.println("line = 75 " + pcsName);
                    }
                }

                table.put(areaName, pcsName, address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return table;
    }

//    public static Table<String, String, String> getPcStation(File file) {
//        Table<String, String, String> table = HashBasedTable.create();
//        Preconditions.checkArgument(file.exists()&& file.isFile());
//        //Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
//        try {
//            Document doc = Jsoup.parse(file, "UTF-8");
//
//
//            Element content = doc.getElementById("bo");
//            String area = content.selectFirst("strong").text().trim();
//            ListIterator<Element> li = content.select("tr").listIterator();
//            boolean flag = false;
//            while (li.hasNext()) {
//                Element e = li.next();
//                if (e.getElementsByAttributeValue("colspan", "2").size() == 0)
//                    continue;
//                String name = e.getElementsByAttributeValue("colspan", "2").get(0).text();
//                String address = null;
//                if (name.indexOf("派出所") != -1 &&
//                        e.getElementsByAttributeValue("colspan", "3").size() != 0) {
//                    if (!flag) {
//                        flag = true;
//                        continue;
//                    }
//                    address = e.getElementsByAttributeValue("colspan", "3").get(0).text();
//                    //System.out.println(name + " ------ " + address);
//                    //resMap.put(name, address);
//                    table.put(area, name, address);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return table;
//    }


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
