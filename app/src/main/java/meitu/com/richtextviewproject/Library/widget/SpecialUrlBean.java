package meitu.com.richtextviewproject.Library.widget;

import android.graphics.Bitmap;
import android.graphics.Color;

public class SpecialUrlBean {
    private String mMainURL;
    private String mURLName;
    private String mIconURL;
    private int mTextNormalColor= Color.BLACK;
    private int mTextPressColor=Color.BLACK;
    private int mBgNormalColor=0xFF87CEFA;
    private int mBgPressColor=0xFF83B5ED;
    private Bitmap mIcon;

    public int getTextNormalColor() {
        return mTextNormalColor;
    }

    public void setTextNormalColor(int textNormalColor) {
        mTextNormalColor = textNormalColor;
    }

    public int getTextPressColor() {
        return mTextPressColor;
    }

    public void setTextPressColor(int textPressColor) {
        mTextPressColor = textPressColor;
    }

    public int getBgNormalColor() {
        return mBgNormalColor;
    }

    public void setBgNormalColor(int bgNormalColor) {
        mBgNormalColor = bgNormalColor;
    }

    public int getBgPressColor() {
        return mBgPressColor;
    }

    public void setBgPressColor(int bgPressColor) {
        mBgPressColor = bgPressColor;
    }

    public String getMainURL() {
        return mMainURL;
    }

    public void setMainURL(String mainURL) {
        mMainURL = mainURL;
    }

    public String getURLName() {
        return mURLName;
    }

    public void setURLName(String URLName) {
        mURLName = URLName;
    }

    public String getIconURL() {
        return mIconURL;
    }

    public void setIconURL(String iconURL) {
        mIconURL = iconURL;
    }

    public Bitmap getIcon() {
        return mIcon;
    }

    public void setIcon(Bitmap icon) {
        mIcon = icon;
    }
}