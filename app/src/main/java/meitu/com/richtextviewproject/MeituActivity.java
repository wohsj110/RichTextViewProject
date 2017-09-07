package meitu.com.richtextviewproject;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import meitu.com.mylibrary.simplifyspan.SimplifySpanBuild;
import meitu.com.mylibrary.simplifyspan.other.OnClickableSpanListener;
import meitu.com.mylibrary.simplifyspan.other.SpecialGravity;
import meitu.com.mylibrary.simplifyspan.unit.SpecialClickableUnit;
import meitu.com.mylibrary.simplifyspan.unit.SpecialImageUnit;
import meitu.com.mylibrary.simplifyspan.unit.SpecialTextUnit;
import meitu.com.richtextviewproject.Library.widget.RichTextBean;

import meitu.com.richtextviewproject.Library.widget.RichTextViewHelper;
import meitu.com.richtextviewproject.Library.widget.SpecialUrlBean;

public class MeituActivity extends AppCompatActivity implements OnClickableSpanListener {
    private TextView mTextView;
    private String mUrl = "https://www.baidu.com";
    private String mUrlIcon = "http://xianse.cc/upload/201410/1108211731.512x512.jpg";
    private String mUrl2 = "http://www.xianse.com";
    private String mUrl2Icon = "http://ico.ooopic.com/ajax/iconpng/?id=154282.png";

    private String mSource="新上宝贝，最潮明显同款大花长裙~\n@阿丁 买家晒图http://www.xianse.com里克哈善良的:#话题# 深刻的哈萨https://www.baidu.com\n哒哒哒四大可好看了哈了";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meitu);
        mTextView = (TextView) findViewById(R.id.tv_meitu);
        setRichText();
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
        //richTextView.setRichText(mSource);


    }
    private void setRichText() {
        int linkNorTextColor = 0xFF483D8B;
        int linkPressBgColor = 0xFF87CEFA;
        int linkNormalBgColor = 0xFF83B5ED;
        SimplifySpanBuild simplifySpanBuild4 = new SimplifySpanBuild();
        simplifySpanBuild4.append(new SpecialTextUnit("@英雄联盟", linkNorTextColor).setClickableUnit(new SpecialClickableUnit(mTextView, this).setPressBgColor(Color.TRANSPARENT)))
                .append(" : ")
                .append(new SpecialTextUnit("#LOG夜话#", linkNorTextColor).setClickableUnit(new SpecialClickableUnit(mTextView, this)))
                .append("想提前看更新的内容情点击链接");
        simplifySpanBuild4.appendMultiClickable(new SpecialClickableUnit(mTextView, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor),
                "\n",
                new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.timeline_card_small_video), 35, 35).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit("LOL新大战闻声识英雄 "));
        simplifySpanBuild4.append("完整文章见 ");

        simplifySpanBuild4.appendMultiClickable(new SpecialClickableUnit(mTextView, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor).setNormalBgColor(linkNormalBgColor),
                new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.timeline_card_small_web), 42, 42).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit("网页链接"));
        simplifySpanBuild4.append(" 凑数字");
        mTextView.setText(simplifySpanBuild4.build());
        mTextView.setTextColor(Color.YELLOW);
        mTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MeituActivity.this, "Long Click Text: " + "长点击", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private float sp2px(float spValue) {
        final float scale = getResources().getDisplayMetrics().scaledDensity;
        return spValue * scale;
    }

    @Override
    public void onClick(TextView tv, String clickText) {
        Toast.makeText(MeituActivity.this, "Click Text: " + clickText, Toast.LENGTH_SHORT).show();
    }
}
