package com.housemgt.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class HouseUtil {
    private static final Logger logger = LoggerFactory.getLogger(HouseUtil.class);

    //页面返回信息转换成Json格式
    public static String getJSONString(int code) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        return json.toJSONString();
    }


    //检查文件扩展名是否为图片
    public static String HOUSE = "http://127.0.0.1:8080/";
    public static String IMAGE_ADR ="/Users/mac/Desktop/Image/"; //图片保存的路径
    public static  String[] IMAGE_EXT = new String[]{"png","jpg","jpeg","bmp"};
    public static boolean checkFileExt(String fileExt){

        for (String ext : IMAGE_EXT){
            if (ext.equals(fileExt)){
                return true;
            }
        }
        return false;
    }

    public static String getJSONString(int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        return json.toJSONString();
    }

    public static String getJSONString(int code, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        return json.toJSONString();
    }

}
