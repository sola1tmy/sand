package moe.sola.state

/**
 * author: youhuajie
 * created on: 2019-08-22 09:25
 * description:
 */
class State (
    val type: Int,
    val error: Throwable? = null,
    val ext: Any? = null
) {

    companion object {
        const val STATE_START = 0
        const val STATE_COMPLETE = 1
        const val STATE_ERROR = 2

        val START = State(STATE_START)
        val COMPLETE = State(STATE_COMPLETE)

        fun error(error: Throwable): State = State(STATE_ERROR, error)
    }

}

