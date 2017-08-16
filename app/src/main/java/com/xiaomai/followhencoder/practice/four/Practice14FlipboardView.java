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
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/16.
 */

public class Practice14FlipboardView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Camera mCamera = new Camera();
    int degree;
    ObjectAnimator mAnimator = ObjectAnimator.ofInt(this, "degree", 0, 180);

    public Practice14FlipboardView(Context context) {
        super(context);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        mAnimator.setDuration(2500);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - mBitmap.getWidth()) / 2;
        int top = (getHeight() - mBitmap.getHeight()) / 2;

        // 先画上半部分
        canvas.save();
        canvas.clipRect(left, top, left + mBitmap.getWidth(), top + mBitmap.getHeight() / 2);
        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();

        // 再画下半部分
        canvas.save();
        mCamera.save();
        mCamera.rotateX(degree);
        canvas.translate(left + mBitmap.getWidth() / 2, top + mBitmap.getHeight() / 2);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-left - mBitmap.getWidth() / 2, -top - mBitmap.getHeight() / 2);
        mCamera.restore();
        canvas.clipRect(left, top + mBitmap.getHeight() / 2, left + mBitmap.getWidth(), top + mBitmap.getHeight());
        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();
    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
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
