package com.xiaomai.followhencoder.practice.seven.practice06;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/9/13.
 */

public class Practice06KeyframeLayout extends RelativeLayout {

    public Practice06KeyframeLayout(Context context) {
        super(context);
    }

    public Practice06KeyframeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06KeyframeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        final Practice06KeyframeView view = (Practice06KeyframeView) findViewById(R.id.objectAnimatorView);
        Button btAnimate = (Button) findViewById(R.id.animateBt);

        btAnimate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Keyframe keyframeStart = Keyframe.ofFloat(0, 0);
                Keyframe keyframeMiddle = Keyframe.ofFloat(0.5f, 100);
                Keyframe keyframeEnd = Keyframe.ofFloat(1, 80);
                PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("progress", keyframeStart, keyframeMiddle, keyframeEnd);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolder)
                        .setDuration(2000);
                objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
                objectAnimator.start();

                /**
                 * 使用 ValueAnimator 这种适用于第三方控件不提供 get/set 方法时使用，
                 * 平时不要难为自己
                 */
                /*ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100, 80);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        view.setProgress((Float) animation.getAnimatedValue());
                    }
                });
                valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimator.setDuration(2000);
                valueAnimator.start();*/
            }
        });
    }
}