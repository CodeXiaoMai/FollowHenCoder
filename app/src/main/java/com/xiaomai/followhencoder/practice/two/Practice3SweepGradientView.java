package com.xiaomai.followhencoder.practice.two;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/28.
 */

public class Practice3SweepGradientView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice3SweepGradientView(Context context) {
        super(context);
    }

    public Practice3SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
        Shader shader = new SweepGradient(300, 300,// cx cy ：扫描的中心
                Color.parseColor("#E91E63"),// color0：扫描的起始颜色
                Color.parseColor("#2196F3"));// color1：扫描的终止颜色
        mPaint.setShader(shader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300, 300, 200, mPaint);
    }
}
