package com.xiaomai.followhencoder.practice.one;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/25.
 */

public class Practice5DrawOvalView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();

    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//      练习内容：使用 canvas.drawOval() 方法画椭圆
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            /**
             * 只能绘制横着的或者竖着的椭圆，不能绘制斜的（斜的倒是也可以，但不是直接使用 drawOval()，
             * 而是配合几何变换）。
             * left, top, right, bottom 是这个椭圆的左、上、右、下四个边界点的坐标。
             */
            canvas.drawOval(getWidth() / 2 - 200, getHeight() / 2 - 50, getWidth() / 2 + 200, getHeight() / 2 + 50, mPaint);
        } else {
            mRectF.set(getWidth() / 2 - 200, getHeight() / 2 - 50, getWidth() / 2 + 200, getHeight() / 2 + 50);
            canvas.drawOval(mRectF, mPaint);
        }
    }
}
