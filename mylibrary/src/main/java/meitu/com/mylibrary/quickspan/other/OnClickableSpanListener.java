package meitu.com.mylibrary.quickspan.other;

import android.widget.TextView;

/**
 * ClickableSpan Listener
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:OnClickableSpanListener 点击监听器
 * Paramas
 */
public interface OnClickableSpanListener {
    /**
     * @param tv 当前的 textView
     * @param clickText 被点击的文字 text（有可能是被替换的图标）
     */
    void onClick(TextView tv, String clickText);

}
