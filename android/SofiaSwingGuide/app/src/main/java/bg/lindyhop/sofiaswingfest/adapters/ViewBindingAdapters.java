package bg.lindyhop.sofiaswingfest.adapters;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import bg.lindyhop.sofiaswingfest.fragments.ImageLoaderCallbacks;

/**
 * Created by lekov on 12/30/15.
 */
public class ViewBindingAdapters {

    @BindingAdapter({"coverUrl", "callback"})
    public static void setImageUrl(ImageView view, String url, final ImageLoaderCallbacks callback) {
        Picasso.with(view.getContext()).load(url).into(view, new Callback() {
            @Override
            public void onSuccess() {
                callback.onImageReady();
            }

            @Override
            public void onError() {
                callback.onImageLoadError();
            }
        });
    }

    @BindingAdapter("photo")
    public static void setImageDrawable(final ImageView view, final int resId) {

        final Context context = view.getContext();

        Picasso.with(context)
                .load(resId)
                .into(view);
    }
}
