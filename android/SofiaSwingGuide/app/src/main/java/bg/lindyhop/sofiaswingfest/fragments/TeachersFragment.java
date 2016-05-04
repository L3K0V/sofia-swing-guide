package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.lindyhop.entities.Teacher;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.adapters.TeachersAdapter;

/**
 * Created by mmironov on 1/4/16.
 */
public class TeachersFragment extends Fragment {

    public static final String TAG = "TeachersFragment";

    private RecyclerView teachersView;
    private TeachersAdapter adapter;

    private GridLayoutManager layoutManager;

    public TeachersFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view =  inflater.inflate(R.layout.fragment_teachers, container, false);

        teachersView = (RecyclerView) view.findViewById(R.id.teachers);

        layoutManager = new GridLayoutManager(getActivity(), 2);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                if (position == 0) {
                    return 2;
                }

                return 1;
            }
        });

        teachersView.setLayoutManager(layoutManager);

        List<Teacher> teachers = new ArrayList<>();

        Teacher williamAndMaeva = new Teacher();
        williamAndMaeva.setName("William and Maeva");
        williamAndMaeva.setDescription("The great Frenchies...");
        williamAndMaeva.setResDrawable(R.drawable.felipe);

        Teacher alice = new Teacher();
        alice.setName("Alice Mei");
        alice.setDescription("With style and rhythm");
        alice.setResDrawable(R.drawable.felipe);

        Teacher felipe = new Teacher();
        felipe.setName("Felipe");
        felipe.setDescription("Perfect teaching.");
        felipe.setResDrawable(R.drawable.felipe);

        Teacher ryan = new Teacher();
        ryan.setName("Ryan");
        ryan.setDescription("Inspiration");
        ryan.setResDrawable(R.drawable.felipe);

        Teacher evgenya = new Teacher();
        evgenya.setName("Evgeniya");
        evgenya.setDescription("Inspiration");
        evgenya.setResDrawable(R.drawable.felipe);

        teachers.add(williamAndMaeva);
        teachers.add(alice);
        teachers.add(felipe);
        teachers.add(ryan);
        teachers.add(evgenya);

        Collections.shuffle(teachers);

        teachers.get(0).setIsFeatured(true);

        adapter = new TeachersAdapter(teachers);

        teachersView.setAdapter(adapter);

        return view;
    }
}
