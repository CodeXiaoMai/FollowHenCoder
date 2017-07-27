package com.xiaomai.followhencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/26.
 */

public class Practice9DrawPathView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Path mPath = new Path();

    private RectF mRectF = new RectF();

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//      练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        // 将 path 的起点移动到 canvas 的中间
        mPath.moveTo(getWidth() / 2, getHeight() / 2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.addArc(getWidth() / 2, getHeight() / 2 - 100, getWidth() / 2 + 200, getHeight() / 2 + 100, 180, 225);
        } else {
            mRectF.set(getWidth() / 2, getHeight() / 2 - 100, getWidth() / 2 + 200, getHeight() / 2 + 100);
            mPath.addArc(mRectF, 180, 225);
        }
        mPath.lineTo(getWidth() / 2, getHeight() / 2 + 250);

        mPath.moveTo(getWidth() / 2, getHeight() / 2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.addArc(getWidth() / 2 - 200, getHeight() / 2 - 100, getWidth() / 2, getHeight() / 2 + 100, 135, 225);
        } else {
            mRectF.set(getWidth() / 2 - 200, getHeight() / 2 - 100, getWidth() / 2, getHeight() / 2 + 100);
            mPath.addArc(mRectF, 135, 225);
        }
        mPath.lineTo(getWidth() / 2, getHeight() / 2 + 250);

        canvas.drawPath(mPath, mPaint);
    }
}
