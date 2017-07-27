package com.xiaomai.followhencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/25.
 */

public class Practice4DrawPointsView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice4DrawPointsView(Context context) {
        super(context);
    }

    public Practice4DrawPointsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//      练习内容：使用 canvas.drawPoint() 方法画点
//      一个圆点，一个方点
//      圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        mPaint.setStrokeWidth(50);

        /**
         * 点的形状可以通过  paint.setStrokeCap(cap) 来设置：
         * ROUND 画出来是圆形的点，
         * SQUARE 或 BUTT 画出来是方形的点。
         * 但这个方法并不是专门用来设置点的形状的，而是一个设置线条端点形状的方法。
         * 端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种
         */
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(getWidth() / 2 - 100, getHeight() / 2, mPaint);

//        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(getWidth() / 2 + 100, getHeight() / 2, mPaint);
    }
}
