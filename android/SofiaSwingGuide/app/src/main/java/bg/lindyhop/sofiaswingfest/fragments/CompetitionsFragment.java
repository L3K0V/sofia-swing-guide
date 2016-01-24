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

    private RecyclerView competitionsView;
    private CompetitionsAdapter adapter;

    public CompetitionsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view =  inflater.inflate(R.layout.fragment_competitions, container, false);

        competitionsView = (RecyclerView) view.findViewById(R.id.competitions);

        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            competitionsView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }
        else {
            competitionsView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        List<Competition> competitions = new ArrayList<>();

        Competition openJnJ = new Competition();
        openJnJ.setName(getResources().getString(R.string.open_jnj));
        openJnJ.setDescription(getResources().getString(R.string.open_jnj_description));
        openJnJ.setResDrawable(R.drawable.marcos);

        Competition advancedJnJ = new Competition();
        advancedJnJ.setName(getResources().getString(R.string.advanced_jnj));
        advancedJnJ.setDescription(getResources().getString(R.string.advanced_jnj_description));
        advancedJnJ.setResDrawable(R.drawable.petr_pavli);

        Competition swingOutDropOut = new Competition();
        swingOutDropOut.setName(getResources().getString(R.string.swing_out_drop_out));
        swingOutDropOut.setDescription(getResources().getString(R.string.swing_out_drop_out_description));
        swingOutDropOut.setResDrawable(R.drawable.marcos);

        Competition oscarsShowDown = new Competition();
        oscarsShowDown.setName(getResources().getString(R.string.oscars_show_down));
        oscarsShowDown.setDescription(getResources().getString(R.string.oscars_showdown_description));
        oscarsShowDown.setResDrawable(R.drawable.petr_pavli);

        competitions.add(openJnJ);
        competitions.add(advancedJnJ);
        competitions.add(swingOutDropOut);
        competitions.add(oscarsShowDown);

        adapter = new CompetitionsAdapter(competitions);

        competitionsView.setAdapter(adapter);

        return view;
    }
}
