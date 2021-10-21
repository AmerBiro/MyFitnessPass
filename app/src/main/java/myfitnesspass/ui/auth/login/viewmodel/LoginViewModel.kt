package myfitnesspass.ui.auth.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import myfitnesspass.other.Resource
import myfitnesspass.repositories.UserRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _loginStatus = MutableLiveData<Resource<String>>()
    val loginStatus: LiveData<Resource<String>> = _loginStatus

    fun login(email: String, password: String) {
        _loginStatus.postValue(Resource.loading(null))
        if(email.isEmpty() || password.isEmpty()) {
            _loginStatus.postValue(Resource.error("Please fill out all the fields", null))
            return
        }
        viewModelScope.launch {
            val result = repository.login(email, password)
            _loginStatus.postValue(result)
        }
    }

}