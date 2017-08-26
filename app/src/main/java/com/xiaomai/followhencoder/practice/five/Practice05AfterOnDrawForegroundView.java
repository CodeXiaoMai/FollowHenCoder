package com.xiaomai.followhencoder.practice.five;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by xiaomai on 2017/8/26.
 */

public class Practice05AfterOnDrawForegroundView extends AppCompatImageView {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Rect mBounds = new Rect();

    public Practice05AfterOnDrawForegroundView(Context context) {
        super(context);
    }

    public Practice05AfterOnDrawForegroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05AfterOnDrawForegroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(60);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);

        mPaint.getTextBounds("New", 0, 3, mBounds);
        mPaint.setColor(Color.parseColor("#f44336"));
        canvas.drawRect(0, 10, mBounds.width() * 1.5f, mBounds.height() * 1.5f + 10, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawText("New", 20, mBounds.height() + 20, mPaint);
    }
}
