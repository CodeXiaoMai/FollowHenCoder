package com.xiaomai.followhencoder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaomai.followhencoder.practice.five.PracticeFiveActivity;
import com.xiaomai.followhencoder.practice.four.PracticeFourActivity;
import com.xiaomai.followhencoder.practice.one.PracticeOneActivity;
import com.xiaomai.followhencoder.practice.six.PracticeSixActivity;
import com.xiaomai.followhencoder.practice.three.PracticeThreeActivity;
import com.xiaomai.followhencoder.practice.two.PracticeTwoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoMai on 2017/7/28.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<Practice> mPracticeList = new ArrayList<>();

    {
        mPracticeList.add(new Practice("自定义 View 1-6 属性动画（上）", PracticeSixActivity.class));
        mPracticeList.add(new Practice("自定义 View 1-5 绘制顺序", PracticeFiveActivity.class));
        mPracticeList.add(new Practice("自定义 View 1-4 Canvas 对绘制的辅助", PracticeFourActivity.class));
        mPracticeList.add(new Practice("自定义 View 1-3 文字的绘制", PracticeThreeActivity.class));
        mPracticeList.add(new Practice("自定义 View 1-2 Paint 详解", PracticeTwoActivity.class));
        mPracticeList.add(new Practice("自定义 View 1-1 绘制基础", PracticeOneActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_practice, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            Holder viewHolder = (Holder) holder;
            viewHolder.textView.setText(mPracticeList.get(position).name);
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, mPracticeList.get(position).action);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mPracticeList.size();
        }

        private class Holder extends RecyclerView.ViewHolder {
            TextView textView;

            public Holder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.tv_name);
            }
        }
    }

    private class Practice {
        String name;
        Class action;

        public Practice(String name, Class action) {
            this.name = name;
            this.action = action;
        }
    }
}
