package com.xiaomai.followhencoder.practice;

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

public class Practice8DrawArcView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(getWidth() / 2 - 200, getHeight() / 2 - 100, getWidth() / 2 + 200, getHeight() / 2 + 100, -110, 100, true, mPaint);
            canvas.drawArc(getWidth() / 2 - 200, getHeight() / 2 - 100, getWidth() / 2 + 200, getHeight() / 2 + 100, 10, 160, false, mPaint);

            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(getWidth() / 2 - 200, getHeight() / 2 - 100, getWidth() / 2 + 200, getHeight() / 2 + 100, 180, 60, false, mPaint);
        } else {
            mRectF.set(getWidth() / 2 - 200, getHeight() / 2 - 100, getWidth() / 2 + 200, getHeight() / 2 + 100);
            canvas.drawArc(mRectF, -110, 100, true, mPaint);
            canvas.drawArc(mRectF, 10, 160, false, mPaint);

            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(mRectF, 180, 60, false, mPaint);
        }
    }
}
