package bg.lindyhop.sofiaswingfest;

import android.databinding.BindingAdapter;
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
}
