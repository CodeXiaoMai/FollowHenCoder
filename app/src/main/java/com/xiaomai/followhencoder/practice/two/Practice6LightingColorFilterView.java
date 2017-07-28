package com.xiaomai.followhencoder.practice.two;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/7/28.
 */

public class Practice6LightingColorFilterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;

    public Practice6LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice6LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        // R' = R * mul.R / 0xff + add.R
        // G' = G * mul.G / 0xff + add.G
        // B' = B * mul.B / 0xff + add.B

        // 第一个 LightingColorFilter：去掉红色部分
        mPaint.setColorFilter(new LightingColorFilter(0x00FFFF, 0x000000));
        canvas.drawBitmap(bitmap, 0, 0, mPaint);

        /**
         * 一个「保持原样」的「基本 LightingColorFilter 」，mul 为 0xffffff，add 为 0x000000（也就是0），
         * 那么对于一个像素，它的计算过程就是：
         * R' = R * 0xff / 0xff + 0x0 = R // R' = R
         * G' = G * 0xff / 0xff + 0x0 = G // G' = G
         * B' = B * 0xff / 0xff + 0x0 = B // B' = B
         */

        // 第二个 LightingColorFilter：增强绿色部分
        mPaint.setColorFilter(new LightingColorFilter(0xFFFFFF, 0x003300));
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, mPaint);

        mPaint.setColorFilter(new PorterDuffColorFilter(0x80ff0000, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, bitmap.getHeight() + 20, mPaint);

    }
}
