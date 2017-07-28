package com.xiaomai.followhencoder.base;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xiaomai.followhencoder.R;
import com.xiaomai.followhencoder.model.PageModel;

import java.util.ArrayList;
import java.util.List;

public class BasePracticeActivity extends AppCompatActivity {

    TabLayout tableLayout;
    ViewPager pager;
    public List<PageModel> pageModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.getSampleLayoutRes(), pageModel.getPracticeLayoutRes());
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).getTitleRes());
            }
        });

        tableLayout = (TabLayout) findViewById(R.id.tabLayout);
        tableLayout.setupWithViewPager(pager);
    }

}
