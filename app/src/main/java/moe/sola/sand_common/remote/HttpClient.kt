package moe.sola.sand_common.remote

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

/**
 * author: youhuajie
 * created on: 2020/3/26 8:17 PM
 * description:
 */
val okHttp: OkHttpClient
    get() {
        return OkHttpClient.Builder()
            .addInterceptor {
                val originRequest = it.request()
                val headers = originRequest.headers().newBuilder().add("Authorization", "Bearer " + "edb4bf9c3b3d0bad143cd767b1546a568e22ce33")
                 it.proceed(
                    originRequest.newBuilder().headers(headers.build()).build()
                )
            }
            .build()
    }

val githubClient: ApolloClient
    get() {
        return ApolloClient.builder()
            .serverUrl("https://api.github.com/graphql")
            .okHttpClient(okHttp)
            .build()
    }