package com.example.apidemo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    public static String interfaceUtil(String path,String data) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");//GET和POST必须全大写
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";

            while ((str = br.readLine()) != null) {
                str=new String(str.getBytes(),"UTF-8");//解决中文乱码问题
                sb.append(str);
            }
            is.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String tk = "API";//密钥
        String t = System.currentTimeMillis()+"" ;//时间戳;
        String r = "zf4edLXLl666666666"; //随机串
        EncryBean a = new EncryBean();
        String s = a.arithmetic(t,r,tk);//生成签名
        String link = "http://localhost:8080/servlet/Encry?t="+t+"&r="+r+"&s="+s;
//        String response = interfaceUtil("http://localhost:8080/servlet/Encry?t="+t+"&r="+r+"&s="+s,"");//get请求
//        String response = interfaceUtil("http://www.myhost.com/api.php?t="+t+"&r="+r+"&s="+s,"");//get请求

        System.out.println(link);
    }
}
