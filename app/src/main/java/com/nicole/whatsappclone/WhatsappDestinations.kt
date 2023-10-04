package com.nicole.whatsappclone

interface WhatsappDestination{
    val route: String
}
object ChatsList: WhatsappDestination{
    override val route = "chats_list"
}


object NotWorking: WhatsappDestination{
    override val route = "not_working"
}


object Calls: WhatsappDestination{
    override val route = "calls"
}

object States: WhatsappDestination{
    override val route = "states"
}

val whatsappTabRowScreens = listOf(ChatsList, Calls, States)