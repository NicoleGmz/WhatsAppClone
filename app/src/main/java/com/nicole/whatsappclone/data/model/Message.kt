package com.nicole.whatsappclone.data.model

import java.util.Date

data class Message(
    val contact: Contact,
    val date: Date,
    val text: String
)
