package moe.sola.view

import android.text.TextUtils
import android.widget.TextView

/**
 * author: youhuajie
 * created on: 2020/3/18 4:08 PM
 * description:
 */
fun TextView.singleLineEllipsize() {
    ellipsize = TextUtils.TruncateAt.END
    isSingleLine = true
    maxLines = 1
}