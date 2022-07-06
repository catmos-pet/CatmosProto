package com.dani.catmosproto.enums

enum class PageType(val title: String, val key: String, val tag: String) {
    RealTimeData("RealTimeData", "realtimeData", "tag_realtimeData"),
    CatBehaviors("CatBehaviors", "catBehaviors", "tag_catBehaviors")
}