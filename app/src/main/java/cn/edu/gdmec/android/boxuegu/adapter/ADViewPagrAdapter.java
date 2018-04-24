package cn.edu.gdmec.android.boxuegu.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by apple on 18/4/24.
 */

public class ADViewPagrAdapter extends PagerAdapter {
    private Context context;
    private List<ImageView> list;


    public ADViewPagrAdapter (Context context, List<ImageView> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount(){
        return list.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object){
        return view==object;

    }
    @Override
    public void destroyItem (ViewGroup containner,int postion,Object object){
        containner.removeView(list.get(postion));
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        container.addView(list.get(position));
        return list.get(position);

    }
}
