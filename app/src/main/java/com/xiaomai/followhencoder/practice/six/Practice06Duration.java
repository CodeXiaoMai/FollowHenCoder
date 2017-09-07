package com.xiaomai.followhencoder.practice.six;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.utils.Utils;

/**
 * Created by XiaoMai on 2017/9/7.
 */

public class Practice06Duration extends LinearLayout {
    private ImageView imageView;
    private int duration = 300;
    private int translationState = 0;
    private int stateCount = 2;

    public Practice06Duration(Context context) {
        super(context);
    }

    public Practice06Duration(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06Duration(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        imageView = (ImageView) findViewById(R.id.imageView);

        final TextView tvDurationValue = (TextView) findViewById(R.id.durationValueTv);
        tvDurationValue.setText(getResources().getString(R.string.ms_with_value, duration));

        SeekBar seekBar = (SeekBar) findViewById(R.id.durationSb);
        seekBar.setMax(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duration = progress * 300;
                tvDurationValue.setText(getResources().getString(R.string.ms_with_value, duration));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btAnimate = (Button) findViewById(R.id.animateBt);
        btAnimate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (translationState) {
                    case 0:
                        imageView.animate()
                                .translationX(Utils.dpToPixel(200))
                                .setDuration(duration);
                        break;
                    case 1:
                        imageView.animate()
                                .translationX(0)
                                .setDuration(duration);
                        break;
                }
                translationState++;
                if (translationState >= stateCount) {
                    translationState = 0;
                }
            }
        });
    }
}
