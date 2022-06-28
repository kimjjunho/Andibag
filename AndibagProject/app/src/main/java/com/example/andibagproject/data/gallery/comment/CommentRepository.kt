package com.example.andibagproject.data.gallery.comment

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.commentAPI
import com.example.andibagproject.feature.gallery.comment.data.LoadCommentResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class CommentRepository {
    fun writeComment(content: String, id: Long) : @NonNull Single<Response<Unit>> =
        commentAPI.writeComment(ACCESS_TOKEN,content,id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun deleteComment(id: Long) : @NonNull Single<Response<Unit>> =
        commentAPI.deleteComment(ACCESS_TOKEN,id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun patchComment(content: String, id: Long) : @NonNull Single<Response<Unit>> =
        commentAPI.patchComment(ACCESS_TOKEN,content,id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun loadComment(id: Long) : @NonNull Single<Response<LoadCommentResponse>> =
        commentAPI.loadComment(ACCESS_TOKEN,id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}