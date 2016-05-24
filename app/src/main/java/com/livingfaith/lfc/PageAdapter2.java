package com.livingfaith.lfc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter2 extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter2(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Other_books_online onlineTab1 = new Other_books_online();
                return onlineTab1;
            case 1:
                Others_books_offline offlinetab2 = new Others_books_offline();
                return offlinetab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}