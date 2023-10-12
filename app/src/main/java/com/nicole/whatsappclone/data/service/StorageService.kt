package com.nicole.whatsappclone.data.service

import com.nicole.whatsappclone.data.model.Group
import com.nicole.whatsappclone.data.model.Message
import com.nicole.whatsappclone.data.model.User
import kotlinx.coroutines.flow.Flow

interface StorageService {

    //val groups: Flow<List<Group>>

    suspend fun getGroup()
    suspend fun getGroups(userId: String): List<Group>
    suspend fun getMessages(userId: String, groupId: String): List<Message>
    suspend fun getContacts(userId: String, groupsId: ArrayList<String>): List<User>
}