package com.xiaomai.followhencoder.practice.one;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoMai on 2017/7/26.
 */

public class Practice11PieChartView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    private final float SPACE_ANGLE = 2;

    private final float RADIUS = 175;

    private final float CHART_TEXT_SPACE = 50;

    private List<Android> androidList = new ArrayList<>();

    {
        androidList.add(new Android("Froyo", 4, "#ABABAB"));
        androidList.add(new Android("Gingerbread", 8, "#9C27B0"));
        androidList.add(new Android("Ice Cream Sandwich", 10, "#9E9E9E"));
        androidList.add(new Android("Jelly Bean", 50f, "#009688"));
        androidList.add(new Android("KitKat", 100.5f, "#2196F3"));
        androidList.add(new Android("Lollipop", 120.8f, "#F44336"));
        androidList.add(new Android("Marshmallow", 66.7f, "#FFC107"));
    }

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 画背景色
        canvas.drawColor(Color.parseColor("#506E7A"));

        // 画文字“饼图”
        mTextPaint.setTextSize(35f);
        mTextPaint.setColor(Color.WHITE);
        float width = mTextPaint.measureText("饼图");
        canvas.drawText("饼图", getWidth() / 2 - width / 2, getHeight() - 30, mTextPaint);

        // 画饼图
        canvas.translate(getWidth() / 2 - 25, getHeight() / 2 - 25);
        mTextPaint.setTextSize(16);
        float currentAngle = 0;
        for (int i = 0; i < androidList.size(); i++) {
            Android android = androidList.get(i);
            mPaint.setColor(Color.parseColor(android.getColor()));
            mPaint.setStyle(Paint.Style.FILL);
            if (android.getName().equals("Lollipop")) {
                canvas.drawArc(-185, -185, 160, 160, currentAngle, android.getValue() - SPACE_ANGLE, true, mPaint);
            } else {
                canvas.drawArc(-RADIUS, -RADIUS, RADIUS, RADIUS, currentAngle, android.getValue() - SPACE_ANGLE, true, mPaint);
                mPaint.setColor(Color.TRANSPARENT);
                canvas.drawArc(-RADIUS, -RADIUS, RADIUS, RADIUS, currentAngle + android.getValue() - SPACE_ANGLE, 2, true, mPaint);
            }
            mPaint.setColor(Color.WHITE);
            mPaint.setStyle(Paint.Style.STROKE);
            drawName(android, currentAngle, canvas);
            currentAngle += android.getValue();
        }
    }

    private void drawName(Android android, float currentAngle, Canvas canvas) {
        float middle = currentAngle + (android.getValue() - SPACE_ANGLE) / 2;
        float y = (float) ((RADIUS + CHART_TEXT_SPACE) * Math.sin(middle * Math.PI / 180));
        float y1 = (float) (RADIUS * Math.sin(middle * Math.PI / 180));
        float x = (float) (RADIUS * Math.cos(middle * Math.PI / 180));
        Log.e("y", y + "");
        if (middle >= 0 && middle < 45) {
            canvas.drawText(android.getName(), RADIUS + CHART_TEXT_SPACE, y, mTextPaint);
            Path path = new Path();
            path.moveTo(x, y1);
            path.lineTo(x + ((RADIUS + CHART_TEXT_SPACE) - 10 - x) / 3, y1);
            path.lineTo(x + ((RADIUS + CHART_TEXT_SPACE) - 10 - x) * 2 / 3, y);
            path.lineTo((RADIUS + CHART_TEXT_SPACE) - 10, y);
            canvas.drawPath(path, mPaint);
        } else if (middle < 90) {
            canvas.drawText(android.getName(), RADIUS + CHART_TEXT_SPACE, y, mTextPaint);
            Path path = new Path();
            path.moveTo(x, y1);
            path.lineTo(x + ((RADIUS + CHART_TEXT_SPACE) - 10 - x) / 3, y);
            path.lineTo((RADIUS + CHART_TEXT_SPACE) - 10, y);
            canvas.drawPath(path, mPaint);
        } else if (middle < 135) {
            canvas.drawText(android.getName(), -(RADIUS + CHART_TEXT_SPACE) - mTextPaint.measureText(android.getName()), y, mTextPaint);
            Path path = new Path();
            path.moveTo(x, y1);
            path.lineTo(x - ((RADIUS + CHART_TEXT_SPACE) - 10 + x) * 1 / 3, y);
            path.lineTo(-(RADIUS + CHART_TEXT_SPACE) + 10, y);
            canvas.drawPath(path, mPaint);
        } else if (middle < 180) {

        } else if (middle < 225) {

        } else if (middle < 270) {
            canvas.drawText(android.getName(), -(RADIUS + CHART_TEXT_SPACE) - mTextPaint.measureText(android.getName()) - 10, y - 10, mTextPaint);
            Path path = new Path();
            path.moveTo(x - 10, y1 - 10);
            path.lineTo(x - ((RADIUS + CHART_TEXT_SPACE) - 10 + x) * 1 / 3 - 10, y - 10);
            path.lineTo(-(RADIUS + CHART_TEXT_SPACE) + 10 - 10, y - 10);
            canvas.drawPath(path, mPaint);
        } else if (middle < 315) {

        } else if (middle < 360) {
            canvas.drawText(android.getName(), RADIUS + CHART_TEXT_SPACE, y, mTextPaint);
            Path path = new Path();
            path.moveTo(x, y1);
            path.lineTo(x + ((RADIUS + CHART_TEXT_SPACE) - 10 - x) / 3, y);
            path.lineTo((RADIUS + CHART_TEXT_SPACE) - 10, y);
            canvas.drawPath(path, mPaint);
        }
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
