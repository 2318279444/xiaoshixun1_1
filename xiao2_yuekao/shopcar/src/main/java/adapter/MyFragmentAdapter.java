package adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/2/15
 *@Time:12:07
 *@Description:
 **/
public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<String> sli;
    List<Fragment> fli;

    public MyFragmentAdapter(FragmentManager fm, List<String> sli, List<Fragment> fli) {
        super(fm);
        this.sli = sli;
        this.fli = fli;
    }

    @Override
    public Fragment getItem(int position) {
        return fli.get(position);
    }

    @Override
    public int getCount() {
        return fli.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return sli.get(position);
    }
}
