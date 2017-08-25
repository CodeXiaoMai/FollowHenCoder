package com.xiaomai.followhencoder.practice.five;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;

/**
 * Created by XiaoMai on 2017/8/25.
 */

public class Practice03OnDrawLayout extends LinearLayoutCompat {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Pattern mPattern = new Pattern();

    public Practice03OnDrawLayout(Context context) {
        super(context);
    }

    public Practice03OnDrawLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03OnDrawLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 在这里插入 setWillNotDraw(false) 以启用完整的绘制流程
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPattern.draw(canvas);
    }

    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;

        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Pattern.Spot[] spots;

        private Pattern() {
            spots = new Pattern.Spot[4];
            spots[0] = new Practice03OnDrawLayout.Pattern.Spot(0.24f, 0.3f, 0.026f);
            spots[1] = new Practice03OnDrawLayout.Pattern.Spot(0.69f, 0.25f, 0.067f);
            spots[2] = new Practice03OnDrawLayout.Pattern.Spot(0.32f, 0.6f, 0.067f);
            spots[3] = new Practice03OnDrawLayout.Pattern.Spot(0.62f, 0.78f, 0.083f);
        }

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Spot spot = spots[i % spots.length];
                canvas.drawCircle(
                        i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(),
                        spot.relativeY * getHeight(),
                        spot.relativeSize * getHeight(),
                        patternPaint);
            }

        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
