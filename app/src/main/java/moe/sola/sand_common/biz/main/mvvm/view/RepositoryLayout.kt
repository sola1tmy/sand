package moe.sola.sand_common.biz.main.mvvm.view

import android.content.Context
import moe.sola.view_dsl.compat.toolbar
import moe.sola.view_dsl.compat.verticalRecyclerView
import moe.sola.view_dsl.layout.ILayout
import moe.sola.view_dsl.verticalLayout

/**
 * author: youhuajie
 * created on: 2020/3/28 3:40 PM
 * description:
 */
class RepositoryLayout(override val context: Context): ILayout {

    private val toolbar by toolbar {
        title = "repositories"
    }

    private val repositoryRecycler by verticalRecyclerView {
    }

    override val layout by verticalLayout {
        toolbar()
        repositoryRecycler()

    }

}