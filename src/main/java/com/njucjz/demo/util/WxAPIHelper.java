package com.njucjz.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WxAPIHelper {
    public static String getOpenid(String url){
        HttpURLConnection con = null;
        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL wxAPI = new URL(url);
            con = (HttpURLConnection) wxAPI.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            //得到响应码
            int responseCode = con.getResponseCode();

            InputStream inputStream = con.getInputStream();

            resultBuffer = new StringBuffer();

            String line;
            buffer = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            while ((line = buffer.readLine()) != null) {
                resultBuffer.append(line);
            }

            JSONObject JO = JSON.parseObject(resultBuffer.toString());
            String openid= JO.getString("openid");
            if(openid==null){
                return JO.getString("errcode");
            }
            return openid;
        }catch (Exception e){
            e.printStackTrace();
        }

        return "-1";
    }
}
