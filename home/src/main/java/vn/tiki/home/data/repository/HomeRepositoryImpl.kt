package vn.tiki.home.data.repository

import vn.tiki.home.data.api.HomeApiService
import vn.tiki.home.data.model.BannerDataModel
import vn.tiki.home.data.model.FlashDealDataModel
import vn.tiki.home.data.model.QuickLinkDataModel
import vn.tiki.home.domain.model.BannerDomainModel
import vn.tiki.home.domain.model.FlashDealDomainModel
import vn.tiki.home.domain.model.QuickLinkDomainModel
import vn.tiki.home.domain.repository.HomeRepository
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/5/20
 */

class HomeRepositoryImpl @Inject constructor(
    private val apiService: HomeApiService
) : HomeRepository {

    override suspend fun getBanners(): List<BannerDomainModel> =
        apiService
            .getBanners()
            .data!!
            .map(BannerDataModel::toDomainModel)

    override suspend fun getQuickLinks(): List<List<QuickLinkDomainModel>> =
        apiService
            .getQuickLinks()
            .data!!
            .map {
                it.map(QuickLinkDataModel::toDomainModel)
            }

    override suspend fun getFlashDeals(): List<FlashDealDomainModel> =
        apiService
            .getFlashDeals()
            .data!!
            .map(FlashDealDataModel::toDomainModel)
}