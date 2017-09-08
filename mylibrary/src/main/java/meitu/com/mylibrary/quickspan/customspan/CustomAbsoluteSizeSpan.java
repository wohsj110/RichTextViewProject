package meitu.com.mylibrary.quickspan.customspan;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import   meitu.com.mylibrary.quickspan.other.SpecialGravity;

/**
 * Custom AbsoluteSizeSpan
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des: CustomAbsoluteSizeSpan
 * Paramas
 */
@SuppressLint("ParcelCreator")
public class CustomAbsoluteSizeSpan extends AbsoluteSizeSpan {
    private TextView mTextView;//当前的TextView
    private int mGravity;// 位置的 Gravity
    private int mOffsetBaselineShift;//基线
    private String mText;//文字
    private Rect mTextViewRect = new Rect();
    private Rect mTextRect = new Rect();
    private String mNormalSizeText;//非匹配的文字

    public CustomAbsoluteSizeSpan(String normalSizeText, String text, int size, TextView textView, int gravity) {
        super(size, true);
        mText = text;
        mTextView = textView;
        mGravity = gravity;
        mNormalSizeText = normalSizeText;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);

        if (mGravity == SpecialGravity.BOTTOM) return;

        mTextView.getPaint().getTextBounds(mNormalSizeText, 0, mNormalSizeText.length(), mTextViewRect);
        ds.getTextBounds(mText, 0, mText.length(), mTextRect);
        int mMainTextHeight = mTextViewRect.height();

        int offset = mTextViewRect.bottom - mTextRect.bottom;
        switch (mGravity) {
            case SpecialGravity.TOP:
                mOffsetBaselineShift = mMainTextHeight - mTextRect.height() - offset;
                break;
            case SpecialGravity.CENTER:
                mOffsetBaselineShift = mMainTextHeight / 2 - mTextRect.height() / 2 - offset;
                break;
        }

        ds.baselineShift -= mOffsetBaselineShift;
    }

    @Override
    public void updateMeasureState(TextPaint ds) {
        super.updateMeasureState(ds);
        ds.baselineShift -= mOffsetBaselineShift;
    }
}