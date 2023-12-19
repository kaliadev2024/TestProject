package com.example.collapasablesection.repository
import com.example.collapasablesection.model.CityModel;

object CityRepository {
    // TODO: Implement function to fetch cities from the backend
    fun getCities(): List<CityModel> {
        // Example: Return a list of hardcoded cities
        return listOf(
            // Cities in New South Wales
            CityModel("Sydney", "-33.8678", "151.2100", "Australia", "AU", "New South Wales", "admin", "4840600", "4840600"),
            // Cities in Victoria
            CityModel("Melbourne", "-37.8142", "144.9631", "Australia", "AU", "Victoria", "admin", "4529500", "4529500"),
            // Cities in Queensland
            CityModel("Brisbane", "-27.4678", "153.0281", "Australia", "AU", "Queensland", "admin", "2360241", "2360241"),
            // Cities in Western Australia
            CityModel("Perth", "-31.9559", "115.8606", "Australia", "AU", "Western Australia", "admin", "2141834", "2141834")
            // Add more cities as needed
        )
    }
}