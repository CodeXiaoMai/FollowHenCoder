package com.xiaomai.followhencoder.practice.six.practice08;

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
 * Created by XiaoMai on 2017/9/8.
 */

public class Practice08ObjectAnimatorView extends View {
    private float progressWidth = Utils.dpToPixel(15);

    private Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mProgressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int progress;

    public Practice08ObjectAnimatorView(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mTextPaint.setTextSize(Utils.dpToPixel(50));
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mProgressPaint.setStrokeWidth(progressWidth);
        mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        mProgressPaint.setStyle(Paint.Style.STROKE);
        mProgressPaint.setColor(Color.parseColor("#E91E63"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int middleX = getWidth() / 2;
        int middleY = getHeight() / 2;

        String text = progress + "%";
        canvas.drawText(text, middleX, middleY - (mTextPaint.ascent() + mTextPaint.descent()) / 2, mTextPaint);

        int width = getWidth();
        int height = getHeight();
        float radius = Math.min(width, height) / 2 - progressWidth / 2;
        RectF rectF = new RectF(middleX - radius, middleY - radius, middleX + radius, middleY + radius);
        canvas.drawArc(rectF, 135f, progress * 1.0f / 100 * 270, false, mProgressPaint);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public int getProgress() {
        return progress;
    }
}
