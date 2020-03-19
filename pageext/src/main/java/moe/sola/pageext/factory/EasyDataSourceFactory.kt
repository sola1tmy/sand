package moe.sola.pageext.factory

import androidx.paging.DataSource
import io.reactivex.rxjava3.core.Maybe
import moe.sola.pageext.datasource.EasyDataSource
import moe.sola.pageext.entity.IPage
import moe.sola.pageext.request.IPageRequest


/**
 * author: youhuajie
 * created on: 2020/3/18 4:20 PM
 * description:
 */
class EasyDataSourceFactory<KEY, VALUE>(val request: (KEY, Int)-> IPageRequest<KEY, VALUE>, val initKey: KEY): DataSource.Factory<KEY, VALUE>() {

    override fun create(): DataSource<KEY, VALUE> {
        return EasyDataSource(initKey, request)
    }

}