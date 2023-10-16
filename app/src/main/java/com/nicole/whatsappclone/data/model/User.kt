package com.nicole.whatsappclone.data.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.storage.StorageReference

data class User(
    @DocumentId val id: String = "",
    val name: String = "",
    val nameDisplayed: String = "",
    val number: String = "",
    var image: String? = "",
    val groups: List<DocumentReference> = emptyList()
)
