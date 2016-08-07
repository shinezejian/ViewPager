package com.zejian.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by zejian
 * Time 16/8/7.
 * Description:
 */
public class Main extends Activity {

    private Button vp_btn;
    private Button vp_fg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);

        vp_btn= (Button) findViewById(R.id.normal_vp);
        vp_fg_btn= (Button) findViewById(R.id.fg_vp);


        vp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main.this,MainActivity.class);
                startActivity(i);
            }
        });

        vp_fg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main.this,VP_FG_Activity.class);
                startActivity(i);
            }
        });
    }
}
