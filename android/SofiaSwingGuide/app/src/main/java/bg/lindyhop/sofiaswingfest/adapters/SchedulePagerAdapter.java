package bg.lindyhop.sofiaswingfest.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import bg.lindyhop.sofiaswingfest.fragments.SchedulePageFragment;

/**
 * Created by mmironov on 1/21/16.
 */
public class SchedulePagerAdapter extends FragmentPagerAdapter {

    private List<SchedulePageFragment> schedulePageFragments;
    private List<String> titles;

    public SchedulePagerAdapter(FragmentManager fm) {
        super(fm);

        schedulePageFragments = new ArrayList<>();
        titles = new ArrayList<>();
    }

    public void addFragment(SchedulePageFragment fragment, String title) {
        schedulePageFragments.add(fragment);
        titles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return schedulePageFragments.get(position);
    }

    @Override
    public int getCount() {
        return schedulePageFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
