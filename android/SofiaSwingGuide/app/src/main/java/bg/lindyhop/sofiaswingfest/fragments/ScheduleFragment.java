package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
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

    private SchedulePagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        final AppBarLayout collapsing = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
        collapsing.setExpanded(false);

        TabLayout tabs = (TabLayout) view.findViewById(R.id.tabs);
        ViewPager schedulePager = (ViewPager) view.findViewById(R.id.schedulePager);

        adapter = new SchedulePagerAdapter(getFragmentManager());

        addFragments();

        schedulePager.setAdapter(adapter);

        tabs.setupWithViewPager(schedulePager);

        return view;
    }

    public void addFragments() {
        Bundle args = new Bundle();
        args.putString(SchedulePageFragment.PAGE_TITLE, "Int");
        SchedulePageFragment page1 = new SchedulePageFragment();
        page1.setArguments(args);

        Bundle args2 = new Bundle();
        args2.putString(SchedulePageFragment.PAGE_TITLE, "Int-Adv-1");
        SchedulePageFragment page2 = new SchedulePageFragment();
        page2.setArguments(args2);

        Bundle args3 = new Bundle();
        args3.putString(SchedulePageFragment.PAGE_TITLE, "Int-Adv-2");
        SchedulePageFragment page3 = new SchedulePageFragment();
        page3.setArguments(args3);

        Bundle args4 = new Bundle();
        args4.putString(SchedulePageFragment.PAGE_TITLE, "Adv");
        SchedulePageFragment page4 = new SchedulePageFragment();
        page4.setArguments(args4);

        Bundle args5 = new Bundle();
        args5.putString(SchedulePageFragment.PAGE_TITLE, "Adv+");
        SchedulePageFragment page5 = new SchedulePageFragment();
        page5.setArguments(args5);

        Bundle args6 = new Bundle();
        args6.putString(SchedulePageFragment.PAGE_TITLE, "Inv");
        SchedulePageFragment page6 = new SchedulePageFragment();
        page6.setArguments(args6);

        adapter.addFragment(page1, "Int");
        adapter.addFragment(page2, "IA-1");
        adapter.addFragment(page3, "IA-2");
        adapter.addFragment(page4, "Adv");
        adapter.addFragment(page5, "Adv+");
        adapter.addFragment(page6, "Inv");
    }
}
