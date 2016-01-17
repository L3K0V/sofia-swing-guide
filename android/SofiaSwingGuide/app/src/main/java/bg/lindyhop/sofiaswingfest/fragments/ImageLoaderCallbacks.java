package bg.lindyhop.sofiaswingfest.fragments;

/**
 * Created by lekov on 1/17/16.
 */
public interface ImageLoaderCallbacks {
    // called initially
    void onImageLoading();

    // called when image has successfully loaded
    void onImageReady();

    // called when image loading fails
    void onImageLoadError();
}
