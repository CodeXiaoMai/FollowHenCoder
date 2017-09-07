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

public class Practice02Rotation extends RelativeLayout {
    private ImageView imageView;
    private int state = 0;
    private final int stateCount = 6;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, AttributeSet attrs, int defStyleAttr) {
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
                        imageView.animate().rotation(180);
                        break;
                    case 1:
                        imageView.animate().rotation(0);
                        break;
                    case 2:
                        imageView.animate().rotationX(180);
                        break;
                    case 3:
                        imageView.animate().rotationX(0);
                        break;
                    case 4:
                        imageView.animate().rotationY(180);
                        break;
                    case 5:
                        imageView.animate().rotationY(0);
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
