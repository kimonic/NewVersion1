package dingw.com.newversion.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import java.io.ByteArrayOutputStream;

/**
 * Created by 12348 on 2017/4/21 0021.
 * 图片压缩工具类
 */

public class ReduceBitmapUtil {
    private Bitmap bitmap;
    private String TAG = "ReduceBitmapUtil";

    public ReduceBitmapUtil(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void getBitmapSize() {
//        Log.e(TAG, "getBitmapSize: ---" + (bitmap.getByteCount() / 1024) +
//                "kb,宽度为:" + bitmap.getWidth() + ",高度为:" + bitmap.getHeight());
    }

    public Bitmap qualityReduce(int quality) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        byte[] bytes = baos.toByteArray();
        bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//        Log.e(TAG, "qualityReduce: ----" + "压缩后图片的大小:" + (bitmap.getByteCount() / 1024)
//                + "kb,宽度为:" + bitmap.getWidth() + ",高度为:" + bitmap.getHeight()
//                + ",bytes.length=  " + (bytes.length / 1024) + "KB"
//                + ",quality=" + quality);
        return bitmap;
    }

    public Bitmap samplingReduce(int ratio) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = ratio;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bytes = baos.toByteArray();
        bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
//        Log.e(TAG, "samplingReduce: ----" + "压缩后图片的大小:" + (bitmap.getByteCount() / 1024)
//                + "kb,宽度为:" + bitmap.getWidth() + ",高度为:" + bitmap.getHeight());
        return bitmap;
    }

    public Bitmap scaleReduce(float scalWidth,float scalHeight) {
        Matrix matrix = new Matrix();
        matrix.setScale(scalWidth, scalHeight);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
//        Log.e(TAG, "scaleReduce: " + "压缩后图片的大小:" + (bitmap.getByteCount() / 1024)
//                + "kb,宽度为:" + bitmap.getWidth() + ",高度为:" + bitmap.getHeight());
        return bitmap;
    }

    public Bitmap fsfRGBReduce() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bytes = baos.toByteArray();
        bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
//        Log.e(TAG, "fsfRGBReduce: " + "压缩后图片的大小:" + (bitmap.getByteCount() / 1024)
//                + "kb,宽度为:" + bitmap.getWidth() + ",高度为:" + bitmap.getHeight());
        return bitmap;
    }

    public Bitmap createReduce(int width,int height) {
        bitmap = bitmap.createScaledBitmap(bitmap, width, height, true);
//        Log.e(TAG, "createReduce: " + "压缩后图片的大小:" + (bitmap.getByteCount() / 1024) + "KB,宽度为:"
//                + bitmap.getWidth() + ",高度为:" + bitmap.getHeight());
        return bitmap;
    }


}
