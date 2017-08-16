package com.xiaomai.followhencoder.practice.four;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/16.
 */

public class Practice13CameraRotateHittingFaceView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Camera mCamera = new Camera();
    int degree;
    ObjectAnimator mAnimator = ObjectAnimator.ofInt(this, "degree", 0, 360);

    public Practice13CameraRotateHittingFaceView(Context context) {
        super(context);
    }

    public Practice13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth() * 2, mBitmap.getHeight() * 2, true);
        mBitmap.recycle();
        mBitmap = scaledBitmap;

        mAnimator.setDuration(5000);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float newZ = -displayMetrics.density * 6;
        mCamera.setLocation(0, 0, newZ);
    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - mBitmap.getWidth()) / 2;
        int top = (getHeight() - mBitmap.getHeight()) / 2;
        int centerX = left + mBitmap.getWidth() / 2;
        int centerY = top + mBitmap.getHeight() / 2;

        canvas.save();
        mCamera.save();
        mCamera.rotateX(degree);
        canvas.translate(centerX, centerY);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        mCamera.restore();
        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAnimator.end();
    }
}
