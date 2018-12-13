package com.tcl.mie.framework.bean;

import com.tcl.mie.framework.util.CastUtil;
import com.tcl.mie.framework.util.CollectionUtil;
import com.tcl.mie.framework.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装所有的请求参数
 */
public class Param {
    //表单参数
    private List<FormParam> formParamList;
    //文件上传参数
    private List<FileParam> fileParamList;

    public Param(List<FormParam> formParamList){
        this.formParamList = formParamList;
    }

    public Param(List<FormParam> formParamList, List<FileParam> fileParamList){
        this.formParamList = formParamList;
        this.fileParamList = fileParamList;
    }

    /**
     * 获取表单参数键值对
     * @return
     */
    public Map<String, Object> getFieldMap(){
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        if(CollectionUtil.isNotEmpty(formParamList)){
            for(FormParam formParam : formParamList){
                String fieldName = formParam.getFieldName();
                Object fieldValue = formParam.getFieldValue();
                if(fieldMap.containsKey(fieldName)){
                    fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
                }
                fieldMap.put(fieldName, fieldValue);

            }
        }
        return fieldMap;
    }

    /**
     * 获取文件参数键值对  key  filedName   value  List<FileParam>
     * @return
     */
    public Map<String, List<FileParam>> getFileMap(){
        Map<String, List<FileParam>> fileMap = new HashMap<String, List<FileParam>>();
        if(CollectionUtil.isNotEmpty(fileParamList)){
            for(FileParam fileParam : fileParamList){
                String fieldName = fileParam.getFieldName();
                //List<FileParam> fileParamList;
                // file param temp list
                List<FileParam> fPTList;
                if(fileMap.containsKey(fieldName)){
                    fPTList = fileMap.get(fieldName);
                }else{
                    fPTList = new ArrayList<FileParam>();
                }
                fPTList.add(fileParam);
                fileMap.put(fieldName, fPTList);
            }
        }
        return fileMap;
    }

    public List<FileParam> getFileList(String fieldName){
        return getFileMap().get(fieldName);
    }

    public FileParam getFile(String fieldName){
        List<FileParam> fileParamList = getFileList(fieldName);
        if(CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1){
            return fileParamList.get(0);
        }
        return null;
    }

    public boolean isEmpty(){
        return CollectionUtil.isEmpty(formParamList) &&
                CollectionUtil.isEmpty(fileParamList);
    }

    public String getString(String name){
        return CastUtil.castString(getFieldMap().get(name));
    }

    public double getDouble(String name){
        return CastUtil.castDouble(getFieldMap().get(name));
    }

    public long getLong(String name){
        return CastUtil.castLong(getFieldMap().get(name));
    }

    public int getInt(String name){
        return CastUtil.castInt(getFieldMap().get(name));
    }

    public boolean getBoolean(String name){
        return CastUtil.castBoolean(getFieldMap().get(name));
    }

}
