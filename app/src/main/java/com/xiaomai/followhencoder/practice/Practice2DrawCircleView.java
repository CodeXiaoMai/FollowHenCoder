package com.xiaomai.followhencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/25.
 */

public class Practice2DrawCircleView extends View {

    /**
     * 所谓的毛边或者锯齿，发生的原因并不是很多人所想象的「绘制太粗糙」「像素计算能力不足」；
     * 同样，抗锯齿的原理也并不是选择了更精细的算法来算出了更平滑的图形边缘。
     * 实质上，锯齿现象的发生，只是由于图形分辨率过低，导致人眼察觉出了画面中的像素颗粒而已。
     * 换句话说，就算不开启抗锯齿，图形的边缘也已经是最完美的了，而并不是一个粗略计算的粗糙版本。
     * 那么，为什么抗锯齿开启之后的图形边缘会更加平滑呢？
     * 因为抗锯齿的原理是：修改图形边缘处的像素颜色，从而让图形在肉眼看来具有更加平滑的感觉。
     */
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        /* 开始画第一个圆 */
        /**
         * setStyle(Style style) 这个方法设置的是绘制的 Style 。
         * Style 具体来说有三种： FILL, STROKE 和  FILL_AND_STROKE 。
         * FILL 是填充模式，
         * STROKE 是画线模式（即勾边模式），
         * FILL_AND_STROKE 是两种模式一并使用：既画线又填充。
         * 它的默认值是 FILL，填充模式。
         */
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth() * 2 / 7, getHeight() * 2 / 7, 100, mPaint);

        /* 开始画第二个圆 */
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(getWidth() * 5 / 7, getHeight() * 2 / 7, 100, mPaint);

        /* 开始画第三个圆 */
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(getWidth() * 2 / 7, getHeight() * 5 / 7, 100, mPaint);

        /* 开始画第四个圆 */
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth() * 5 / 7, getHeight() * 5 / 7, 100, mPaint);
    }
}
