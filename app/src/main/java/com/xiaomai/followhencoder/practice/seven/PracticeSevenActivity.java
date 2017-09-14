package com.xiaomai.followhencoder.practice.seven;

import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.base.BasePracticeActivity;
import com.xiaomai.followhencoder.model.PageModel;

/**
 * Created by XiaoMai on 2017/9/12.
 */

public class PracticeSevenActivity extends BasePracticeActivity {

    {
        pageModels.add(new PageModel(R.layout.sample_keyframe, R.string.title_keyframe, R.layout.practice_keyframe));
        pageModels.add(new PageModel(R.layout.sample_animator_set, R.string.title_animator_set, R.layout.practice_animator_set));
        pageModels.add(new PageModel(R.layout.sample_property_values_holder, R.string.title_property_values_holder, R.layout.practice_property_values_holder));
        pageModels.add(new PageModel(R.layout.sample_of_object, R.string.title_of_object, R.layout.practice_of_object));
        pageModels.add(new PageModel(R.layout.sample_hsv_evaluator, R.string.title_hsv_evaluator, R.layout.practice_hsv_evaluator));
        pageModels.add(new PageModel(R.layout.sample_argb_evaluator, R.string.title_argb_evaluator, R.layout.practice_argb_evaluator));
    }
}
