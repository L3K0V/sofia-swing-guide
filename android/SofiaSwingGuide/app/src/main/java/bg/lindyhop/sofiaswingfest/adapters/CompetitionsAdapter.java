package bg.lindyhop.sofiaswingfest.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import java.util.List;

import bg.lindyhop.entities.Competition;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.databinding.CompetitionsItemBinding;
import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by mmironov on 1/17/16.
 */
public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {

    private List<Competition> competitions;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.competitions_item, parent, false);

        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setItem(competitions.get(position));
        holder.getBinding().executePendingBindings();
    }

    public CompetitionsAdapter(List<Competition> competitions) {
        this.competitions = competitions;
    }

    @Override
    public int getItemCount() {
        return competitions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CompetitionsItemBinding binding;

        public ViewHolder(View viewItem) {
            super(viewItem);

            binding = DataBindingUtil.bind(viewItem);

            binding.infoButton.setOnClickListener(this);
        }

        public CompetitionsItemBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {

            // get the center for the clipping circle
            int cx = (v.getLeft() + v.getRight()) / 2;
            int cy = (v.getTop() + v.getBottom()) / 2;

            // get the final radius for the clipping circle
            int dx = Math.max(cx, v.getWidth() - cx);
            int dy = Math.max(cy, v.getHeight() - cy);
            float finalRadius = (float) Math.hypot(dx, dy);
            float startRadius = 0;

            if (getBinding().name.getVisibility() == View.INVISIBLE) {
                float temp = finalRadius;
                finalRadius = startRadius;
                startRadius = temp;
            }

            SupportAnimator animator =
                    ViewAnimationUtils.createCircularReveal(getBinding().card, cx, cy, startRadius, finalRadius);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(500);

            animator.addListener(new SupportAnimator.AnimatorListener() {
                @Override
                public void onAnimationStart() {

                    int nameVisibility = getBinding().name.getVisibility();
                    int descriptionVisibility = getBinding().description.getVisibility();

                    //swap the visibilities
                    getBinding().name.setVisibility(descriptionVisibility);
                    getBinding().anotherName.setVisibility(nameVisibility);
//                    getBinding().infoButton.setVisibility(descriptionVisibility);

                    getBinding().description.setVisibility(nameVisibility);
                }

                @Override
                public void onAnimationEnd() {

                }

                @Override
                public void onAnimationCancel() {

                }

                @Override
                public void onAnimationRepeat() {

                }
            });

            animator.start();
        }
    }
}
