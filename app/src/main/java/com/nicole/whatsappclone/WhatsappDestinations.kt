package com.nicole.whatsappclone

interface WhatsappDestination{
    val route: String
}
object ChatsList: WhatsappDestination{
    override val route = "Chats"
}


object NotWorking: WhatsappDestination{
    override val route = "Not Working"
}


object Calls: WhatsappDestination{
    override val route = "Calls"
}

object States: WhatsappDestination{
    override val route = "States"
}

val whatsappTabRowScreens = listOf(ChatsList, Calls, States)