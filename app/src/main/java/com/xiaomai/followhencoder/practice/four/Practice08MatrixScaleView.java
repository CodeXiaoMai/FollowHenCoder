package com.xiaomai.followhencoder.practice.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/16.
 */

public class Practice08MatrixScaleView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Matrix mMatrix = new Matrix();

    public Practice08MatrixScaleView(Context context) {
        super(context);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        mMatrix.reset();
        mMatrix.postScale(0.5f, 0.5f);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, 20, 20, mPaint);
        canvas.restore();

        canvas.save();
        mMatrix.reset();
        mMatrix.postScale(1.2f, 1.2f, 200 + mBitmap.getWidth() / 2, 200 + mBitmap.getHeight() / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, 200, 200, mPaint);
        canvas.restore();
    }
}
