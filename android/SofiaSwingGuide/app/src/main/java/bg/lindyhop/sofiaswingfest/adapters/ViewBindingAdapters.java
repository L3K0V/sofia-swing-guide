package bg.lindyhop.sofiaswingfest.adapters;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

import bg.lindyhop.sofiaswingfest.fragments.ImageLoaderCallbacks;

/**
 * Created by lekov on 12/30/15.
 */
public class ViewBindingAdapters {

    @BindingAdapter({"coverUrl", "callback"})
    public static void setImageUrl(ImageView view, String url, final ImageLoaderCallbacks callback) {

        final Context context = view.getContext();
        Glide.with(context).load(url).crossFade().listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                callback.onImageLoadError();
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(new GlideDrawableImageViewTarget(view) {
            @Override
            protected void setResource(GlideDrawable resource) {
                super.setResource(resource);
                callback.onImageReady();
            }
        });
    }

    @BindingAdapter("photo")
    public static void setImageDrawable(final ImageView view, final int resId) {

        final Context context = view.getContext();

        Glide.with(context)
                .load(resId)
                .centerCrop()
                .crossFade()
                .into(view);

    }
}
