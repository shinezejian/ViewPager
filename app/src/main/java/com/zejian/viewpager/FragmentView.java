package com.zejian.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zejian
 * Time 16/8/7.
 * Description:
 */
public class FragmentView extends Fragment {

    private Bundle arg;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arg=getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment,null);
        TextView tv= (TextView) view.findViewById(R.id.tv);
        int page=arg.getInt("pager_num");

        if (page==1){
            view.setBackgroundResource(R.color.colorAccent);
        }else if(page==2){
            view.setBackgroundResource(R.color.greed);
        }else if(page==3){
            view.setBackgroundResource(R.color.red);
        }else if(page==4){
            view.setBackgroundResource(R.color.colorPrimary);
        }

        tv.setText(arg.getString("Title"));
        return view;
    }


   public static FragmentView newInstance(Bundle args) {
        FragmentView fragment = new FragmentView();
        fragment.setArguments(args);
        return fragment;
    }

}
