package bg.lindyhop.sofiaswingfest;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by lekov on 12/30/15.
 */
public class ViewBindingAdapters {

    @BindingAdapter("coverUrl")
    public static void setImageUrl(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).placeholder(android.R.color.holo_blue_light).into(view);
    }

    @BindingAdapter("photo")
    public static void setImageDrawable(ImageView view, int resId) {

        Drawable drawable = ContextCompat.getDrawable(view.getContext(), resId);

        view.setImageDrawable(drawable);
    }
}
