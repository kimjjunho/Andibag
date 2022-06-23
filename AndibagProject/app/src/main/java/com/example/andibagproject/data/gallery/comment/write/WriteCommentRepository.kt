package com.example.andibagproject.data.gallery.comment.write

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.writeCommentAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class WriteCommentRepository {
    fun writeComment(content: String, id: Int) : @NonNull Single<Response<Unit>> =
        writeCommentAPI.writeComment(ACCESS_TOKEN,content,id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}