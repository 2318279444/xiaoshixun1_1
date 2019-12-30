package com.bawei.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2019/12/30
 *@Time:15:15
 *@Description:
 **/
public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<String> slist;
    List<Fragment> flist;

    public MyFragmentAdapter(@NonNull FragmentManager fm, List<String> slist, List<Fragment> flist) {
        super(fm);
        this.slist = slist;
        this.flist = flist;
    }

    public MyFragmentAdapter(@NonNull FragmentManager fm, int behavior, List<String> slist, List<Fragment> flist) {
        super(fm, behavior);
        this.slist = slist;
        this.flist = flist;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position);
    }
}
