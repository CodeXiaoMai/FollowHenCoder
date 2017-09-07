package com.xiaomai.followhencoder.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by XiaoMai on 2017/9/7.
 */

public class Utils {

    public static float dpToPixel(float dp) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return dp * displayMetrics.density;
    }
}
