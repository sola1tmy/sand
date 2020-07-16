package moe.sola.pageext.entity

import androidx.paging.Pager

/**
 * author: youhuajie
 * created on: 2020/3/19 8:55 AM
 * description:
 */
interface IPage<KEY, DATA> {

    fun data(): List<DATA>

    fun currentPage(): KEY

    fun nextPage(): KEY

    fun previousPage(): KEY

    fun itemCount(): Int
}