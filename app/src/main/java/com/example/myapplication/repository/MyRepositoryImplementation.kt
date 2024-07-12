package com.example.myapplication.repository

import com.example.myapplication.ApiService.PhotosApi
import com.example.myapplication.model.Photos
import retrofit2.Response

class MyRepositoryImplementation(private val api : PhotosApi): MyRepository {
    override suspend fun doNetworkCal() : Response<List<Photos>> {
        return api.getPhotos()
    }

}