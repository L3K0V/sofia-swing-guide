package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
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

    private StaggeredGridLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view =  inflater.inflate(R.layout.fragment_teachers, container, false);

        teachersView = (RecyclerView) view.findViewById(R.id.teachers);

        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        teachersView.setLayoutManager(layoutManager);

        List<Teacher> teachers = new ArrayList<>();

        Teacher williamAndMaeva = new Teacher();
        williamAndMaeva.setName("William and Maeva");
        williamAndMaeva.setResDrawable(R.drawable.william_maeva);

        Teacher petrAndPavli = new Teacher();
        petrAndPavli.setName("Petr & Pavli");
        petrAndPavli.setResDrawable(R.drawable.petr_pavli);

        Teacher daxAndSarah = new Teacher();
        daxAndSarah.setName("Dax & Sarah");
        daxAndSarah.setResDrawable(R.drawable.dax_sarah);

        Teacher marcos = new Teacher();
        marcos.setName("Marcos");
        marcos.setResDrawable(R.drawable.marcos);

        teachers.add(williamAndMaeva);
        teachers.add(petrAndPavli);
        teachers.add(daxAndSarah);
        teachers.add(marcos);

        adapter = new TeachersAdapter(teachers);

        teachersView.setAdapter(adapter);

        return view;
    }
}
