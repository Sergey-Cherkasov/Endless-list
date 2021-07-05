package pt.svcdev.endlesslist.repository

import pt.svcdev.endlesslist.model.Listing
import retrofit2.Response

interface RetrofitRepository {
    suspend fun getData(): Response<Listing>
}