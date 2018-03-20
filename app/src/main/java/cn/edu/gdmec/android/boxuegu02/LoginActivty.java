package cn.edu.gdmec.android.boxuegu02;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by apple on 18/3/20.
 */

public class LoginActivty {
    private TextView tv_main_title;
    private TextView tv_back,tv_register,tv_find_psw;
    private Button btn_login;
    private String userName,psw,spPsw;
    private EditText et_user_name,et_psw;



    private  void init(){
        //从main_title_bar.xml页面布局中获取UI控件
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        tv_main_title.setText("登陆");
        tv_back=(TextView)findViewById(R.id.tv_back);
        tv_register=(TextView) findViewById(R.id.tv_register);
       tv_find_psw=(TextView)findViewById(R.id.btn_login);
        //从activity_register.xml页面布局中获取UI控件
        btn_login=(Button)findViewById(R.id.btn_register);

        et_user_name=(EditText)findViewById(R.id.et_user_name);
        et_psw=(EditText)findViewById(R.id.et_psw);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivty.this.finish();
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivty.this,RegisterActivity.class);
                startActiviryForResult(intent,1);

            }
        });
}
