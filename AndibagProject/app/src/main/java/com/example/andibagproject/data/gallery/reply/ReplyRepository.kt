package com.example.andibagproject.data.gallery.reply

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.replyAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class ReplyRepository {
    fun writeReply(content: String, id: Long) : @NonNull Single<Response<Unit>> =
        replyAPI.writeReply(ACCESS_TOKEN, content, id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun deleteReply(id: Long) : @NonNull Single<Response<Unit>> =
        replyAPI.deleteReply(ACCESS_TOKEN, id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun patchReply(content: String, id: Long) : @NonNull Single<Response<Unit>> =
        replyAPI.patchReply(ACCESS_TOKEN, content, id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}