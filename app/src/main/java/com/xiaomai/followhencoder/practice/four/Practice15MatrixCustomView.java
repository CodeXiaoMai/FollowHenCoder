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

public class Practice15MatrixCustomView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Matrix mMatrix = new Matrix();

    public Practice15MatrixCustomView(Context context) {
        super(context);
    }

    public Practice15MatrixCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice15MatrixCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float left = (getWidth() - mBitmap.getWidth()) / 2;
        float top = (getHeight() - mBitmap.getHeight()) / 2;
        float right = left + mBitmap.getWidth();
        float bottom = top + mBitmap.getHeight();

        canvas.drawBitmap(mBitmap, 10, top, mPaint);

        float[] pointsSrc = {left, top, right, top, left, bottom, right, bottom};
        float[] pointsDst = {left - 10, top + 50, right + 120, top - 90, left + 20, bottom + 30, right + 20, bottom + 60};
        canvas.save();
        mMatrix.reset();
        mMatrix.setPolyToPoly(pointsSrc,//源点集合
                0, //第一个点的偏移
                pointsDst, // 目标点集
                0, // 第一个点的偏移
                4 // 采集的点的个数（个数不能大于 4，因为大于 4 个点就无法计算变换了）
        );
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();
    }
}
