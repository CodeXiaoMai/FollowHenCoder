package com.xiaomai.followhencoder.practice.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/15.
 */

public class Practice05RotateView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Point mPoint1 = new Point(100, 200);
    Point mPoint2 = new Point(400, 200);

    public Practice05RotateView(Context context) {
        super(context);
    }

    public Practice05RotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05RotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.rotate(90, mPoint1.x + mBitmap.getWidth() / 2, mPoint1.y + mBitmap.getHeight() / 2);
        canvas.drawBitmap(mBitmap, mPoint1.x, mPoint1.y, mPaint);
        canvas.restore();

        canvas.save();
        canvas.rotate(45, mPoint2.x + mBitmap.getWidth() / 2, mPoint2.y + mBitmap.getHeight() / 2);
        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();
    }
}
