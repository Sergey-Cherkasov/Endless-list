package pt.svcdev.endlesslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pt.svcdev.endlesslist.repository.RetrofitRepository
import pt.svcdev.endlesslist.repository.RetrofitRepositoryImpl

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainListAdapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initList()
        initView()
    }

    private fun initView() {
        lifecycleScope.launch {
            viewModel.listData.collect {
                mainListAdapter.submitData(it)
            }
        }
    }

    private fun initList() {
        mainListAdapter = MainListAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = mainListAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(RetrofitRepositoryImpl())
        )[MainViewModel::class.java]
    }
}