package com.example.asus.audiodemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    public void play(View view)
    {
//        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.demoaudio);

        mediaPlayer.start();

    }

    public void pause(View view)
    {


        mediaPlayer.pause();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.demoaudio);
        audioManager=(AudioManager)getSystemService(AUDIO_SERVICE);
        int maxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        mediaPlayer=MediaPlayer.create(this,R.raw.demoaudio);
//        mediaPlayer.start();

        SeekBar volumeSeekBar=(SeekBar)findViewById(R.id.volumeSeekBar);
        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setProgress(currentVolume);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("Value",Integer.toString(progress));

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar scrubSeekBar=(SeekBar)findViewById(R.id.scrubSeekBar);
        scrubSeekBar.setMax(mediaPlayer.getDuration());
        scrubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Scrub seeker moved!",Integer.toString(progress));
                mediaPlayer.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                    mediaPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.start();
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,100);

    }
}
