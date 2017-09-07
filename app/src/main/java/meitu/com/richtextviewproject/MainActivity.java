package meitu.com.richtextviewproject;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import meitu.com.mylibrary.simplifyspan.SimplifySpanBuild;
import meitu.com.mylibrary.simplifyspan.other.OnClickableSpanListener;
import meitu.com.mylibrary.simplifyspan.other.SpecialConvertMode;
import meitu.com.mylibrary.simplifyspan.other.SpecialGravity;
import meitu.com.mylibrary.simplifyspan.unit.SpecialClickableUnit;
import meitu.com.mylibrary.simplifyspan.unit.SpecialImageUnit;
import meitu.com.mylibrary.simplifyspan.unit.SpecialLabelUnit;
import meitu.com.mylibrary.simplifyspan.unit.SpecialTextUnit;
import meitu.com.richtextviewproject.Library.widget.RichTextBean;
import meitu.com.richtextviewproject.Library.widget.RichTextViewHelper;
import meitu.com.richtextviewproject.Library.widget.SpecialUrlBean;

public class MainActivity extends AppCompatActivity implements OnClickableSpanListener {
    private String mUrl = "https://www.baidu.com";
    private String mUrlIcon = "http://xianse.cc/upload/201410/1108211731.512x512.jpg";
    private String mUrl2 = "http://www.xianse.com";
    private String mUrl2Icon = "http://ico.ooopic.com/ajax/iconpng/?id=154282.png";

    private String mSource="新上宝贝，最潮明显同款大花长裙~\n@阿丁 买家晒图http://www.xianse.com里克哈善良的:#话题# 深刻的哈萨https://www.baidu.com\n哒哒哒四大可好看了哈了";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvText1 = (TextView) findViewById(R.id.tv_text1);
        TextView tvText11 = (TextView) findViewById(R.id.tv_text11);
        TextView tvText2 = (TextView) findViewById(R.id.tv_text2);
        TextView tvText21 = (TextView) findViewById(R.id.tv_text21);
        TextView tvText22 = (TextView) findViewById(R.id.tv_text22);
        TextView tvText3 = (TextView) findViewById(R.id.tv_text3);
        TextView tvText4 = (TextView) findViewById(R.id.tv_text4);
        TextView tvText41 = (TextView) findViewById(R.id.tv_text41);
        findViewById(R.id.btn_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MeituActivity.class));
            }
        });

        CharSequence tv1SpannableString = new SimplifySpanBuild(" 艾客优品雷霆Dock 2 雷电转USB3.0/火线/esata 扩展HUB")
                .appendToFirst(new SpecialLabelUnit("1212", Color.WHITE, sp2px(8), Color.RED, 70, 35).useTextBold().setGravity(SpecialGravity.CENTER))
                .appendToFirst(new SpecialLabelUnit("天猫", Color.WHITE, sp2px(8), 0xFFFF5000, 60, 35).setGravity(SpecialGravity.CENTER))
                .build();
        tvText1.setText(tv1SpannableString);

