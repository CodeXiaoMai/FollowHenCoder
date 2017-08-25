package com.xiaomai.followhencoder.practice.five;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;

/**
 * Created by XiaoMai on 2017/8/25.
 */

public class Practice02BeforeOnDrawView extends AppCompatTextView {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mBounds = new RectF();

    public Practice02BeforeOnDrawView(Context context) {
        super(context);
    }

    public Practice02BeforeOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02BeforeOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setColor(Color.parseColor("#FFC107"));
        mPaint.setTextSize(28);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Layout layout = getLayout();

        mBounds.left = layout.getLineLeft(1);
        mBounds.right = layout.getLineRight(1);
        mBounds.top = layout.getLineTop(1);
        mBounds.bottom = layout.getLineBottom(1);

        canvas.drawRect(mBounds, mPaint);

        mBounds.left = layout.getLineLeft(layout.getLineCount() - 3);
        mBounds.right = layout.getLineRight(layout.getLineCount() - 3);
        mBounds.top = layout.getLineTop(layout.getLineCount() - 3);
        mBounds.bottom = layout.getLineBottom(layout.getLineCount() - 3);

        canvas.drawRect(mBounds, mPaint);
        super.onDraw(canvas);
    }
}
