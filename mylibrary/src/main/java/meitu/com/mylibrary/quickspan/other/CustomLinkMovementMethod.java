package meitu.com.mylibrary.quickspan.other;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

import  meitu.com.mylibrary.quickspan.customspan.CustomClickableSpan;

/**
 * Custom LinkMovementMethod
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des: 自定义的 LinkMovementMethod
 * Paramas
 */
public class CustomLinkMovementMethod extends LinkMovementMethod {
    private static CustomLinkMovementMethod sInstance;
    private CustomClickableSpan mCustomClickableSpan;

    public static CustomLinkMovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new CustomLinkMovementMethod();

        return sInstance;
    }

    @Override
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mCustomClickableSpan = getPressedSpan(textView, spannable, event);
            if (mCustomClickableSpan != null) {
                mCustomClickableSpan.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(mCustomClickableSpan), spannable.getSpanEnd(mCustomClickableSpan));
            }
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            CustomClickableSpan touchedSpan = getPressedSpan(textView, spannable, event);
            if (mCustomClickableSpan != null && touchedSpan != mCustomClickableSpan) {
                mCustomClickableSpan.setPressed(false);
                mCustomClickableSpan = null;
                Selection.removeSelection(spannable);
            }
        } else {
            if (mCustomClickableSpan != null) {
                mCustomClickableSpan.setPressed(false);
                super.onTouchEvent(textView, spannable, event);
            }
            mCustomClickableSpan = null;
            Selection.removeSelection(spannable);
        }
        return true;
    }

    /**
     *获得被 触摸 span 通过设置 press状态 来分发点击事件
     * @param textView 当前的textView
     * @param spannable 对应的spanable
     * @param event 事件
     * @return 自定义的ClickSpan
     */
    private CustomClickableSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        x -= textView.getTotalPaddingLeft();
        y -= textView.getTotalPaddingTop();

        x += textView.getScrollX();
        y += textView.getScrollY();

        Layout layout = textView.getLayout();
        int line = layout.getLineForVertical(y);
        int off = layout.getOffsetForHorizontal(line, x);

        CustomClickableSpan[] link = spannable.getSpans(off, off, CustomClickableSpan.class);
        CustomClickableSpan touchedSpan = null;
        if (link.length > 0) {
            touchedSpan = link[0];
        }
        return touchedSpan;
    }

}