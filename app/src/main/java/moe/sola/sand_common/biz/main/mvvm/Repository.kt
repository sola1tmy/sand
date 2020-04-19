package moe.sola.sand_common.biz.main.mvvm

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx2.rxQuery
import io.reactivex.Observable
import moe.sola.sand_common.GithubRepositoriesQuery
import moe.sola.sand_common.remote.githubClient
import moe.sola.sand_common.type.OrderDirection
import moe.sola.sand_common.type.RepositoryOrderField

/**
 * author: youhuajie
 * created on: 2020/3/28 3:37 PM
 * description:
 */
class Repository {

    fun getRepositories(): Observable<Response<GithubRepositoriesQuery.Data>> {
        return githubClient
            .rxQuery(
                GithubRepositoriesQuery(
                    10,
                    RepositoryOrderField.CREATED_AT,
                    OrderDirection.ASC
                )
            )
    }

}