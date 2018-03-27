package cn.edu.gdmec.android.boxuegu02.Activity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.edu.gdmec.android.boxuegu02.Fragment.CourseFragment;
import cn.edu.gdmec.android.boxuegu02.Fragment.ExercisesFragment;
import cn.edu.gdmec.android.boxuegu02.Fragment.MyinfoFragment;
import cn.edu.gdmec.android.boxuegu02.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private RelativeLayout main_body;
    private TextView bottom_bar_text_course;
    private ImageView bottom_bar_image_course;
    private RelativeLayout bottom_bar_course_btn;
    private TextView bottom_bar_text_myinfo;
    private ImageView bottom_bar_image_myinfo;
    private RelativeLayout bottm_bar_myinfo_btn;
    private LinearLayout main_bottom_bar;
    private TextView bottom_bar_text_exercises;
    private ImageView bottom_bar_image_exercises;
    private RelativeLayout bottm_bar_exercises_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setMian();

    }

    private void initView() {
        main_body = (RelativeLayout) findViewById(R.id.main_body);
        bottom_bar_text_course = (TextView) findViewById(R.id.bottom_bar_text_course);
        bottom_bar_image_course = (ImageView) findViewById(R.id.bottom_bar_image_course);
        bottom_bar_course_btn = (RelativeLayout) findViewById(R.id.bottom_bar_course_btn);
        bottom_bar_text_myinfo = (TextView) findViewById(R.id.bottom_bar_text_myinfo);
        bottom_bar_image_myinfo = (ImageView) findViewById(R.id.bottom_bar_image_myinfo);
        bottm_bar_myinfo_btn = (RelativeLayout) findViewById(R.id.bottm_bar_myinfo_btn);
        main_bottom_bar = (LinearLayout) findViewById(R.id.main_bottom_bar);

        bottom_bar_text_exercises = (TextView) findViewById(R.id.bottom_bar_text_exercises);
        bottm_bar_myinfo_btn.setOnClickListener(this);

        bottom_bar_image_exercises = (ImageView) findViewById(R.id.bottom_bar_image_exercises);
        bottom_bar_course_btn.setOnClickListener(this);

        bottm_bar_exercises_btn = (RelativeLayout) findViewById(R.id.bottm_bar_exercises_btn);
        bottm_bar_exercises_btn.setOnClickListener(this);

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.main_body,new CourseFragment()).commit();

    }
    public void setSelectStatus(int index){
        switch (index){
            case 0:
                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon_selected);
                bottom_bar_text_course.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon);
                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon);
                break;
            case 1:
                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon_selected);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon);
                break;
            case 2:
                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon_selected);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));
                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon);
                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                break;
        }
    }
    public void setMian(){
        this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,new MyinfoFragment()).commit();
        setSelectStatus(2);
    }
    @Override
    public void onClick(View v) {
   switch (v.getId()){
       case R.id.bottom_bar_course_btn:
           getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new CourseFragment()).commit();
           setSelectStatus(0);
           break;
       case R.id.bottm_bar_myinfo_btn:
           getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new MyinfoFragment()).commit();
           setSelectStatus(2);
           break;
       case R.id.bottm_bar_exercises_btn:
           getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new ExercisesFragment()).commit();
           setSelectStatus(1);
           break;
   }

    }
}


