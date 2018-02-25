package com.example.brd_e.a0xc4m3ra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;
import android.graphics.Color;
public class Generate extends AppCompatActivity {
    private static Random rand = new Random();
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        this.imageView = this.findViewById(R.id.imageView1);
        Button photoButton = this.findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            photo = photo.copy( Bitmap.Config.ARGB_8888 , true);
            int width = photo.getWidth();
            int height = photo.getHeight();
            int[] pixels = new int[width*height];
            photo.getPixels(pixels, 0, width, 0, 0, width, height);
            for(int p = 0; p < pixels.length; p++)
            {
                pixels[p] = Color.argb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
            }
            photo.setPixels(pixels, 0, width, 0, 0, width, height);
            imageView.setImageBitmap(photo);
        }

    }
}