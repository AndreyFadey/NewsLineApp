package com.newslineapp.api

import com.newslineapp.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("v2/top-headlines")

    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "ru",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = ApiKey.apiKey
    ): Response<NewsResponse>

    @GET("v2/everything")

    suspend fun searchForNews(
        @Query("q")
        searchQuery: String = "",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = ApiKey.apiKey
    ): Response<NewsResponse>
}