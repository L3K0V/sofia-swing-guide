package bg.lindyhop.sofiaswingfest;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.sofiaswingfest.databinding.ActivityFeedItemBinding;
import bg.lindyhop.sofiaswingfest.fragments.ImageLoaderCallbacks;


public class FeedItemActivity extends AppCompatActivity {

    public static final String EXTRA_FEED_ITEM = "bg.lindyhop.sofiaswingfest.extra.feedItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_item);

        if (getIntent() == null) {
            finish();
        }

        FeedItem item = getIntent().getParcelableExtra(EXTRA_FEED_ITEM);

        if (item == null) {
            finish();
        }

        final ActivityFeedItemBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_item);
        binding.setItem(item);
        binding.setCallback(new ImageLoaderCallbacks() {
            @Override
            public void onImageLoading() {

            }

            @Override
            public void onImageReady() {
                Bitmap bitmap;
                if (binding.cover.getDrawable() instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) binding.cover.getDrawable()).getBitmap();
                } else {
                    Drawable d = binding.cover.getDrawable();
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
                            binding.toolbarLayout.setContentScrimColor(p.getVibrantColor(ActivityCompat.getColor(FeedItemActivity.this, R.color.primary)));
                            binding.toolbarLayout.setStatusBarScrimColor(p.getDarkVibrantColor(ActivityCompat.getColor(FeedItemActivity.this, R.color.primary_dark)));
                        }
                    }
                });
            }

            @Override
            public void onImageLoadError() {

            }
        });

        CollapsingToolbarLayout collapsing = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsing.setExpandedTitleTextAppearance(R.style.transperant);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(item.getTitle());
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
