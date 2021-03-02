package com.example.apidemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryBean {
    public String timeStamp;//时间戳
    public String randomStr;//随机串
    public String signature;//签名
    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getRandomStr() {
        return randomStr;
    }
    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public EncryBean() {

    }

    public EncryBean(String timeStamp, String randomStr, String signature) {
        super();
        this.timeStamp = timeStamp;
        this.randomStr = randomStr;
        this.signature = signature;
    }

    /**
     * @param timeStamp 时间戳
     * @param randomStr 随机字符串
     * @param tk 令牌字符串
     * @return string 返回签名
     */
    @SuppressWarnings("static-access")
    public String arithmetic(String timeStamp,String randomStr,String tk){

        String  [] arr =  new String[3];
        arr[0] = timeStamp;
        arr[1] = tk;
        arr[2] = randomStr;
        StringBuilder bf = new StringBuilder();
        for(int i =0; i<arr.length;i++){
            bf.append(arr[i]);//按照首字母大小写顺序排序 拼接成字符串
        }

        String signature="";
        try {
            signature = this.shaEncode(bf.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }//SHA-1加密

        signature = this.encryption(signature);//MD5加密
        return signature.toUpperCase();//转成大写字符
    }

    /**
     * @Comment SHA1实现
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * @param Md5实现
     */
    public String encryption(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }
}
