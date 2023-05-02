package com.nicole.whatsappclone.data.model

data class Profile(
    val name: String,
    val image: String?,
    val state: String,
    val number: String,
    val contact: List<Contact>
)
