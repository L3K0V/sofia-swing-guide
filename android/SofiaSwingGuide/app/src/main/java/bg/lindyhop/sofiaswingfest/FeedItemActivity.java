package bg.lindyhop.sofiaswingfest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.sofiaswingfest.databinding.ActivityFeedItemBinding;


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

        ActivityFeedItemBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_item);
        binding.setItem(item);

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
