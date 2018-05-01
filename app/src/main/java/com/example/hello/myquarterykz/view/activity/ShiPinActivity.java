package com.example.hello.myquarterykz.view.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.application.WieApplication;
import com.example.hello.myquarterykz.model.bean.ShiPinXiangQingBean;
import com.example.hello.myquarterykz.presenter.Presenter;
import com.example.hello.myquarterykz.util.ApiUrl;
import com.example.hello.myquarterykz.util.DivergeViewSecond;
import com.example.hello.myquarterykz.util.RetrofitUtil;
import com.example.hello.myquarterykz.util.ShareUtil;
import com.example.hello.myquarterykz.view.iview.MyView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayerStandard;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;
import okhttp3.ResponseBody;

public class ShiPinActivity extends AppCompatActivity implements MyView {
    @BindView(R.id.image_fanhui)
    ImageView imageFanhui;
    @BindView(R.id.image_xin)
    ImageView imageXin;
    @BindView(R.id.image_lie)
    ImageView imageLie;
    @BindView(R.id.image_fenxiang)
    ImageView imageFenxiang;
    @BindView(R.id.sdv_yuan)
    SimpleDraweeView sdvYuan;
    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard videoplayer;
    @BindView(R.id.text_workDesc)
    TextView textWorkDesc;
    @BindView(R.id.text_qiang)
    TextView textQiang;
    @BindView(R.id.text_playNum)
    TextView textPlayNum;
    @BindView(R.id.divergeView)
    DivergeViewSecond mDivergeView;
    @BindView(R.id.danmaku_view)
    DanmakuView danmakuView;
    @BindView(R.id.bt_t)
    Switch t;
//    @BindView(R.id.bt_add)
//    Button bt;
//    @BindView(R.id.bt_kai)
//    Button kai;
//    @BindView(R.id.bt_guan)
//    ImageView guan;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.operation_layout)
    LinearLayout operationLayout;
    private DanmakuContext danmakuContext;
    @BindView(R.id.i)
    ImageView i;
    private boolean showDanmaku;
    private boolean kaiguan;
    private BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };
    private Presenter presenter;
    private List<Bitmap> mList = new ArrayList<Bitmap>();
    private int mIndex = 0;
    private int theme = R.style.AppTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if(savedInstanceState != null){
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        setContentView(R.layout.activity_shi_pin);
        ButterKnife.bind(this);
        Log.d("throw", "+++++++++++++++++++++++++++++++++++视频:");
        String url = getIntent().getStringExtra("url");
        presenter = new Presenter(this);
        presenter.attachView(this);
        Map<String, String> map = new HashMap<>();
        map.put("wid", url);
        presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl
                .SHIPINREMENXIANGQING_URL, map));
        danmu();
        kaiguan=false;
        initWidthAndHeight();
        danmakuView.pause();
        danmakuView.setVisibility(View.GONE);
        t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    danmakuView.resume();
                danmakuView.setVisibility(View.VISIBLE);
                }else {
                    danmakuView.pause();
                    danmakuView.setVisibility(View.GONE);
                }

            }
        });
    }
    //弹幕
    private void danmu() {
        danmakuView.enableDanmakuDrawingCache(true);



        danmakuView.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                showDanmaku = true;
                danmakuView.start();
                generateSomeDanmaku();
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {

            }
        });
        danmakuContext = DanmakuContext.create();
        danmakuView.prepare(parser, danmakuContext);
        danmakuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operationLayout.getVisibility() == View.GONE) {
                    operationLayout.setVisibility(View.VISIBLE);
                } else {
                    operationLayout.setVisibility(View.GONE);
                }
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = editText.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    addDanmaku(content, true);
                    editText.setText("");
                }
            }
        });
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener (new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == View.SYSTEM_UI_FLAG_VISIBLE) {
                    onWindowFocusChanged(true);
                }
            }
        });


    }
    private void addDanmaku(String content, boolean withBorder) {
        BaseDanmaku danmaku = danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        danmaku.text = content;
        danmaku.padding = 5;
        danmaku.textSize = sp2px(20);
        danmaku.textColor = Color.WHITE;
        danmaku.setTime(danmakuView.getCurrentTime());
        if (withBorder) {
            danmaku.borderColor = Color.GREEN;
        }
        danmakuView.addDanmaku(danmaku);
    }

    /**
     * 随机生成一些弹幕内容以供测试
     */
    private void generateSomeDanmaku() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(showDanmaku) {
                    int time = new Random().nextInt(300);
                    String content = "" + time + time;
                    addDanmaku(content, false);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * sp转px的方法。
     */
    public int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (danmakuView != null && danmakuView.isPrepared()) {
            danmakuView.pause();
        }
    }





    private void initWidthAndHeight() {
        int deviceHeight = WieApplication.getDeviceHeight();
        int deviceWidth = WieApplication.getDeviceWidth();
        if (deviceHeight == 1920 && deviceWidth == 1080) {
            //标准的手机 不需要计算
            return;
        } else {
            //计算每一个需要微调控件的宽度和高度 并设置给该控件
            //一般match_parent和wrap_content不需要计算
            //计算的是布局文件写死的哪些dp值

            //根据标准app的标注计算出实际像素值---540/1080
            int width_text_01 = (int) (540 * deviceWidth / 1080 + 0.5);
            int height_text_01 = (int) (150 * deviceHeight / 1920 + 0.5);

            //把计算的宽度和高度给text_01使用代码设置上

        }
    }

    @Override
    public void getResponse(ResponseBody responseBody) {
        try {
            ShiPinXiangQingBean shiPinXiangQingBean = new Gson()
                    .fromJson(responseBody.string(), ShiPinXiangQingBean.class);
            ShiPinXiangQingBean.DataBean data = shiPinXiangQingBean.getData();
            videoplayer.setUp(data.getVideoUrl(), JZVideoPlayerStandard
                    .SCREEN_WINDOW_NORMAL, data.getWorkDesc());
            Glide.with(this).load(data.getCover())
                    .into(videoplayer.thumbImageView);
            textWorkDesc.setText(data.getWorkDesc());
            textPlayNum.setText(data.getPlayNum() + "次播放");
            sdvYuan.setImageURI(data.getUser().getIcon());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getResponseBodyBean(ResponseBody responseBody) {

    }

    @Override
    public void getError(Throwable throwable) {

    }

    @OnClick({R.id.image_fanhui, R.id.image_xin, R.id.image_lie, R.id.image_fenxiang, R.id.sdv_yuan,R.id.bt_t})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_fanhui:
                finish();
                break;
            case R.id.image_xin:
                imageXin.setImageResource(R.drawable.guanzhudian);
                imageLie.setImageResource(R.drawable.raw_1499933217);
                if (mIndex == 8) {
                    mIndex = 0;
                }
                mDivergeView.startDiverges(mIndex);
                mIndex++;
                break;
            case R.id.image_lie:

                imageXin.setImageResource(R.drawable.raw_1499933216);
                imageLie.setImageResource(R.drawable.xinsui);

                break;
            case R.id.image_fenxiang:
                ShareUtil.shareWeb(this, "http://www.baidu.com"
                        , "这就是标题", "这就是描述"
                        , "http://img1.imgtn.bdimg.com/it/u=2764371306,3467823016&fm=214&gp=0.jpg"
                        , R.mipmap.ic_launcher, SHARE_MEDIA.QQ);
                break;
            case R.id.sdv_yuan:

                break;
//            case R.id.bt_add:
//                //弹
//                danmakuView.resume();
//                danmakuView.setVisibility(View.VISIBLE);
//                break;
//            case R.id.bt_t:
//                //不弹
//                if ()
//                danmakuView.pause();
//                danmakuView.setVisibility(View.GONE);
//                break;
//            case R.id.bt_kai:
//                videoplayer.startButton.performClick();
//                break;
//            case R.id.bt_guan:
//                if (kaiguan==false){
//                    danmakuView.resume();
//                    videoplayer.releaseAllVideos();
//                    guan.setImageResource(R.drawable.play);
//                     kaiguan=true;
//                }else {
//                    danmakuView.pause();
//                    videoplayer.startButton.performClick();
//                    guan.setImageResource(R.drawable.pause);
//
//                    kaiguan=false;
//                }
//
//                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        mList = new ArrayList<>();
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a1, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a2, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a3, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a4, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a5, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a6, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a7, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a8, null)).getBitmap());
        mDivergeView.post(new Runnable() {
            @Override
            public void run() {
                mDivergeView.setEndPoint(new PointF(mDivergeView.getMeasuredWidth() / 2, 0));
                mDivergeView.setDivergeViewProvider(new Provider());
            }
        });
        if (danmakuView != null && danmakuView.isPrepared() && danmakuView.isPaused()) {
            danmakuView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mList != null) {
            mList.clear();
            mList = null;
        }
        showDanmaku = false;
        if (danmakuView != null) {
            danmakuView.release();
            danmakuView = null;
        }

    }

    class Provider implements DivergeViewSecond.DivergeViewProvider {

        @Override
        public Bitmap getBitmap(Object obj) {
            return mList == null ? null : mList.get((int) obj);
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme", theme);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");
    }
}
