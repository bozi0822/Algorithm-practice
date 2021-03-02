package com.example.apidemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class Encry extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String timeStamp = request.getParameter("t");//获取时间戳
        String randomStr = request.getParameter("r");//获取随机串
        String signature = request.getParameter("s");//获取签名
        PrintWriter out = response.getWriter();
        Map<String, Object> map = new HashMap<String, Object>();
        if(timeStamp==null && timeStamp==""){
            map.put("status", "100");//状态码100时间戳不能为空
        }
        if(randomStr==null && randomStr==""){
            map.put("status", "101");//状态码101随机串不能为空
        }
        if(signature==null && signature==""){
            map.put("status", "102");//状态码102签名不能为空
        }

        System.out.println("timeStamp"+timeStamp);
        System.out.println("randomStr"+randomStr);
        System.out.println("signature"+signature);

        String TOKEN = "API";//令牌字符串(双方约定)
        EncryBean a = new EncryBean();
        String str = a.arithmetic(timeStamp,randomStr,TOKEN);//通过前台传过来的时间戳跟随机数重新按照签名函数进行生成一遍签名
        //然后将传过来签名跟，自己重新生成的签名进行比对

        if(str.equals(signature)){
            map.put("status", "1");//状态码1成功
        }else{
            map.put("status", "0");//状态码0签名错误
        }
        String mapJson = JSON.toJSONString(map);
        out.print(mapJson);
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
