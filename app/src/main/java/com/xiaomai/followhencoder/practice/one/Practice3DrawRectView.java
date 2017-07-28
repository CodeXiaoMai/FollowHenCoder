package com.xiaomai.followhencoder.practice.one;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/25.
 */

public class Practice3DrawRectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Rect mRect = new Rect();
    private RectF mRectF = new RectF();

    public Practice3DrawRectView(Context context) {
        super(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//      练习内容：使用 canvas.drawRect() 方法画矩形

        int middleWidth = getWidth() / 2;
        int middleHeight = getHeight() / 2;
        int left = middleWidth - 200;
        int top = middleHeight - 200;
        int right = middleWidth + 200;
        int bottom = middleHeight + 200;

        // 方法一：
//        canvas.drawRect(left, top, right, bottom, mPaint);

        // 方法二：
        mRect.set(left, top, right, bottom);
        canvas.drawRect(mRect, mPaint);

        // 方法三：
//        mRectF.set(left, top, right, bottom);
//        canvas.drawRect(mRectF, mPaint);
    }
}
