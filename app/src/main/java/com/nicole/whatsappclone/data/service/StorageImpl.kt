package com.nicole.whatsappclone.data.service

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.nicole.whatsappclone.data.model.Group
import com.nicole.whatsappclone.data.model.Message
import com.nicole.whatsappclone.data.model.User
import kotlinx.coroutines.flow.Flow

class StorageImpl : StorageService{

    private val TAG = "MyActivity"
    private val db = Firebase.firestore
    private val userId = "AmBQSY3ElVrdA83NR7vI"

    override suspend fun getGroup() {
        db.collection("Groups")
            .document("JEswbnRyQRlntSjGxHGy")
            .get()
            .addOnSuccessListener {document ->
            if(document != null){
                Log.d(TAG, "DocumentSnapshot data: ${document.data}")
            }else{
                Log.d(TAG, "No such document")
            }
        }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    override suspend fun getGroups(userId: String): List<Group> {
        val document = db.collection("Users")
            .document(userId)
            .get()
            .addOnSuccessListener { document ->
                if(document != null){
                    document.toObject<User>()
                    Log.d(TAG, "User snapshot data: ${document.data}")
                }else{
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener {exception ->
                Log.d(TAG, "get failed with ", exception)
            }

        document.
    }

    override suspend fun getMessages(userId: String, groupId: String): List<Message> {
        TODO("Not yet implemented")
    }

    override suspend fun getContacts(userId: String, groupsId: ArrayList<String>): List<User> {
        TODO("Not yet implemented")
    }

}
