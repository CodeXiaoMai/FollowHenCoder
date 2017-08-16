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

public class Practice12CameraRotateFixedView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    Camera mCamera = new Camera();

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = 100;
        int top = 200;
        int centerX = left + mBitmap.getWidth() / 2;
        int centerY = top + mBitmap.getHeight() / 2;

        canvas.save();
        mCamera.save();
        mCamera.rotateX(30);
        canvas.translate(centerX, centerY);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        mCamera.restore();
        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();

        left = 400;
        top = 200;
        centerX = left + mBitmap.getWidth() / 2;
        centerY = top + mBitmap.getHeight() / 2;

        canvas.save();
        mCamera.save();
        mCamera.rotateY(30);
        canvas.translate(centerX, centerY);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        mCamera.restore();
        canvas.drawBitmap(mBitmap, left, top, mPaint);
        canvas.restore();
    }
}
