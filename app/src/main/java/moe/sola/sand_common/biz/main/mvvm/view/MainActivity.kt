package moe.sola.sand_common.biz.main.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import moe.sola.view_dsl.layout.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(RepositoryLayout(this))

    }
}
