package com.example.myapplication.ApiService

import com.example.myapplication.model.Photos
import retrofit2.Response
import retrofit2.http.GET

interface PhotosApi {
    @GET("/photos")
    suspend fun getPhotos(): Response<List<Photos>>

}