package com.xiaomai.followhencoder.practice.two;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoMai on 2017/8/1.
 */

public class Practice12PathEffectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.moveTo(50, 70);
        mPath.rLineTo(50, 100);
        mPath.rLineTo(80, -150);
        mPath.rLineTo(100, 100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        mPaint.setPathEffect(new CornerPathEffect(50));
        canvas.drawPath(mPath, mPaint);

        canvas.save();
        canvas.translate(350, 0);
        // 第二处：DiscretePathEffect
        mPaint.setPathEffect(new DiscretePathEffect(
                10, //segmentLength 是用来拼接的每个线段的长度
                5));   //deviation 是偏离量
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 150);
        // 第三处：DashPathEffect
        mPaint.setPathEffect(new DashPathEffect(
                new float[]{20, 5, 10, 5}, //第一个参数 intervals 是一个数组，它指定了虚线的格式：数组中元素必须为偶数（最少是 2 个），按照「画线长度、空白长度、画线长度、空白长度」……的顺序排列，
                3));//第二个参数 phase 是虚线的偏移量。
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(350, 150);
        // 第四处：PathDashPathEffect
        Path path = new Path();
        path.moveTo(10, 0);
        path.lineTo(0, -(float) (10 * Math.sqrt(3)));
        path.lineTo(-10, 0);
        /**
         * shape 参数是用来绘制的 Path ；
         * advance 是两个相邻的 shape 段之间的间隔，不过注意，这个间隔是两个 shape 段的起点的间隔，而不是前一个的终点和后一个的起点的距离；
         * phase 和 DashPathEffect 中一样，是虚线的偏移；
         * 最后一个参数 style，是用来指定拐弯改变的时候 shape 的转换方式。
         * style 的类型为 PathDashPathEffect.Style ，是一个 enum ，具体有三个值：
         * TRANSLATE：位移
         * ROTATE：旋转
         * MORPH：变体
         */
        mPaint.setPathEffect(new PathDashPathEffect(
                path,
                30,
                5,
                PathDashPathEffect.Style.MORPH));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 300);
        // 第五处：SumPathEffect
        PathEffect pathEffect1 = new DiscretePathEffect(3, 2);
        PathEffect pathEffect2 = new DashPathEffect(new float[]{15, 5, 5, 3}, 5);
        mPaint.setPathEffect(new SumPathEffect(pathEffect1, pathEffect2));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(350, 300);
        // 第六处：ComposePathEffect
        mPaint.setPathEffect(new ComposePathEffect(pathEffect2, pathEffect1));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }
}
