package com.xiaomai.followhencoder.practice.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/8/15.
 */

public class Practice06SkewView extends View {
    Paint mPaint =new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;

    public Practice06SkewView(Context context) {
        super(context);
    }

    public Practice06SkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06SkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.skew(0, 0.5f);
        canvas.drawBitmap(mBitmap, 100, 100, mPaint);
        canvas.restore();

        canvas.save();
        canvas.skew(-0.5f, 0);
        canvas.drawBitmap(mBitmap, 500, 100, mPaint);
        canvas.restore();
    }
}
