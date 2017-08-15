package com.xiaomai.followhencoder.practice.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/15.
 */

public class Practice03TranslateView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;

    public Practice03TranslateView(Context context) {
        super(context);
    }

    public Practice03TranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03TranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, 50, 50, mPaint);

        canvas.save();
        canvas.translate(mBitmap.getWidth() + 50, mBitmap.getHeight() + 50);
        canvas.drawBitmap(mBitmap, 10, 10, mPaint);
        canvas.restore();
    }
}
