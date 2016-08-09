package com.zejian.viewpageranimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private CompatibleViewPager vp;
    private List<View> imageViewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        vp= (CompatibleViewPager) findViewById(R.id.vp);
        initData();
    }


    public void initData(){
        int[] imageResIDs = {R.drawable.android_guide_step_1, R.drawable.android_guide_step_2,
                R.drawable.android_guide_step_3};
        imageViewList = new ArrayList<>();

        ImageView iv;// 图片

        for (int i = 0; i < imageResIDs.length; i++) {
            iv = new ImageView(this);
            iv.setScaleType(ImageView.ScaleType.CENTER);
            iv.setBackgroundResource(imageResIDs[i]);
            imageViewList.add(iv);
        }

        vp.setAdapter(new MyPagerAdapter());
//        vp.setPageTransformer(true,new ZoomOutPageTransformer());
        vp.setPageTransformer(true,new DepthPageTransformer());
    }


    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewList.get(position));
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewList.get(position));
            return imageViewList.get(position);
        }
    }

}
