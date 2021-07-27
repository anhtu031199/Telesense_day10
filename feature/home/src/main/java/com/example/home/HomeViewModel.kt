package com.example.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.base.BaseViewModel
import com.example.common.utils.Event
import com.example.home.domain.GetTopUsersUseCase
import com.example.model.User
import com.example.repository.AppDispatchers
import com.example.repository.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.home.databinding.FragmentHomeBindingImpl

/**
 * A simple [BaseViewModel] that provide the data and handle logic to communicate with the model
 * for [HomeFragment].
 */
class HomeViewModel(private val getTopUsersUseCase: GetTopUsersUseCase,
                    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    // FOR DATA
    private val _users = MediatorLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>> get() = _users
    private var usersSource: LiveData<Resource<List<User>>> = MutableLiveData()

    init {
        getUsers(false)
    }

    // PUBLIC ACTIONS ---
//    fun userClicksOnItem(user: User)
//            = navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(user.name))


    fun userRefreshesItems()
            = getUsers(true)

    // ---

    private fun getUsers(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
        _users.removeSource(usersSource) // We make sure there is only one source of livedata (allowing us properly refresh)
        withContext(dispatchers.io) { usersSource = getTopUsersUseCase(forceRefresh = forceRefresh) }
        _users.addSource(usersSource) {
            _users.value = it
            if (it.status == Resource.Status.ERROR) _snackbarError.value = Event(R.string.an_error_happened)
        }
    }
}