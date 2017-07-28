package com.xiaomai.followhencoder.practice.one;

import com.xiaomai.followhencoder.base.BasePracticeActivity;
import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.model.PageModel;

/**
 * Created by XiaoMai on 2017/7/28.
 */

public class PracticeOneActivity extends BasePracticeActivity {

    {
        pageModels.add(new PageModel(R.layout.sample_progress, R.string.title_draw_progress, R.layout.practice_progress));
        pageModels.add(new PageModel(R.layout.sample_pie_chart, R.string.title_draw_pie_chart, R.layout.practice_pie_chart));
        pageModels.add(new PageModel(R.layout.sample_histogram, R.string.title_draw_histogram, R.layout.practice_histogram));
        pageModels.add(new PageModel(R.layout.sample_path, R.string.title_draw_path, R.layout.practice_path));
        pageModels.add(new PageModel(R.layout.sample_color, R.string.title_draw_color, R.layout.practice_color));
        pageModels.add(new PageModel(R.layout.sample_circle, R.string.title_draw_circle, R.layout.practice_circle));
        pageModels.add(new PageModel(R.layout.sample_rect, R.string.title_draw_rect, R.layout.practice_rect));
        pageModels.add(new PageModel(R.layout.sample_point, R.string.title_draw_point, R.layout.practice_point));
        pageModels.add(new PageModel(R.layout.sample_oval, R.string.title_draw_oval, R.layout.practice_oval));
        pageModels.add(new PageModel(R.layout.sample_line, R.string.title_draw_line, R.layout.practice_line));
        pageModels.add(new PageModel(R.layout.sample_round_rect, R.string.title_draw_round_rect, R.layout.practice_round_rect));
        pageModels.add(new PageModel(R.layout.sample_arc, R.string.title_draw_arc, R.layout.practice_arc));
    }

}
