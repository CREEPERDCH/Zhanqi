package top.creeperdch.zhanqitv.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import top.creeperdch.zhanqitv.R;

public class SplashActivity extends BaseActivity {

    private LinearLayout mSplash_ll;
    private AlphaAnimation mAa2;

    // 启动页全屏处理
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initAnim();
    }

    @Override
    protected void initView() {
        mSplash_ll = findViewById(R.id.splash_ll);
    }

    private void initAnim() {
        AlphaAnimation aa1 = new AlphaAnimation(0.0f, 1.0f);
        aa1.setDuration(2000);
        aa1.setFillAfter(true);
        mAa2 = new AlphaAnimation(1.0f, 0.0f);
        mAa2.setDuration(2000);
        mAa2.setFillAfter(true);
        mSplash_ll.startAnimation(aa1);
        aa1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mSplash_ll.startAnimation(mAa2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mAa2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                // todo 下边的Activity跳转动画没有测试
                overridePendingTransition(R.anim.enter_anim, 0);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
