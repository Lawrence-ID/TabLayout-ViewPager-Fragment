package com.example.again;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private int[] TabRes = new int[]{R.drawable.shouye, R.drawable.kefu, R.drawable.tianjia};
    private String[] titles = new String[]{"首页", "客服", "添加"};
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabLayout.Tab tabAtOne;
    private TabLayout.Tab tabAttwo;
    private TabLayout.Tab tabAtthree;
    private TabLayout.Tab tabAtfour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        initView();
        initDate();

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_content_view);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_view);

        //使用适配器将ViewPager与Fragment绑定在一起
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        //将TabLayout与ViewPager绑定
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < titles.length; i++) {
            tabLayout.getTabAt(i).setIcon(TabRes[i]);
        }
    }
    private void initDate(){

    }

    public void initListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i < titles.length; i++) {
                    if(tab == tabLayout.getTabAt(i)){
                        tabLayout.getTabAt(i).setIcon(TabRes[i]);
                        viewPager.setCurrentItem(i);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                for (int i = 0; i < titles.length; i++) {
                    tabLayout.getTabAt(i).setIcon(TabRes[i]);
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
        public MyFragmentPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position == 1){
                return new SecondFragment();
            }else if(position == 2){
                return new ThirdFragment();
            }
            return new FirstFragment();
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
