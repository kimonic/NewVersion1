package dingw.com.newversion.utils;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by 12348 on 2017/3/28 0028.
 */

public abstract class BaseImageLoader implements ImageLoaderInterface<ImageView>{
    @Override
    public ImageView creteImageView(Context context) {
        ImageView imageView = new ImageView(context);
        return imageView;
    }
}
