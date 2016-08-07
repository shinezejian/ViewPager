package com.zejian.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zejian
 * Time 16/8/7.
 * Description:
 */
public class VP_FG_Activity extends FragmentActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_fg);
        viewPager= (ViewPager) findViewById(R.id.vp);
        initData();
    }

    public void initData(){

        List<Fragment> list=new ArrayList<>();

        Bundle bundle1=new Bundle();
        bundle1.putString("Title","第一个Fragment");
        bundle1.putInt("pager_num",1);
        Fragment fg1=FragmentView.newInstance(bundle1);

        Bundle bundle2=new Bundle();
        bundle2.putString("Title","第二个Fragment");
        bundle2.putInt("pager_num",2);
        Fragment fg2=FragmentView.newInstance(bundle2);

        Bundle bundle3=new Bundle();
        bundle3.putString("Title","第三个Fragment");
        bundle3.putInt("pager_num",3);
        Fragment fg3=FragmentView.newInstance(bundle3);

        Bundle bundle4=new Bundle();
        bundle4.putString("Title","第四个Fragment");
        bundle4.putInt("pager_num",4);
        Fragment fg4=FragmentView.newInstance(bundle4);

        list.add(fg1);
        list.add(fg2);
        list.add(fg3);
        list.add(fg4);

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),list));

    }

    class MyFragmentAdapter extends FragmentPagerAdapter{

        List<Fragment> list;

        public MyFragmentAdapter(FragmentManager fm,List<Fragment> list) {
            super(fm);
            this.list=list;
        }

        /**
         * 返回需要展示的fragment
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        /**
         * 返回需要展示的fangment数量
         * @return
         */
        @Override
        public int getCount() {
            return list.size();
        }
    }
    class MyFragmentStateAdapter extends FragmentStatePagerAdapter{

        List<Fragment> list;

        public MyFragmentStateAdapter(FragmentManager fm,List<Fragment> list) {
            super(fm);
            this.list=list;
        }

        /**
         * 返回需要展示的fragment
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        /**
         * 返回需要展示的fangment数量
         * @return
         */
        @Override
        public int getCount() {
            return list.size();
        }
    }
}
