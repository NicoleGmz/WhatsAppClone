package com.nicole.whatsappclone.data.service

import com.google.firebase.storage.StorageReference
import com.nicole.whatsappclone.data.model.Group
import com.nicole.whatsappclone.data.model.Message
import com.nicole.whatsappclone.data.model.User
import kotlinx.coroutines.flow.Flow

interface StorageService {

    //val groups: Flow<List<Group>>
    suspend fun getUserInfo(userId: String)
    suspend fun getProfileImage(userId: String)
    suspend fun getGroups(userId: String)
    suspend fun getMessages(userId: String, groupId: String): List<Message>
    suspend fun getContacts(userId: String, groupsId: ArrayList<String>): List<User>
}