package meitu.com.richtextviewproject.Library.process;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import meitu.com.mylibrary.simplifyspan.SimplifySpanBuild;
import meitu.com.mylibrary.simplifyspan.other.OnClickableSpanListener;
import meitu.com.mylibrary.simplifyspan.other.SpecialGravity;
import meitu.com.mylibrary.simplifyspan.unit.SpecialClickableUnit;
import meitu.com.mylibrary.simplifyspan.unit.SpecialImageUnit;
import meitu.com.mylibrary.simplifyspan.unit.SpecialTextUnit;
import meitu.com.richtextviewproject.Library.widget.SpecialUrlBean;
import meitu.com.richtextviewproject.R;

/**
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des:
 * Paramas
 */
public class ContentTextUtil {

    private static final String AT = "@[\\w\\p{InCJKUnifiedIdeographs}-]{1,26}";// @人
    private static final String TOPIC = "#[\\p{Print}\\p{InCJKUnifiedIdeographs}&&[^#]]+#";// ##话题
    private static final String URL = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";// url
    private static final String ALL = "(" + AT + ")" + "|" + "(" + TOPIC + ")" + "|" + "(" + URL + ")";


    public static SimplifySpanBuild getContent(String source, HashMap<String,SpecialUrlBean> urlHashMap, final Context context, TextView textView) {
        SimplifySpanBuild mSpanBuild = new SimplifySpanBuild();
        int linkNorTextColor = 0xFF483D8B;
        int linkPressBgColor = 0xFF87CEFA;
        //设置正则
        Pattern pattern = Pattern.compile(ALL);
        Matcher matcher = pattern.matcher(source);
        int maxEnd=0;
        int preStart=0;
        while (matcher.find()) {
            final String at = matcher.group(1);
            final String topic = matcher.group(2);
            final String url = matcher.group(3);

            //处理@用户
            if (at != null) {
                int start = matcher.start(1);
                int end = start + at.length();
                maxEnd=Math.max(maxEnd,end);
                if (start!=0&&preStart!=start){
                   mSpanBuild.append(source.substring(preStart,start));
                    preStart=end+1;
                }
                mSpanBuild.append(new SpecialTextUnit(at, linkNorTextColor)
                        .setClickableUnit(new SpecialClickableUnit(textView,
                                new OnClickableSpanListener() {
                    @Override
                    public void onClick(TextView tv, String clickText) {
                        Toast.makeText(context, "Click Text: " + clickText, Toast.LENGTH_SHORT).show();}
                        }).setPressTextColor(linkNorTextColor).setNormalTextColor(linkNorTextColor)
                                .setPressBgColor(Color.TRANSPARENT)));
            }
            //处理##话题
            if (topic != null) {
                int start = matcher.start(2);
                int end = start + topic.length();
                maxEnd=Math.max(maxEnd,end);
                if (start!=0&&preStart!=start){
                   mSpanBuild.append(source.substring(preStart,start));
                    preStart=end+1;
                }
                mSpanBuild.append(
                        new SpecialTextUnit(topic, linkNorTextColor)
                                .setClickableUnit(new SpecialClickableUnit(textView, new OnClickableSpanListener() {
                    @Override
                    public void onClick(TextView tv, String clickText) {
                        Toast.makeText(context, "Click Text: " + clickText, Toast.LENGTH_SHORT).show();}
                })
                                        .setPressTextColor(linkNorTextColor)
                                        .setNormalTextColor(linkNorTextColor)
                                        .setPressBgColor(Color.TRANSPARENT)));

            }
            // 处理url地址
            if (url != null) {
                int start = matcher.start(3);
                int end = start + url.length();
                maxEnd=Math.max(maxEnd,end);
                if (start!=0&&preStart!=start){
                   mSpanBuild.append(source.substring(preStart,start));
                    preStart=end+1;
                }
                SpecialUrlBean bean = urlHashMap.get(url);
                if (bean.getIcon()!=null){
                    mSpanBuild.appendMultiClickable(new SpecialClickableUnit(textView, new OnClickableSpanListener() {
                                @Override
                                public void onClick(TextView tv, String clickText) {
                                    Toast.makeText(context, "Click Text: " + url, Toast.LENGTH_SHORT).show();
                                }
                            }).setNormalTextColor(bean.getTextNormalColor()).setPressBgColor(Color.TRANSPARENT).setNormalBgColor(Color.TRANSPARENT)
                            , new SpecialImageUnit(context,bean.getURLName(),bean.getIcon(), 33, 33,
                                    context.getResources().getDrawable(R.drawable.bg_rectangle,context.getTheme())
                                    )
                                    .setSpnWidth(-1).setPadding(8)
                                    //.setGravity(SpecialGravity.CENTER)

                    );
                }else {
                    mSpanBuild.appendMultiClickable(new SpecialClickableUnit(textView, new OnClickableSpanListener() {
                                @Override
                                public void onClick(TextView tv, String clickText) {
                                    Toast.makeText(context, "Click Text: " + url, Toast.LENGTH_SHORT).show();
                                }
                            }).setNormalTextColor(bean.getTextNormalColor()).setPressBgColor(Color.TRANSPARENT).setNormalBgColor(Color.TRANSPARENT)
                            , new SpecialImageUnit(context,bean.getURLName(), BitmapFactory.decodeResource(context.getResources(), R.drawable.timeline_card_small_web), 33, 33,
                                    context.getResources().getDrawable(R.drawable.bg_rectangle,context.getTheme()))
                                    .setSpnWidth(-1)
                                    //.setGravity(SpecialGravity.CENTER)

                    );
                }

            }
        }
        if (maxEnd<source.length()){
            mSpanBuild.append(source.substring(maxEnd,source.length()));

        }
        mSpanBuild.append(new SpecialTextUnit("@英雄联盟", linkNorTextColor).setClickableUnit(new SpecialClickableUnit(textView, new OnClickableSpanListener() {
            @Override
            public void onClick(TextView tv, String clickText) {

            }
        }).setPressBgColor(linkPressBgColor)));

        return mSpanBuild;
    }

}
