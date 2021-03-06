package com.leedopoem.ljh.friendlyteacher.data.source.remote.retrofit.api;

import com.leedopoem.ljh.friendlyteacher.entity.Book;
import com.leedopoem.ljh.friendlyteacher.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.entity.Result;
import com.leedopoem.ljh.friendlyteacher.entity.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by ljh on 17-9-28.
 */

public interface LectureService {
    @GET("users/{user}/repos")
    Observable<List<Class>> getAllClasses(@Path("user") String user);
    @GET("book/search")
    Observable<Book> getSearchBook(@Query("q") String name, @Query("tag") String tag,
                                   @Query("start") int start, @Query("count") int count);

    //注册
    @POST("/user")
    Observable<Result> registAsUser(@Body User user);

    //用户
    //登录
    @GET("/session")
    Observable<Result> login(@Query("uid") String uid,@Query("password") String password);
    //修改用户信息
    @PUT("/user/{uid}")
    Observable<Result> alterUserInformation(@Path("user") String uid, @Body User user);
    //获取用户信息
    @GET("/user/{uid}")
    Observable<Result> getUserInformation(@Path("uid") String uid);


    //课程
    //获取所有课程信息
    @GET("/lectures")
    Observable<List<Lecture>> getALlLectures();
    //发布某个课程
    @POST("/lecture")
    Observable<Result> publishLecture(@Body Lecture lecture);
    //获取某个用户的课程
    @GET("lecture/{uid}")
    Observable<List<Lecture>> getLecturesByUid(@Path("uid") String uid);
    //获取某个课程
    @GET("lecture/{lid}")
    Observable<Lecture> getLectureByLid(@Path("lid") String lid);
    //删除某个课程
    @DELETE("lecture/{lid}")
    Observable<Result> deleteLecture(@Path("lid") String lid);
    //修改课程信息
    @PUT("lecture/{lid}")
    Observable<Result> alterLectureInformation(@Path("lid") String lid,@Body Lecture lecture);

}