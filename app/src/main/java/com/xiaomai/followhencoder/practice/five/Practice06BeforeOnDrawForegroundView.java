package com.xiaomai.followhencoder.practice.five;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by xiaomai on 2017/8/26.
 */

public class Practice06BeforeOnDrawForegroundView extends AppCompatImageView {
    
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    
    public Practice06BeforeOnDrawForegroundView(Context context) {
        super(context);
    }

    public Practice06BeforeOnDrawForegroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06BeforeOnDrawForegroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    {
        mPaint.setTextSize(60);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        mPaint.setColor(Color.parseColor("#f44336"));
        canvas.drawRect(0, 40, 200, 120, mPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("New", 20, 100, mPaint);

        super.onDrawForeground(canvas);
    }
}
