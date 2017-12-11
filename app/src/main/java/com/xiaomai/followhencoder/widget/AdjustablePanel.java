package com.xiaomai.followhencoder.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.utils.Utils;


/**
 * Created by XiaoMai on 2017/11/22.
 */

public class AdjustablePanel extends RelativeLayout {
    FrameLayout parentLayout;
    AppCompatSeekBar heightBar;
    AppCompatSeekBar widthBar;

    float bottomMargin = Utils.dpToPixel(48);
    float minWidth = Utils.dpToPixel(80);
    float minHeight = Utils.dpToPixel(100);

    public AdjustablePanel(Context context) {
        super(context);
    }

    public AdjustablePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdjustablePanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        parentLayout = findViewById(R.id.parentLayout);
        widthBar = findViewById(R.id.widthBar);
        heightBar = findViewById(R.id.heightBar);

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                LayoutParams layoutParams = (LayoutParams) parentLayout.getLayoutParams();
                layoutParams.width = (int) (minWidth
                        + (AdjustablePanel.this.getWidth() - minWidth) * widthBar.getProgress() / 100);
                layoutParams.height = (int) (minHeight
                        + (AdjustablePanel.this.getHeight() - bottomMargin - minHeight) * heightBar.getProgress() / 100);
                parentLayout.setLayoutParams(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        widthBar.setOnSeekBarChangeListener(listener);
        heightBar.setOnSeekBarChangeListener(listener);
    }
}
