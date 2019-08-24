package spring.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SendGet {
    public synchronized static String get(String url){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try{
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                return response.body().string();
            }else{
                System.out.println("获取数据失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "获取openid失败";
    }
}
