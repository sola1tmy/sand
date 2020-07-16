package moe.sola.pageext

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import moe.sola.pageext.factory.EasyDataSourceFactory
import moe.sola.pageext.request.IPageRequest

/**
 * author: youhuajie
 * created on: 2020/3/18 4:15 PM
 * description:
 */
fun <KEY, VALUE> easyPage(
    creator: (KEY, Int) -> IPageRequest<KEY, VALUE>,
    key: KEY,
    config: PagedList.Config = PagedList.Config.Builder().setPageSize(10).build()
) {
    LivePagedListBuilder(EasyDataSourceFactory(creator, key), config).build()
}