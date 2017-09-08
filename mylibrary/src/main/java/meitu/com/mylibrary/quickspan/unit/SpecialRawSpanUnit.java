package meitu.com.mylibrary.quickspan.unit;

import android.text.Spanned;

/**
 * Special Raw Span Unit
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des: 带有 flag 的 直接 对象
 * Paramas
 */
public class SpecialRawSpanUnit extends BaseSpecialUnit {
    private Object mSpanObj; //对象
    private int flags; //span flag

    public SpecialRawSpanUnit(String text, Object spanObj) {
        super(text);
        this.mSpanObj = spanObj;
        this.flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
    }

    public SpecialRawSpanUnit(String text, Object spanObj, int flags) {
        super(text);
        this.mSpanObj = spanObj;
        this.flags = flags;
    }

    public Object getSpanObj() {
        return mSpanObj;
    }

    public int getFlags() {
        return flags;
    }

}