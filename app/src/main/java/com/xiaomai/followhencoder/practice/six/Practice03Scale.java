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

public class Practice03Scale extends RelativeLayout {
    private final int stateCount = 4;
    private ImageView imageView;
    private int state = 0;

    public Practice03Scale(Context context) {
        super(context);
    }

    public Practice03Scale(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03Scale(Context context, AttributeSet attrs, int defStyleAttr) {
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
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        imageView.animate().scaleX(1f);
                        break;
                    case 2:
                        imageView.animate().scaleY(0.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1f);
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
