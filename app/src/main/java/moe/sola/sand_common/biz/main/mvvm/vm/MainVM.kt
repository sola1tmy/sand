package moe.sola.sand_common.biz.main.mvvm.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.apollographql.apollo.api.Response
import io.reactivex.Maybe
import moe.sola.pageext.easyPage
import moe.sola.sand_common.GithubRepositoriesQuery
import moe.sola.sand_common.biz.main.mvvm.Repository

/**
 * author: youhuajie
 * created on: 2020/4/6 9:43 PM
 * description:
 */
class MainVM(app: Application) : AndroidViewModel(app) {

    val page by lazy {
    }

    fun loadPage(): Maybe<Response<GithubRepositoriesQuery.Data>>? {

        return Repository().getRepositories()
            .elementAt(0)
    }
}