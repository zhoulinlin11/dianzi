package com.example.asus.caojiyang20180521.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.asus.caojiyang20180521.R;

public class WebActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        //视频播放页面
        initView();
        //获取传过来的值
        Intent intent = getIntent();
        String vvv = intent.getStringExtra("vvv");
        //网络加载视频
        Uri uri = Uri.parse( vvv );
        videoView = (VideoView)this.findViewById(R.id.videoView );

        //设置视频控制器
        videoView.setMediaController(new MediaController(this));

        //播放完成回调
        videoView.setOnCompletionListener( new MyPlayerOnCompletionListener());

        //设置视频路径
        videoView.setVideoURI(uri);

        //开始播放视频
        videoView.start();
    }


    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
    }
    //回调方法
    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( WebActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }
}
