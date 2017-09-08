package meitu.com.mylibrary.quickspan.unit;

import android.widget.TextView;

import java.util.List;

import  meitu.com.mylibrary.quickspan.other.OnClickStateChangeListener;
import meitu.com.mylibrary.quickspan.other.OnClickableSpanListener;

/**
 * Clickable Special Unit
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:  ClickableSpan 的设置参数
 * Paramas
 */
public class SpecialClickableUnit extends BaseSpecialUnit {
    private List<OnClickStateChangeListener> mOnClickStateChangeListeners;//点击状态的监听
    private OnClickableSpanListener mOnClickListener;//点击事件的监听
    private TextView mCurTextView;//当前的TextView
    private int mNormalBgColor;//span 点击状态为normal的背景颜色
    private int mPressBgColor;//span 点击状态为 press 的背景颜色
    // only text
    private boolean isShowUnderline;//是否显示下划线
    private int mNormalTextColor;//span 点击状态为 normal 的文字颜色
    private int mPressTextColor;//span 点击状态为 press 的为文字颜色

    public SpecialClickableUnit(TextView curTextView, OnClickableSpanListener onClickListener) {
        super(null);
        this.mCurTextView = curTextView;
        this.mOnClickListener = onClickListener;
    }

    public SpecialClickableUnit showUnderline() {
        this.isShowUnderline = true;
        return this;
    }

    public SpecialClickableUnit setPressBgColor(int pressBgColor) {
        this.mPressBgColor = pressBgColor;
        return this;
    }

    public SpecialClickableUnit setPressTextColor(int pressTextColor) {
        this.mPressTextColor = pressTextColor;
        return this;
    }

    public SpecialClickableUnit setNormalBgColor(int normalBgColor) {
        this.mNormalBgColor = normalBgColor;
        return this;
    }

    public SpecialClickableUnit setNormalTextColor(int normalTextColor) {
        this.mNormalTextColor = normalTextColor;
        return this;
    }

    /**
     * 只有在 自定义的SpanBuild 内部调用
     *
     * @param onClickStateChangeListeners OnClickStateChangeListener list
     */
    public void setOnClickStateChangeListeners(List<OnClickStateChangeListener> onClickStateChangeListeners) {
        this.mOnClickStateChangeListeners = onClickStateChangeListeners;
    }

    public OnClickableSpanListener getOnClickListener() {
        return mOnClickListener;
    }

    public int getPressTextColor() {
        return mPressTextColor;
    }

    public int getPressBgColor() {
        return mPressBgColor;
    }

    public int getNormalBgColor() {
        return mNormalBgColor;
    }

    public int getNormalTextColor() {
        return mNormalTextColor;
    }

    public TextView getCurTextView() {
        return mCurTextView;
    }

    public List<OnClickStateChangeListener> getOnClickStateChangeListeners() {
        return mOnClickStateChangeListeners;
    }

    public boolean isShowUnderline() {
        return isShowUnderline;
    }

    /**只有在 自定义的SpanBuild 内部调用
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }

}