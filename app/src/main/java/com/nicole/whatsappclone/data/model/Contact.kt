package com.nicole.whatsappclone.data.model

data class Contact(
    val name: String,
    val number: String,
    val image: String?,
    val chat: Chat
)
