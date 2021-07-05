package pt.svcdev.endlesslist.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import pt.svcdev.endlesslist.model.Child
import pt.svcdev.endlesslist.repository.RetrofitRepository

class GetDataSource(private val retrofitRepository: RetrofitRepository) : PagingSource<Int, Child>() {
    override fun getRefreshKey(state: PagingState<Int, Child>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Child> {
        return try {
            val currentLoadingPageKey = params.key ?: 1
            val response = retrofitRepository.getData()
            val responseData = mutableListOf<Child>()
            val data = response.body()?.data?.children ?: emptyList()
            responseData.addAll(data)
            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1
            LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}