package com.xiaomai.followhencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoMai on 2017/7/28.
 */

public class Practice12ProgressView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    private Rect mRect = new Rect();
    private List<Android> androidList = new ArrayList<>();

    {
        androidList.add(new Android("Ice Cream Sandwich", 10, "#9E9E9E"));
        androidList.add(new Android("Jelly Bean", 50f, "#009688"));
        androidList.add(new Android("KitKat", 100.5f, "#2196F3"));
        androidList.add(new Android("Lollipop", 120.8f, "#F44336"));
    }

    public Practice12ProgressView(Context context) {
        super(context);
        init();
    }

    public Practice12ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice12ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth() / 2, getHeight() / 2);

        float maxWidth = 0;
        float heightForMaxWidth = 0;

        String text = "1,453 calories";
        mTextPaint.setTextSize(40);
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTextPaint.getTextBounds(text, 0, text.length(), mRect);
        canvas.drawText(text, -mRect.width() / 2, 0, mTextPaint);
        int height = mRect.height() + 10;
        if (mRect.width() > maxWidth) {
            heightForMaxWidth = height;
        }
        maxWidth = Math.max(maxWidth, mRect.width());

        text = "burned";
        mTextPaint.getTextBounds(text, 0, text.length(), mRect);
        canvas.drawText(text, -mRect.width() / 2, height, mTextPaint);
        height += mRect.height() + 25;
        if (mRect.width() > maxWidth) {
            heightForMaxWidth = height;
        }
        maxWidth = Math.max(maxWidth, mRect.width());

        text = "Your avg is 2,399 calories";
        mTextPaint.setTextSize(20);
        mTextPaint.getTextBounds(text, 0, text.length(), mRect);
        canvas.drawText(text, -mRect.width() / 2, height, mTextPaint);
        height += mRect.height() + 10;
        if (mRect.width() > maxWidth) {
            heightForMaxWidth = height;
        }
        maxWidth = Math.max(maxWidth, mRect.width());

        maxWidth += 30;
        float radius = (float) Math.sqrt(Math.pow(maxWidth / 2, 2) + Math.pow(heightForMaxWidth, 2)) + 30;
        float currentAngle = -90f;
        for (Android android : androidList) {
            currentAngle += android.getValue();
        }
        mPaint.setColor(Color.LTGRAY);
        canvas.drawArc(-radius, -radius, radius, radius, currentAngle, 285 - currentAngle, false, mPaint);
        for (int i = androidList.size() - 1; i > 0; i--) {
            Android android = androidList.get(i);
            mPaint.setColor(Color.parseColor(android.getColor()));
            currentAngle -= android.getValue();
            canvas.drawArc(-radius, -radius, radius, radius, currentAngle, android.getValue(), false, mPaint);
        }
    }

    private void init() {
        mPaint.setStrokeWidth(30);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    private class Android {
        private String name;
        private float value;
        private String color;

        public Android(String name, float value, String color) {
            this.name = name;
            this.value = value;
            this.color = color;
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

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
