package com.xiaomai.followhencoder.practice.two;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/8/1.
 */

public class Practice13ShadowLayer extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Rect mBounds = new Rect();

    public Practice13ShadowLayer(Context context) {
        super(context);
    }

    public Practice13ShadowLayer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13ShadowLayer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Hello HenCoder";
        mPaint.setShadowLayer(10, 5, 5, Color.parseColor("#ff0000"));
        mPaint.setTextSize(80);
        mPaint.getTextBounds(text, 0, text.length(), mBounds);
        canvas.drawText("Hello HenCoder", getWidth() / 2 - mBounds.width() / 2, getHeight() / 2 + mBounds.height() / 2, mPaint);
    }
}
