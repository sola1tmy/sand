package com.example.state_sample

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moe.sola.state.IStateHandler
import moe.sola.state.State
import moe.sola.state_rx.bind
import moe.sola.state.bindState

class MainActivity : AppCompatActivity() {

    val successButton by lazy { findViewById<View>(R.id.load_success_button) }
    val failButton by lazy { findViewById<View>(R.id.load_error_button) }

    val progressDialog by lazy { ProgressDialog(this) }
    val disposeList = mutableListOf<Disposable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        successButton.setOnClickListener {
            disposeList.add(
                loadDataMaybe()
                    .bindPrompt()
                    .subscribeOn(Schedulers.io())
                    .bindStateView()
                    .subscribe({}, Throwable::printStackTrace)
            )
        }

        failButton.setOnClickListener {
            disposeList.add(
                loadDataMaybeError().bindPrompt()
                    .subscribeOn(Schedulers.io())
                    .bindStateView()
                    .subscribe({}, Throwable::printStackTrace)
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposeList.forEach {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    fun Maybe<Any>.bindPrompt(): Maybe<Any> {
        return bind(object : IStateHandler(this@MainActivity) {
            override fun doByState(state: State?) {
                when (state?.type) {
                    State.START.type -> progressDialog.show()
                    State.COMPLETE.type -> {
                        progressDialog.dismiss()
                        Toast.makeText(
                            this@MainActivity,
                            "success!!!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    State.STATE_ERROR -> {
                        progressDialog.dismiss()
                        Toast.makeText(
                            this@MainActivity,
                            "error!!!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        })
    }

    fun Maybe<Any>.bindStateView(): Maybe<Any> {
        val contentView = findViewById<View>(R.id.content)
        val parent = contentView.parent as ViewGroup
        val position = parent.indexOfChild(contentView)

        var frameLayout: FrameLayout
        var errorView: TextView
        if (contentView.parent is FrameLayout && (contentView.parent as FrameLayout).tag == "stateLayout") {
            frameLayout = contentView.parent as FrameLayout
            errorView = frameLayout.findViewWithTag("errorView")
        } else {
            frameLayout = FrameLayout(this@MainActivity).apply {
                tag = "stateLayout"
                layoutParams = contentView.layoutParams
            }
            parent.removeViewAt(position)
            parent.addView(frameLayout, position)

            contentView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            errorView = TextView(this@MainActivity).apply {
                tag = "errorView"
                text = "I'm error state view"
                visibility = View.GONE
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
            frameLayout.addView(contentView)
            frameLayout.addView(errorView)
        }






        return bind(object : IStateHandler(this@MainActivity) {
            override fun doByState(state: State?) {
                when (state?.type) {
                    State.COMPLETE.type -> {
                        errorView.visibility = View.GONE
                        contentView.visibility = View.VISIBLE
                    }
                    State.STATE_ERROR -> {
                        errorView.visibility = View.VISIBLE
                        contentView.visibility = View.GONE
                    }
                }
            }

        })
    }


    fun loadDataMaybe(): Maybe<Any> {

        return Maybe.create {
            Thread.sleep(2000)
            it.onSuccess(Any())
        }
    }

    fun loadDataMaybeError(): Maybe<Any> {
        return Maybe.create {
            Thread.sleep(2000)
            it.onError(Throwable("error!!!"))
        }
    }
}