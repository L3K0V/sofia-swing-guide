package bg.lindyhop.sofiaswingfest.adapters;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.sofiaswingfest.FeedItemActivity;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.databinding.FeedListItemBinding;
import bg.lindyhop.sofiaswingfest.fragments.ImageLoaderCallbacks;

/**
 * Created by lekov on 12/23/15.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private List<FeedItem> mDataset;
    private final Activity mActivity;

    public FeedAdapter(Activity activity, List<FeedItem> list) {
        mDataset = list;
        mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_list_item, parent, false);
        return new ViewHolder(mActivity, v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.getBinding().setItem(mDataset.get(position));
        holder.getBinding().setCallback(new ImageLoaderCallbacks() {
            @Override
            public void onImageLoading() {

            }

            @Override
            public void onImageReady() {
                Bitmap bitmap;
                if (holder.binding.cover.getDrawable() instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) holder.binding.cover.getDrawable()).getBitmap();
                } else {
                    Drawable d = holder.binding.cover.getDrawable();
                    bitmap = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmap);
                    d.draw(canvas);
                }


                // Asynchronous
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette p) {
                        Palette.Swatch swatch = p.getVibrantSwatch();

                        if (swatch == null) {
                            swatch = p.getMutedSwatch();
                        }

                        if (swatch != null) {
                            holder.binding.card.setCardBackgroundColor(swatch.getRgb());
                            holder.binding.title.setTextColor(swatch.getTitleTextColor());
                            holder.binding.text.setTextColor(swatch.getBodyTextColor());
                        }
                    }
                });
            }

            @Override
            public void onImageLoadError() {

            }
        });
        holder.getBinding().executePendingBindings();


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private FeedListItemBinding binding;
        private final Activity activity;

        public ViewHolder(Activity activity, View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.card.setOnClickListener(this);
            this.activity = activity;
        }

        public FeedListItemBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), FeedItemActivity.class);
            intent.putExtra(FeedItemActivity.EXTRA_FEED_ITEM, binding.getItem());

            Pair<View, String> cover = Pair.create(binding.getRoot().findViewById(R.id.cover), "cover");
            Pair<View, String> title = Pair.create(binding.getRoot().findViewById(R.id.title), "title");

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(activity, cover, title);
            ActivityCompat.startActivity(activity, intent, options.toBundle());
        }
    }

    public void swapDataSet(List<FeedItem> dataSet) {
        mDataset = dataSet;

        notifyDataSetChanged();
    }

    public void add(FeedItem item) {
        mDataset.add(item);
        notifyDataSetChanged();
    }

    public void add(List<FeedItem> items) {

        if (items == null || items.size() <= 0) {
            return;
        }

        final int firstNewIndex = mDataset.size();

        mDataset.addAll(items);
        notifyItemRangeInserted(firstNewIndex, items.size());
    }
}
