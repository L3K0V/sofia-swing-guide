package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

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
        williamAndMaeva.setResDrawable(R.drawable.william_maeva);

        Teacher petrAndPavli = new Teacher();
        petrAndPavli.setName("Petr & Pavli");
        petrAndPavli.setDescription("With style and rhythm");
        petrAndPavli.setResDrawable(R.drawable.petr_pavli);

        Teacher daxAndSarah = new Teacher();
        daxAndSarah.setName("Dax & Sarah");
        daxAndSarah.setDescription("Perfect teaching.");
        daxAndSarah.setResDrawable(R.drawable.dax_sarah);

        Teacher marcos = new Teacher();
        marcos.setName("Marcos");
        marcos.setDescription("Inspiration");
        marcos.setResDrawable(R.drawable.marcos);

        teachers.add(williamAndMaeva);
        teachers.add(petrAndPavli);
        teachers.add(daxAndSarah);
        teachers.add(marcos);

        Collections.shuffle(teachers);

        teachers.get(0).setIsFeatured(true);

        adapter = new TeachersAdapter(teachers);

        teachersView.setAdapter(adapter);

        return view;
    }
}
