package com.xiaomai.followhencoder.practice.seven.practice06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.utils.Utils;

/**
 * Created by XiaoMai on 2017/9/13.
 */

public class Practice06KeyframeView extends View {
    public static final float RADIUS = Utils.dpToPixel(80);
    private float progress;

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice06KeyframeView(Context context) {
        super(context);
    }

    public Practice06KeyframeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06KeyframeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(Utils.dpToPixel(40));
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        mPaint.setColor(Color.parseColor("#E91E63"));
        mPaint.setStrokeWidth(Utils.dpToPixel(15));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawArc(new RectF(centerX - RADIUS, centerY - RADIUS, centerX + RADIUS, centerY + RADIUS),
                135, progress * 270 / 100, false, mPaint);

        float middle = (mPaint.ascent() + mPaint.descent()) / 2;

        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText((int)progress + "%", centerX, centerY - middle, mPaint);
    }
}
