package com.example.hello.myquarterykz.util;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by 韦作铭 on 2018/4/7.
 */

public interface ApiService {
    @GET("{url}")
    Observable<ResponseBody> doGet(@Path(value = "url"
            , encoded = true) String url, @QueryMap Map<String, String> map);


    @FormUrlEncoded
    @POST("{url}")
    Observable<ResponseBody> doPost(@Path(value = "url"
            , encoded = true) String url, @FieldMap Map<String, String> map);
    /**
     * 上传一张图片
     * @param description
     * @param imgs
     * @return
     */
    @Multipart
    @POST("/upload")
    Call<String> uploadImage(@Part("fileName") String description,
                             @Part("file\"; filename=\"image.png\"")RequestBody imgs);
}