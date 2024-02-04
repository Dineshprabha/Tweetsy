package com.dineshprabha.tweetsy.api

import com.dineshprabha.tweetsy.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/65bf351e1f5677401f2a922a?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String) : Response<List<Tweet>>

    @GET("/v3/b/65bf351e1f5677401f2a922a?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories() : Response<List<String>>
}