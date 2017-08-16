package com.xiaomai.followhencoder.practice.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/16.
 */

public class Practice10MatrixSkewView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Matrix mMatrix = new Matrix();
    Point mPoint1 = new Point(100, 100);
    Point mPoint2 = new Point(500, 100);

    public Practice10MatrixSkewView(Context context) {
        super(context);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        mMatrix.postSkew(-0.5f, 0, mPoint1.x + mBitmap.getWidth() / 2, mPoint1.y + mBitmap.getHeight() / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint1.x, mPoint1.y, mPaint);
        canvas.restore();

        canvas.save();
        mMatrix.reset();
        mMatrix.postSkew(0, 0.5f, mPoint2.x + mBitmap.getWidth() / 2, mPoint2.y + mBitmap.getHeight() / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();
    }
}
