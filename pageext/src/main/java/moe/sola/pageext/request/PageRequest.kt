package moe.sola.pageext.request

import moe.sola.pageext.entity.IPage

/**
 * author: youhuajie
 * created on: 2020/3/19 9:50 AM
 * description:
 */
interface IPageRequest<KEY, VALUE> {

    fun page(resultAction: (IPage<KEY, VALUE>)-> Unit, errorAction: (Throwable)-> Unit)

}