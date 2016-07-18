package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bg.lindyhop.entities.ScheduleItem;
import bg.lindyhop.entities.Teacher;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.adapters.ScheduleAdapter;
import bg.lindyhop.sofiaswingfest.adapters.TeachersAdapter;

/**
 * Created by mmironov on 5/23/16.
 */
public class PartiesFragment extends android.support.v4.app.Fragment {

    public static final String TAG = "PartiesFragment";

    public static final String PAGE_TITLE = "pageTitle";

    public static final String HALL_BULGARIA = "Hall Bulgaria";
    public static final String HALL_CZECH_REPUBLIC = "Hall Czech Republic";
    public static final String HALL_ROMANIA = "Hall Romania";
    public static final String HALL_ITALY = "Hall Italy";
    public static final String HALL_GREECE = "Hall Greece";
    public static final String HALL_SLOVENIA = "Hall Slovenia";

    private RecyclerView scheduleThursday;
    private RecyclerView scheduleFriday;
    private RecyclerView scheduleSaturday;
    private RecyclerView scheduleSunday;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_page, container, false);

        scheduleThursday = (RecyclerView) view.findViewById(R.id.scheduleThursday);

        scheduleThursday.setLayoutManager(new LinearLayoutManager(getActivity()));
        scheduleThursday.setAdapter(new TeachersAdapter(new ArrayList<Teacher>()));

        scheduleFriday = (RecyclerView) view.findViewById(R.id.scheduleFriday);

        scheduleFriday.setLayoutManager(new LinearLayoutManager(getActivity()));
        scheduleFriday.setAdapter(new TeachersAdapter(new ArrayList<Teacher>()));

        scheduleSaturday = (RecyclerView) view.findViewById(R.id.scheduleSaturday);

        scheduleSaturday.setLayoutManager(new LinearLayoutManager(getActivity()));
        scheduleSaturday.setAdapter(new TeachersAdapter(new ArrayList<Teacher>()));

        scheduleSunday = (RecyclerView) view.findViewById(R.id.scheduleSunday);

        scheduleSunday.setLayoutManager(new LinearLayoutManager(getActivity()));
        scheduleSunday.setAdapter(new TeachersAdapter(new ArrayList<Teacher>()));

        setupAdapters();

        return view;
    }

    private void setupAdapters() {

        List<ScheduleItem> thursdayItems = new ArrayList<>();
        thursdayItems.add(new ScheduleItem("History Talk with Ryan", "Peroto", "21:00 - 22:00"));
        thursdayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 04:00"));

        ScheduleAdapter thursdayScheduleAdapter = new ScheduleAdapter(thursdayItems);
        scheduleThursday.setAdapter(thursdayScheduleAdapter);

        List<ScheduleItem> fridayItems = new ArrayList<>();

        fridayItems.add(new ScheduleItem("Open JnJ Prelims", HALL_BULGARIA, "21:00 - 22:00"));
        fridayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 04:00"));
        fridayItems.add(new ScheduleItem("Cabaret", HALL_SLOVENIA, "23:30 - 00:00"));
        fridayItems.add(new ScheduleItem("Open JnJ Finals", HALL_SLOVENIA, "00:00 - 00:15"));
        fridayItems.add(new ScheduleItem("Teachers Presentation", HALL_SLOVENIA ,"00:15"));

        ScheduleAdapter fridayAdapter = new ScheduleAdapter(fridayItems);
        scheduleFriday.setAdapter(fridayAdapter);

        List<ScheduleItem> saturdayItems = new ArrayList<>();
        saturdayItems.add(new ScheduleItem("Advanced JnJ Prelims", HALL_BULGARIA, "21:00 - 21:30"));
        saturdayItems.add(new ScheduleItem("Strictly Lindy Prelims", HALL_BULGARIA, "21:30 - 22:00"));
        saturdayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 4:00"));
        saturdayItems.add(new ScheduleItem("Advanced JnJ Finals", HALL_SLOVENIA, "23:30 - 23:45"));
        saturdayItems.add(new ScheduleItem("Strictly Lindy Finals", HALL_SLOVENIA, "23:45 - 00:00"));

        ScheduleAdapter saturdayAdapter = new ScheduleAdapter(saturdayItems);
        scheduleSaturday.setAdapter(saturdayAdapter);

        List<ScheduleItem> sundayItems = new ArrayList<>();
        sundayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 4:00"));
        sundayItems.add(new ScheduleItem("Swingout Dropout", HALL_BULGARIA, "22:00 - 22:30"));

        ScheduleAdapter sundayAdapter = new ScheduleAdapter(sundayItems);
        scheduleSunday.setAdapter(sundayAdapter);
    }
}
