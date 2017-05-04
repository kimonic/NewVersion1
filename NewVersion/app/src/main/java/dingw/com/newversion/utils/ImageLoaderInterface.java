package dingw.com.newversion.utils;

import android.content.Context;
import android.view.View;

import java.io.Serializable;


/**
 * Created by 12348 on 2017/3/28 0028.
 */

public interface ImageLoaderInterface<T extends View> extends Serializable {
    void displayImage(Context context, Object path, T imageView);

    void displayCircleImage(Context context, Object path, T imageView);

    T creteImageView(Context context);
}
