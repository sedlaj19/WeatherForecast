package cz.sedlacek.weatherforecast.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cz.sedlacek.weatherforecast.*
import cz.sedlacek.weatherforecast.databinding.ActivityMainBinding
import cz.sedlacek.weatherforecast.databinding.ItemCityBinding
import cz.sedlacek.weatherforecast.di.injector
import cz.sedlacek.weatherforecast.ui.ForecastClickListener
import cz.sedlacek.weatherforecast.ui.detail.DetailActivity

class MainActivity : BaseActivity<MainViewModel>(), ForecastClickListener<ItemCityBinding> {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CitiesAdapter

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this, injector.mainViewModelFactory()).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.citiesList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = CitiesAdapter(this)
        binding.citiesList.adapter = adapter

        binding.vm = viewModel
        viewModel.forecast().observe(this, Observer { result ->
            adapter.updateCities(result.list)
        })
    }

    override fun onClick(binding: ItemCityBinding) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(ARG_CITY_ID, binding.forecast?.id)
        intent.putExtra(ARG_FORECAST, binding.forecast)
        intent.putExtra(ARG_CITY_NAME, binding.forecast?.name)
        startActivity(intent)
    }

}
