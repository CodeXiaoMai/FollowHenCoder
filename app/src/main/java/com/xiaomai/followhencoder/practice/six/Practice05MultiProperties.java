package com.xiaomai.followhencoder.practice.six;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.utils.Utils;

/**
 * Created by XiaoMai on 2017/9/7.
 */

public class Practice05MultiProperties extends ConstraintLayout {
    private ImageView imageView;
    private boolean isAnimated;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        Button btAnimate = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);

        btAnimate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimated) {
                    imageView.animate()
                            .translationX(Utils.dpToPixel(200))
                            .rotation(360)
                            .scaleX(1)
                            .scaleY(1)
                            .alpha(1);
                } else {
                    imageView.animate()
                            .translationX(0)
                            .rotation(0)
                            .scaleX(0)
                            .scaleY(0)
                            .alpha(0);
                }
                isAnimated = !isAnimated;
            }
        });
    }
}
