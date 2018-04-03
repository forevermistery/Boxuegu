package cn.edu.gdmec.android.boxuegu02.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdmec.android.boxuegu02.R;
import cn.edu.gdmec.android.boxuegu02.utils.MD5Utils;

/**
 * Created by apple on 18/3/20.
 */

public class LoginActivty  extends AppCompatActivity {
    private TextView tv_main_title;
    private TextView tv_back, tv_register, tv_find_psw;
    private Button btn_login;
    private String userName, psw, spPsw;
    private EditText et_user_name, et_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {


        //从main_title_bar.xml页面布局中获取UI控件
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        tv_main_title.setText("登陆");

        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_register = (TextView) findViewById(R.id.tv_register);
        tv_find_psw = (TextView) findViewById(R.id.tv_find_psw);
        //从activity_register.xml页面布局中获取UI控件
        btn_login = (Button) findViewById(R.id.btn_login);

        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_psw = (EditText) findViewById(R.id.et_psw);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivty.this.finish();
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivty.this, RegisterActivity.class);
                startActivityForResult(intent, 1);


            }
        });
        tv_find_psw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivty.this,FindPswActivity.class);
                startActivity(intent);
            }
        });
        //登录按钮的点击事件
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                userName=et_user_name.getText().toString().trim();
                psw=et_psw.getText().toString().trim();
                String md5Psw= MD5Utils.md5(psw);
                spPsw=readPsw(userName);
                if (TextUtils.isEmpty(userName)){
                    Toast.makeText(LoginActivty.this,"请输入用户名",Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(psw)){
                    Toast.makeText(LoginActivty.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }else if(md5Psw.equals(spPsw)){
                    Toast.makeText(LoginActivty.this,"登录成功",Toast.LENGTH_SHORT).show();
                    saveLoginStatus(true,userName);
                    Intent data=new Intent();
                    data.putExtra("isLogin",true);
                    data.putExtra("userName",true);
                    setResult(RESULT_OK,data);
                    Intent intent=new Intent(LoginActivty.this,MainActivity.class);
                    startActivity(intent);

                    LoginActivty.this.finish();
                    return;
                }else if((spPsw!=null&&TextUtils.isEmpty(spPsw)&&!md5Psw.equals(spPsw))){
                    Toast.makeText(LoginActivty.this,"输入的用户名和密码不一致",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Toast.makeText(LoginActivty.this,"此用户名不存在",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    private  String readPsw(String userName){
        SharedPreferences sp =getSharedPreferences("loginInfo",MODE_PRIVATE);
        return  sp.getString(userName,"");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            //从注册页面传递过来的用户名
            String userName=data.getStringExtra("userName");
            if (!TextUtils.isEmpty(userName)){
                et_user_name.setText(userName);
                //设置光标的位置
                et_user_name.setSelection(userName.length());
            }
        }
    }

    private void saveLoginStatus(boolean status, String userName){
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();//获取编辑器
        editor.putBoolean("isLogin",status);//存入boolean类型的登录状态
        editor.putString("loginUserName",userName);//存入登录状态时的用户名
        boolean commit = editor.commit();//提交修改



    }
}
