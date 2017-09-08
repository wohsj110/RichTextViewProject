package meitu.com.mylibrary.quickspan.unit;

import android.graphics.Bitmap;

/**
 * Label Special Unit
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des: LabelSpan 的对应设置参数
 * Paramas
 */
public class SpecialLabelUnit extends BaseSpecialUnit {
    private int mLabelTextColor;// label 文字颜色
    private float mLabelTextSize; // sp|px label 文字 的 size
    private Bitmap mBitmap;
    private int labelBgColor;//label的背景色
    private float labelBgRadius;
    private int labelBgWidth; // px
    private int labelBgHeight; // px
    private int padding; // px
    private int paddingLeft; // px
    private int paddingRight; // px
    private float borderSize; // px
    private int labelBgBorderColor;
    private boolean isShowBorder;
    private boolean isTextBold;
    private boolean isClickable;
    private int bgColor;//背景色

    /**
     * @param labelText      label text
     * @param labelTextColor label text color
     * @param labelTextSize  label text size (unit：xp)
     * @param labelBgColor   label background color
     */
    public SpecialLabelUnit(String labelText, int labelTextColor, float labelTextSize, int labelBgColor) {
        super(labelText);
        this.mLabelTextSize = labelTextSize;
        this.mLabelTextColor = labelTextColor;
        this.labelBgColor = labelBgColor;
    }

    /**
     * @param labelText      label text
     * @param labelTextColor label text color
     * @param labelTextSize  label text size (unit：xp)
     * @param labelBgColor   label background color
     * @param labelBgWidth   label background width
     * @param labelBgHeight  label background height
     */
    public SpecialLabelUnit(String labelText, int labelTextColor, float labelTextSize, int labelBgColor, int labelBgWidth, int labelBgHeight) {
        super(labelText);
        this.mLabelTextSize = labelTextSize;
        this.mLabelTextColor = labelTextColor;
        this.labelBgColor = labelBgColor;
        this.labelBgWidth = labelBgWidth;
        this.labelBgHeight = labelBgHeight;
    }

    /**
     * @param labelText      label text
     * @param labelTextColor label text color
     * @param labelTextSize  label text size (unit：xp)
     * @param bitmap         label background image bitmap
     */
    public SpecialLabelUnit(String labelText, int labelTextColor, float labelTextSize, Bitmap bitmap) {
        super(labelText);
        this.mLabelTextSize = labelTextSize;
        this.mLabelTextColor = labelTextColor;
        this.mBitmap = bitmap;
    }

    /**
     * @param labelText      label text
     * @param labelTextColor label text color
     * @param labelTextSize  label text size (unit：xp)
     * @param bitmap         label background image bitmap
     * @param labelBgWidth   label background width
     * @param labelBgHeight  label background height
     */
    public SpecialLabelUnit(String labelText, int labelTextColor, float labelTextSize, Bitmap bitmap, int labelBgWidth, int labelBgHeight) {
        super(labelText);
        this.mLabelTextSize = labelTextSize;
        this.mLabelTextColor = labelTextColor;
        this.mBitmap = bitmap;
        this.labelBgWidth = labelBgWidth;
        this.labelBgHeight = labelBgHeight;
    }

    public SpecialLabelUnit setLabelBgSize(int labelBgWidth, int labelBgHeight) {
        this.labelBgWidth = labelBgWidth;
        this.labelBgHeight = labelBgHeight;
        return this;
    }

    public SpecialLabelUnit setBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
        return this;
    }

    public SpecialLabelUnit setPadding(int padding) {
        this.padding = padding;
        return this;
    }

    public SpecialLabelUnit setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public SpecialLabelUnit setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public SpecialLabelUnit setLabelBgRadius(float labelBgRadius) {
        this.labelBgRadius = labelBgRadius;
        return this;
    }

    public SpecialLabelUnit showBorder(int labelBgBorderColor, float borderSize) {
        isShowBorder = true;
        this.labelBgBorderColor = labelBgBorderColor;
        this.borderSize = borderSize;
        return this;
    }

    public SpecialLabelUnit useTextBold() {
        isTextBold = true;
        return this;
    }

    public SpecialLabelUnit setBgColor(int bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    /**
     * Set Gravity
     *
     * @param gravity use SpecialGravity.xx
     * @return
     */
    public SpecialLabelUnit setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * 设置转换模式
     *
     * @param convertMode use SpecialConvertMode.xx
     *
     * @return this
     */
    public SpecialLabelUnit setConvertMode(int convertMode) {
        this.convertMode = convertMode;
        return this;
    }

    public int getLabelBgColor() {
        return labelBgColor;
    }

    public int getLabelBgHeight() {
        return labelBgHeight;
    }

    public int getLabelBgWidth() {
        return labelBgWidth;
    }

    public int getLabelTextColor() {
        return mLabelTextColor;
    }

    /**
     * label Text Size
     *
     * @return px
     */
    public float getLabelTextSize() {
        return mLabelTextSize;
    }

    public int getPadding() {
        return padding;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public float getLabelBgRadius() {
        return labelBgRadius;
    }

    public boolean isShowBorder() {
        return isShowBorder;
    }

    /**
     * 只有在 自定义的SpanBuild 内部调用
     *
     * @param clickable
     */
    public void setClickable(boolean clickable) {
        isClickable = clickable;
    }

    public float getBorderSize() {
        return borderSize;
    }

    public int getLabelBgBorderColor() {
        return labelBgBorderColor;
    }

    public boolean isTextBold() {
        return isTextBold;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public boolean isClickable() {
        return isClickable;
    }

    public int getBgColor() {
        return bgColor;
    }

}