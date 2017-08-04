package com.xiaomai.followhencoder.practice.three;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01DrawTextView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    String text = "Hello HenCoder";

    public Practice01DrawTextView(Context context) {
        super(context);
    }

    public Practice01DrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);

        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(150, 300);
        path.rLineTo(80, -20);
        path.rLineTo(80, 40);
        path.rLineTo(80, -40);
        path.rLineTo(80, 40);
        path.rLineTo(80, -40);
        path.rLineTo(80, 40);
        path.rLineTo(80, -40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 drawText() 来绘制文字
        // 文字坐标： (50, 100)
        canvas.drawText(text, 50, 100, paint);

        canvas.drawText(text, 0, 0, paint);

        paint.setPathEffect(new CornerPathEffect(20));
        canvas.drawPath(path, paint);
        canvas.drawTextOnPath(text, path, 0, -5, paint);
    }
}
