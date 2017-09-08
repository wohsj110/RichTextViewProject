package meitu.com.richtextviewproject.Library.process;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import meitu.com.mylibrary.quickspan.QuickSpanBuild;
import meitu.com.mylibrary.quickspan.other.OnClickableSpanListener;
import meitu.com.mylibrary.quickspan.unit.SpecialClickableUnit;
import meitu.com.mylibrary.quickspan.unit.SpecialImageUnit;
import meitu.com.mylibrary.quickspan.unit.SpecialTextUnit;
import meitu.com.richtextviewproject.Library.utils.RichTextRegex;
import meitu.com.richtextviewproject.Library.widget.SpecialUrlBean;
import meitu.com.richtextviewproject.R;

/**
 * Author huangshijie on 2017/9/4.
 * E-mail: wohsj110@gmail.com
 * Des: ContentTextUtil 可以对文字做富文本效果
 * Paramas
 */
public class ContentTextUtil {
    public static QuickSpanBuild getContent(String source, HashMap<String,SpecialUrlBean> urlHashMap, final Context context, TextView textView) {
        QuickSpanBuild mSpanBuild = new QuickSpanBuild();
        int linkNorTextColor = 0xFF483D8B;
        //设置正则
        Pattern pattern = Pattern.compile(RichTextRegex.ALL);
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
                            , new SpecialImageUnit(context,bean.getURLName(),bean.getIcon(), 33, 33
                                    , context.getResources().getDrawable(R.drawable.bg_rectangle,context.getTheme())
                                    )
                                    .setSpnWidth(SpecialImageUnit.WARP_CONTENT).setPadding(8).setSpecialTextSize(32)
                    );
                }else {
                    mSpanBuild.appendMultiClickable(new SpecialClickableUnit(textView, new OnClickableSpanListener() {
                                @Override
                                public void onClick(TextView tv, String clickText) {
                                    Toast.makeText(context, "Click Text: " + url, Toast.LENGTH_SHORT).show();
                                }
                            }).setNormalTextColor(bean.getTextNormalColor()).setPressBgColor(Color.TRANSPARENT).setNormalBgColor(Color.TRANSPARENT)
                            , new SpecialImageUnit(context,bean.getURLName(), BitmapFactory.decodeResource(context.getResources(), R.drawable.timeline_card_small_web), 33, 33
                                    , context.getResources().getDrawable(R.drawable.bg_rectangle,context.getTheme())

                                    )
                                    .setSpnWidth(SpecialImageUnit.WARP_CONTENT).setPadding(8).setSpecialTextSize(32)
                    );
                }

            }
        }
        if (maxEnd<source.length()){
            mSpanBuild.append(source.substring(maxEnd,source.length()));

        }
        return mSpanBuild;
    }

}
