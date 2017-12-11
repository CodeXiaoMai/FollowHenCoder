package com.xiaomai.followhencoder.practice.eight;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by XiaoMai on 2017/11/22.
 */

public class Practice01SquareImageView extends AppCompatImageView {
    public Practice01SquareImageView(Context context) {
        super(context);
    }

    public Practice01SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 调用父类的 onMeasure 触发原先的测量
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获取测量的宽高
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        measuredWidth = measuredHeight = Math.min(measuredWidth, measuredHeight);
        // 重新保存宽高
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
