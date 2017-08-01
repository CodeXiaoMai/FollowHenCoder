package com.xiaomai.followhencoder.practice.two;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/1.
 */

public class Practice14MaskFilter extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;

    public Practice14MaskFilter(Context context) {
        super(context);
    }

    public Practice14MaskFilter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * BlurMaskFilter(float radius, BlurMaskFilter.Blur style) 中，
         * radius 参数是模糊的范围，style 是模糊的类型。一共有四种：
         * NORMAL: 内外都模糊绘制
         * SOLID: 内部正常绘制，外部模糊
         * INNER: 内部模糊，外部不绘制
         * OUTER: 内部不绘制，外部模糊
         */
        // 第一个：NORMAL
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(mBitmap, 100, 50, mPaint);

        // 第二个：INNER
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
        canvas.drawBitmap(mBitmap, mBitmap.getWidth() + 200, 50, mPaint);

        // 第三个：OUTER
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER));
        canvas.drawBitmap(mBitmap, 100, mBitmap.getHeight() + 100, mPaint);

        // 第四个：SOLID
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));
        canvas.drawBitmap(mBitmap, mBitmap.getWidth() + 200, mBitmap.getHeight() + 100, mPaint);
    }
}
