package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    private Button zoominButton;
    private Button zoomoutButton;
    private Button rotateButton;
    private Button bounceButton;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zoominButton = findViewById(R.id.zoominButton);
        zoomoutButton = findViewById(R.id.zoomoutButton);
        rotateButton = findViewById(R.id.rotateButton);
        bounceButton = findViewById(R.id.bounceButton);
        imageView = findViewById(R.id.imageView);

        bounceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(view.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
                imageView.startAnimation(animation);
            }
        });
        zoominButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(view.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoomout);
                imageView.startAnimation(animation);
            }
        });
        zoomoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(view.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoomin);
                imageView.startAnimation(animation);
            }
        });
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(view.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                imageView.startAnimation(animation);
            }
        });
    }
}
