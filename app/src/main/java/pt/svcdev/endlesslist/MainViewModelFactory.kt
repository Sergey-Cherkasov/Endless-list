package pt.svcdev.endlesslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pt.svcdev.endlesslist.repository.RetrofitRepository

class MainViewModelFactory(private val retrofitRepository: RetrofitRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(retrofitRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}