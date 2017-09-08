package meitu.com.mylibrary.quickspan.unit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Image Special Unit
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des: 自定义 ImageSpan 的对应设置参数
 * Paramas
 */
public class SpecialImageUnit extends BaseSpecialUnit {
    private static final String DEF_IMG_PLACEHOLDER = "img";
    private Context mContext;//上下文
    private Bitmap mBitmap;//需要进行绘制的 biamap 图标什么的
    private int mBgColor;//背景颜色
    private boolean mIsClickable;//是否可以点击
    public final static int WARP_CONTENT=-1;//设置 ImageSpan 长度的模式包裹模式（包含了内部的Padding）
    private int mSpecialTextSize;//需要进行绘制的文字的 size
    private int mPadding;// imageSpan 内部的padding 目前暂时只支持固定的padding;
    /**
     *   imageSpan 的宽度 默认为0
     *   WARP_CONTENT  等于这个值的时候，会进行包裹模式
     */
    private int mSpnWidth=0;
    private int mWidth; // px 图片的宽度
    private int mHeight; // px 图片的高度

    /**
     * 用于外部设置的 具有 press 和normal 两个状态的 Drawable xml 拥有二态
     * 如果有设置 drawable 那么会只绘制 Drawable 否则会绘制背景色
     */
    private Drawable mDrawable;


    public int getSpecialTextSize() {
        return mSpecialTextSize;
    }

    public SpecialImageUnit setSpecialTextSize(int specialnTextSize) {
        mSpecialTextSize = specialnTextSize;
        return this;
    }
    public int getPadding() {
        return mPadding;
    }

    public SpecialImageUnit setPadding(int padding) {
        mPadding = padding;
        return this;
    }



    public int getSpnWidth() {
        return mSpnWidth;
    }

    public SpecialImageUnit setSpnWidth(int spnWidth) {
        mSpnWidth = spnWidth;
        return this;
    }


    /**
     * @param context     Context
     * @param bitmap      Bitmap
     */
    public SpecialImageUnit(Context context, Bitmap bitmap) {
        this(context, DEF_IMG_PLACEHOLDER, bitmap);
    }

    /**
     * @param context     Context
     * @param specialText Special Text
     * @param bitmap      Bitmap
     */
    public SpecialImageUnit(Context context, String specialText, Bitmap bitmap) {
        super(specialText);
        this.mContext = context;
        this.mBitmap = bitmap;
    }

    /**
     * @param context     Context
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     */
    public SpecialImageUnit(Context context,  Bitmap bitmap, int width, int height,Drawable drawable) {
        super(DEF_IMG_PLACEHOLDER);
        this.mContext = context;
        this.mBitmap = bitmap;
        this.mWidth = width;
        this.mHeight = height;
        this.mDrawable =drawable;
    }


    /**
     * @param context     Context
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     */
    public SpecialImageUnit(Context context, String specialText, Bitmap bitmap, int width, int height,Drawable drawable) {
        super(DEF_IMG_PLACEHOLDER+specialText);
        this.mContext = context;
        this.mBitmap = bitmap;
        this.mWidth = width;
        this.mHeight = height;
        this.mDrawable =drawable;
    }

    /**
     * @param context     Context
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     */
    public SpecialImageUnit(Context context, Bitmap bitmap, int width, int height) {
        this(context, DEF_IMG_PLACEHOLDER, bitmap, width, height);
    }

    /**
     * @param context     Context
     * @param specialText Special Text
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     */
    public SpecialImageUnit(Context context, String specialText, Bitmap bitmap, int width, int height) {
        super(specialText);
        this.mContext = context;
        this.mBitmap = bitmap;
        this.mWidth = width;
        this.mHeight = height;
    }

    /**
     * @param context     Context
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     * @param gravity     Use SpecialGravity.xx
     */
    public SpecialImageUnit(Context context, Bitmap bitmap, int width, int height, int gravity) {
        this(context, DEF_IMG_PLACEHOLDER, bitmap, width, height, gravity);
    }

    /**
     * @param context     Context
     * @param specialText Special Text
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     * @param gravity     Use SpecialGravity.xx
     */
    public SpecialImageUnit(Context context, String specialText, Bitmap bitmap, int width, int height, int gravity) {
        super(specialText);
        this.mContext = context;
        this.mBitmap = bitmap;
        this.mWidth = width;
        this.mHeight = height;
        this.gravity = gravity;
    }

    /**
     * Set Background Color
     * @param bgColor 背景色
     * @return this
     */
    public SpecialImageUnit setBgColor(int bgColor) {
        this.mBgColor = bgColor;
        return this;
    }

    /**
     * Set Gravity
     * @param gravity use SpecialGravity.xx
     * @return this
     */
    public SpecialImageUnit setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * 设置转换模式
     * @param convertMode use SpecialConvertMode.xx
     * @return this
     */
    public SpecialImageUnit setConvertMode(int convertMode) {
        this.convertMode = convertMode;
        return this;
    }

    public boolean isClickable() {
        return mIsClickable;
    }

    /**
     * 只有在 自定义的SpanBuild 内部调用
     * @param clickable 是否点击
     */
    public void setClickable(boolean clickable) {
        mIsClickable = clickable;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getBgColor() {
        return mBgColor;
    }

    public Context getContext() {
        return mContext;
    }

    public Drawable getDrawable() {
        return mDrawable;
    }
}