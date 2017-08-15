package com.xiaomai.followhencoder.practice.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/15.
 */

public class Practice02ClipPathView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Path mPath1 = new Path();
    Path mPath2 = new Path();

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        mPath2.setFillType(Path.FillType.INVERSE_WINDING);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath1.addCircle(getWidth() / 2 + mBitmap.getWidth() / 2, getHeight() / 2 + mBitmap.getHeight() / 2, mBitmap.getWidth() * 2 / 3, Path.Direction.CW);
        mPath2.addCircle(getWidth() / 2 + mBitmap.getWidth() / 2 - 10, getHeight() / 2 + mBitmap.getHeight() / 2 - 10, mBitmap.getWidth() * 2 / 3, Path.Direction.CW);

        canvas.save();
        canvas.clipPath(mPath1);
        canvas.drawBitmap(mBitmap, getWidth() / 2 - mBitmap.getWidth() / 2, getHeight() / 2 - mBitmap.getHeight() / 2, mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(mPath2);
        canvas.drawBitmap(mBitmap, getWidth() / 2 - mBitmap.getWidth() / 2 - 10, getHeight() / 2 - mBitmap.getHeight() / 2 - 10, mPaint);
        canvas.restore();
    }
}
