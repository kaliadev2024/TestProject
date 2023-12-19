
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cityapp.viewmodel.CityViewModel
import com.example.collapasablesection.model.CityModel
import com.example.testproject.ui.theme.TestProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CityList()
                }
            }
        }
    }
}

@Composable
fun CityList() {
    val viewModel = viewModel<CityViewModel>()
    val citiesState: State<List<CityModel>?> = viewModel.cities.observeAsState()
    val cities = citiesState.value // Extract the value from the State

    LazyColumn {
        items(cities ?: emptyList()) { city ->
            when {
                city?.lat.isNullOrEmpty() -> {
                    // This is a section header
                    SectionHeader(city?.adminName.orEmpty())
                }
                else -> {
                    // This is a city item
                    CityItem(city)
                }
            }
        }
    }
}


@Composable
fun SectionHeader(state: String) {
    Text(
        text = state,
        style = MaterialTheme.typography.titleLarge,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun CityItem(city: CityModel) {
    Text(
        text = city.city,
        style = MaterialTheme.typography.bodyMedium,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}