package com.xiaomai.followhencoder.practice.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/16.
 */

public class Practice11CameraRotateView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Camera mCamera = new Camera();

    public Practice11CameraRotateView(Context context) {
        super(context);
    }

    public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = 30;
        int top = 100;

        canvas.save();

        mCamera.save();
        mCamera.rotateX(30);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();

        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();

        left = 500;
        top = 200;

        canvas.save();

        mCamera.save();
        mCamera.rotateY(30);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();

        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();

        left = 300;
        top = 400;

        canvas.save();

        mCamera.save();
        mCamera.rotateZ(30);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();

        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();
    }
}
