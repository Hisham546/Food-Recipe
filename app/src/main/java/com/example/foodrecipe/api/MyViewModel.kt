import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.api.ApiService
import com.example.foodrecipe.api.ApiServiceBuilder
import com.example.foodrecipe.api.ApiService.ApiResponse
import com.example.foodrecipe.api.DataModel
import com.example.foodrecipe.api.RecipeDetailsModel
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _responseData = MutableLiveData<List<DataModel>>()
    val responseData: MutableLiveData<List<DataModel>> get() = _responseData

    private val apiService = ApiServiceBuilder.retrofit.create(ApiService::class.java)

    fun fetchDataFromApi() {
        viewModelScope.launch {
            try {
                // Make the API call using the ApiService interface
                val apiResponse: ApiResponse = apiService.fetchData()

                // Assuming results is not null in the ApiResponse
                apiResponse.results?.let { results ->
                    // Update the LiveData with the fetched data
                    _responseData.value = results
                }
            } catch (e: Exception) {
                // Handle network or other errors
                // You can set an error state or log the error
            }
        }
    }

    fun recipeInformationApi(id: Int) {
        println(id)
        viewModelScope.launch {
            try {
                // Make the API call using the ApiService interface
                val apiResponse: ApiService.RecipeDetailsResponse = apiService.fetchRecipeDetails(id)

                // Assuming results is not null in the ApiResponse
                apiResponse.results?.let { results ->
                    // Update the LiveData with the fetched data
                    _responseData.value = results
                }
            } catch (e: Exception) {
                // Handle network or other errors
                // You can set an error state or log the error
            }
        }
    }
}
