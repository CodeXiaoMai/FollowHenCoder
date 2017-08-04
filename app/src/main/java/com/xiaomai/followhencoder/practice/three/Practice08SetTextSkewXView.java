package com.xiaomai.followhencoder.practice.three;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice08SetTextSkewXView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice08SetTextSkewXView(Context context) {
        super(context);
    }

    public Practice08SetTextSkewXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08SetTextSkewXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);

        // 使用 Paint.setTextSkewX() 来让文字倾斜

        paint.setTextSkewX(-0.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("skewx = -0.5f, 向右偏", 50, 100, paint);

        paint.setTextSkewX(0.5f);
        canvas.drawText("skewx = 0.5f, 向左偏", 50, 300, paint);
    }
}