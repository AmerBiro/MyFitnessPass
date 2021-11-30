package myfitnesspass.ui.home.programs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import myfitnesspass.data.local.entities.Program
import myfitnesspass.other.Event
import myfitnesspass.other.Resource
import myfitnesspass.repositories.ProgramRepository
import javax.inject.Inject

@HiltViewModel
class CreateProgramViewModel @Inject constructor(
    private val repository: ProgramRepository
) : ViewModel() {

    private val _program = MutableLiveData<Event<Resource<Program>>>()
    val program: LiveData<Event<Resource<Program>>> = _program

    fun createProgram(program: Program) = GlobalScope.launch{
        repository.insertProgram(program)
    }

    fun getProgramById(programId: String) = viewModelScope.launch{
        _program.postValue(Event(Resource.loading(null)))
        val program = repository.getProgramById(programId)
        program?.let {
            _program.postValue(Event(Resource.success(it)))
        } ?: _program.postValue(Event(Resource.error("Program not found", null)))
    }



}