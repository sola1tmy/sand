package moe.sola.bind_sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.lifecycle.LiveData
import moe.sola.binding.bindContext
import moe.sola.livedataext.mutableLiveData
import moe.sola.unit.dp
import moe.sola.view_dsl.button
import moe.sola.view_dsl.layout.ILayout
import moe.sola.view_dsl.layout.setContentView
import moe.sola.view_dsl.lp.wrapContent
import moe.sola.view_dsl.textView
import moe.sola.view_dsl.verticalLayout

class MainActivity : AppCompatActivity() {

    val layout by lazy { Layout(this) }

    val number by mutableLiveData(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout)
        layout.button.setOnClickListener {
            number.value = number.value?.plus(1)
        }
        bindContext {
            number.bind { layout.text.text = it.toString() }
        }
    }


    class Layout(override val context: Context) : ILayout {

        override val layout: View by verticalLayout {
            text(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_HORIZONTAL
            }
            button(100.dp, 50.dp) {
                gravity = Gravity.CENTER_HORIZONTAL
            }
        }

        val text by textView { }
        val button by button { text = "+" }
    }


}
