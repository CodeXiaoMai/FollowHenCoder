package com.xiaomai.followhencoder.practice.six;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.utils.Utils;

import static com.xiaomai.followhencoder.utils.Utils.dpToPixel;

/**
 * Created by XiaoMai on 2017/9/7.
 */

public class Practice01Translation extends RelativeLayout {
    private ImageView imageView;

    private int translationStateCount = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 6 : 4;
    private int translationState = 0;

    public Practice01Translation(Context context) {
        super(context);
    }

    public Practice01Translation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01Translation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        Button btAnimate = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }

        btAnimate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (translationState) {
                    case 0:
                        imageView.animate().translationX(Utils.dpToPixel(100));
                        break;
                    case 1:
                        imageView.animate().translationX(0);
                        break;
                    case 2:
                        imageView.animate().translationY(Utils.dpToPixel(50));
                        break;
                    case 3:
                        imageView.animate().translationY(0);
                        break;
                    case 4:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(Utils.dpToPixel(15));
                        }
                        break;
                    case 5:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(0);
                        }
                        break;
                    case 6:

                        break;
                }
                translationState++;
                if (translationState >= translationStateCount) {
                    translationState = 0;
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }


        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}
