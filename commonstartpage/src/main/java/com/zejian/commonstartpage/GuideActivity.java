
package com.zejian.commonstartpage;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zejian
 * Time 16/8/7.
 * Description:
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    // ViewPager的数据
    private List<ImageView> imageViewList;
    // 点的组
    private LinearLayout llPointGroup;
    // 选中的点view对象
    private View mSelectPointView;
    // 开始体验按钮
    private Button btnStartExperience;
    // ViewPager
    ViewPager mViewPager;
    // 点之间的宽度
    private int pWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去标题, 需要在setContentView方法之前调用
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        initView();// 初始化控件
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        btnStartExperience = (Button) findViewById(R.id.btn_guide_start_experience);
        llPointGroup = (LinearLayout) findViewById(R.id.ll_guide_point_group);
        mSelectPointView = findViewById(R.id.select_point);
        initData();// 初始化ViewPager数据
        GuideAdapter adapter = new GuideAdapter();
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(this);// 设置监听器
        btnStartExperience.setOnClickListener(this);// 按钮添加监听
    }

    /**
     * TODO：初始化ViewPager数据 void
     */
    private void initData() {
        int[] imageResIDs = {R.drawable.guide_1, R.drawable.guide_2,
                R.drawable.guide_3};
        imageViewList = new ArrayList<>();

        ImageView iv;// 图片
        View view;// 点
        LayoutParams params; // 参数类

        for (int i = 0; i < imageResIDs.length; i++) {
            iv = new ImageView(this);
            iv.setBackgroundResource(imageResIDs[i]);
            imageViewList.add(iv);
            // 根据图片的个数, 每循环一次向LinearLayout中添加一个点
            view = new View(this);
            view.setBackgroundResource(R.drawable.point_normal);
            // 设置参数
            params = new LayoutParams(10, 10);
            if (i != 0) {
                params.leftMargin = 10;
            }
            view.setLayoutParams(params);// 添加参数
            llPointGroup.addView(view);
        }
    }


    /**
     * 当页面正在滚动时 position 当前选中的是哪个页面 positionOffset 比例 positionOffsetPixels 偏移像素
     */
    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {

        Log.e("zejian","positionOffset:-->"+positionOffset);
        Log.e("zejian","position:-->"+position);
        //获取两个点间的距离,获取一次即可
        if(pWidth==0) {
            pWidth = llPointGroup.getChildAt(1).getLeft()
                    - llPointGroup.getChildAt(0).getLeft();
        }

        // 获取点要移动的距离
        int leftMargin = (int) (pWidth * (position + positionOffset));
        // 给红点设置参数
        RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) mSelectPointView
                .getLayoutParams();
        params.leftMargin = leftMargin;
        mSelectPointView.setLayoutParams(params);
    }

    /**
     * 当页面被选中
     */
    @Override
    public void onPageSelected(int position) {
        // 显示体验按钮
        if (position == imageViewList.size() - 1) {
            btnStartExperience.setVisibility(View.VISIBLE);// 显示
        } else {
            btnStartExperience.setVisibility(View.GONE);// 隐藏
        }
    }

    /**
     * 当页面滚动状态改变
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 打开新的界面
     */
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "跳转新界面", Toast.LENGTH_SHORT).show();
    }


    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /*
         * 删除元素
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = imageViewList.get(position);
            container.addView(iv);// 1. 向ViewPager中添加一个view对象
            return iv; // 2. 返回当前添加的view对象
        }
    }
}