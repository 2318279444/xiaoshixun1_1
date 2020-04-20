package adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/3/9
 *@Time:13:21
 *@Description:
 **/
public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<String> sl;
    List<Fragment> fl;

    public MyFragmentAdapter(FragmentManager fm, List<String> sl, List<Fragment> fl) {
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
