package com.example.myapplication.repository

import com.example.myapplication.model.Photos
import retrofit2.Response

interface MyRepository {
    suspend fun doNetworkCal() : Response<List<Photos>>
}