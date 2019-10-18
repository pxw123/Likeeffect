package com.example.bannerdemoa.vg;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kaisengao.likeview.like.KsgLikeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private KsgLikeView mLikeView;

    private Button mMore;


    Handler mhandler=new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        mLikeView = findViewById(R.id.live_view);
        findViewById(R.id.live_view_single).setOnClickListener(this);
        mMore=findViewById(R.id.live_view_more);
        mMore .setOnClickListener(this);

        mLikeView.addLikeImage(R.drawable.heart0);
        mLikeView.addLikeImage(R.drawable.heart1);
        mLikeView.addLikeImage(R.drawable.heart2);
        mLikeView.addLikeImage(R.drawable.heart3);
        mLikeView.addLikeImage(R.drawable.heart4);
        mLikeView.addLikeImage(R.drawable.heart5);
        mLikeView.addLikeImage(R.drawable.heart6);
        mLikeView.addLikeImage(R.drawable.heart7);
        mLikeView.addLikeImage(R.drawable.heart8);



    }

        @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.live_view_single:

                mLikeView.addFavor();

                break;

            case R.id.live_view_more:

                boolean selected = mMore.isSelected();

                if (selected){
                     mhandler.removeCallbacks(runnable);
                }else {
                    mhandler.postDelayed(runnable,100);
                }

                mMore.setSelected(!selected);
                break;

                default:
                    break;
        }
    }

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            mLikeView.addFavor();

            mhandler.postDelayed(runnable,100);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mhandler.removeCallbacks(runnable);
    }
}
