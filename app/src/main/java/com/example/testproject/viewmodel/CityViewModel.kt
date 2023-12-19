// CityViewModel.kt
package com.example.cityapp.viewmodel


import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.collapasablesection.model.CityModel;
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import com.example.collapasablesection.repository.CityRepository;
class CityViewModel : ViewModel() {

    private val _cities = MutableLiveData<List<CityModel>>()
    val cities: LiveData<List<CityModel>> get() = _cities

    init {
        // Example: Load initial data
        viewModelScope.launch(Dispatchers.IO) {
            loadData()
        }
    }

    private suspend fun loadData() {
        // Example: Assuming you have a function to load cities from a repository
        val allCities = CityRepository.getCities()

        // Group cities by state
        val citiesByState = allCities.groupBy { it.adminName }

        // Flatten the grouped map to a list
        val flattenedCities = citiesByState.flatMap { (state, cities) ->
            listOf(CityModel(state, "", "", "", "", "", "", "", "")) + cities
        }

        _cities.postValue(flattenedCities)
    }

    fun refreshData() {
        // TODO: Implement data refresh logic
    }
}
