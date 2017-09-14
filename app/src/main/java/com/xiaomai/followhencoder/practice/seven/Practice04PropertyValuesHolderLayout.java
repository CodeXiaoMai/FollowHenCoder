package com.xiaomai.followhencoder.practice.seven;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/9/12.
 */

public class Practice04PropertyValuesHolderLayout extends RelativeLayout {
    public Practice04PropertyValuesHolderLayout(Context context) {
        super(context);
    }

    public Practice04PropertyValuesHolderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04PropertyValuesHolderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        final ImageView imageView = (ImageView) findViewById(R.id.objectAnimatorView);
        Button btAnimate = (Button) findViewById(R.id.animateBt);

        btAnimate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("alpha", 0, 1);
                PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 0, 1);
                PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("scaleY", 0, 1);

                ObjectAnimator.ofPropertyValuesHolder(imageView, holder1, holder2, holder3)
                        .start();
            }
        });
    }
}
