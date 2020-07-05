package com.example.myapplication

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel

class HomeController(private val listener: (String) -> Unit): AsyncEpoxyController() {

    var recentlyActive: MutableList<Profile> = mutableListOf()
        set(value) {
            field = value
            requestModelBuild()
        }
    var allMessages: MutableList<Message> = mutableListOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    var loadingPromotion : Boolean = false
    set(value) {
        field = value
        requestModelBuild()
    }

    override fun buildModels() {


        if (loadingPromotion) {
            headerItem {
                id("recently_active")
                title("Recently Active")
            }
            val recentlyActiveModels = recentlyActive.map {
                RecentlyActiveItemModel_(listener)
                    .id(it.id)
                    .profile(it)
             }
            carousel {
                id("recent")
                padding(Carousel.Padding.dp(0, 4, 0, 16, 10))
                models(recentlyActiveModels)
            }
        }

        headerItem {
            id("allproducts")
            title("All Products")
        }
        allMessages.forEach {
            messageItem {
                id(it.id)
                message(it)
                spanSizeOverride { _, _, _ -> 3 }


            }
        }

        headerItem {
            id("all_messages")
            title("All Messages")
            spanSizeOverride { _, _, _ -> 3 }

        }
        allMessages.forEach {
            messageItem {
                id(it.id)
                message(it)

            }
        }
    }
}