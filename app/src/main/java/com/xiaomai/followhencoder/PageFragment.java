package com.xiaomai.followhencoder;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

/**
 * Created by XiaoMai on 2017/7/21.
 */

public class PageFragment extends Fragment {

    @LayoutRes
    int sampleLayoutRes;
    @LayoutRes
    int practiceLayoutRes;

    static final String SAMPLE_LAYOUT_RES = "sampleLayoutRes";
    static final String PRACTICE_LAYOUT_RES = "practiceLayoutRes";

    public static PageFragment newInstance(@LayoutRes int sampleLayoutRes, @LayoutRes int practiceLayoutRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(SAMPLE_LAYOUT_RES, sampleLayoutRes);
        args.putInt(PRACTICE_LAYOUT_RES, practiceLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        ViewStub sampleStub = view.findViewById(R.id.sampleStub);
        sampleStub.setLayoutResource(sampleLayoutRes);
        sampleStub.inflate();

        ViewStub practiceStub = view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(practiceLayoutRes);
        practiceStub.inflate();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            sampleLayoutRes = args.getInt(SAMPLE_LAYOUT_RES);
            practiceLayoutRes = args.getInt(PRACTICE_LAYOUT_RES);
        }
    }
}
