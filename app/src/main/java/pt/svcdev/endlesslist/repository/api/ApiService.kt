package pt.svcdev.endlesslist.repository.api

import pt.svcdev.endlesslist.model.Listing
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("r/subreddit/hot.json")
    suspend fun getListData(): Response<Listing>
}