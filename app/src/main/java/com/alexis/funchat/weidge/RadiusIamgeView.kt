package com.alexis.funchat.weidge

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import com.alexis.funchat.R


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/6/4  10:03
 */

class RadiusIamgeView(context: Context, attributes: AttributeSet?=null, defStyleAttr:Int = 0) : AppCompatImageView(context,attributes,defStyleAttr) {
    private val TAG: String? = RadiusIamgeView::class.simpleName

    private var mRadius:Float = 0f
    private var mLTRadius:Float = 0f
    private var mLBRadius:Float = 0f
    private var mRTRadius:Float = 0f
    private var mRBRadius:Float = 0f
    private var mPath:Path = Path()
    init {
        var ta:TypedArray = context.obtainStyledAttributes(attributes, R.styleable.RadiusIamgeView,defStyleAttr,0)
        if (ta.hasValue(R.styleable.RadiusIamgeView_radius)){
            mRadius = ta.getDimensionPixelOffset(R.styleable.RadiusIamgeView_radius,0).toFloat()
        }
        if(mRadius == 0.toFloat()){
            mLTRadius = ta.getDimensionPixelOffset(R.styleable.RadiusIamgeView_ltRadius,0).toFloat()
            mLBRadius = ta.getDimensionPixelOffset(R.styleable.RadiusIamgeView_lbRadius,0).toFloat()
            mRTRadius = ta.getDimensionPixelOffset(R.styleable.RadiusIamgeView_rtRadius,0).toFloat()
            mRBRadius = ta.getDimensionPixelOffset(R.styleable.RadiusIamgeView_rbRadius,0).toFloat()
        }else{
            mLTRadius = mRadius
            mLBRadius = mRadius
            mRTRadius = mRadius
            mRBRadius = mRadius
        }
        ta.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        if (mLTRadius == 0f&&mLBRadius == 0f&&mRTRadius == 0f&&mRBRadius == 0f){
            super.onDraw(canvas)
            return
        }
        Log.e(TAG,"onDraw...")
        //这里做下判断，只有图片的宽高大于设置的圆角距离的时候才进行裁剪
        val maxLeft:Float = Math.max(mLTRadius, mLBRadius)
        val maxRight:Float = Math.max(mRTRadius, mRBRadius)
        val minWidth:Float = maxLeft + maxRight
        val maxTop:Float = Math.max(mLTRadius, mRTRadius)
        val maxBottom:Float = Math.max(mLBRadius, mRBRadius)
        val minHeight:Float = maxTop + maxBottom

        val top = paddingTop.toFloat()
        val right = paddingRight.toFloat()
        val bottom = paddingBottom.toFloat()
        val left = paddingLeft.toFloat()
        val width = measuredWidth.toFloat()
        val height = measuredHeight.toFloat()
        //绘制的实际宽度为控件宽度减去左右padding
        val realWidth = width - left - right;
        //绘制的实际高度为控件宽度减去上下padding
        val realHeight = height - top - bottom;
        Log.e(TAG, "minWidth = $minWidth, minHeight = $minHeight, realWidth = $realWidth, realHeight = $realHeight, width = $width, height = $height")
        if (realWidth >= minWidth && realHeight >= minHeight) {
            mPath.reset();
            //四个角：右上，右下，左下，左上
            val startX:Float = mLTRadius + paddingLeft.toFloat()
            val startY:Float = paddingTop.toFloat()
            mPath.moveTo(startX, startY)
            mPath.rLineTo(realWidth - mLTRadius - mRTRadius, 0f)
            mPath.rQuadTo(mRTRadius, 0f, mRTRadius, mRTRadius)

            mPath.rLineTo(0f, realHeight - mRTRadius - mRBRadius)
            mPath.rQuadTo(0f, mRBRadius, -mRBRadius, mRBRadius)

            mPath.rLineTo(-(realWidth - mRBRadius - mLBRadius), 0f)
            mPath.rQuadTo(-mLBRadius, 0f, -mLBRadius, -mLBRadius)

            mPath.rLineTo(0f, -(realHeight - mLBRadius - mLTRadius))
            mPath.rQuadTo(0f, -mLTRadius, mLTRadius, -mLTRadius)

            canvas?.clipPath(mPath)
        }
        super.onDraw(canvas)
    }
}