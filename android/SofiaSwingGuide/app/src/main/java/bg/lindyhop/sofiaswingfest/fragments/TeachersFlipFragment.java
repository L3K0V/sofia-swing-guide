package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bartoszlipinski.flippablestackview.FlippableStackView;

import java.util.ArrayList;
import java.util.List;

import bg.lindyhop.entities.Teacher;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.adapters.TeachersPageAdapter;

/**
 * Created by mmironov on 1/13/16.
 */
public class TeachersFlipFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_flip_teachers, container, false);

        FlippableStackView stack = (FlippableStackView) view.findViewById(R.id.stack);
        stack.initStack(2);

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

        stack.setAdapter(new TeachersPageAdapter(teachers, getFragmentManager()));

        return view;
    }
}
