package com.pms.kirillbaranov.premierleague.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.pms.kirillbaranov.premierleague.R;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class ImageLoaderManager {

    private static ImageLoaderManager sInstance;
    private ImageLoader mImageLoader = ImageLoader.getInstance();
    private DisplayImageOptions mImageLoaderOptions;

    private ImageLoaderManager(Context context) {
        init(context);
    }

    private void init(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        // Initialize ImageLoader with configuration.
        mImageLoader.init(config);

        mImageLoaderOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.transparent_logo)
                .showImageForEmptyUri(R.drawable.transparent_logo)
                .showImageOnFail(R.drawable.transparent_logo)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new SimpleBitmapDisplayer())//magic don't touch it (This needed to scale ImageView properly)!!!
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    public static ImageLoaderManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ImageLoaderManager(context);
        }
        return sInstance;
    }

    public void displayImage(String fileUrl, ImageView view) {
        mImageLoader.displayImage(fileUrl, view, mImageLoaderOptions);
    }
}

