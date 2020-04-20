package adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<String> sl;
    List<Fragment> fl;

    public MyFragmentAdapter(@NonNull FragmentManager fm, List<String> sl, List<Fragment> fl) {
        super(fm);
        this.sl = sl;
        this.fl = fl;
    }

    public MyFragmentAdapter(@NonNull FragmentManager fm, int behavior, List<String> sl, List<Fragment> fl) {
        super(fm, behavior);
        this.sl = sl;
        this.fl = fl;
    }

    @NonNull
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
