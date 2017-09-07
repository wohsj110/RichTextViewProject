package meitu.com.mylibrary.simplifyspan.customspan;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import  meitu.com.mylibrary.simplifyspan.other.OnClickStateChangeListener;
import  meitu.com.mylibrary.simplifyspan.other.OnClickableSpanListener;
import  meitu.com.mylibrary.simplifyspan.unit.SpecialClickableUnit;

/**
 * Custom ClickableSpan
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:
 * Paramas
 */
public class CustomClickableSpan extends ClickableSpan {
    private List<OnClickStateChangeListener> mOnClickStateChangeListeners;
    private OnClickableSpanListener mOnClickableSpanListener;
    private boolean isPressed;
    private boolean isShowUnderline;
    private int mTextColorNor;
    private int mTextColorPre;
    private int mBgColorNor;
    private int mBgColorPre;

    public CustomClickableSpan(SpecialClickableUnit specialClickableUnit) {
        mTextColorNor = specialClickableUnit.getNormalTextColor();
        mTextColorPre = specialClickableUnit.getPressTextColor();
        mBgColorNor = specialClickableUnit.getNormalBgColor();
        mBgColorPre = specialClickableUnit.getPressBgColor();
        isShowUnderline = specialClickableUnit.isShowUnderline();
        mOnClickableSpanListener = specialClickableUnit.getOnClickListener();
        mOnClickStateChangeListeners = specialClickableUnit.getOnClickStateChangeListeners();
    }

    @Override
    public void onClick(View widget) {
        if (null != mOnClickableSpanListener) {
            TextView tv = (TextView)widget;
            Spanned spanned = (Spanned)tv.getText();
            int start = spanned.getSpanStart(this);
            int end = spanned.getSpanEnd(this);
            mOnClickableSpanListener.onClick(tv, spanned.subSequence(start, end).toString());
        }
    }

    public void setPressed(boolean isSelected) {
        if (null != mOnClickStateChangeListeners && !mOnClickStateChangeListeners.isEmpty()) {
            for (OnClickStateChangeListener csl : mOnClickStateChangeListeners) {
                csl.onStateChange(isSelected, mBgColorPre);
            }
        }
        isPressed = isSelected;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
       // ds.setTextSize();
        // set text color And press status color
        if (mTextColorNor != 0) {
            if (mTextColorPre != 0) {
                ds.setColor(isPressed ? mTextColorPre : mTextColorNor);
            } else {
                ds.setColor(mTextColorNor);
            }
        }

        // set background color And press status color

        ds.bgColor = isPressed ? mBgColorPre : mBgColorNor == 0 ? Color.TRANSPARENT : mBgColorNor;


        /*if (mBgColorPre != 0) {
            ds.bgColor = isPressed ? mBgColorPre : mBgColorNor == 0 ? Color.TRANSPARENT : mBgColorNor;
        } else if (mBgColorNor != 0) {
            ds.bgColor = mBgColorNor;
        }*/
        if (!isShowUnderline) {
            // clear underline
            ds.setUnderlineText(false);
        }
    }
}
