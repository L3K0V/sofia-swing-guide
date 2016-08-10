package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import bg.lindyhop.sofiaswingfest.R;

/**
 * Created by mmironov on 5/23/16.
 */
public class PartiesFragment extends android.support.v4.app.Fragment implements MonthLoader.MonthChangeListener {

    public static final String TAG = "PartiesFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        final AppBarLayout collapsing = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
        collapsing.setExpanded(false);

        final Calendar start = Calendar.getInstance();
        start.set(2016, 7, 11);

        WeekView agenda = (WeekView) view.findViewById(R.id.weekView);
        agenda.setMonthChangeListener(this);
        agenda.setHorizontalFlingEnabled(false);
        agenda.setNumberOfVisibleDays(1);
        agenda.setShowNowLine(true);
        agenda.goToDate(start);
        agenda.setEventMarginVertical(1);

        return view;
    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {

        List<WeekViewEvent> schedule = new ArrayList<>();
        schedule.addAll(getBoogieThursday());
        schedule.addAll(getBoogieFriday());
        schedule.addAll(getBoggieSaturday());
        schedule.addAll(getLindyMonday());
        schedule.addAll(getLindyTuesday());
        schedule.addAll(getLindyWednesday());
        schedule.addAll(getLindyThursday());
        schedule.addAll(getLindyFriday());
        schedule.addAll(getLindySaturday());

        return newMonth == 8 ? schedule : Collections.EMPTY_LIST;
    }

