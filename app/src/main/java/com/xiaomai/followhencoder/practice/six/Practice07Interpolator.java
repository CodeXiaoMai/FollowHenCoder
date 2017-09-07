package com.xiaomai.followhencoder.practice.six;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.utils.Utils;

/**
 * Created by XiaoMai on 2017/9/7.
 */

public class Practice07Interpolator extends LinearLayout {
    private Interpolator[] interpolators = new Interpolator[13];
    private Context context;

    public Practice07Interpolator(Context context) {
        super(context);
    }

    public Practice07Interpolator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07Interpolator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        context = getContext();
        // AccelerateDecelerateInterpolator 先加速再减速,这是默认的 Interpolator
        interpolators[0] = new AccelerateDecelerateInterpolator();
        interpolators[1] = new LinearInterpolator();
        // AccelerateInterpolator 在整个动画过程中，一直在加速，直到动画结束的一瞬间，直接停止。
        interpolators[2] = new AccelerateInterpolator();
        // DecelerateInterpolator 动画开始的时候是最高速度，然后在动画过程中逐渐减速，直到动画结束的时候恰好减速到 0。
        interpolators[3] = new DecelerateInterpolator();
        // AnticipateInterpolator 如果是图中这样的平移动画，那么就是位置上的回拉；如果是放大动画，那么就是先缩小一下再放大；其他类型的动画同理。
        interpolators[4] = new AnticipateInterpolator();
        // OvershootInterpolator 动画会超过目标值一些，然后再弹回来。
        interpolators[5] = new OvershootInterpolator();
        // AnticipateOvershootInterpolator 上面这两个的结合版：开始前回拉，最后超过一些然后回弹。
        interpolators[6] = new AnticipateOvershootInterpolator();
        // BounceInterpolator 在目标值处弹跳。有点像玻璃球掉在地板上的效果。
        interpolators[7] = new BounceInterpolator();

        /**
         * CycleInterpolator 的速度 / 时间曲线以及动画完成度 / 时间曲线也是一个正弦 / 余弦曲线，
         * 不过它和 AccelerateDecelerateInterpolator 的区别是，它可以自定义曲线的周期，
         * 由于一个完整的正弦 / 余弦曲线 在 y 轴上是有正有负的，所以动画的效果也会出现正负。比如：
         * 设置周期为1，调用view.animate().translateX(150f); 效果就是，先向右移动 150（1/4周期），再向左移动 150（1／2周期）
         * ，再向左移动 150（3／4周期），最后再向右移动 150 到达原点，这样一个周期就结束了。
         * 而如果设置周期为 0.5，那么就是先向右移动 150，再向左移动 150
         * 所以动画可以不到终点就结束，也可以到达终点后回弹，回弹的次数由曲线的周期决定，
         * 曲线的周期由 CycleInterpolator() 构造方法的参数决定。
         */
        interpolators[8] = new CycleInterpolator(0.5f);

        /**
         * 这条 Path 具体到细节是 n 个 path.lineTo(x, y) 组成的，描述的其实是一个 y = f(x) (0 ≤ x ≤ 1)
         * （y 为动画完成度，x 为时间完成度）的曲线，所以同一段时间完成度上不能有两段不同的动画完成度
         * （因为内容不能出现分身术呀），而且每一个时间完成度的点上都必须要有对应的动画完成度
         * （因为内容不能在某段时间段内消失呀）。
         */
        Path pathInterpolator = new Path();
        // 先用 25% 的时间，匀速移动到 25% 的位置
        pathInterpolator.lineTo(0.25f, 0.25f);
        // 在时间为 25% 时瞬间移动到 150% 的位置
        pathInterpolator.lineTo(0.25f, 1.5f);
        // 最后利用剩余的时间匀速移动到 100% 的位置
        pathInterpolator.lineTo(1, 1);

        interpolators[9] = PathInterpolatorCompat.create(pathInterpolator);

        interpolators[10] = new FastOutLinearInInterpolator();
        interpolators[11] = new FastOutSlowInInterpolator();
        interpolators[12] = new LinearOutSlowInInterpolator();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final Spinner spinner = (Spinner) findViewById(R.id.interpolatorSpinner);

        Button btAnimate = (Button) findViewById(R.id.animateBt);

        /**
         * ViewPropertyAnimator.withStartAction/EndAction()。这两个方法是 ViewPropertyAnimator 的独有方法。
         * 它们和 set/addListener() 中回调的 onAnimationStart() /  onAnimationEnd() 相比起来的不同主要有两点：
         * 1. withStartAction() / withEndAction() 是一次性的，在动画执行结束后就自动弃掉了，
         *    就算之后再重用 ViewPropertyAnimator 来做别的动画，用它们设置的回调也不会再被调用。
         *    而 set/addListener() 所设置的 AnimatorListener 是持续有效的，当动画重复执行时，回调总会被调用。
         * 2. withEndAction() 设置的回调只有在动画正常结束时才会被调用，而在动画被取消时不会被执行。
         *    这点和 AnimatorListener.onAnimationEnd() 的行为是不一致的。
         */

        final ViewPropertyAnimator viewPropertyAnimator = imageView.animate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            viewPropertyAnimator.withEndAction(new Runnable() {
                @Override
                public void run() {
                    if (context instanceof AppCompatActivity)
                        ((AppCompatActivity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "我是endAction，只执行一次", Toast.LENGTH_SHORT).show();
                            }
                        });
                }
            });
        }

        btAnimate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPropertyAnimator
                        .translationX(Utils.dpToPixel(150))
                        .setDuration(600)
                        .setInterpolator(interpolators[spinner.getSelectedItemPosition()])
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                imageView.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageView.setTranslationX(0);
                                    }
                                }, 500);
                                if (context instanceof AppCompatActivity) {
                                    ((AppCompatActivity) context).runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(context, "我是Listener，我又来了", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
            }
        });
    }
}
