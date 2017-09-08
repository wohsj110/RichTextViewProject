package meitu.com.richtextviewproject.Library.widget;

import java.util.HashMap;

/**
 * Author huangshijie on 2017/9/6.
 * E-mail: wohsj110@gmail.com
 * Des:
 * Paramas
 */

/**
 * 富文本的实体类
 */
public class RichTextBean {
    private String mTextcontent;
    private HashMap<String, SpecialUrlBean> mUrlHashMap = new HashMap<>();

    public String getTextcontent() {
        return mTextcontent;
    }

    public void setTextcontent(String textcontent) {
        mTextcontent = textcontent;
    }

    public HashMap<String, SpecialUrlBean> getUrlHashMap() {
        return mUrlHashMap;
    }

    public void setUrlHashMap(HashMap<String, SpecialUrlBean> urlHashMap) {
        mUrlHashMap = urlHashMap;
    }


}
