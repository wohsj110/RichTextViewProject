package meitu.com.mylibrary.simplifyspan.customspan;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import   meitu.com.mylibrary.simplifyspan.other.SpecialGravity;

/**
 * Custom AbsoluteSizeSpan
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:
 * Paramas
 */
@SuppressLint("ParcelCreator")
public class CustomAbsoluteSizeSpan extends AbsoluteSizeSpan {
    private TextView mTextView;
    private int mGravity;
    private int mOffsetBaselineShift;
    private String mText;
    private Rect mTextViewRect = new Rect();
    private Rect mTextRect = new Rect();
    private String mNormalSizeText;

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