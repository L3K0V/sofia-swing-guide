package bg.lindyhop.sofiaswingfest.adapters;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
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
    public static void setImageDrawable(ImageView view, int resId) {

        Drawable drawable = ContextCompat.getDrawable(view.getContext(), resId);
        view.setImageDrawable(drawable);
    }
}
