package com.nicole.whatsappclone.data.service

import android.util.Log
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.nicole.whatsappclone.data.model.Group
import com.nicole.whatsappclone.data.model.Message
import com.nicole.whatsappclone.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.File

class StorageImpl : StorageService{

    private val TAG = "MyActivity"
    private val db = Firebase.firestore
    private val storage = Firebase.storage
    private lateinit var user: User
    private val groupList: MutableList<Group> = mutableListOf()


    override suspend fun getUserInfo(userId: String){
        //val source = Source.CACHE
        db.collection("Users").document(userId).get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null){
                user = documentSnapshot.toObject<User>()!!
                Log.d(TAG, "${documentSnapshot.id} => ${documentSnapshot.data}")
            }else{
                Log.d(TAG, "error in the document in the database")
            }
        }.addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents: ", exception)
        }.await()
        getProfileImage(userId)
        getGroups(userId)
    }
    override suspend fun getProfileImage(userId: String) {
        val imageId= db.collection("Users")
            .document(userId).collection("image")
            .get().await().documents[0].id

        val imagePath = "${user.id}/${imageId}"
        val imageRef = storage.reference.child(imagePath)
        val localFile = withContext(Dispatchers.IO) {
            File.createTempFile("profile", ".jpg")
        }
        imageRef.getFile(localFile).addOnSuccessListener {
            Log.d(TAG, "Image downloaded correctly")
        }.addOnFailureListener {exception ->
            Log.w(TAG, "Error getting profile image: ", exception)
        }.await()
        Log.d(TAG, localFile.path)
        user.image = localFile.path
    }

    override suspend fun getGroups(userId: String) {
        for(group in user.groups){
            db.collection("Groups").document(group.id).get()
                .addOnSuccessListener { document ->
                    groupList.add(document.toObject<Group>()!!)
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
                .addOnFailureListener {exception ->
                    Log.d(TAG, "get failed with ", exception)
                }.await()
        }
    }
    override suspend fun getMessages(userId: String, groupId: String): List<Message> {
        TODO("Not yet implemented")
    }
    override suspend fun getContacts(userId: String, groupsId: ArrayList<String>): List<User> {
        TODO("Not yet implemented")
    }

}
