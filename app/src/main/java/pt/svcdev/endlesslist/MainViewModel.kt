package pt.svcdev.endlesslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import pt.svcdev.endlesslist.datasource.GetDataSource
import pt.svcdev.endlesslist.repository.RetrofitRepository

class MainViewModel(private val retrofitRepository: RetrofitRepository) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 6)) {
        GetDataSource(retrofitRepository)
    }.flow.cachedIn(viewModelScope)

}