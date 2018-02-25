package com.example.brd_e.a0xc4m3ra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Rando extends AppCompatActivity {
    private static Random rand = new Random();
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
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
            int[] pixels = new int[width*height];             //initializing the array for the image size
            photo.getPixels(pixels, 0, width, 0, 0, width, height);   //copy pixel data from the Bitmap into the 'intArray' array
            photo.setPixels(randomizer(pixels), 0, width, 0, 0, width, height);
            imageView.setImageBitmap(photo);
        }

    }
    public int[] randomizer(int[] pixels){
        return pixels;
    }


}