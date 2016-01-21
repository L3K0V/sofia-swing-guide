package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.adapters.SchedulePagerAdapter;

/**
 * Created by mmironov on 1/21/16.
 */
public class ScheduleFragment extends Fragment {

    public static final String TAG = "ScheduleFragment";

    private TabLayout tabs;
    private ViewPager schedulePager;
    private SchedulePagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        tabs = (TabLayout) view.findViewById(R.id.tabs);
        schedulePager = (ViewPager) view.findViewById(R.id.schedulePager);

        adapter = new SchedulePagerAdapter(getFragmentManager());

        addFragments();

        schedulePager.setAdapter(adapter);
        tabs.setTabsFromPagerAdapter(adapter);

        return view;
    }

    public void addFragments() {
        Bundle args = new Bundle();
        args.putString(SchedulePageFragment.PAGE_TITLE, "Int");
        SchedulePageFragment page1 = new SchedulePageFragment();
        page1.setArguments(args);

        Bundle args2 = new Bundle();
        args2.putString(SchedulePageFragment.PAGE_TITLE, "Int-Adv");
        SchedulePageFragment page2 = new SchedulePageFragment();
        page2.setArguments(args2);

        Bundle args3 = new Bundle();
        args3.putString(SchedulePageFragment.PAGE_TITLE, "Adv");
        SchedulePageFragment page3 = new SchedulePageFragment();
        page1.setArguments(args3);

        Bundle args4 = new Bundle();
        args4.putString(SchedulePageFragment.PAGE_TITLE, "Inv");
        SchedulePageFragment page4 = new SchedulePageFragment();
        page2.setArguments(args4);

        adapter.addFragment(page1, "Int");
        adapter.addFragment(page2, "Int-Adv");
        adapter.addFragment(page3, "Adv");
        adapter.addFragment(page4, "Inv");
    }
}
