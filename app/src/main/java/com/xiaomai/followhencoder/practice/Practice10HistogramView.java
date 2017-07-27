package com.xiaomai.followhencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoMai on 2017/7/26.
 */

public class Practice10HistogramView extends View {

    private static final int TRANSLATE_X = 50;
    private static final int TRANSLATE_Y = 150;
    private static final int SPACE = 15;

    private List<Android> androidList = new ArrayList<>();

    {
        androidList.add(new Android("Froyo", 1));
        androidList.add(new Android("GB", 3.5f));
        androidList.add(new Android("ICS", 4));
        androidList.add(new Android("JB", 38.8f));
        androidList.add(new Android("KitKat", 73.2f));
        androidList.add(new Android("L", 91.2f));
        androidList.add(new Android("M", 44.4f));
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        // Y 轴的高度
        float y = getHeight() - TRANSLATE_Y - 50;
        // X 轴的长度
        float x = getWidth() - TRANSLATE_X - 50;

        // 坐标轴的原点移动到图中坐标轴原点的位置
        canvas.translate(TRANSLATE_X, getHeight() - TRANSLATE_Y);

        // 画背景色
        canvas.drawColor(Color.parseColor("#506E7A"));

        // 画坐标线
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, 0, -y, mPaint);
        canvas.drawLine(0, 0, x, 0, mPaint);

        // 画文字“直方图”
        mTextPaint.setTextSize(35);
        mTextPaint.setColor(Color.WHITE);
        float width = mTextPaint.measureText("直方图") / 2;
        canvas.drawText("直方图", getWidth() / 2 - width - TRANSLATE_X, TRANSLATE_Y - 50, mTextPaint);

        // 画直方图
        mPaint.setColor(Color.parseColor("#72B916"));
        mPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextSize(20);
        // 柱状图的宽度
        float itemWith = (x * 1.0f - SPACE) / androidList.size() - SPACE;
        for (int i = 0; i < androidList.size(); i++) {
            Android android = androidList.get(i);
            float left = SPACE * (i + 1) + itemWith * i;
            float top = y * 1.0f / 100 * android.getValue();
            float right = left + itemWith;
            float bottom = 0;
            canvas.drawRect(left, -top, right, bottom, mPaint);
            Rect bounds = new Rect();
            mTextPaint.getTextBounds(android.getName(), 0, android.getName().length(), bounds);
            canvas.drawText(android.getName(), left + (itemWith - bounds.right) / 2f, 5 + bounds.height(), mTextPaint);
        }
    }

    private class Android {
        private String name;
        private float value;

        public Android(String name, float value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }
    }
}
