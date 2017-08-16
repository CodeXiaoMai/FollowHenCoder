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

public class Practice07MatrixTranslateView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Matrix mMatrix = new Matrix();

    public Practice07MatrixTranslateView(Context context) {
        super(context);
    }

    public Practice07MatrixTranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07MatrixTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 把 Matrix 应用到 Canvas 有两个方法： Canvas.setMatrix(matrix) 和 Canvas.concat(matrix)。
         * Canvas.setMatrix(matrix)：用 Matrix 直接替换 Canvas 当前的变换矩阵，即抛弃 Canvas 当前的变换，
         * 改用 Matrix 的变换（注：不同的系统中  setMatrix(matrix) 的行为可能不一致，所以还是尽量用 concat(matrix) 吧）；
         *
         * Canvas.concat(matrix)：用 Canvas 当前的变换矩阵和 Matrix 相乘，即基于 Canvas 当前的变换，叠加上 Matrix 中的变换。
         */

        canvas.save();
        mMatrix.reset();
        mMatrix.postTranslate(50, 50);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        canvas.restore();

        canvas.save();
        mMatrix.reset();
        mMatrix.postTranslate(-20, -20);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, 300, 300, mPaint);
        canvas.restore();
    }
}
