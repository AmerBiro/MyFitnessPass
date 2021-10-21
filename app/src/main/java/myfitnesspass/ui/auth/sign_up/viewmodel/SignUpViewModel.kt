package myfitnesspass.ui.auth.sign_up.viewmodel

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
class SignUpViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _registerStatus = MutableLiveData<Resource<String>>()
    val registerStatus: LiveData<Resource<String>> = _registerStatus

    fun register(email: String, password: String, repeatedPassword: String) {
        _registerStatus.postValue(Resource.loading(null))
        if(email.isEmpty() || password.isEmpty() || repeatedPassword.isEmpty()) {
            _registerStatus.postValue(Resource.error("Please fill out all the fields", null))
            return
        }
        if(password != repeatedPassword) {
            _registerStatus.postValue(Resource.error("The passwords do not match", null))
            return
        }
        viewModelScope.launch {
            val result = repository.register(email, password)
            _registerStatus.postValue(result)
        }
    }

}