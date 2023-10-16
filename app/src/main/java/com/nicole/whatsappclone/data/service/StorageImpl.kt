package com.nicole.whatsappclone.data.service

import android.util.Log
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
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


    override suspend fun getUserInfo(userId: String){
        val source = Source.CACHE
        db.collection("Users").document(userId).get(source).addOnSuccessListener { documentSnapshot ->
            user = documentSnapshot.toObject<User>()!!
            Log.d(TAG, "${documentSnapshot.id} => ${documentSnapshot.data}")
        }.addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents: ", exception)
        }.await()
        getProfileImage(userId)
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
        TODO("Not yet implemented")
        /*val document = db.collection("Users")
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
            }*/

    }
    override suspend fun getMessages(userId: String, groupId: String): List<Message> {
        TODO("Not yet implemented")
    }
    override suspend fun getContacts(userId: String, groupsId: ArrayList<String>): List<User> {
        TODO("Not yet implemented")
    }

}
