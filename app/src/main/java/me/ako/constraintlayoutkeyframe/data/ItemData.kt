package me.ako.constraintlayoutkeyframe.data

import me.ako.constraintlayoutkeyframe.R
import me.ako.constraintlayoutkeyframe.model.Item

object ItemData {
    fun getItemList(): ArrayList<Item> {
        return arrayListOf(
            Item(
                1,
                "Andromeda",
                "This is M31 or most commonly known as the Andromeda Galaxy. It is our closest neighboring galaxy and is only a few thousand light years away. Take a minute to look at it in all it’s glory! I’m on IG @bryangoffphoto Stop by and say hi!",
                "Bryan Goff",
                "https://images.unsplash.com/photo-1506703719100-a0f3a48c0f86?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
            ),
            Item(
                2,
                "Milky Way",
                "Our is spiral galaxy, though from earth the milky way is flat because we are inside one of the arms.",
                "Dan Grinwis",
                "https://images.unsplash.com/photo-1505609833666-8d2ab9413498?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=826&q=80"
            ),
            Item(
                3,
                "Orion M42",
                "My photo of the Orion Nebula was taken in my backyard in Petaluma, California. It is composed of 60 images at 60 seconds each. I stacked them all to reduce noise and bring out the amazing details you see in the nebula . I think it is one of my better images. I hope you enjoy it. I’m on IG @bryangoffphoto Stop by and say hi!",
                "Bryan Goff",
                "https://images.unsplash.com/photo-1504333638930-c8787321eee0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
            )
        )
    }
}