package meitu.com.richtextviewproject.Library.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 *  屏幕密度工具类
 * @see #dip2px(int)  dp 转sp
 */
class DeviceUtils {
    static int dip2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }
}