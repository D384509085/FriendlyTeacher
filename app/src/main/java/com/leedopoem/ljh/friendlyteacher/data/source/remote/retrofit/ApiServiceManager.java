package com.leedopoem.ljh.friendlyteacher.data.source.remote.retrofit;

import com.google.gson.GsonBuilder;
import com.leedopoem.ljh.friendlyteacher.data.source.remote.IRemoteDataSource;
import com.leedopoem.ljh.friendlyteacher.data.source.remote.retrofit.api.LectureService;
import com.leedopoem.ljh.friendlyteacher.entity.Book;
import com.leedopoem.ljh.friendlyteacher.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.entity.Result;
import com.leedopoem.ljh.friendlyteacher.entity.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ljh on 17-9-28.
 */

public class ApiServiceManager implements IRemoteDataSource{
    public Retrofit retrofit;
    public LectureService lectureService;
    public ApiServiceManager() {
        retrofit=new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        lectureService=retrofit.create(LectureService.class);
    }

    public Observable<Book> getSearchBook(){
        return lectureService.getSearchBook("金瓶梅",null,0,1);
    }


    @Override
    public Observable<Result> registAsUser(User user) {
        return lectureService.registAsUser(user);
    }

    @Override
    public Observable<Result> login(String uid, String password) {
        return lectureService.login(uid,password);
    }

    @Override
    public Observable<Result> alterUserInformation(User user) {
        return lectureService.alterUserInformation(user.getUid(),user);
    }

    @Override
    public Observable<Result> getUserInformation(String uid) {
        return lectureService.getUserInformation(uid);
    }

    @Override
    public Observable<List<Lecture>> getAllLectures() {
        return lectureService.getALlLectures();
    }

    @Override
    public Observable<Result> publishLecture(Lecture lecture) {
        return lectureService.publishLecture(lecture);
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUid(String uid) {
        return lectureService.getLecturesByUid(uid);
    }

    @Override
    public Observable<Lecture> getLectureByLid(String lid) {
        return lectureService.getLectureByLid(lid);
    }

    @Override
    public Observable<Result> deleteLecture(String lid) {
        return lectureService.deleteLecture(lid);
    }

    @Override
    public Observable<Result> alterLectureInformation(Lecture lecture) {
        return lectureService.alterLectureInformation("1",lecture);
    }
}