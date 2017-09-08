package meitu.com.mylibrary.quickspan.unit;

import android.widget.TextView;

/**
 * Text Special Unit
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:
 * Paramas
 */
public class SpecialTextUnit extends BaseSpecialUnit {
    private int mTextColor;//文字的颜色
    private int mTextBackgroundColor;//文字的背景色
    private float mTextSize; // sp(px) 文字的大小
    private boolean mIsShowUnderline;//是否显示下划线
    private boolean mIsShowStrikeThrough;//是否显示 Strike
    private boolean mIsTextBold;//是否使用 TextBold
    private SpecialClickableUnit mSpecialClickableUnit;//为了Text 可以被点击
    private TextView mCurTextView;//当前的TextView

    /**
     * @param text text
     */
    public SpecialTextUnit(String text) {
        super(text);
    }

    /**
     * @param text      text
     * @param texColor Text Color
     */
    public SpecialTextUnit(String text, int texColor) {
        this(text);
        this.mTextColor = texColor;
    }

    /**
     * @param text      text
     * @param textColor text color
     * @param textSize  text size (unit：sp)
     */
    public SpecialTextUnit(String text, int textColor, float textSize) {
        this(text);
        this.mTextColor = textColor;
        this.mTextSize = textSize;
    }

    /**
     * @param text        text
     * @param textColor   text color
     * @param textSize    text size (unit：sp)
     * @param gravity     use SpecialGravity.xx
     * @param curTextView current TextView
     */
    public SpecialTextUnit(String text, int textColor, float textSize, int gravity, TextView curTextView) {
        this(text);
        this.mTextColor = textColor;
        this.mTextSize = textSize;
        this.gravity = gravity;
        this.mCurTextView = curTextView;
    }

    /**
     * Show StrikeThrough
     *
     * @return SpecialTextUnit
     */
    public SpecialTextUnit showStrikeThrough() {
        mIsShowStrikeThrough = true;
        return this;
    }

    /**
     * 是否显示下滑线路
     *
     * @return SpecialTextUnit
     */
    public SpecialTextUnit showUnderline() {
        mIsShowUnderline = true;
        return this;
    }

    /**
     * 使用 TextBlod
     *
     * @return SpecialTextUnit
     */
    public SpecialTextUnit useTextBold() {
        mIsTextBold = true;
        return this;
    }

    /**
     * 设置背景色
     *
     * @param textBackgroundColor color
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setTextBackgroundColor(int textBackgroundColor) {
        this.mTextBackgroundColor = textBackgroundColor;
        return this;
    }

    /**
     * 设置 Special Text 的字体颜色
     *
     * @param mTextColor color
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
        return this;
    }

    /**
     * 设置 Special Text 的 Size
     *
     * @param mTextSize size (sp|px)
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
        return this;
    }

    /**
     * Set SpecialClickableUnit
     *
     * @param specialClickableUnit SpecialClickableUnit
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setClickableUnit(SpecialClickableUnit specialClickableUnit) {
        this.mSpecialClickableUnit = specialClickableUnit;
        return this;
    }

    /**
     * Set Gravity
     *
     * @param curTextView current TextView
     * @param gravity     use SpecialGravity.xx
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setGravity(TextView curTextView, int gravity) {
        this.mCurTextView = curTextView;
        this.gravity = gravity;
        return this;
    }

    /**
     * 设置转换模式
     *
     * @param convertMode use SpecialConvertMode.xx
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setConvertMode(int convertMode) {
        this.convertMode = convertMode;
        return this;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public int getTextBackgroundColor() {
        return mTextBackgroundColor;
    }

    public float getTextSize() {
        return mTextSize;
    }

    public boolean isShowUnderline() {
        return mIsShowUnderline;
    }

    public boolean isShowStrikeThrough() {
        return mIsShowStrikeThrough;
    }

    public boolean isTextBold() {
        return mIsTextBold;
    }

    public TextView getCurTextView() {
        return mCurTextView;
    }

    public SpecialClickableUnit getSpecialClickableUnit() {
        return mSpecialClickableUnit;
    }

}