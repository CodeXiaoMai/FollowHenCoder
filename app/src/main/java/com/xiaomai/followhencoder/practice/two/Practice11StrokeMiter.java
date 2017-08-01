package com.xiaomai.followhencoder.practice.two;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/8/1.
 */

public class Practice11StrokeMiter extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public Practice11StrokeMiter(Context context) {
        super(context);
    }

    public Practice11StrokeMiter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11StrokeMiter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);
        
        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.translate(100, 100);
        // MITER 值：1
        mPaint.setStrokeMiter(1);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // MITER 值：2
        mPaint.setStrokeMiter(2);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(0, 200);
        // MITER 值：5
        mPaint.setStrokeMiter(5);
        canvas.drawPath(mPath, mPaint);

        canvas.restore();
    }
}
