package com.example.fbprofilelayout;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends Activity {
    ImageView imageView;
    RoundImage roudndImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.rounldImage);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.avatar_image);
        roudndImage = new RoundImage(bitmap);
        imageView.setImageDrawable(roudndImage);
    }
}
