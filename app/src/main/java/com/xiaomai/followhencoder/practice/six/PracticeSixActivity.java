package com.xiaomai.followhencoder.practice.six;

import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.base.BasePracticeActivity;
import com.xiaomai.followhencoder.model.PageModel;

/**
 * Created by XiaoMai on 2017/9/7.
 */

public class PracticeSixActivity extends BasePracticeActivity {

    {
        pageModels.add(new PageModel(R.layout.sample_object_anomator, R.string.title_object_animator, R.layout.practice_object_animator));
        pageModels.add(new PageModel(R.layout.sample_interpolator, R.string.title_interpolator, R.layout.practice_interpolator));
        pageModels.add(new PageModel(R.layout.sample_duration, R.string.title_duration, R.layout.practice_duration));
        pageModels.add(new PageModel(R.layout.sample_multi_properties, R.string.title_multi_properties, R.layout.practice_multi_properties));
        pageModels.add(new PageModel(R.layout.sample_alpha_xy, R.string.title_alpha, R.layout.practice_alpha_xy));
        pageModels.add(new PageModel(R.layout.sample_scale_xy, R.string.title_scale_xy, R.layout.practice_scale_xy));
        pageModels.add(new PageModel(R.layout.sample_rotation, R.string.title_rotation, R.layout.practice_rotation));
        pageModels.add(new PageModel(R.layout.sample_translation, R.string.title_translation, R.layout.practice_translation));
    }
}