package meitu.com.richtextviewproject;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import meitu.com.mylibrary.quickspan.QuickSpanBuild;
import meitu.com.mylibrary.quickspan.other.OnClickableSpanListener;
import meitu.com.mylibrary.quickspan.other.SpecialConvertMode;
import meitu.com.mylibrary.quickspan.other.SpecialGravity;
import meitu.com.mylibrary.quickspan.unit.SpecialClickableUnit;
import meitu.com.mylibrary.quickspan.unit.SpecialImageUnit;
import meitu.com.mylibrary.quickspan.unit.SpecialLabelUnit;
import meitu.com.mylibrary.quickspan.unit.SpecialTextUnit;
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
