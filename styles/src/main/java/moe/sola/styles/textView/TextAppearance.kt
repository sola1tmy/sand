package moe.sola.styles.textView

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.text.AllCapsTransformationMethod
import androidx.appcompat.widget.AppCompatTextView
import moe.sola.unit.SP

/**
 * author: youhuajie
 * created on: 2020/4/1 10:34 AM
 * description:
 */
class TextAppearance {
    var mTextColorHighlight = 0
    var mTextColor: ColorStateList? = null
    var mTextColorHint: ColorStateList? = null
    var mTextColorLink: ColorStateList? = null
    var mTextSize: SP? = null
    var mTextLocales: LocaleList? = null
    var mFontFamily: String? = null
    var mFontTypeface: Typeface? = null
    var mFontFamilyExplicit = false
    var mTypefaceIndex = -1
    var mTextStyle = 0
    var mFontWeight = -1
    var mAllCaps = false
    var mShadowColor = 0
    var mShadowDx = 0f
    var mShadowDy: Float = 0f
    var mShadowRadius: Float = 0f
    var mHasElegant = false
    var mElegant = false
    var mHasFallbackLineSpacing = false
    var mFallbackLineSpacing = false
    var mHasLetterSpacing = false
    var mLetterSpacing = 0f
    var mFontFeatureSettings: String? = null
    var mFontVariationSettings: String? = null
}

inline fun AppCompatTextView.setTextAppearance(attributes: TextAppearance) {
    if (attributes.mTextColor != null) {
        setTextColor(attributes.mTextColor)
    }

    if (attributes.mTextColorHint != null) {
        setHintTextColor(attributes.mTextColorHint)
    }

    if (attributes.mTextColorLink != null) {
        setLinkTextColor(attributes.mTextColorLink)
    }

    if (attributes.mTextColorHighlight != 0) {
        highlightColor = attributes.mTextColorHighlight
    }

    attributes.mTextSize?.let {
        textSize = it.value
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        attributes.mTextLocales?.let {
            textLocales = it
        }
    }

    if (attributes.mTypefaceIndex != -1 && !attributes.mFontFamilyExplicit) {
        attributes.mFontFamily = null
    }

// todo typeface
//    setTypefaceFromAttrs(
//        attributes.mFontTypeface, attributes.mFontFamily,
//        attributes.mTypefaceIndex, attributes.mTextStyle, attributes.mFontWeight
//    )

    if (attributes.mShadowColor != 0) {
        setShadowLayer(
            attributes.mShadowRadius, attributes.mShadowDx, attributes.mShadowDy,
            attributes.mShadowColor
        )
    }

// todo 默认大写
//    if (attributes.mAllCaps) {
//        transformationMethod = AllCapsTransformationMethod(context)
//    }

    if (attributes.mHasElegant) {
        isElegantTextHeight = attributes.mElegant
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        if (attributes.mHasFallbackLineSpacing) {
            isFallbackLineSpacing = attributes.mFallbackLineSpacing
        }
    }

    if (attributes.mHasLetterSpacing) {
        letterSpacing = attributes.mLetterSpacing
    }

    if (attributes.mFontFeatureSettings != null) {
        fontFeatureSettings = attributes.mFontFeatureSettings
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        if (attributes.mFontVariationSettings != null) {

            fontVariationSettings = attributes.mFontVariationSettings
        }
    }
}