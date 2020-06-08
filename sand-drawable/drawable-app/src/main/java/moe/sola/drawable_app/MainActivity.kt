package moe.sola.drawable_app

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import moe.sola.android.common.Sand
import moe.sola.sand.drawable.colorDrawable
import moe.sola.sand.drawable.corner.cornerDrawable
import moe.sola.sand.drawable.layerDrawable
import moe.sola.sand.drawable.selectable.selectableItemBackground
import moe.sola.sand.drawable.stateDrawable

class MainActivity : AppCompatActivity() {


    val stateButton by lazy { findViewById<Button>(R.id.state_drawable) }
    val layerButton by lazy { findViewById<Button>(R.id.layerDrawable) }
    val cornerButton by lazy { findViewById<Button>(R.id.corner_drawable) }
    val selectableButton by lazy { findViewById<Button>(R.id.selectable_drawable) }
    val colorButton by lazy { findViewById<Button>(R.id.color_drawable) }


    override fun onCreate(savedInstanceState: Bundle?) {
        Sand.setup(application)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorButton.setDrawableEvent(colorDrawable(Color.RED))

        cornerButton.setDrawableEvent(
            cornerDrawable(Color.RED, 30f)
        )

        selectableButton.setDrawableEvent(selectableItemBackground() ?: colorDrawable(Color.GREEN))

        stateButton.setDrawableEvent(
            stateDrawable(
                enableDrawable = colorDrawable(Color.WHITE),
                disableDrawable = colorDrawable(Color.GRAY),
                clickDrawable = colorDrawable(Color.WHITE.withAlpha(80))
            )
        )
        layerButton.setDrawableEvent(
            layerDrawable(
                colorDrawable(Color.YELLOW),
                selectableItemBackground() ?: colorDrawable(Color.TRANSPARENT)
            )
        )
    }

    fun Button.setDrawableEvent(drawable: Drawable) {
        setOnClickListener {
            this@MainActivity.findViewById<View>(R.id.drawable_view).background = drawable
        }
    }

    fun Int.withAlpha(alpha: Int): Int {
        require(alpha in 0..0xFF)
        return this and 0x00FFFFFF or (alpha shl 24)
    }
}
