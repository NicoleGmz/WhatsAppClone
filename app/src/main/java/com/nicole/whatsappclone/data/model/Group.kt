package com.nicole.whatsappclone.data.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentReference

data class Group(
    @DocumentId val id: String = "",
    val createdAt: Timestamp = Timestamp.now(),
    val createdBy: DocumentReference? = null,
    val members: List<DocumentReference> = emptyList(),
    val name: String = "",
    val type: Int = 0,
    )
