package bg.lindyhop.sofiaswingfest.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bg.lindyhop.entities.ScheduleItem;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.databinding.ScheduleItemBinding;

/**
 * Created by mmironov on 5/23/16.
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private List<ScheduleItem> schedule;

    public ScheduleAdapter(List<ScheduleItem> schedule) {
        this.schedule = schedule;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);

        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setItem(schedule.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ScheduleItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }

        public ScheduleItemBinding getBinding() {
            return binding;
        }
    }
}
