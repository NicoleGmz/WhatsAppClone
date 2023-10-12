package com.nicole.whatsappclone.data.model

data class User(
    val id: String,
    val name: String,
    val nameDisplayed: String,
    val number: String,
    val image: String?,
    val groups: List<Group>
)
