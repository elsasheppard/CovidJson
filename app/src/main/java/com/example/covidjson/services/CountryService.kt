package com.example.covidjson.services

import com.example.covidjson.models.MyCountry
import retrofit2.Call
import retrofit2.http.GET

interface CountryService {

    @GET("countries")
    fun getAffectedCountryList () : Call<List<MyCountry>>
}