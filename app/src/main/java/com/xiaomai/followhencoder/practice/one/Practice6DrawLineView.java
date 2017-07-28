package com.xiaomai.followhencoder.practice.one;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/25.
 */

public class Practice6DrawLineView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float[] mPoints = new float[12];

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//      练习内容：使用 canvas.drawLine() 方法画直线
        canvas.drawLine(
                getWidth() / 2 - 100,
                getHeight() / 2 - 100,
                getWidth() / 2 + 100,
                getHeight() / 2 + 100,
                mPaint);

        mPoints[0] = 250;
        mPoints[1] = getHeight() / 2;
        mPoints[2] = 250 - 100;
        mPoints[3] = getHeight() / 2 - 100;

        mPoints[4] = 250 - 100;
        mPoints[5] = getHeight() / 2 - 100;
        mPoints[6] = 250 - 100;
        mPoints[7] = getHeight() / 2 + 100;

        mPoints[8] = 250;
        mPoints[9] = getHeight() / 2;
        mPoints[10] = 250 - 100;
        mPoints[11] = getHeight() / 2 + 100;

        canvas.drawLines(mPoints, mPaint);
    }
}
