package com.alexis.funchat.weidge

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat
import android.content.res.ColorStateList
import android.widget.ImageView.ScaleType
import android.view.ViewGroup
import android.graphics.Color
import android.os.Build
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.alexis.funchat.R


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/6/4  11:10
 */
class ImageTextView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    private var mIconView:ImageView
    private val mTextView:TextView

    init {

        super.setOrientation(HORIZONTAL)
        mIconView = ImageView(context)
        mIconView.contentDescription = null
        mIconView.scaleType = ScaleType.FIT_XY
        val iconParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        iconParams.gravity = Gravity.CENTER_VERTICAL
        val padding = context.resources.getDimensionPixelOffset(R.dimen.inner_padding)
        mIconView.setPadding(padding, padding, padding, padding)
        addView(mIconView, iconParams)

        mTextView = TextView(context)
        val textParams = LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT)
        textParams.weight = 1f
        mTextView.gravity = Gravity.CENTER_VERTICAL
        val margin = context.resources.getDimensionPixelOffset(R.dimen.normal_margin)
        textParams.marginStart = margin
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16.toFloat())
        addView(mTextView, textParams)

        val ta = context.obtainStyledAttributes(attrs, R.styleable.ImageTextView, defStyleAttr, 0)
        if (ta.hasValue(R.styleable.ImageTextView_android_src)) {
            mIconView.setImageDrawable(ta.getDrawable(R.styleable.ImageTextView_android_src))
        }
        if (ta.hasValue(R.styleable.ImageTextView_android_tint)) {
            mIconView.imageTintList = ta.getColorStateList(R.styleable.ImageTextView_android_tint)
        }
        if (ta.hasValue(R.styleable.ImageTextView_image_height)) {
            iconParams.height = ta.getDimensionPixelOffset(R.styleable.ImageTextView_image_height, iconParams.height)
        }
        if (ta.hasValue(R.styleable.ImageTextView_image_width)) {
            iconParams.width = ta.getDimensionPixelOffset(R.styleable.ImageTextView_image_width, iconParams.width)
        }
        if (ta.hasValue(R.styleable.ImageTextView_android_text)) {
            mTextView.text = ta.getString(R.styleable.ImageTextView_android_text)
        }
        if (ta.hasValue(R.styleable.ImageTextView_android_textColor)) {
            mTextView.setTextColor(ta.getColor(R.styleable.ImageTextView_android_textColor, Color.BLACK))
        }
        val isShowIndicator = ta.getBoolean(R.styleable.ImageTextView_isShowIndicator, false)
        if (isShowIndicator) {
            val indicator = ImageView(context)
            val indicatorParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
            indicator.setImageResource(R.drawable.ic_arrow_back_black)
            indicator.scaleType = ScaleType.CENTER
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                indicator.imageTintList = ColorStateList.valueOf(context.getColor(R.color.icon_tint_color))
            }
            addView(indicator, indicatorParams)
        }
        ta.recycle()
    }

    /**
     * 拦截设置为纵向的事件，必需
     */
    override fun setOrientation(orientation: Int) {
    }

    fun getIconView():ImageView{
        return mIconView
    }

    fun setText(text:CharSequence){
        mTextView.text = text
    }
}