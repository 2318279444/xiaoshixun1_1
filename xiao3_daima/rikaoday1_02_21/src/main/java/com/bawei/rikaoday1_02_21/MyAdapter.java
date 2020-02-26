package com.bawei.rikaoday1_02_21;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/2/21
 *@Time:13:45
 *@Description:
 **/
public class MyAdapter extends FragmentPagerAdapter {
    List<String> sl;
    List<Fragment> fl;

    public MyAdapter(FragmentManager fm, List<String> sl, List<Fragment> fl) {
        super(fm);
        this.sl = sl;
        this.fl = fl;
    }

    @Override
    public Fragment getItem(int position) {
        return fl.get(position);
    }

    @Override
    public int getCount() {
        return fl.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return sl.get(position);
    }
}
