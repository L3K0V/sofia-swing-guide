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
        williamAndMaeva.setDescription(getResources().getString(R.string.william_and_maeva_description));
        williamAndMaeva.setResDrawable(R.drawable.william_maeva);

        Teacher alice = new Teacher();
        alice.setName("Alice Meï");
        alice.setDescription(getResources().getString(R.string.alice_description));
        alice.setResDrawable(R.drawable.alice);

        Teacher felipe = new Teacher();
        felipe.setName("Felipe Braga");
        felipe.setDescription(getResources().getString(R.string.felipe_description));
        felipe.setResDrawable(R.drawable.felipe);

        Teacher ryan = new Teacher();
        ryan.setName("Ryan Francois");
        ryan.setDescription(getResources().getString(R.string.ryan_description));
        ryan.setResDrawable(R.drawable.ryan);

        Teacher evgenya = new Teacher();
        evgenya.setName("Evgenia Salakhutdinova");
        evgenya.setDescription(getResources().getString(R.string.evgenia_description));
        evgenya.setResDrawable(R.drawable.evgenia);

        Teacher max = new Teacher();
        max.setName("Max Pitruzzella");
        max.setDescription(getResources().getString(R.string.max_description));
        max.setResDrawable(R.drawable.max);

        Teacher audrey = new Teacher();
        audrey.setName("Audrey da Sois");
        audrey.setDescription(getResources().getString(R.string.audrey_description));
        audrey.setResDrawable(R.drawable.audrey);

        teachers.add(williamAndMaeva);
        teachers.add(alice);
        teachers.add(felipe);
        teachers.add(ryan);
        teachers.add(evgenya);
        teachers.add(max);
        teachers.add(audrey);

        Collections.shuffle(teachers);

        teachers.get(0).setIsFeatured(true);

        adapter = new TeachersAdapter(teachers);

        teachersView.setAdapter(adapter);

        return view;
    }
}
