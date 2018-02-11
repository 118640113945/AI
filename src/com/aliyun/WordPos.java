package com.aliyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class WordPos {
    public static void main( String[] args ) throws Exception {
        // serviceURL: https://dtplus-cn-shanghai.data.aliyuncs.com/{org_code}/nlp/api/WordPos/{Domain}
        String serviceURL = "https://dtplus-cn-shanghai.data.aliyuncs.com/dt_ng_1833182213083680/nlp/api/WordPos/general";
        String akID = "LTAIUbIGaWKwtiLc";
        String akSecret = "j5Xan68Vpl7sNdHPnINwa2zTOEnpXx";
        // 填充请求body
        // String postBody = "{\"text\":\"真丝韩都衣舍连衣裙\"}";
        JSONObject postBodyJson = new JSONObject();
        postBodyJson.put("text", "真丝韩都衣舍连衣裙");
        // Sender代码参考 https://help.aliyun.com/document_detail/shujia/OCR/ocr-api/sender.html
        // String result = Sender.sendPost(serviceURL, postBody, akID, akSecret);
        String result = AESDecode.sendPost(serviceURL, postBodyJson.toJSONString(), akID, akSecret);
        System.out.println(result);
        try {
            JSONObject resultJson = JSON.parseObject(result);
            JSONArray wordObjs = resultJson.getObject("data", JSONArray.class);
            for(Object wordObj : wordObjs){
                JSONObject wordJson = JSON.parseObject(wordObj.toString());
                String pos = wordJson.getString("pos"); // 词性
                String word = wordJson.getString("word"); // 词
                System.out.printf("pos: %s, word: %s\n", pos, word);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
  
}
