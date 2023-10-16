package com.nicole.whatsappclone.data.model

import java.util.*

data class Group(
    val id: String,
    val createdAt: Date,
    val createdBy: User,
    val members: List<String>,
    val name: String,
    val type: Int,
    )
