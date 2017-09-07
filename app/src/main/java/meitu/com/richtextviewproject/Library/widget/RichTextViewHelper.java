package meitu.com.richtextviewproject.Library.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.HashMap;
import java.util.Map;
import meitu.com.mylibrary.simplifyspan.SimplifySpanBuild;
import meitu.com.richtextviewproject.Library.process.ContentTextUtil;
import meitu.com.richtextviewproject.R;

/**
 * Created by meitu on 2017/9/6.
 */

public class RichTextViewHelper{


    public static void setRichText(final TextView textView, final RichTextBean richTextBean) {
        final long startTime = System.currentTimeMillis();
        SimplifySpanBuild spanBuild = ContentTextUtil.getContent(richTextBean.getTextcontent(),richTextBean.getUrlHashMap(), textView.getContext(), textView);
        textView.setText(spanBuild.build());
        Log.e("耗时","耗时=="+(System.currentTimeMillis()-startTime));
        BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        decodingOptions.outHeight=50;
        decodingOptions.outWidth=50;
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.timeline_card_small_web)  // empty URI时显示的图片
                .showImageOnFail(R.drawable.timeline_card_small_web)       // 不是图片文件 显示图片
                .resetViewBeforeLoading(false)  // default
                .cacheInMemory(true)           // default 不缓存至内存
                .cacheOnDisk(true) // default 不缓存至手机SDCard
                .decodingOptions(decodingOptions)//设置图片的解码配置
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .bitmapConfig(Bitmap.Config.ARGB_4444)              // default
                .build();
        final long startTimeAsync = System.currentTimeMillis();
        for (Object o : richTextBean.getUrlHashMap().entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            final String key = (String) entry.getKey();
            ImageLoader.getInstance().loadImage(richTextBean.getUrlHashMap().get(key).getIconURL(), options, new SimpleImageLoadingListener() {
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    super.onLoadingComplete(imageUri, view, loadedImage);
                    richTextBean.getUrlHashMap().get(key).setIcon(loadedImage);
                    if (checkLoadAll(richTextBean.getUrlHashMap())) {
                        Log.e("耗时","异步加载图片耗时=="+(System.currentTimeMillis()-startTimeAsync));
                        long startTime = System.currentTimeMillis();
                        SimplifySpanBuild spanBuild = ContentTextUtil.getContent(richTextBean.getTextcontent(), richTextBean.getUrlHashMap(), textView.getContext(), textView);
                        textView.setText(spanBuild.build());
                        Log.e("耗时","耗时=="+(System.currentTimeMillis()-startTime));
                    }
                }
            });
        }
    }
    private static boolean checkLoadAll(HashMap<String,SpecialUrlBean> map){
        boolean loadAll=true;
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            final String key = (String) entry.getKey();
            boolean result = map.get(key).getIcon() != null;
            loadAll = loadAll && result;
        }
        return loadAll;
    }
}
