package moe.sola.pageext.datasource

import androidx.paging.PageKeyedDataSource
import io.reactivex.rxjava3.core.Maybe
import moe.sola.pageext.entity.IPage
import moe.sola.pageext.request.IPageRequest

/**
 * author: youhuajie
 * created on: 2020/3/18 4:27 PM
 * description:
 */
class EasyDataSource<KEY, VALUE>(
    val initKey: KEY,
    val request: (KEY, Int) -> IPageRequest<KEY, VALUE>
) : PageKeyedDataSource<KEY, VALUE>() {

    override fun loadInitial(
        params: LoadInitialParams<KEY>,
        callback: LoadInitialCallback<KEY, VALUE>
    ) {
        request.invoke(initKey, params.requestedLoadSize).page({
            callback.onResult(it.datas(), it.nextPage(), it.currentPage())
        }, {
            callback.onError(it)
        })
    }

    override fun loadAfter(params: LoadParams<KEY>, callback: LoadCallback<KEY, VALUE>) {
        request.invoke(params.key, params.requestedLoadSize).page({
            callback.onResult(it.datas(), it.nextPage())
        }, {
            callback.onError(it)
        })
    }

    override fun loadBefore(params: LoadParams<KEY>, callback: LoadCallback<KEY, VALUE>) {
        request.invoke(params.key, params.requestedLoadSize).page({
            callback.onResult(it.datas(), it.previousPage())
        }, {
            callback.onError(it)
        })
    }

}