package vn.tiki.home.domain.model

import vn.tiki.home.presentation.ui.model.quicklink.QuickLinkItem

/**
 * Created by phatvt2 on 8/5/20
 */

data class QuickLinkDomainModel(
    val title: String,
    val content: String?,
    val url: String,
    val authentication: Boolean,
    val webUrl: String?,
    val imageUrl: String
) {
    fun toQuickLinkItem() = QuickLinkItem(title, url, imageUrl)
}