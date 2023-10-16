package com.nicole.whatsappclone.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicole.whatsappclone.data.service.StorageService
import kotlinx.coroutines.launch

class GroupsViewModel(private  val storageService: StorageService): ViewModel() {

    private val userId = "AmBQSY3ElVrdA83NR7vI"

    fun getUserInfo(){
        viewModelScope.launch { storageService.getUserInfo(userId) }
    }

}