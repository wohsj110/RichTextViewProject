package meitu.com.mylibrary.quickspan.other;

/**
 * Click State Change Listener
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des: OnClickStateChangeListener  点击状态的监听
 * Paramas
 */

public interface OnClickStateChangeListener {
    /**
     * 点击状态改变的的监听
     * @param isSelected 是否被选中
     * @param pressBgColor press 的背景色
     */
    void onStateChange(boolean isSelected, int pressBgColor);
}
