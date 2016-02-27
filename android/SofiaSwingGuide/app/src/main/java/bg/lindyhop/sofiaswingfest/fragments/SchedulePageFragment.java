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

import bg.lindyhop.entities.Teacher;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.adapters.TeachersAdapter;

/**
 * Created by mmironov on 1/21/16.
 */
public class SchedulePageFragment extends Fragment {

    public static final String PAGE_TITLE = "pageTitle";

    private RecyclerView schedule;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_page, container, false);

        schedule = (RecyclerView) view.findViewById(R.id.schedule);

        schedule.setLayoutManager(new LinearLayoutManager(getActivity()));
        schedule.setAdapter(new TeachersAdapter(new ArrayList<Teacher>()));

        return view;
    }
}
