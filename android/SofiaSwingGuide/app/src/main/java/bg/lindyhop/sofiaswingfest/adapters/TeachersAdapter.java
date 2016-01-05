package bg.lindyhop.sofiaswingfest.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bg.lindyhop.entities.Teacher;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.databinding.TeachersItemBinding;

/**
 * Created by mmironov on 1/4/16.
 */
public class TeachersAdapter extends RecyclerView.Adapter<TeachersAdapter.ViewHolder> {

    private List<Teacher> teachers;

    public TeachersAdapter(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public TeachersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.teachers_item, parent, false);

        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(TeachersAdapter.ViewHolder holder, int position) {
        holder.getBinding().setItem(teachers.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TeachersItemBinding binding;

        public ViewHolder(View viewItem) {
            super(viewItem);

            binding = DataBindingUtil.bind(viewItem);
        }

        public TeachersItemBinding getBinding() {
            return binding;
        }
    }
}
