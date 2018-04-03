package cn.edu.gdmec.android.boxuegu02.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

import cn.edu.gdmec.android.boxuegu02.R;
import cn.edu.gdmec.android.boxuegu02.utils.AnalysisUtils;

public class SettingActivity extends Activity implements View.OnClickListener {

//    private RelativeLayout rlModifyPsw;
//    private RelativeLayout rlSecuritySetting;
//    private RelativeLayout rlExitLogin;
    private TextView tv_back;
    private TextView tv_main_title;
    private TextView tv_save;
    private RelativeLayout title_bar;
    private RelativeLayout rl_modify_psw;
    private RelativeLayout rl_security_setting;
    private RelativeLayout rl_exit_login;
    public static SettingActivity instance=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        instance=this;
        initView();

//        rlModifyPsw = (RelativeLayout) findViewById(R.id.rl_modify_psw);
//        rlSecuritySetting = (RelativeLayout) findViewById(R.id.rl_security_setting);
//        rlExitLogin = (RelativeLayout) findViewById(R.id.rl_exit_login);
    }

    private void initView() {
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        tv_save = (TextView) findViewById(R.id.tv_save);
        title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        rl_modify_psw = (RelativeLayout) findViewById(R.id.rl_modify_psw);
        rl_security_setting = (RelativeLayout) findViewById(R.id.rl_security_setting);
        rl_exit_login = (RelativeLayout) findViewById(R.id.rl_exit_login);

        tv_main_title.setText("设置");
        title_bar.setBackgroundColor(Color.parseColor("#F0F0F0"));


        tv_back.setOnClickListener(this);
        rl_modify_psw.setOnClickListener(this);
        rl_security_setting.setOnClickListener(this);
        rl_exit_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
              SettingActivity.this.finish();

                break;

            case R.id.rl_modify_psw:
               //设置密码界面
                Intent intent=new Intent(SettingActivity.this,ModifyPswActivity.class);
               startActivity(intent);
                break;

            case R.id.rl_security_setting:
                //设置密保界面
                Intent intent2=new Intent(SettingActivity.this,FindPswActivity.class);
                intent2.putExtra("from","security");
                startActivity(intent2);

                break;
            case R.id.rl_exit_login:
                //退出登陆，即清除登陆状态
                Toast.makeText(this, "退出登陆成功", Toast.LENGTH_SHORT).show();
                AnalysisUtils.clearLoginStatus(this);
                Intent data=new Intent();
                data.putExtra("isLogin",false);
                setResult(RESULT_OK,data);
                Intent intents=new Intent(SettingActivity.this,MainActivity.class);

               startActivity(intents);
                break;

        }

    }

}
