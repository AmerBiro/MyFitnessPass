package myfitnesspass.ui.home.programs.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import myfitnesspass.data.local.entities.Program
import myfitnesspass.other.Event
import myfitnesspass.other.Resource
import myfitnesspass.repositories.ProgramRepository
import javax.inject.Inject


@HiltViewModel
class ShowProgramsViewModel @Inject constructor(
    private val repository: ProgramRepository
) : ViewModel() {

    private val _forceUpdate = MutableLiveData<Boolean>(false)

    private val _allPrograms = _forceUpdate.switchMap {
        repository.getAllPrograms().asLiveData(viewModelScope.coroutineContext)
    }.switchMap {
        MutableLiveData(Event(it))
    }
    val allPrograms: LiveData<Event<Resource<List<Program>>>> = _allPrograms

    fun syncAllPrograms() = _forceUpdate.postValue(true)
}