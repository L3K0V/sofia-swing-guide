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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

        final Calendar start = Calendar.getInstance();
        start.set(2016, 7, 11);

        WeekView agenda = (WeekView) view.findViewById(R.id.weekView);
        agenda.setMonthChangeListener(this);
        agenda.setHorizontalFlingEnabled(false);
        agenda.setNumberOfVisibleDays(1);
        agenda.setShowNowLine(true);
        agenda.goToDate(start);

        return view;
    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> schedule = new ArrayList<>();
        schedule.addAll(getBoogieScheduleDay1());
        schedule.addAll(getBoogieScheduleDay2());
        schedule.addAll(getBoogieScheduleDay3());
        schedule.addAll(getLindyScheduleDay1());
        schedule.addAll(getLindyScheduleDay2());
        schedule.addAll(getLindyScheduleDay3());
        schedule.addAll(getLindyScheduleDay4());
        schedule.addAll(getLindyScheduleDay5());
        return newMonth == 8 ? schedule : Collections.EMPTY_LIST;
    }

    private List<WeekViewEvent> getBoogieScheduleDay1() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Cours Découverte Gratuit Nicolas & Irene", 2016, 8, 11, 11, 0, 2016, 8, 11, 12, 0);
        f1.setLocation("Chapiteau 1");
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Boogie Competition (en couple) Thobjorn & Flora", 2016, 8, 11, 11, 0, 2016, 8, 11, 12, 0);
        f2.setLocation("Chapiteau 2");
        f2.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f3 = new WeekViewEvent(3, "Boogie Intermediaire Thobjorn & Flora", 2016, 8, 11, 12, 10, 2016, 8, 11, 13, 10);
        f3.setLocation("Chapiteau 1");
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Boogie Avancé William & Maeva", 2016, 8, 11, 12, 10, 2016, 8, 11, 13, 10);
        f4.setLocation("Chapiteau 2");
        f4.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f5 = new WeekViewEvent(5, "Boogie Intermediaire Thobjorn & Flora", 2016, 8, 11, 13, 20, 2016, 8, 11, 14, 20);
        f5.setLocation("Chapiteau 1");
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Boogie Avancé William & Maeva", 2016, 8, 11, 13, 20, 2016, 8, 11, 14, 20);
        f6.setLocation("Chapiteau 2");
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f7 = new WeekViewEvent(7, "Boogie Débutant Sondre & Tanya", 2016, 8, 11, 14, 30, 2016, 8, 11, 15, 30);
        f7.setLocation("Chapiteau 1");
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f8 = new WeekViewEvent(8, "Boogie Novices Jeff & Joelle", 2016, 8, 11, 14, 30, 2016, 8, 11, 15, 30);
        f8.setLocation("Chapiteau 2");
        f8.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f9 = new WeekViewEvent(9, "Boogie Débutant Sondre & Tanya", 2016, 8, 11, 15, 40, 2016, 8, 11, 16, 40);
        f9.setLocation("Chapiteau 1");
        f9.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f10 = new WeekViewEvent(10, "Boogie Novices Jeff & Joelle", 2016, 8, 11, 15, 40, 2016, 8, 11, 16, 40);
        f10.setLocation("Chapiteau 2");
        f10.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    private List<WeekViewEvent> getBoogieScheduleDay2() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Cours Découverte Gratuit Jeff & Joelle", 2016, 8, 12, 11, 0, 2016, 8, 12, 12, 0);
        f1.setLocation("Chapiteau 1");
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Boogie Competition ( en couple ) Sondre & Tanya", 2016, 8, 12, 11, 0, 2016, 8, 12, 12, 0);
        f2.setLocation("Chapiteau 2");
        f2.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f3 = new WeekViewEvent(3, "Boogie Intermediaire Sondre & Tanya", 2016, 8, 12, 12, 10, 2016, 8, 12, 13, 10);
        f3.setLocation("Chapiteau 1");
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Boogie Avancé Thobjorn & Flora", 2016, 8, 12, 12, 10, 2016, 8, 12, 13, 10);
        f4.setLocation("Chapiteau 2");
        f4.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f5 = new WeekViewEvent(5, "Boogie Intermediaire Sondre & Tanya", 2016, 8, 12, 13, 20, 2016, 8, 12, 14, 20);
        f5.setLocation("Chapiteau 1");
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Boogie Avancé Thobjorn & Flora", 2016, 8, 12, 13, 20, 2016, 8, 12, 14, 20);
        f6.setLocation("Chapiteau 2");
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f7 = new WeekViewEvent(7, "Boogie Débutant William & Maeva", 2016, 8, 12, 14, 30, 2016, 8, 12, 15, 30);
        f7.setLocation("Chapiteau 1");
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f8 = new WeekViewEvent(8, "Boogie Novices Jeff & Joelle", 2016, 8, 12, 14, 30, 2016, 8, 12, 15, 30);
        f8.setLocation("Chapiteau 2");
        f8.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f9 = new WeekViewEvent(9, "Boogie Débutant William & Maeva", 2016, 8, 12, 15, 40, 2016, 8, 12, 16, 40);
        f9.setLocation("Chapiteau 1");
        f9.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f10 = new WeekViewEvent(10, "Boogie Novices Nicolas & Irene", 2016, 8, 12, 15, 40, 2016, 8, 12, 16, 40);
        f10.setLocation("Chapiteau 2");
        f10.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    private List<WeekViewEvent> getBoogieScheduleDay3() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Cours Découverte Gratuit Martin & Cathy", 2016, 8, 13, 11, 10, 2016, 8, 13, 12, 10);
        f1.setLocation("Chapiteau 1");
        f1.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f2 = new WeekViewEvent(2, "Boogie Competition ( en couple ) Pontus & Isabella", 2016, 8, 13, 11, 10, 2016, 8, 13, 12, 10);
        f2.setLocation("Chapiteau 2");
        f2.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f3 = new WeekViewEvent(3, "Boogie Intermediaire Sondre & Tanya", 2016, 8, 13, 12, 20, 2016, 8, 13, 13, 20);
        f3.setLocation("Chapiteau 1");
        f3.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f4 = new WeekViewEvent(4, "Boogie Avancé Pontus & Isabella", 2016, 8, 13, 12, 20, 2016, 8, 13, 13, 20);
        f4.setLocation("Chapiteau 2");
        f4.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f5 = new WeekViewEvent(5, "Boogie Intermediaire Thobjorn & Flora", 2016, 8, 13, 13, 30, 2016, 8, 13, 14, 30);
        f5.setLocation("Chapiteau 1");
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Boogie Avancé Pontus & Isabella", 2016, 8, 13, 13, 30, 2016, 8, 13, 14, 30);
        f6.setLocation("Chapiteau 2");
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f7 = new WeekViewEvent(7, "Boogie Débutant Thobjorn & Flora", 2016, 8, 13, 14, 40, 2016, 8, 13, 15, 40);
        f7.setLocation("Chapiteau 1");
        f7.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f8 = new WeekViewEvent(8, "Boogie Novices Martin & Cathy", 2016, 8, 13, 14, 40, 2016, 8, 13, 15, 40);
        f8.setLocation("Chapiteau 2");
        f8.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f9 = new WeekViewEvent(9, "Boogie Débutant Sondre & Tanya", 2016, 8, 13, 15, 50, 2016, 8, 13, 16, 50);
        f9.setLocation("Chapiteau 1");
        f9.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f10 = new WeekViewEvent(10, "Boogie Novices Martin & Cathy", 2016, 8, 13, 15, 50, 2016, 8, 13, 16, 50);
        f10.setLocation("Chapiteau 2");
        f10.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    private List<WeekViewEvent> getLindyScheduleDay1() {

        WeekViewEvent f1 = new WeekViewEvent(1, "Lindy Hop Inter Max & Audrey", 2016, 8, 15, 11, 0, 2016, 8, 15, 12, 0);
        f1.setLocation("Salle Polyvalente");
        f1.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f2 = new WeekViewEvent(1, "Lindy Hop Avancé Thomas & Maeva", 2016, 8, 15, 11, 0, 2016, 8, 15, 12, 0);
        f2.setLocation("Chapiteau 1");
        f2.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f3 = new WeekViewEvent(3, "Lindy Hop Débutant Thobjorn & Flora", 2016, 8, 15, 11, 0, 2016, 8, 15, 12, 0);
        f3.setLocation("Chapiteau 2");
        f3.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f4 = new WeekViewEvent(4, "Lindy Hop Inter Max & Audrey", 2016, 8, 15, 12, 10, 2016, 8, 15, 13, 10);
        f4.setLocation("Salle Polyvalente");
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "Lindy Hop Avancé Thomas & Maeva", 2016, 8, 15, 12, 10, 2016, 8, 15, 13, 10);
        f5.setLocation("Chapiteau 1");
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Lindy Hop Débutant Miguel & Carla", 2016, 8, 15, 12, 10, 2016, 8, 15, 13, 10);
        f6.setLocation("Chapiteau 2");
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        // Break

        WeekViewEvent f7 = new WeekViewEvent(7, "Solo JAzz Inter Nicolas Rodriguez", 2016, 8, 15, 14, 0, 2016, 8, 15, 15, 10);
        f7.setLocation("Salle Polyvalente");
        f7.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f8 = new WeekViewEvent(8, "Lindy Hop Avancé + Pontus & Isabella", 2016, 8, 15, 14, 0, 2016, 8, 15, 15, 10);
        f8.setLocation("Chapiteau 1");
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f9 = new WeekViewEvent(9, "Solo Jazz Débutant Oliv", 2016, 8, 15, 14, 0, 2016, 8, 15, 15, 10);
        f9.setLocation("Chapiteau 2");
        f9.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f10 = new WeekViewEvent(10, "Solo Jazz Avancé Carla", 2016, 8, 15, 15, 20, 2016, 8, 15, 16, 20);
        f10.setLocation("Salle Polyvalente");
        f10.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f11 = new WeekViewEvent(11, "Lindy Hop Avancé + Pontus & Isabella", 2016, 8, 15, 15, 20, 2016, 8, 15, 16, 20);
        f11.setLocation("Chapiteau 1");
        f11.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f12 = new WeekViewEvent(12, "SoloJazz Avancé + Tatiana", 2016, 8, 15, 16, 20, 2016, 8, 15, 17, 20);
        f12.setLocation("Chapiteau 1");
        f12.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12);
    }

    private List<WeekViewEvent> getLindyScheduleDay2() {

        WeekViewEvent f1 = new WeekViewEvent(1, "Lindy Hop Avancé + Jb & Tatiana", 2016, 8, 16, 11, 0, 2016, 8, 16, 12, 0);
        f1.setLocation("Salle Polyvalente");
        f1.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f2 = new WeekViewEvent(2, "Lindy Hop Avancé Pontus & Isabella", 2016, 8, 16, 11, 0, 2016, 8, 16, 12, 0);
        f2.setLocation("Chapiteau 1");
        f2.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f3 = new WeekViewEvent(3, "Lindy Hop Débutant Thomas & Maeva", 2016, 8, 16, 11, 0, 2016, 8, 16, 12, 0);
        f3.setLocation("Chapiteau 2");
        f3.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f4 = new WeekViewEvent(4, "Lindy Hop Avancé + Jb & Tatiana", 2016, 8, 16, 12, 10, 2016, 8, 16, 13, 10);
        f4.setLocation("Salle Polyvalente");
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "Lindy Hop Avancé Pontus & Isabella", 2016, 8, 16, 12, 10, 2016, 8, 16, 13, 10);
        f5.setLocation("Chapiteau 1");
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Lindy Hop Débutant Thomas & Maeva", 2016, 8, 16, 12, 10, 2016, 8, 16, 13, 10);
        f6.setLocation("Chapiteau 2");
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        // Break

        WeekViewEvent f7 = new WeekViewEvent(7, "Lindy Hop Avancé + Max & Audrey", 2016, 8, 16, 14, 0, 2016, 8, 16, 15, 10);
        f7.setLocation("Salle Polyvalente");
        f7.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f8 = new WeekViewEvent(8, "Lindy Hop Avancé Jb & Tatiana", 2016, 8, 16, 14, 0, 2016, 8, 16, 15, 10);
        f8.setLocation("Chapiteau 1");
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f9 = new WeekViewEvent(9, "Lindy Hop Inter Thomas & Maeva", 2016, 8, 16, 14, 0, 2016, 8, 16, 15, 10);
        f9.setLocation("Chapiteau 2");
        f9.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f10 = new WeekViewEvent(10, "Solo Jazz Avancé + Max", 2016, 8, 16, 15, 20, 2016, 8, 16, 16, 20);
        f10.setLocation("Salle Polyvalente");
        f10.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f11 = new WeekViewEvent(11, "Solo Jazz Avancé Andy", 2016, 8, 16, 15, 20, 2016, 8, 16, 16, 20);
        f11.setLocation("Chapiteau 1");
        f11.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f12 = new WeekViewEvent(12, "Lindy Hop Inter Thomas & Maeva", 2016, 8, 16, 15, 20, 2016, 8, 16, 16, 20);
        f12.setLocation("Chapiteau 2");
        f12.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f13 = new WeekViewEvent(13, "Solo Jazz Inter Nicolas Rodriguez", 2016, 8, 16, 16, 20, 2016, 8, 16, 17, 20);
        f13.setLocation("Salle Polyvalente");
        f13.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f14 = new WeekViewEvent(14, "Solo Jazz Débutant Audrey", 2016, 8, 16, 16, 20, 2016, 8, 16, 17, 20);
        f14.setLocation("Chapiteau 2");
        f14.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14);
    }

    private List<WeekViewEvent> getLindyScheduleDay3() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Lindy Hop Inter Jb & Tatiana", 2016, 8, 17, 11, 0, 2016, 8, 17, 12, 0);
        f1.setLocation("Salle Polyvalente");
        f1.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f2 = new WeekViewEvent(2, "Lindy Hop Avancé Max & Audrey", 2016, 8, 17, 11, 0, 2016, 8, 17, 12, 0);
        f2.setLocation("Chapiteau 1");
        f2.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f3 = new WeekViewEvent(3, "Lindy Hop Débutant Thobjorn & Flora", 2016, 8, 17, 11, 0, 2016, 8, 17, 12, 0);
        f3.setLocation("Chapiteau 2");
        f3.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f4 = new WeekViewEvent(4, "Lindy Hop Inter Jb & Tatiana", 2016, 8, 17, 12, 10, 2016, 8, 17, 13, 10);
        f4.setLocation("Salle Polyvalente");
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "Lindy Hop Avancé Max & Audrey", 2016, 8, 17, 12, 10, 2016, 8, 17, 13, 10);
        f5.setLocation("Chapiteau 1");
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Lindy Hop Débutant Thobjorn & Flora", 2016, 8, 17, 12, 10, 2016, 8, 17, 13, 10);
        f6.setLocation("Chapiteau 2");
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        // Break

        WeekViewEvent f7 = new WeekViewEvent(7, "Lindy Hop Inter Pontus & Isabella", 2016, 8, 17, 14, 0, 2016, 8, 17, 15, 10);
        f7.setLocation("Salle Polyvalente");
        f7.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f8 = new WeekViewEvent(8, "Lindy Hop Avancé+ Max & Audrey", 2016, 8, 17, 14, 0, 2016, 8, 17, 15, 10);
        f8.setLocation("Chapiteau 1");
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f9 = new WeekViewEvent(9, "Solo Jazz Débutant Nicolas Rodriguez", 2016, 8, 17, 14, 0, 2016, 8, 17, 15, 10);
        f9.setLocation("Chapiteau 2");
        f9.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f10 = new WeekViewEvent(10, "Solo Jazz Inter Jb Mino", 2016, 8, 17, 15, 20, 2016, 8, 17, 16, 20);
        f10.setLocation("Salle Polyvalente");
        f10.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f11 = new WeekViewEvent(11, "Lindy Hop Avancé+ Thomas & Maeva", 2016, 8, 17, 15, 20, 2016, 8, 17, 16, 20);
        f11.setLocation("Chapiteau 1");
        f11.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f12 = new WeekViewEvent(12, "Solo Jazz Débutant Nicolas Rodriguez", 2016, 8, 17, 15, 20, 2016, 8, 17, 16, 20);
        f12.setLocation("Chapiteau 2");
        f12.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f13 = new WeekViewEvent(13, "Solo Jazz Avancé Andy", 2016, 8, 17, 16, 20, 2016, 8, 17, 17, 20);
        f13.setLocation("Salle Polyvalente");
        f13.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f14 = new WeekViewEvent(14, "Solo Jazz Avancé + Oliv Wan", 2016, 8, 17, 16, 20, 2016, 8, 17, 17, 20);
        f14.setLocation("Chapiteau 1");
        f14.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14);
    }

    private List<WeekViewEvent> getLindyScheduleDay4() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Lindy Hop Avancé + Pontus & Isabella", 2016, 8, 18, 11, 0, 2016, 8, 18, 12, 0);
        f1.setLocation("Salle Polyvalente");
        f1.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f2 = new WeekViewEvent(2, "Lindy Hop Avancé Jb & Tatiana", 2016, 8, 18, 11, 0, 2016, 8, 18, 12, 0);
        f2.setLocation("Chapiteau 1");
        f2.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f3 = new WeekViewEvent(3, "Lindy Hop Débutant Miguel & Carla", 2016, 8, 18, 11, 0, 2016, 8, 18, 12, 0);
        f3.setLocation("Chapiteau 2");
        f3.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f4 = new WeekViewEvent(4, "Lindy Hop Avancé + Pontus & Isabella", 2016, 8, 18, 12, 10, 2016, 8, 18, 13, 10);
        f4.setLocation("Salle Polyvalente");
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "Lindy Hop Avancé Jb & Tatiana", 2016, 8, 18, 12, 10, 2016, 8, 18, 13, 10);
        f5.setLocation("Chapiteau 1");
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Lindy Hop Débutant Miguel & Carla", 2016, 8, 18, 12, 10, 2016, 8, 18, 13, 10);
        f6.setLocation("Chapiteau 2");
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        // Break

        WeekViewEvent f7 = new WeekViewEvent(7, "Solo Jazz Avancé + Andy", 2016, 8, 18, 14, 0, 2016, 8, 18, 15, 10);
        f7.setLocation("Salle Polyvalente");
        f7.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f8 = new WeekViewEvent(8, "Solo Jazz Avancé Oliv Wan", 2016, 8, 18, 14, 0, 2016, 8, 18, 15, 10);
        f8.setLocation("Chapiteau 1");
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f9 = new WeekViewEvent(9, "Lindy Hop Inter Miguel & Carla", 2016, 8, 18, 14, 0, 2016, 8, 18, 15, 10);
        f9.setLocation("Chapiteau 2");
        f9.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f10 = new WeekViewEvent(10, "Solo Jazz Avancé + Andy", 2016, 8, 18, 15, 20, 2016, 8, 18, 16, 20);
        f10.setLocation("Salle Polyvalente");
        f10.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f11 = new WeekViewEvent(11, "Solo Jazz Avancé Oliv Wan", 2016, 8, 18, 15, 20, 2016, 8, 18, 16, 20);
        f11.setLocation("Chapiteau 1");
        f11.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f12 = new WeekViewEvent(12, "Lindy Hop Inter Miguel & Carla", 2016, 8, 18, 15, 20, 2016, 8, 18, 16, 20);
        f12.setLocation("Chapiteau 2");
        f12.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f13 = new WeekViewEvent(13, "Solo Jazz Inter Andy", 2016, 8, 18, 16, 20, 2016, 8, 18, 17, 20);
        f13.setLocation("Salle Polyvalente");
        f13.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f14 = new WeekViewEvent(14, "Solo Jazz Débutant Nicolas Rodriguez", 2016, 8, 18, 16, 20, 2016, 8, 18, 17, 20);
        f14.setLocation("Chapiteau 2");
        f14.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14);
    }

    private List<WeekViewEvent> getLindyScheduleDay5() {
        WeekViewEvent f1 = new WeekViewEvent(1, "Lindy Hop Inter Pontus & Isabella", 2016, 8, 19, 11, 0, 2016, 8, 19, 12, 0);
        f1.setLocation("Salle Polyvalente");
        f1.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f2 = new WeekViewEvent(2, "Lindy Hop Avancé Thomas & Maeva", 2016, 8, 19, 11, 0, 2016, 8, 19, 12, 0);
        f2.setLocation("Chapiteau 1");
        f2.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f3 = new WeekViewEvent(3, "Lindy Hop Débutant Thobjorn & Flora", 2016, 8, 19, 11, 0, 2016, 8, 19, 12, 0);
        f3.setLocation("Chapiteau 2");
        f3.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f4 = new WeekViewEvent(4, "Lindy Hop Inter Pontus & Isabella", 2016, 8, 19, 12, 10, 2016, 8, 19, 13, 10);
        f4.setLocation("Salle Polyvalente");
        f4.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f5 = new WeekViewEvent(5, "Lindy Hop Avancé Thomas & Maeva", 2016, 8, 19, 12, 10, 2016, 8, 19, 13, 10);
        f5.setLocation("Chapiteau 1");
        f5.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f6 = new WeekViewEvent(6, "Lindy Hop Débutant Thobjorn & Flora", 2016, 8, 19, 12, 10, 2016, 8, 19, 13, 10);
        f6.setLocation("Chapiteau 2");
        f6.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        // Break

        WeekViewEvent f7 = new WeekViewEvent(7, "Solo Jazz Inter Nicolas Rodriguez", 2016, 8, 19, 14, 0, 2016, 8, 19, 15, 10);
        f7.setLocation("Salle Polyvalente");
        f7.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f8 = new WeekViewEvent(8, "Lindy Hop Avancé + Jb & Tatiana", 2016, 8, 19, 14, 0, 2016, 8, 19, 15, 10);
        f8.setLocation("Chapiteau 1");
        f8.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f9 = new WeekViewEvent(9, "Lindy Hop Débutant Pontus & Isabella", 2016, 8, 19, 14, 0, 2016, 8, 19, 15, 10);
        f9.setLocation("Chapiteau 2");
        f9.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f10 = new WeekViewEvent(10, "Solo Jazz Inter Miguel", 2016, 8, 19, 15, 20, 2016, 8, 19, 16, 20);
        f10.setLocation("Salle Polyvalente");
        f10.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f11 = new WeekViewEvent(11, "Lindy Hop Avancé + Max & Audrey", 2016, 8, 19, 15, 20, 2016, 8, 19, 16, 20);
        f11.setLocation("Chapiteau 1");
        f11.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        WeekViewEvent f12 = new WeekViewEvent(12, "Solo Jazz Débutant Oliv Wan", 2016, 8, 19, 15, 20, 2016, 8, 19, 16, 20);
        f12.setLocation("Chapiteau 2");
        f12.setColor(ContextCompat.getColor(getContext(), R.color.primary_dark));

        WeekViewEvent f13 = new WeekViewEvent(13, "Solo Jazz Avancé Oliv Wan", 2016, 8, 19, 16, 20, 2016, 8, 19, 17, 20);
        f13.setLocation("Salle Polyvalente");
        f13.setColor(ContextCompat.getColor(getContext(), R.color.contact_pink));

        WeekViewEvent f14 = new WeekViewEvent(14, "Solo Jazz Avancé + Jb Mino", 2016, 8, 19, 16, 20, 2016, 8, 19, 17, 20);
        f14.setLocation("Chapiteau 1");
        f14.setColor(ContextCompat.getColor(getContext(), R.color.accent));

        return Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14);
    }
}
