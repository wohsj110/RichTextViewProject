package meitu.com.richtextviewproject.Library.utils;

/**
 * Created by meitu on 2017/9/8.
 */

public class RichTextRegex {
    public static final String AT = "@[\\w\\p{InCJKUnifiedIdeographs}-]{1,26}";// @人
    public static final String TOPIC = "#[\\p{Print}\\p{InCJKUnifiedIdeographs}&&[^#]]+#";// ##话题
    public static final String URL = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";// url
    public static final String ALL = "(" + AT + ")" + "|" + "(" + TOPIC + ")" + "|" + "(" + URL + ")";
}
