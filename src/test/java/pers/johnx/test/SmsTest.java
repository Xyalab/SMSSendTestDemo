package pers.johnx.test;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import pers.johnx.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class SmsTest {

    public static void main(String[] args) {

        String host = "http://dingxin.market.alicloudapi.com";
        String path = "/dx/sendSms";
        String method = "POST";
        String appcode = "****";  //开通过后会有一个个人独有的appcode

        Map<String, String> headers = new HashMap<>();

        headers.put("Authorization", "APPCODE "+appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "***");  //接收手机号
        querys.put("param", "code:***");  //验证码
        querys.put("tpl_id", "TP1711063");  //短信模板

        Map<String, String> bodys = new HashMap<>();


        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

            System.out.println(response.toString());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
