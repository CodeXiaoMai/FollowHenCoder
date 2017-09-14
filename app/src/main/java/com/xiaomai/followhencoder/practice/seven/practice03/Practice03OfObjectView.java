package com.xiaomai.followhencoder.practice.seven.practice03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.utils.Utils;

/**
 * Created by XiaoMai on 2017/9/12.
 */

public class Practice03OfObjectView extends View {
    public static final float RADIUS = Utils.dpToPixel(20);

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private PointF position = new PointF();

    public Practice03OfObjectView(Context context) {
        super(context);
    }

    public Practice03OfObjectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03OfObjectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setColor(Color.parseColor("#009688"));
    }

    public PointF getPosition() {
        return position;
    }

    public void setPosition(PointF position) {
        if (position != null) {
            this.position.set(position);
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth() - RADIUS * 2;
        float height = getHeight() - RADIUS * 2;

        canvas.drawCircle(RADIUS + width * position.x, RADIUS + height * position.y, RADIUS, mPaint);
    }
}
