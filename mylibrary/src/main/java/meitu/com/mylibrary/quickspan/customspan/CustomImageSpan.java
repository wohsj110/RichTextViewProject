package meitu.com.mylibrary.quickspan.customspan;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;

import java.lang.ref.WeakReference;

import meitu.com.mylibrary.quickspan.other.OnClickStateChangeListener;
import meitu.com.mylibrary.quickspan.other.SpecialGravity;
import meitu.com.mylibrary.quickspan.unit.SpecialImageUnit;

/**
 * Custom ImageSpan
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:CustomImageSpan
 * Paramas
 */
public class CustomImageSpan extends ImageSpan implements OnClickStateChangeListener {
    private final String mSpecialText;
    private WeakReference<Drawable> mDrawableRef;
    private int gravity;
    private Rect mRect = new Rect();
    private String mNormalSizeText;
    private Drawable mBgDrawable;
    private int mBgColor;
    private boolean isSelected;
    private boolean isClickable;
    private int pressBgColor;
    private int mSpanWidth;
    private int mLineTextHeight;
    private int mLineTextBaselineOffset;
    private int mAllPadding;
    private int mSpecialTextSize;
    public CustomImageSpan(String normalSizeText, SpecialImageUnit specialImageUnit) {
        super(specialImageUnit.getContext(), specialImageUnit.getBitmap(), ALIGN_BASELINE);
        this.gravity = specialImageUnit.getGravity();
        this.mSpecialText = specialImageUnit.getText();
        this.mNormalSizeText = normalSizeText;
        this.mBgDrawable = specialImageUnit.getDrawable();
        this.mBgColor = specialImageUnit.getBgColor();
        this.isClickable = specialImageUnit.isClickable();
        this.mSpanWidth = specialImageUnit.getSpnWidth();
        this.mAllPadding = specialImageUnit.getPadding();
        this.mSpecialTextSize = specialImageUnit.getSpecialTextSize();
    }

    @Override
    public void onStateChange(boolean isSelected, int pressBgColor) {
        this.isSelected = isSelected;
        this.pressBgColor = pressBgColor;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
         super.getSize(paint, text, start, end, fm);
        if (mSpanWidth == 0){
              mSpanWidth= super.getSize(paint, text, start, end, fm);
        }else if (mSpanWidth ==SpecialImageUnit.WARP_CONTENT){
            mSpanWidth = super.getSize(paint, text, start, end, fm) +mAllPadding*2;
            if (paint.getTextSize()!=mSpecialTextSize){
                paint.setTextSize(mSpecialTextSize);
            }
            mSpanWidth+= paint.measureText(mSpecialText,3,mSpecialText.length())+mAllPadding;
        }
        return  Math.round(mSpanWidth);
    }



    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        //super.draw(canvas, text, start, end, x, top, y, bottom, paint);
        Drawable b = getCachedDrawable();
        int drawableHeight = b.getIntrinsicHeight();
        int drawableWidth = b.getIntrinsicWidth();

        paint.getTextBounds(String.valueOf(text), start, end, mRect);
        int lineHeight = mRect.height();
        float finalUnitHeight = bottom - top;
        float bgTop = bottom - finalUnitHeight;
        if (mBgDrawable!=null){
            if (isSelected){
                mBgDrawable.setState(new int[] {android.R.attr.state_pressed});
            }else {
                mBgDrawable.setState(new int[] {});
            }
            mBgDrawable.setBounds((int) x, (int) top, (int) (x+mSpanWidth),(int)  y +lineHeight/2);

            mBgDrawable.draw(canvas);
        }else {
            if (isClickable && isSelected) {
                // click background
                paint.setColor(pressBgColor);
                //canvas.drawRect(x, bgTop, x + drawableWidth, bgTop + finalUnitHeight, paint);
                canvas.drawRect(x, bgTop, x + mSpanWidth, bgTop + lineHeight, paint);
            } else {
                // normal background
                paint.setColor(mBgColor);
                canvas.drawRect(x, bgTop, x + mSpanWidth, bgTop + lineHeight, paint);

            }
        }
        canvas.save();
        if (mLineTextHeight <= 0) {
            Rect specialTextRect = new Rect();
            paint.getTextBounds(mNormalSizeText, 0, mNormalSizeText.length(), specialTextRect);
            mLineTextHeight = specialTextRect.height();
            mLineTextBaselineOffset = specialTextRect.bottom;
        }

        float newStartY = y;
        float newTextY = y;
        float newTextX = x+drawableWidth+mAllPadding*2;
        switch (gravity) {
            case SpecialGravity.TOP: {
                newStartY -= mLineTextHeight - mLineTextBaselineOffset;
                canvas.translate(x+8, newStartY);
                break;
            }
            case SpecialGravity.CENTER: {
                newStartY -= (mLineTextHeight / 2 + drawableHeight / 2 - mLineTextBaselineOffset);
                canvas.translate(x+mAllPadding, newStartY);
                break;
            }
            case SpecialGravity.BOTTOM: {
                newStartY -= drawableHeight - mLineTextBaselineOffset;
                canvas.translate(x+mAllPadding, newStartY);
                break;
            }
        }
        b.draw(canvas);
        canvas.restore();
        paint.setColor(Color.WHITE);
        paint.setTextSize(mSpecialTextSize);
        canvas.drawText(mSpecialText,3,mSpecialText.length(),newTextX,newTextY,paint);

    }


    private Drawable getCachedDrawable() {
        Drawable drawable = null;

        if (mDrawableRef != null) {
            drawable = mDrawableRef.get();
        }

        if (drawable == null) {
            drawable = getDrawable();
            mDrawableRef = new WeakReference<>(drawable);
        }

        return drawable;
    }

}  