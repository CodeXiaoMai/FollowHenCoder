package com.xiaomai.followhencoder.practice.six;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xiaomai.followhencoder.R;

/**
 * Created by XiaoMai on 2017/9/7.
 */

public class Practice04Alpha extends RelativeLayout {
    private ImageView imageView;
    private final int stateCount = 2;
    private int state = 0;

    public Practice04Alpha(Context context) {
        super(context);
    }

    public Practice04Alpha(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04Alpha(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        Button btAnimate = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        btAnimate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (state) {
                    case 0:
                        imageView.animate().alpha(0f);
                        break;
                    case 1:
                        imageView.animate().alpha(1f);
                        break;
                }
                state++;
                if (state >= stateCount) {
                    state = 0;
                }
            }
        });
    }
}
