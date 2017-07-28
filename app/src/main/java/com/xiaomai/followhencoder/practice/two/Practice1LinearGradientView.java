package com.xiaomai.followhencoder.practice.two;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/7/28.
 */

public class Practice1LinearGradientView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice1LinearGradientView(Context context) {
        super(context);
    }

    public Practice1LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        /**
         * 当设置了 Shader 之后，Paint 在绘制图形和文字时就不使用 setColor/ARGB() 设置的颜色了，
         * 而是使用 Shader 的方案中的颜色。
         * 在 Android 的绘制里使用 Shader，并不直接用 Shader 这个类，而是用它的几个子类。
         * 具体来讲有  LinearGradient（线性渐变）、RadialGradient（辐射渐变）、SweepGradient（扫描渐变）、
         * BitmapShader、ComposeShader
         */
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3

        Shader shader = new LinearGradient(
                100, 100, 500, 500,// x0, y0, x1, y1：渐变的两个端点的位置
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),//color0, color1 是端点的颜色
                Shader.TileMode.CLAMP);// tile：端点范围之外的着色规则，类型是 TileMode。
        // TileMode 一共有 3 个值可选： CLAMP, MIRROR 和  REPEAT。
        // CLAMP （夹子模式？？？算了这个词我不会翻）会在端点之外延续端点处的颜色；
        // MIRROR 是镜像模式；
        // REPEAT 是重复模式
        mPaint.setShader(shader);

        Shader textShader = new LinearGradient(
                0, 0, 50, 50,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.MIRROR
        );
        mTextPaint.setShader(textShader);
        mTextPaint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300, 300, 200, mPaint);
        canvas.drawText("TileMode = MIRROR", 0, 50, mTextPaint);

        mTextPaint.setShader(new LinearGradient(0, 0, 50, 50,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.REPEAT));
        canvas.drawText("TileMode = REPEAT", 0, 100, mTextPaint);
    }
}
