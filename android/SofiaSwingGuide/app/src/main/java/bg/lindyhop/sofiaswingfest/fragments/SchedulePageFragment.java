package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
 * Created by mmironov on 1/21/16.
 */
public class SchedulePageFragment extends Fragment {

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

        String level = getArguments().getString(PAGE_TITLE);

        switch (level) {
            case "Int":
                setupIntermediateSchedule();
                break;
            case "Int-Adv-1":
                setupIntAdv1Schedule();
                break;
            case "Int-Adv-2":
                setupIntAdv2Schedule();
                break;
            case "Adv":
                setupAdvancedSchedule();
                break;
            case "Adv+":
                setupAdvancedPlusSchedule();
                break;
            case "Inv":
                setupInvitationalSchedule();
                break;
        }
    }

    private void setupIntermediateSchedule() {
        List<ScheduleItem> thursdayItems = new ArrayList<>();
        thursdayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_BULGARIA, "17:00 - 18:00"));
        thursdayItems.add(new ScheduleItem("History Talk with Ryan", "Peroto", "21:00 - 22:00"));
        thursdayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 04:00"));

        ScheduleAdapter thursdayScheduleAdapter = new ScheduleAdapter(thursdayItems);
        scheduleThursday.setAdapter(thursdayScheduleAdapter);

        List<ScheduleItem> fridayItems = new ArrayList<>();
        fridayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_CZECH_REPUBLIC, "10:30 - 11:30"));
        fridayItems.add(new ScheduleItem("Audition", HALL_SLOVENIA, "12:00 - 13:00"));
        fridayItems.add(new ScheduleItem("Felipe & Alice", HALL_BULGARIA, "13:10 - 14:10"));
        fridayItems.add(new ScheduleItem("Max & Audrey", HALL_GREECE, "14:20 - 16:30"));
        fridayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Nastya", HALL_SLOVENIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_BULGARIA, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_CZECH_REPUBLIC, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "18:00 - 19:00"));

        fridayItems.add(new ScheduleItem("Open JnJ Prelims", HALL_BULGARIA, "21:00 - 22:00"));
        fridayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 04:00"));

        ScheduleAdapter fridayAdapter = new ScheduleAdapter(fridayItems);
        scheduleFriday.setAdapter(fridayAdapter);

        List<ScheduleItem> saturdayItems = new ArrayList<>();
        saturdayItems.add(new ScheduleItem("Felipe & Alice", HALL_SLOVENIA, "11:00 - 12:00"));
        saturdayItems.add(new ScheduleItem("Felipe", HALL_GREECE, "12:10 - 14:20"));
        saturdayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_BULGARIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Nastya", HALL_CZECH_REPUBLIC, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_SLOVENIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Advanced JnJ Prelims", HALL_BULGARIA, "21:00 - 21:30"));
        saturdayItems.add(new ScheduleItem("Strictly Lindy Prelims", HALL_BULGARIA, "21:30 - 22:00"));
        saturdayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 4:00"));

        ScheduleAdapter saturdayAdapter = new ScheduleAdapter(saturdayItems);
        scheduleSaturday.setAdapter(saturdayAdapter);

        List<ScheduleItem> sundayItems = new ArrayList<>();
        sundayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_ITALY, "11:00 - 12:00"));
        sundayItems.add(new ScheduleItem("William & Maeva", HALL_ITALY, "12:00 - 13:00"));
        sundayItems.add(new ScheduleItem("Group Photo", HALL_BULGARIA, "16:30 - 16:50"));
        sundayItems.add(new ScheduleItem("Walking Tour with LIVE music", HALL_BULGARIA, "16:50 - 19:00"));
        sundayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 4:00"));

        ScheduleAdapter sundayAdapter = new ScheduleAdapter(sundayItems);
        scheduleSunday.setAdapter(sundayAdapter);
    }

    private void setupIntAdv1Schedule() {
        List<ScheduleItem> thursdayItems = new ArrayList<>();
        thursdayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_BULGARIA, "17:00 - 18:00"));
        thursdayItems.add(new ScheduleItem("History Talk with Ryan", "Peroto", "21:00 - 22:00"));
        thursdayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 04:00"));

        ScheduleAdapter thursdayScheduleAdapter = new ScheduleAdapter(thursdayItems);
        scheduleThursday.setAdapter(thursdayScheduleAdapter);

        List<ScheduleItem> fridayItems = new ArrayList<>();
        fridayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_CZECH_REPUBLIC, "10:30 - 11:30"));
        fridayItems.add(new ScheduleItem("Audition", HALL_SLOVENIA, "12:00 - 13:00"));
        fridayItems.add(new ScheduleItem("William & Maeva", HALL_CZECH_REPUBLIC, "13:10 - 14:10"));
        fridayItems.add(new ScheduleItem("Alice", HALL_SLOVENIA, "14:20 - 16:30"));
        fridayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Nastya", HALL_SLOVENIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_BULGARIA, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_CZECH_REPUBLIC, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "18:00 - 19:00"));

        fridayItems.add(new ScheduleItem("Open JnJ Prelims", HALL_BULGARIA, "21:00 - 22:00"));
        fridayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 04:00"));

        ScheduleAdapter fridayAdapter = new ScheduleAdapter(fridayItems);
        scheduleFriday.setAdapter(fridayAdapter);

        List<ScheduleItem> saturdayItems = new ArrayList<>();
        saturdayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_SLOVENIA, "12:10 - 13:10"));
        saturdayItems.add(new ScheduleItem("Max & Audrey", HALL_BULGARIA, "13:20 - 14:20"));
        saturdayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_BULGARIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Nastya", HALL_CZECH_REPUBLIC, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_SLOVENIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Advanced JnJ Prelims", HALL_BULGARIA, "21:00 - 21:30"));
        saturdayItems.add(new ScheduleItem("Strictly Lindy Prelims", HALL_BULGARIA, "21:30 - 22:00"));
        saturdayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 4:00"));

        ScheduleAdapter saturdayAdapter = new ScheduleAdapter(saturdayItems);
        scheduleSaturday.setAdapter(saturdayAdapter);

        List<ScheduleItem> sundayItems = new ArrayList<>();
        sundayItems.add(new ScheduleItem("Felipe & Alice", HALL_BULGARIA, "12:00 - 13:00"));
        sundayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_BULGARIA, "13:10 - 14:10"));
        sundayItems.add(new ScheduleItem("William & Maeva", HALL_CZECH_REPUBLIC, "15:30 - 16:30"));
        sundayItems.add(new ScheduleItem("Group Photo", HALL_BULGARIA, "16:30 - 16:50"));
        sundayItems.add(new ScheduleItem("Walking Tour with LIVE music", HALL_BULGARIA, "16:50 - 19:00"));
        sundayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 4:00"));

        ScheduleAdapter sundayAdapter = new ScheduleAdapter(sundayItems);
        scheduleSunday.setAdapter(sundayAdapter);
    }

    private void setupIntAdv2Schedule() {
        List<ScheduleItem> thursdayItems = new ArrayList<>();
        thursdayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_BULGARIA, "17:00 - 18:00"));
        thursdayItems.add(new ScheduleItem("History Talk with Ryan", "Peroto", "21:00 - 22:00"));
        thursdayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 04:00"));

        ScheduleAdapter thursdayScheduleAdapter = new ScheduleAdapter(thursdayItems);
        scheduleThursday.setAdapter(thursdayScheduleAdapter);

        List<ScheduleItem> fridayItems = new ArrayList<>();
        fridayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_CZECH_REPUBLIC, "10:30 - 11:30"));
        fridayItems.add(new ScheduleItem("Audition", HALL_SLOVENIA, "12:00 - 13:00"));
        fridayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_SLOVENIA, "13:10 - 14:10"));
        fridayItems.add(new ScheduleItem("Alice", HALL_SLOVENIA, "14:20 - 16:30"));
        fridayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Nastya", HALL_SLOVENIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_BULGARIA, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_CZECH_REPUBLIC, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "18:00 - 19:00"));

        fridayItems.add(new ScheduleItem("Open JnJ Prelims", HALL_BULGARIA, "21:00 - 22:00"));
        fridayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 04:00"));

        ScheduleAdapter fridayAdapter = new ScheduleAdapter(fridayItems);
        scheduleFriday.setAdapter(fridayAdapter);

        List<ScheduleItem> saturdayItems = new ArrayList<>();
        saturdayItems.add(new ScheduleItem("Max & Audrey", HALL_GREECE, "11:00 - 12:00"));
        saturdayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_SLOVENIA, "12:10 - 13:10"));
        saturdayItems.add(new ScheduleItem("Max & Audrey", HALL_CZECH_REPUBLIC, "14:30 - 15:30"));
        saturdayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_BULGARIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Nastya", HALL_CZECH_REPUBLIC, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_SLOVENIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Advanced JnJ Prelims", HALL_BULGARIA, "21:00 - 21:30"));
        saturdayItems.add(new ScheduleItem("Strictly Lindy Prelims", HALL_BULGARIA, "21:30 - 22:00"));
        saturdayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 4:00"));

        ScheduleAdapter saturdayAdapter = new ScheduleAdapter(saturdayItems);
        scheduleSaturday.setAdapter(saturdayAdapter);

        List<ScheduleItem> sundayItems = new ArrayList<>();
        sundayItems.add(new ScheduleItem("William & Maeva", HALL_BULGARIA, "14:20 - 15:20"));
        sundayItems.add(new ScheduleItem("Felipe & Alice", HALL_BULGARIA, "15:30 - 16:30"));
        sundayItems.add(new ScheduleItem("Group Photo", HALL_BULGARIA, "16:30 - 16:50"));
        sundayItems.add(new ScheduleItem("Walking Tour with LIVE music", HALL_BULGARIA, "16:50 - 19:00"));
        sundayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 4:00"));

        ScheduleAdapter sundayAdapter = new ScheduleAdapter(sundayItems);
        scheduleSunday.setAdapter(sundayAdapter);
    }

    private void setupAdvancedSchedule() {
        List<ScheduleItem> thursdayItems = new ArrayList<>();
        thursdayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_BULGARIA, "17:00 - 18:00"));
        thursdayItems.add(new ScheduleItem("History Talk with Ryan", "Peroto", "21:00 - 22:00"));
        thursdayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 04:00"));

        ScheduleAdapter thursdayScheduleAdapter = new ScheduleAdapter(thursdayItems);
        scheduleThursday.setAdapter(thursdayScheduleAdapter);

        List<ScheduleItem> fridayItems = new ArrayList<>();
        fridayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_CZECH_REPUBLIC, "10:30 - 11:30"));
        fridayItems.add(new ScheduleItem("Audition", HALL_SLOVENIA, "12:00 - 13:00"));
        fridayItems.add(new ScheduleItem("Max & Audrey", HALL_GREECE, "13:10 - 14:10"));
        fridayItems.add(new ScheduleItem("William & Maeva", HALL_CZECH_REPUBLIC, "14:20 - 15:20"));
        fridayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_CZECH_REPUBLIC, "15:30 - 16:30"));
        fridayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Nastya", HALL_SLOVENIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_BULGARIA, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_CZECH_REPUBLIC, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "18:00 - 19:00"));

        fridayItems.add(new ScheduleItem("Open JnJ Prelims", HALL_BULGARIA, "21:00 - 22:00"));
        fridayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 04:00"));

        ScheduleAdapter fridayAdapter = new ScheduleAdapter(fridayItems);
        scheduleFriday.setAdapter(fridayAdapter);

        List<ScheduleItem> saturdayItems = new ArrayList<>();
        saturdayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_SLOVENIA, "13:20 - 14:20"));
        saturdayItems.add(new ScheduleItem("William & Maeva", HALL_BULGARIA, "14:30 - 15:30"));
        saturdayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_BULGARIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Nastya", HALL_CZECH_REPUBLIC, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_SLOVENIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Advanced JnJ Prelims", HALL_BULGARIA, "21:00 - 21:30"));
        saturdayItems.add(new ScheduleItem("Strictly Lindy Prelims", HALL_BULGARIA, "21:30 - 22:00"));
        saturdayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 4:00"));

        ScheduleAdapter saturdayAdapter = new ScheduleAdapter(saturdayItems);
        scheduleSaturday.setAdapter(saturdayAdapter);

        List<ScheduleItem> sundayItems = new ArrayList<>();
        sundayItems.add(new ScheduleItem("Felipe & Alice", HALL_BULGARIA, "11:00 - 12:00"));
        sundayItems.add(new ScheduleItem("Max", HALL_ROMANIA, "12:00 - 14:10"));
        sundayItems.add(new ScheduleItem("Group Photo", HALL_BULGARIA, "16:30 - 16:50"));
        sundayItems.add(new ScheduleItem("Walking Tour with LIVE music", HALL_BULGARIA, "16:50 - 19:00"));
        sundayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 4:00"));

        ScheduleAdapter sundayAdapter = new ScheduleAdapter(sundayItems);
        scheduleSunday.setAdapter(sundayAdapter);
    }

    private void setupAdvancedPlusSchedule() {
        List<ScheduleItem> thursdayItems = new ArrayList<>();
        thursdayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_BULGARIA, "17:00 - 18:00"));
        thursdayItems.add(new ScheduleItem("History Talk with Ryan", "Peroto", "21:00 - 22:00"));
        thursdayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 04:00"));

        ScheduleAdapter thursdayScheduleAdapter = new ScheduleAdapter(thursdayItems);
        scheduleThursday.setAdapter(thursdayScheduleAdapter);

        List<ScheduleItem> fridayItems = new ArrayList<>();
        fridayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_CZECH_REPUBLIC, "10:30 - 11:30"));
        fridayItems.add(new ScheduleItem("Audition", HALL_SLOVENIA, "12:00 - 13:00"));
        fridayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_BULGARIA, "14:20 - 15:20"));
        fridayItems.add(new ScheduleItem("William & Maeva", HALL_BULGARIA, "15:30 - 16:30"));
        fridayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Nastya", HALL_SLOVENIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_BULGARIA, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_CZECH_REPUBLIC, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "18:00 - 19:00"));

        fridayItems.add(new ScheduleItem("Open JnJ Prelims", HALL_BULGARIA, "21:00 - 22:00"));
        fridayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 04:00"));

        ScheduleAdapter fridayAdapter = new ScheduleAdapter(fridayItems);
        scheduleFriday.setAdapter(fridayAdapter);

        List<ScheduleItem> saturdayItems = new ArrayList<>();
        saturdayItems.add(new ScheduleItem("William & Maeva", HALL_SLOVENIA, "11:00 - 12:00"));
        saturdayItems.add(new ScheduleItem("Max & Audrey", HALL_SLOVENIA, "12:10 - 13:10"));
        saturdayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_SLOVENIA, "13:20 - 14:20"));
        saturdayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_BULGARIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Nastya", HALL_CZECH_REPUBLIC, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_SLOVENIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Advanced JnJ Prelims", HALL_BULGARIA, "21:00 - 21:30"));
        saturdayItems.add(new ScheduleItem("Strictly Lindy Prelims", HALL_BULGARIA, "21:30 - 22:00"));
        saturdayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 4:00"));

        ScheduleAdapter saturdayAdapter = new ScheduleAdapter(saturdayItems);
        scheduleSaturday.setAdapter(saturdayAdapter);

        List<ScheduleItem> sundayItems = new ArrayList<>();
        sundayItems.add(new ScheduleItem("Max", HALL_ROMANIA, "12:00 - 14:10"));
        sundayItems.add(new ScheduleItem("Felipe & Alice", HALL_ROMANIA, "14:20 - 15:20"));
        sundayItems.add(new ScheduleItem("Group Photo", HALL_BULGARIA, "16:30 - 16:50"));
        sundayItems.add(new ScheduleItem("Walking Tour with LIVE music", HALL_BULGARIA, "16:50 - 19:00"));
        sundayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 4:00"));

        ScheduleAdapter sundayAdapter = new ScheduleAdapter(sundayItems);
        scheduleSunday.setAdapter(sundayAdapter);
    }

    private void setupInvitationalSchedule() {
        List<ScheduleItem> thursdayItems = new ArrayList<>();
        thursdayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_BULGARIA, "17:00 - 18:00"));
        thursdayItems.add(new ScheduleItem("History Talk with Ryan", "Peroto", "21:00 - 22:00"));
        thursdayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 04:00"));

        ScheduleAdapter thursdayScheduleAdapter = new ScheduleAdapter(thursdayItems);
        scheduleThursday.setAdapter(thursdayScheduleAdapter);

        List<ScheduleItem> fridayItems = new ArrayList<>();
        fridayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_CZECH_REPUBLIC, "10:30 - 11:30"));
        fridayItems.add(new ScheduleItem("Audition", HALL_SLOVENIA, "12:00 - 13:00"));
        fridayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Nastya", HALL_SLOVENIA, "16:50 - 17:50"));
        fridayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_BULGARIA, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Šárka & Štěpán", HALL_CZECH_REPUBLIC, "18:00 - 19:00"));
        fridayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "18:00 - 19:00"));

        fridayItems.add(new ScheduleItem("Open JnJ Prelims", HALL_BULGARIA, "21:00 - 22:00"));
        fridayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 04:00"));

        ScheduleAdapter fridayAdapter = new ScheduleAdapter(fridayItems);
        scheduleFriday.setAdapter(fridayAdapter);

        List<ScheduleItem> saturdayItems = new ArrayList<>();
        saturdayItems.add(new ScheduleItem("William & Maeva", HALL_CZECH_REPUBLIC, "12:10 - 14:20"));
        saturdayItems.add(new ScheduleItem("Felipe & Alice", HALL_SLOVENIA, "14:30 - 15:30"));
        saturdayItems.add(new ScheduleItem("Taster with Marcell & Dora", HALL_BULGARIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Peter & Elze", HALL_CZECH_REPUBLIC, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Avgoustinos & Vassia", HALL_SLOVENIA, "16:00 - 17:00"));
        saturdayItems.add(new ScheduleItem("Taster with Hakan & Nazlı", HALL_BULGARIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Nastya", HALL_CZECH_REPUBLIC, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Taster with Pavlina & Simon", HALL_SLOVENIA, "17:10 - 18:10"));
        saturdayItems.add(new ScheduleItem("Advanced JnJ Prelims", HALL_BULGARIA, "21:00 - 21:30"));
        saturdayItems.add(new ScheduleItem("Strictly Lindy Prelims", HALL_BULGARIA, "21:30 - 22:00"));
        saturdayItems.add(new ScheduleItem("Party", HALL_SLOVENIA, "21:00 - 4:00"));

        ScheduleAdapter saturdayAdapter = new ScheduleAdapter(saturdayItems);
        scheduleSaturday.setAdapter(saturdayAdapter);

        List<ScheduleItem> sundayItems = new ArrayList<>();
        sundayItems.add(new ScheduleItem("Ryan & Evgenia", HALL_CZECH_REPUBLIC, "12:00 - 13:00"));
        sundayItems.add(new ScheduleItem("Felipe & Alice", HALL_CZECH_REPUBLIC, "13:10 - 14:10"));
        sundayItems.add(new ScheduleItem("Max & Audrey", HALL_CZECH_REPUBLIC, "14:20 - 15:20"));
        sundayItems.add(new ScheduleItem("Group Photo", HALL_BULGARIA, "16:30 - 16:50"));
        sundayItems.add(new ScheduleItem("Walking Tour with LIVE music", HALL_BULGARIA, "16:50 - 19:00"));
        sundayItems.add(new ScheduleItem("Party", HALL_BULGARIA, "21:00 - 4:00"));

        ScheduleAdapter sundayAdapter = new ScheduleAdapter(sundayItems);
        scheduleSunday.setAdapter(sundayAdapter);
    }
}
