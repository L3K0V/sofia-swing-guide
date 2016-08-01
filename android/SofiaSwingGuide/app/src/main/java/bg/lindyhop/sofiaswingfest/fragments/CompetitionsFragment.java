package bg.lindyhop.sofiaswingfest.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bg.lindyhop.entities.Competition;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.adapters.CompetitionsAdapter;

/**
 * Created by mmironov on 1/4/16.
 */
public class CompetitionsFragment extends Fragment {

    public static final String TAG = "CompetitionsFragment";

    public CompetitionsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view =  inflater.inflate(R.layout.fragment_competitions, container, false);

        RecyclerView competitionsView = (RecyclerView) view.findViewById(R.id.competitions);

        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            competitionsView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }
        else {
            competitionsView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        List<Competition> competitions = new ArrayList<>();

        Competition solojazz = new Competition();
        solojazz.setName("Solo Jazz Competition");
        solojazz.setDescription("Open to dancers of all levels.\n" +
                "Dancers are required to dance on various music that will be suitable for Solo Jazz such\n" +
                "as Charleston, Blues , Shim Sham etc etc\n" +
                "Prelims : All Skate\n" +
                "Final : Crowd Judged");

        Competition openJnJ = new Competition();
        openJnJ.setName("Open J`NJ Competition");
        openJnJ.setDescription("Swing Dancing with a random partner.\n" +
                "Registrations will be on the spot.\n" +
                "All Levels");


        competitions.add(openJnJ);
        competitions.add(solojazz);

        CompetitionsAdapter adapter = new CompetitionsAdapter(competitions);

        competitionsView.setAdapter(adapter);

        return view;
    }
}
