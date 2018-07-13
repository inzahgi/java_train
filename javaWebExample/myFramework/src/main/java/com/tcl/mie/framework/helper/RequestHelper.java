package com.tcl.mie.framework.helper;

import com.tcl.mie.framework.bean.FormParam;
import com.tcl.mie.framework.bean.Param;
import com.tcl.mie.framework.util.ArrayUtil;
import com.tcl.mie.framework.util.CodecUtil;
import com.tcl.mie.framework.util.StreamUtil;
import com.tcl.mie.framework.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 封装请求参数 工具类
 */
public final class RequestHelper {

    // 封装servlet Request请求 方便统一分发 controller
    public static Param createParam(HttpServletRequest request) throws IOException {
        List<FormParam> formParamList = new ArrayList<FormParam>();
        formParamList.addAll(parseParameterNames(request));
        formParamList.addAll(parseInputStream(request));
        return new Param(formParamList);
    }

    // 封装表单数据 方便解析  get
    private static List<FormParam> parseParameterNames(HttpServletRequest request){
        List<FormParam> formParamList = new ArrayList<FormParam>();
        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()){
            String fieldName = paramNames.nextElement();
            String[] fieldValues = request.getParameterValues(fieldName);
            if(ArrayUtil.isNotEmpty(fieldValues)){
                Object fieldValue;
                //如果只有一个值 直接赋值
                if(fieldValues.length == 1){
                    fieldValue = fieldValues[0];
                }else{
                    //多个值 时拼接成字符串
                    // todo  考虑生成数组？？？
                    StringBuilder sb = new StringBuilder("");
                    for(int i = 0; i < fieldValues.length; i++){
                        sb.append(fieldValues[i]);
                        if(i != fieldValues.length - 1){
                            sb.append(StringUtil.SEPARATOR);
                        }
                    }
                    fieldValue = sb.toString();
                }
                formParamList.add(new FormParam(fieldName, fieldValue));
            }
        }
        return formParamList;
    }

    //封装流的输入方式 生成表单  post
    private static List<FormParam> parseInputStream(HttpServletRequest request) throws IOException{
        List<FormParam> formParamList = new ArrayList<FormParam>();
        String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
        if(StringUtil.isNotEmpty(body)){
            //按照 & 分割参数
            String[] kvs = StringUtil.splitString(body, "&");
            if(ArrayUtil.isNotEmpty(kvs)){
                for(String kv : kvs){
                    // 再按照 = 分割 键值对
                    String[] array = StringUtil.splitString(kv, "=");
                    // 仅当键值对同时存在时 添加进list
                    if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                        String fieldname = array[0];
                        String fieldValue = array[1];
                        formParamList.add(new FormParam(fieldname, fieldValue));
                    }
                }
            }
        }
        return formParamList;
    }

}
