package bg.lindyhop.sofiaswingfest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import bg.lindyhop.entities.Teacher;
import bg.lindyhop.sofiaswingfest.databinding.ActivityTeachersItemBinding;

/**
 * Created by mmironov on 1/16/16.
 */
public class TeachersItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_teachers_item);

        Intent intent = getIntent();

        if (intent != null) {
            Teacher teacher = intent.getParcelableExtra(Teacher.KEY_EXTRA);
            ActivityTeachersItemBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_teachers_item);
            binding.setItem(teacher);
        }
    }
}
