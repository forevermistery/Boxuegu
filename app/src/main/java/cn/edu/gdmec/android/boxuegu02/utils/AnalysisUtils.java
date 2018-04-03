package cn.edu.gdmec.android.boxuegu02.utils;


import android.content.Context;
import android.content.SharedPreferences;



/**
 * Created by apple on 18/4/3.
 */

public class AnalysisUtils  {

    //读取用户名


    public static String readLoginUserName(Context context){
        SharedPreferences sp=context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        String userName=sp.getString("loginUserName","");
        return userName;

    }

    //读取登陆状态

    public static boolean readLoginStatus(Context context){
        SharedPreferences sp=context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        boolean isLogin=sp.getBoolean("isLogin",false);
        return isLogin;

    }
    //清楚登录状态

    public static void clearLoginStatus(Context context){
        SharedPreferences sp=context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();

        editor.putBoolean("isLogin",false);
        editor.putString("loginUserName","");
        editor.commit();
    }


    }

