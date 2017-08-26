package com.xiaomai.followhencoder.practice.five;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by xiaomai on 2017/8/26.
 */

public class Practice08BeforeDrawView extends AppCompatEditText {

    public Practice08BeforeDrawView(Context context) {
        super(context);
    }

    public Practice08BeforeDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08BeforeDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#66BB6A")); // 涂上绿色

        super.draw(canvas);
    }
}
