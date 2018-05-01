package com.example.hello.myquarterykz.util;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by 韦作铭 on 2018/4/23.
 */

public interface BlogServiceHead {
    @Multipart
    @POST("file/upload")
    Call<ResponseBody> getHead(@Query("uid") String uid, @Part MultipartBody.Part body);

}