    private List<WeekViewEvent> getLindySaturday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Début de soirée DJ William", 2016, 8, 20, 21, 0, 2016, 8, 20, 22, 0);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f2 = new WeekViewEvent(2, "Live with Emilie Cole & The Rhythm Gamblers", 2016, 8, 20, 22, 0, 2016, 8, 20, 22, 30);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f3 = new WeekViewEvent(3, " DJ Nicolas Rodriguez", 2016, 8, 20, 22, 30, 2016, 8, 20, 23, 15);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Live with Emilie Cole & The Rhythm Gamblers", 2016, 8, 20, 23, 15, 2016, 8, 20, 23, 45);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "DJ Andy Spitz", 2016, 8, 20, 23, 45, 2016, 8, 21, 0, 30);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Live with Emilie Cole & The Rhythm Gamblers", 2016, 8, 21, 0, 30, 2016, 8, 21, 1, 0);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f7 = new WeekViewEvent(7, "DJ El Cerf", 2016, 8, 21, 1, 0, 2016, 8, 21, 1, 45);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f8 = new WeekViewEvent(8, "DJ Nicolas Rodriguez & William", 2016, 8, 21, 1, 45, 2016, 8, 21, 2, 30);
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f9 = new WeekViewEvent(9, "AFTER PARTY au Bar Le Joker", 2016, 8, 21, 2, 30, 2016, 8, 21, 3, 30);
        f9.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    private List<WeekViewEvent> getLindyFriday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Début de soirée DJ William", 2016, 8, 19, 21, 0, 2016, 8, 19, 22, 0);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f2 = new WeekViewEvent(2, "Live with Emilie Cole & The Rhythm Gamblers", 2016, 8, 19, 22, 0, 2016, 8, 19, 22, 30);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f3 = new WeekViewEvent(3, " DJ Nicolas Rodriguez", 2016, 8, 19, 22, 30, 2016, 8, 19, 23, 15);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Live with Emilie Cole & The Rhythm Gamblers", 2016, 8, 19, 23, 15, 2016, 8, 19, 23, 45);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "DJ Andy Spitz", 2016, 8, 19, 23, 45, 2016, 8, 20, 0, 30);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Live with Emilie Cole & The Rhythm Gamblers", 2016, 8, 20, 0, 30, 2016, 8, 20, 1, 0);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f7 = new WeekViewEvent(7, "DJ Nicolas Rodriguez", 2016, 8, 20, 1, 0, 2016, 8, 20, 1, 45);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f8 = new WeekViewEvent(8, "DJ Damien Verron « New Orleans »", 2016, 8, 20, 1, 45, 2016, 8, 20, 2, 30);
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f9 = new WeekViewEvent(9, "AFTER PARTY au Bar Le Joker", 2016, 8, 20, 2, 30, 2016, 8, 20, 3, 30);
        f9.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    private List<WeekViewEvent> getLindyThursday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Cour Musicalité avec Oliv Wan", 2016, 8, 18, 21, 0, 2016, 8, 18, 22, 0);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Début de soirée DJ Andy", 2016, 8, 18, 22, 0, 2016, 8, 18, 22, 30);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f3 = new WeekViewEvent(3, "Live with The Rhythm Gamblers", 2016, 8, 18, 22, 30, 2016, 8, 18, 23, 15);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f4 = new WeekViewEvent(4, "DJ Nicolas Rodriguez", 2016, 8, 18, 23, 15, 2016, 8, 18, 23, 45);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f5 = new WeekViewEvent(5, "Live with The Rhythm Gamblers", 2016, 8, 18, 23, 45, 2016, 8, 19, 0, 30);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f6 = new WeekViewEvent(6, "DJ William", 2016, 8, 19, 0, 30, 2016, 8, 19, 1, 0);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f7 = new WeekViewEvent(7, "Live with The Rhythm Gamblers", 2016, 8, 19, 1, 0, 2016, 8, 19, 1, 45);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f8 = new WeekViewEvent(8, "DJ El Cerf", 2016, 8, 19, 1, 45, 2016, 8, 19, 2, 30);
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f9 = new WeekViewEvent(9, "DJ Damien Verron « New Orleans »", 2016, 8, 19, 2, 30, 2016, 8, 19, 3, 30);
        f9.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    private List<WeekViewEvent> getLindyWednesday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "DJ Andy Spitz", 2016, 8, 17, 22, 0, 2016, 8, 17, 22, 30);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Live with The Rhythm Gamblers", 2016, 8, 17, 22, 30, 2016, 8, 17, 23, 15);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f3 = new WeekViewEvent(3, "Teachers Cabaret ( DJ Nicolas Rodriguez )", 2016, 8, 17, 23, 15, 2016, 8, 17, 23, 45);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f4 = new WeekViewEvent(4, "Live with The Rhythm Gamblers", 2016, 8, 17, 23, 45, 2016, 8, 18, 0, 30);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "Final Jack’N’Jill & Solo Jazz Competition", 2016, 8, 18, 0, 30, 2016, 8, 18, 1, 0);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f6 = new WeekViewEvent(6, "Live with The Rhythm Gamblers", 2016, 8, 18, 1, 0, 2016, 8, 18, 1, 45);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f7 = new WeekViewEvent(7, "DJ William & Nicolas Rodriguez (RhythmNBlues)", 2016, 8, 18, 1, 45, 2016, 8, 18, 2, 30);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f8 = new WeekViewEvent(8, "AFTER PARTY au Bar Le Joker", 2016, 8, 18, 2, 30, 2016, 8, 18, 4, 0);
        f8.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8);
    }

    private List<WeekViewEvent> getLindyTuesday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "DJ Andy", 2016, 8, 16, 22, 0, 2016, 8, 16, 22, 30);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Live with The Rhythm Gamblers tribute to Count Basie", 2016, 8, 16, 22, 30, 2016, 8, 16, 23, 15);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f3 = new WeekViewEvent(3, "DJ Nicolas Rodriguez", 2016, 8, 16, 23, 15, 2016, 8, 16, 23, 45);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Live with The Rhythm Gamblers tribute to Count Basie", 2016, 8, 16, 23, 45, 2016, 8, 17, 0, 30);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "DJ William", 2016, 8, 17, 0, 30, 2016, 8, 17, 1, 0);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Live with The Rhythm Gamblers tribute to Count Basie", 2016, 8, 17, 1, 0, 2016, 8, 17, 1, 45);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f7 = new WeekViewEvent(7, "DJ El Cerf", 2016, 8, 17, 1, 45, 2016, 8, 17, 2, 30);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f8 = new WeekViewEvent(8, "DJ Nicolas Rodriguez", 2016, 8, 17, 2, 30, 2016, 8, 17, 3, 30);
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8);
    }

    private List<WeekViewEvent> getLindyMonday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "DJ Nicolas Rodriguez", 2016, 8, 15, 22, 0, 2016, 8, 15, 22, 30);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Live Music with The Swing Shouters", 2016, 8, 15, 22, 30, 2016, 8, 15, 23, 15);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f3 = new WeekViewEvent(3, "DJ Nicolas Rodriguez", 2016, 8, 15, 23, 15, 2016, 8, 15, 23, 45);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Live Music with The Swing Shouters", 2016, 8, 15, 23, 45, 2016, 8, 16, 0, 30);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "DJ William", 2016, 8, 16, 0, 30, 2016, 8, 16, 1, 0);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Live Music with The Swing Shouters", 2016, 8, 16, 1, 0, 2016, 8, 16, 1, 45);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f7 = new WeekViewEvent(7, "DJ Nicolas Rodriguez", 2016, 8, 16, 1, 45, 2016, 8, 16, 2, 30);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7);
    }

    private List<WeekViewEvent> getBoggieSaturday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "DJ William", 2016, 8, 13, 22, 30, 2016, 8, 13, 23, 0);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Live Music with The Swing Shouters", 2016, 8, 13, 23, 0, 2016, 8, 13, 23, 30);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f3 = new WeekViewEvent(3, "DJ Nicolas Rodriguez", 2016, 8, 13, 23, 30, 2016, 8, 14, 0, 30);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Live Music with The Swing Shouters", 2016, 8, 14, 0, 30, 2016, 8, 14, 0, 45);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "DJ El Cerf", 2016, 8, 14, 0, 45, 2016, 8, 14, 1, 30);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Live Music with The Swing Shouters", 2016, 8, 14, 1, 30, 2016, 8, 14, 2, 0);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f7 = new WeekViewEvent(7, "DJ Battle ( 2 songs per DJ -William / Jeff / Nicolas- )", 2016, 8, 14, 2, 0, 2016, 8, 14, 3, 0);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7);
    }

    private List<WeekViewEvent> getBoogieFriday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "DJ William", 2016, 8, 12, 22, 30, 2016, 8, 12, 23, 0);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Live Music with The Swing Shouters", 2016, 8, 12, 23, 0, 2016, 8, 12, 23, 30);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f3 = new WeekViewEvent(3, "DJ El Cerf", 2016, 8, 12, 23, 30, 2016, 8, 13, 0, 30);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Live Music with The Swing Shouters", 2016, 8, 13, 0, 30, 2016, 8, 13, 0, 45);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "DJ Nicolas Rodriguez", 2016, 8, 13, 0, 45, 2016, 8, 13, 1, 30);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Live Music with The Swing Shouters", 2016, 8, 13, 1, 30, 2016, 8, 13, 2, 0);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f7 = new WeekViewEvent(7, "DJ El Cerf", 2016, 8, 13, 2, 0, 2016, 8, 13, 3, 0);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7);
    }

    private List<WeekViewEvent> getBoogieThursday() {
        WeekViewEvent f1 = new WeekViewEvent(1, "DJ William", 2016, 8, 11, 22, 30, 2016, 8, 11, 23, 0);
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "DJ Nicolas Rodriguez", 2016, 8, 11, 23, 0, 2016, 8, 11, 23, 30);
        f2.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f3 = new WeekViewEvent(3, "DJ El Cerf", 2016, 8, 11, 23, 30, 2016, 8, 12, 0, 30);
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Presentation Boogie Woogie Teachers", 2016, 8, 12, 0, 30, 2016, 8, 12, 0, 45);
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "DJ Battle ( 2 songs per DJ Willian / Jeff / Nicolas )", 2016, 8, 12, 0, 45, 2016, 8, 12, 1, 30);
        f5.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f6 = new WeekViewEvent(6, "DJ El Cerf", 2016, 8, 12, 1, 30, 2016, 8, 12, 2, 0);
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f7 = new WeekViewEvent(7, "DJ Battle ( 2 songs per DJ -William / Jeff / Nicolas- )", 2016, 8, 12, 2, 0, 2016, 8, 12, 3, 0);
        f7.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7);
    }
}
