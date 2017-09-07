package com.xiaomai.followhencoder.practice.six.practice08;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/9/8.
 */

public class Practice08ObjectAnimatorLayout extends RelativeLayout {
    private static final String TAG = "Practice08Object";

    public Practice08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        final Practice08ObjectAnimatorView objectAnimatorView = (Practice08ObjectAnimatorView) findViewById(R.id.objectAnimatorView);
        Button button = (Button) findViewById(R.id.animateBt);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final ObjectAnimator objectAnimator = ObjectAnimator
                        .ofInt(objectAnimatorView, "progress", 0, 65)
                        .setDuration(1000);
                objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
                objectAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.d(TAG, "onAnimationEnd: " + objectAnimatorView.getProgress());
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                objectAnimator.start();
            }
        });
    }
}
