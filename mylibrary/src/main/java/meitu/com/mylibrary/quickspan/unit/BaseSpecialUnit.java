package meitu.com.mylibrary.quickspan.unit;

import  meitu.com.mylibrary.quickspan.other.SpecialConvertMode;
import  meitu.com.mylibrary.quickspan.other.SpecialGravity;

/**
 * Base Special Unit
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:
 * Paramas
 */

/**
 * 基础的 单元 每个单元都为对应 span 的设置参数
 */
public class BaseSpecialUnit {
    protected String text;//文字内容
    private int[] startPoss;//开始位置
    protected int gravity = SpecialGravity.BOTTOM;// 位置  Gravity
    protected int convertMode = SpecialConvertMode.ONLY_FIRST;//转换模式

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
     * 只有在 自定义的SpanBuild 内部调用
     * @param startPoss
     */
    public void setStartPoss(int[] startPoss) {
        this.startPoss = startPoss;
    }

    public int[] getStartPoss() {
        return startPoss;
    }

}