package pt.svcdev.endlesslist.repository

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import pt.svcdev.endlesslist.repository.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepositoryImpl : RetrofitRepository {
    override suspend fun getData() = getService().getListData()

    fun getService(): ApiService = Retrofit.Builder()
        .baseUrl("https://www.reddit.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService::class.java)

    private val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()
}