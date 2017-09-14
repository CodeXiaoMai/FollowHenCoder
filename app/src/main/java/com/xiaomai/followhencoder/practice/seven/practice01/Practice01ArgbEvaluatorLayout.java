package com.xiaomai.followhencoder.practice.seven.practice01;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/9/12.
 */

public class Practice01ArgbEvaluatorLayout extends RelativeLayout {

    public Practice01ArgbEvaluatorLayout(Context context) {
        super(context);
    }

    public Practice01ArgbEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ArgbEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        final Practice01ArgbEvaluatorView view = (Practice01ArgbEvaluatorView) findViewById(R.id.objectAnimatorView);
        Button btAnimate = (Button) findViewById(R.id.animateBt);

        btAnimate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofInt(view, "color", Color.RED, Color.GREEN);
                // 在这里使用 ObjectAnimator.setEvaluator() 来设置 ArgbEvaluator，修复闪烁问题
                animator.setEvaluator(new ArgbEvaluator());
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }
}
