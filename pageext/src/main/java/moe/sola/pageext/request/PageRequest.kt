package moe.sola.pageext.request

import io.reactivex.rxjava3.core.Maybe
import moe.sola.pageext.entity.IPage

/**
 * author: youhuajie
 * created on: 2020/3/19 9:50 AM
 * description:
 */
interface IPageRequest<KEY, VALUE> {

    fun page(resultAction: (IPage<KEY, VALUE>)-> Unit, errorAction: (Throwable)-> Unit)

}

fun <KEY, VALUE> Maybe<IPage<KEY, VALUE>>.handlePage(): IPageRequest<KEY, VALUE> {
    return object: IPageRequest<KEY, VALUE> {
        override fun page(
            resultAction: (IPage<KEY, VALUE>) -> Unit,
            errorAction: (Throwable) -> Unit
        ) {
            this@handlePage
                .doOnSuccess { resultAction(it) }
                .doOnError { errorAction(it) }
        }

    }

}