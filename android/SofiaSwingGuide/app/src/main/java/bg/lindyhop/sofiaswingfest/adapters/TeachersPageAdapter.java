package bg.lindyhop.sofiaswingfest.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import bg.lindyhop.entities.Teacher;
import bg.lindyhop.sofiaswingfest.fragments.TeachersFragment;

/**
 * Created by mmironov on 1/13/16.
 */
public class TeachersPageAdapter extends FragmentPagerAdapter {

    private List<Teacher> teacherList;

    public TeachersPageAdapter(List<Teacher> teachers, FragmentManager fm) {
        super(fm);
        teacherList = teachers;
    }

    @Override
    public Fragment getItem(int position) {
        return new TeachersFragment();
    }

    @Override
    public int getCount() {
        return teacherList.size();
    }
}
