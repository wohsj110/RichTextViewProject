package meitu.com.mylibrary.simplifyspan.unit;

import  meitu.com.mylibrary.simplifyspan.other.SpecialConvertMode;
import  meitu.com.mylibrary.simplifyspan.other.SpecialGravity;

/**
 * Base Special Unit
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:
 * Paramas
 */
public class BaseSpecialUnit {
    protected String text;
    private int[] startPoss;
    protected int gravity = SpecialGravity.BOTTOM;
    protected int convertMode = SpecialConvertMode.ONLY_FIRST;

    public BaseSpecialUnit(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getGravity() {
        return gravity;
    }

    public int getConvertMode() {
        return convertMode;
    }

    /**
     * Use only in SimplifySpanBuild
     * @param startPoss
     */
    public void setStartPoss(int[] startPoss) {
        this.startPoss = startPoss;
    }

    public int[] getStartPoss() {
        return startPoss;
    }

}