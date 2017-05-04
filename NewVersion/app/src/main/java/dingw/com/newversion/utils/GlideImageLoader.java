package dingw.com.newversion.utils;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by 12348 on 2017/3/28 0028.
 */

public class GlideImageLoader extends BaseImageLoader{
    private static GlideImageLoader instance;

    /**
     * 获得单例
     * @return
     */
    public static GlideImageLoader getInstance() {
        if (instance == null) {
            instance = new GlideImageLoader();
        }
        return instance;
    }

    /**
     * 加载图片
     * @param context
     * @param path 路径URL等
     * @param imageView
     */
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .crossFade()
                .into(imageView);
    }

    /**
     * 显示圆形图片
     * @param context
     * @param path  路径url等
     * @param imageView
     */
    @Override
    public void displayCircleImage(Context context, Object path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .crossFade()
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imageView);
    }
}
