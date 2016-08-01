package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import bg.lindyhop.sofiaswingfest.R;

/**
 * Created by mmironov on 1/21/16.
 */
public class ScheduleFragment extends Fragment implements MonthLoader.MonthChangeListener {

    public static final String TAG = "ScheduleFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        final AppBarLayout collapsing = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
        collapsing.setExpanded(false);

        WeekView agenda = (WeekView) view.findViewById(R.id.weekView);
        agenda.setMonthChangeListener(this);
        agenda.setHorizontalFlingEnabled(false);

        return view;
    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {

        WeekViewEvent event = new WeekViewEvent(1, "Party", 2016, 7, 26, 12, 30, 2016, 7, 26, 23, 0);
        event.setLocation("Stadion Lazur");
        event.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent event2 = new WeekViewEvent(2, "Party", 2016, 7, 26, 9, 0, 2016, 7, 26, 14, 30);
        event2.setLocation("NDK");
        event2.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return newMonth == 7 ? Arrays.asList(event, event2) : Collections.EMPTY_LIST;
    }
}