//        tvText1.setText(new SimplifySpanBuild("距离您：").append(new SpecialTextUnit("385", Color.BLUE)).append(" 米").build());

        SimplifySpanBuild simplifySpanBuild11 = new SimplifySpanBuild();
        simplifySpanBuild11.append(new SpecialLabelUnit("火", Color.RED, sp2px(7), BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravity.CENTER))
                .append("正常")
                .append(new SpecialLabelUnit("火", Color.RED, sp2px(7), BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravity.TOP))
                .append("正常")
                .append(new SpecialLabelUnit("火", Color.RED, sp2px(7), BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravity.BOTTOM))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.BLACK, sp2px(10), BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravity.TOP))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.BLACK, sp2px(10), BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravity.CENTER))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.BLACK, sp2px(10), BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravity.BOTTOM))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.BOTTOM))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.TOP))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.CENTER))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), Color.GRAY).setLabelBgRadius(5).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.BOTTOM))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), Color.GRAY).setLabelBgRadius(5).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.TOP))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), Color.GRAY).setLabelBgRadius(5).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.CENTER))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.RED, sp2px(10), Color.TRANSPARENT).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.BOTTOM))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.RED, sp2px(10), Color.TRANSPARENT).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.TOP))
                .append("正常")
                .append(new SpecialLabelUnit("原创", Color.RED, sp2px(10), Color.TRANSPARENT).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.CENTER));
        tvText11.setText(simplifySpanBuild11.build());


        SimplifySpanBuild simplifySpanBuild2 = new SimplifySpanBuild("替换所有张字的颜色及字体大小并加粗，张歆艺、张馨予、张嘉倪、张涵予、张含韵、张韶涵、张嘉译、张佳宁、大张伟", new SpecialTextUnit("张").useTextBold().setTextSize(20).setTextColor(0xFFFFA500).setConvertMode(SpecialConvertMode.ALL));
        tvText2.setText(simplifySpanBuild2.build());


        SimplifySpanBuild simplifySpanBuild21 = new SimplifySpanBuild();
        simplifySpanBuild21.append(new SpecialTextUnit("居中").setTextSize(12).setGravity(tvText21, SpecialGravity.CENTER).setTextColor(Color.BLUE))
                .append("正常")
                .append(new SpecialTextUnit("顶部").setTextSize(12).setGravity(tvText21, SpecialGravity.TOP).setTextColor(0xFFFF5000))
                .append("正常")
                .append(new SpecialTextUnit("底部").setTextSize(12).setTextColor(0xFF8B658B));
        tvText21.setText(simplifySpanBuild21.build());


        SimplifySpanBuild simplifySpanBuild22 = new SimplifySpanBuild("正常底部正常居中正常顶部正常",
                new SpecialTextUnit("底部").setTextSize(30).setTextColor(Color.BLUE),
                new SpecialTextUnit("居中").setTextSize(30).setGravity(tvText22, SpecialGravity.CENTER).setTextColor(0xFFB03060),
                new SpecialTextUnit("顶部").setTextSize(30).setGravity(tvText22, SpecialGravity.TOP).setTextColor(0xFFB0C4DE));
        tvText22.setText(simplifySpanBuild22.build());


        SimplifySpanBuild simplifySpanBuild3 = new SimplifySpanBuild();
        simplifySpanBuild3.append(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.ic_bulletin), 50, 50).setGravity(SpecialGravity.CENTER))
                .append("正常")
                .append(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.test_img), 150, 150))
                .append("正常")
                .append(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravity.CENTER))
                .append("正常")
                .append(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravity.TOP))
                .append("正常")
                .append(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravity.BOTTOM));
        tvText3.setText(simplifySpanBuild3.build());


        int linkNorTextColor = 0xFF483D8B;
        int linkPressBgColor = 0xFF87CEFA;
        SimplifySpanBuild simplifySpanBuild4 = new SimplifySpanBuild();
        simplifySpanBuild4.append(new SpecialTextUnit("@英雄联盟", linkNorTextColor).setClickableUnit(new SpecialClickableUnit(tvText4, this).setPressBgColor(linkPressBgColor)))
                .append(" : ")
                .append(new SpecialTextUnit("#LOG夜话#", linkNorTextColor).setClickableUnit(new SpecialClickableUnit(tvText4, this).setPressBgColor(linkPressBgColor)))
                .append(new SpecialTextUnit("#LOL明星召唤师#", linkNorTextColor).setClickableUnit(new SpecialClickableUnit(tvText4, this).setPressBgColor(linkPressBgColor)))
                .append("星光熠熠的各赛区阵容、精彩的1V1Solo赛、克隆/双人共玩等奇葩套路层出不穷的花样对抗，你最期待看到哪位选手、哪种模式的对决？");
        simplifySpanBuild4.appendMultiClickable(new SpecialClickableUnit(tvText4, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor),
                " ",
                new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.timeline_card_small_video), 35, 35).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit("LOL新大战闻声识英雄 "));
        simplifySpanBuild4.append("完整文章见 ");
        simplifySpanBuild4.appendMultiClickable(new SpecialClickableUnit(tvText4, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor),
                new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.timeline_card_small_article), 30, 30).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit("LOL超强攻略,不见绝对后悔 "));
        simplifySpanBuild4.append(" 更多好玩的内容请点击 ");
        simplifySpanBuild4.appendMultiClickable(new SpecialClickableUnit(tvText4, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor).setNormalBgColor(0xFF875000),
                new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.timeline_card_small_web), 42, 42).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit("网页链接"));
        simplifySpanBuild4.append(" 已收录 ");
        simplifySpanBuild4.appendMultiClickable(new SpecialClickableUnit(tvText4, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor),
                " ",
                new SpecialLabelUnit("酷玩", 0xFF483D8B, sp2px(8), Color.TRANSPARENT).showBorder(0xFF483D8B, 2).setLabelBgRadius(8).setPadding(5).setPaddingLeft(8).setPaddingRight(10).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit(" LOL新闻库 "));
        simplifySpanBuild4.append(" 后面加的内容是为了凑字数的哈");
        tvText4.setText(simplifySpanBuild4.build());

        SimplifySpanBuild simplifySpanBuild41 = new SimplifySpanBuild();
        simplifySpanBuild41.append("无默认背景")
                .append(new SpecialTextUnit("点我点我1").setClickableUnit(new SpecialClickableUnit(tvText41, this).setPressBgColor(0xFFFF5000)).setTextColor(Color.BLUE))
                .append("无默认背景显示下划线")
                .append(new SpecialTextUnit("点我点我2").setClickableUnit(new SpecialClickableUnit(tvText41, this).showUnderline().setPressBgColor(0xFFFF5000).setPressTextColor(Color.WHITE)).setTextColor(0xFFFF5000))
                .append("有默认背景")
                .append(new SpecialTextUnit("点我点我3").setClickableUnit(new SpecialClickableUnit(tvText41, this).setPressBgColor(Color.BLUE).setPressTextColor(Color.WHITE)).setTextColor(0xFFFF5000).setTextBackgroundColor(0xFF87CEEB))
                .append("我只是个结尾");
        tvText41.setText(simplifySpanBuild41.build());

        TextView richTextView = (TextView) findViewById(R.id.rtv_conent);
        RichTextBean richTextBean = new RichTextBean();
        richTextBean.setTextcontent(mSource);
        SpecialUrlBean urlBean =new SpecialUrlBean();
        urlBean.setMainURL(mUrl);
        urlBean.setIconURL(mUrlIcon);
        urlBean.setURLName("百度链接");
        SpecialUrlBean urlBean2 =new SpecialUrlBean();
        urlBean2.setMainURL(mUrl2);
        urlBean2.setIconURL(mUrl2Icon);
        urlBean2.setBgNormalColor(0xAF98D9B6);
        urlBean2.setBgPressColor(Color.GREEN);
        urlBean2.setURLName("鲜网链接");
        richTextBean.getUrlHashMap().put(mUrl,urlBean);
        richTextBean.getUrlHashMap().put(mUrl2,urlBean2);
        RichTextViewHelper.setRichText(richTextView,richTextBean);
    }

    @Override
    public void onClick(TextView tv, String clickText) {
        Toast.makeText(MainActivity.this, "Click Text: " + clickText, Toast.LENGTH_SHORT).show();
    }

    private float sp2px(float spValue) {
        final float scale = getResources().getDisplayMetrics().scaledDensity;
        return spValue * scale;
    }
}
