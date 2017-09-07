package meitu.com.mylibrary.simplifyspan.unit;

import android.text.Spanned;

/**
 * Special Raw Span Unit
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:
 * Paramas
 */
public class SpecialRawSpanUnit extends BaseSpecialUnit {
    private Object spanObj;
    private int flags;

    public SpecialRawSpanUnit(String text, Object spanObj) {
        super(text);
        this.spanObj = spanObj;
        this.flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
    }

    public SpecialRawSpanUnit(String text, Object spanObj, int flags) {
        super(text);
        this.spanObj = spanObj;
        this.flags = flags;
    }

    public Object getSpanObj() {
        return spanObj;
    }

    public int getFlags() {
        return flags;
    }

}