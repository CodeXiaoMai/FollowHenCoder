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

public class Practice7DrawRoundRectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//      练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径。
            canvas.drawRoundRect(getWidth() / 2 - 200, getHeight() / 2 - 100, getWidth() / 2 + 200, getHeight() / 2 + 100, 50, 50, mPaint);
        } else {
            mRectF.set(getWidth() / 2 - 200, getHeight() / 2 - 100, getWidth() / 2 + 200, getHeight() / 2 + 100);
            canvas.drawRoundRect(mRectF, 50, 50, mPaint);
        }
    }
}
