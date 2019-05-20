package cz.sedlacek.weatherforecast.ui.detail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cz.sedlacek.weatherforecast.*
import cz.sedlacek.weatherforecast.databinding.ActivityDetailBinding
import cz.sedlacek.weatherforecast.di.injector

class DetailActivity : BaseActivity<DetailViewModel>() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var todayAdapter: ForecastAdapter
    private lateinit var firstDayAdapter: ForecastAdapter
    private lateinit var secondDayAdapter: ForecastAdapter
    private lateinit var thirdDayAdapter: ForecastAdapter

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this, injector.detailViewModelFactory()).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        title = intent.getStringExtra(ARG_CITY_NAME)
        binding.today = intent.getParcelableExtra(ARG_FORECAST)
        initLists()
        prepareViewModel()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.vm = viewModel
    }

    private fun initLists() {
        initAdapters()
        initListLayouts()
    }

    private fun initListLayouts() {
        binding.todayForecast.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.todayForecast.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        binding.firstForecast.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.firstForecast.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        binding.secondForecast.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.secondForecast.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        binding.thirdForecast.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.thirdForecast.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
    }

    private fun initAdapters() {
        todayAdapter = ForecastAdapter()
        firstDayAdapter = ForecastAdapter()
        secondDayAdapter = ForecastAdapter()
        thirdDayAdapter = ForecastAdapter()
        binding.todayForecast.adapter = todayAdapter
        binding.firstForecast.adapter = firstDayAdapter
        binding.secondForecast.adapter = secondDayAdapter
        binding.thirdForecast.adapter = thirdDayAdapter
    }

    private fun prepareViewModel() {
        viewModel.forecast().observe(this, Observer { result ->
            todayAdapter.updateForecasts(result.today())
            binding.firstDayTitle = result.firstDay()[0].dayAsText()
            firstDayAdapter.updateForecasts(result.firstDay())
            binding.secondDayTitle = result.secondDay()[0].dayAsText()
            secondDayAdapter.updateForecasts(result.secondDay())
            binding.thirdDayTitle = result.thirdDay()[0].dayAsText()
            thirdDayAdapter.updateForecasts(result.thirdDay())
        })
        viewModel.loadDailyForecast(intent.getLongExtra(ARG_CITY_ID, 2761369))
    }
}
