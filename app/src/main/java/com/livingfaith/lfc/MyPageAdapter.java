package com.livingfaith.lfc;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

class MyPageAdapter extends PagerAdapter {

    private static Integer[] titles = new Integer[]
            {
                    R.drawable.announcement,R.drawable.event,R.drawable.church_news
            };

    public int getCount() {
        return 3;
    }

    public Object instantiateItem(View collection, int position) {

        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        ImageView iv;

        view = inflater.inflate(R.layout.activity_main2, null);

        ((ViewPager) collection).addView(view, 0);
        switch (position) {
            case 0:
               /* iv = (ImageView)view.findViewById(R.id.image1);
                iv.setImageResource(titles[position]);*/
                break;
            case 1:
               /* iv = (ImageView)view.findViewById(R.id.image1);
                iv.setImageResource(titles[position]);*/
                break;
            case 2:
                /*iv = (ImageView)view.findViewById(R.id.image1);
                iv.setImageResource(titles[position]);*/
                break;
        }
        return view;
    }

    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);

    }



    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);

    }

}