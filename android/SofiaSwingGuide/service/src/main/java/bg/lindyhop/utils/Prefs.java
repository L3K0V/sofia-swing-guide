package bg.lindyhop.utils;

import android.content.Context;
import android.content.SharedPreferences;

import bg.lindyhop.App;
import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.entities.FeedItemsPage;

/**
 * Created by mmironov on 1/4/16.
 */
public class Prefs {

    private static final String PREFS_NAME = "SofiaSwingFestPrefs";

    private static final String KEY_PAGE = "page";

    private static SharedPreferences get() {
        return App.getInstance().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static int getNextPage() {

        return get().getInt(KEY_PAGE, FeedItemsPage.FIRST_PAGE_INDEX);
    }

    public static void putNextPage(int page) {
        SharedPreferences.Editor editor = get().edit();

        editor.putInt(KEY_PAGE, page);

        editor.commit();
    }

    public static void removeNextPage() {
        SharedPreferences.Editor editor = get().edit();

        editor.remove(KEY_PAGE);

        editor.commit();
    }

    public static boolean hasNextPage() {
        return get().contains(KEY_PAGE);
    }
}
