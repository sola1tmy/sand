package moe.sola.android.common.exception

/**
 * author: youhuajie
 * created on: 2020-03-09 16:43
 * description:
 */
class SandException: Exception {

    constructor(msg: String): super(msg)

    constructor(throwable: Throwable): super(throwable)


}