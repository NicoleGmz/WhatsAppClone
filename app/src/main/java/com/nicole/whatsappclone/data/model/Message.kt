package com.nicole.whatsappclone.data.model

import java.util.Date

data class Message(
    val id: String,
    val sentBy: User,
    val date: Date,
    val message: String
)
