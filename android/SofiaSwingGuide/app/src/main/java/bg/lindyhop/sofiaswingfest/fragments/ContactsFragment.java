package bg.lindyhop.sofiaswingfest.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bg.lindyhop.sofiaswingfest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment implements ContactClickCallbacks {

    public static final String TAG = "ContactsFragment";

    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final AppBarLayout collapsing = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
        collapsing.setExpanded(false);
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void handleFacebookPage(View v) {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL(getActivity(), v.getId() == R.id.facebook_lindyhop ? R.string.contacts_lindyhop_facebook : R.string.contacts_ssdf_facebook);
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);
    }

    @Override
    public void handleWebPage(View v) {
        Intent web = new Intent(Intent.ACTION_VIEW);
        web.setData(Uri.parse(getContext().getString(v.getId() == R.id.web_lindyhop ? R.string.contacts_lindyhop_web : R.string.contacts_ssdf_web)));
        startActivity(Intent.createChooser(web, "Open web page..."));
    }

    @Override
    public void handleEmail(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.contacts_lindyhop_email)}); // recipients
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    @Override
    public void handlePhone(View v) {
        Uri number = Uri.parse("tel:+33678834569");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(Intent.createChooser(callIntent, "Call..."));
    }

    //method to get the right URL to use in the intent
    private String getFacebookPageURL(Context context, int facebookPageRes) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + context.getString(facebookPageRes);
            } else { //older versions of fb app
                return "fb://page/" + facebookPageRes;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return context.getString(facebookPageRes); //normal web url
        }
    }

}
