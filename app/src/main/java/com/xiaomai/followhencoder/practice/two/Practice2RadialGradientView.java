package com.xiaomai.followhencoder.practice.two;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/28.
 */

public class Practice2RadialGradientView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2RadialGradientView(Context context) {
        super(context);
    }

    public Practice2RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3

        Shader shader = new RadialGradient(
                300, 300,// centerX centerY：辐射中心的坐标
                200, // radius：辐射半径
                Color.parseColor("#E91E63"), //centerColor：辐射中心的颜色
                Color.parseColor("#2196F3"),//edgeColor：辐射边缘的颜色
                Shader.TileMode.CLAMP); //tileMode：辐射范围之外的着色模式。
        mPaint.setShader(shader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300, 300, 200, mPaint);
    }
}
