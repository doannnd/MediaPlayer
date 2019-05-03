package com.nguyendinhdoan.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.dung);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                    player = null;
                    Toast.makeText(MainActivity.this, "Media realse", Toast.LENGTH_SHORT).show();
                }
            });
        }
        player.start();
    }


    public void pause(View view) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View view) {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "Media realse", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.release();
        player = null;
        Toast.makeText(this, "Media realse", Toast.LENGTH_SHORT).show();
    }
}
