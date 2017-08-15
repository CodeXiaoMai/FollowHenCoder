package com.xiaomai.followhencoder.practice.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by xiaomai on 2017/8/14.
 */

public class Practice01ClipRectView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;

    public Practice01ClipRectView(Context context) {
        super(context);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - mBitmap.getWidth()) / 2;
        int top = (getHeight() - mBitmap.getHeight()) / 2;

        canvas.save();
        canvas.clipRect(left - 10, top - 10, left + mBitmap.getWidth() + 10, top + mBitmap.getHeight() + 10);
        canvas.drawColor(Color.CYAN);
        canvas.restore();

        canvas.save();
        canvas.clipRect(left - 10, top - 10, left - 10 + mBitmap.getWidth() / 2, top - 10 + mBitmap.getHeight() / 2);
        canvas.drawBitmap(mBitmap, left - 10, top - 10, mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipRect(left + 10 + mBitmap.getWidth() / 2, top - 10, left + 10 + mBitmap.getWidth(), top - 10 + mBitmap.getHeight() / 2);
        canvas.drawBitmap(mBitmap, left + 10, top - 10, mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipRect(left - 10, top + 10 + mBitmap.getHeight() / 2, left - 10 + mBitmap.getWidth() / 2, top + 10 + mBitmap.getHeight());
        canvas.drawBitmap(mBitmap, left - 10, top + 10, mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipRect(left + 10 + mBitmap.getWidth() / 2, top + 10 + mBitmap.getHeight() / 2, left + 10 + mBitmap.getWidth(), top + 10 + mBitmap.getHeight());
        canvas.drawBitmap(mBitmap, left + 10, top + 10, mPaint);
        canvas.restore();

        // Android O 新增功能
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            canvas.save();
//            canvas.clipOutRect(10, 10, 10 + mBitmap.getWidth() / 2, 10 + mBitmap.getHeight() / 2);
//            canvas.drawBitmap(mBitmap, 10, 10, mPaint);
//            canvas.restore();
//        }
    }
}
