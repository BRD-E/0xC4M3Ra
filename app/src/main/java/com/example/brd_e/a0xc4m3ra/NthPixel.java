package com.example.brd_e.a0xc4m3ra;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Random;

public class NthPixel extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private EditText text;
    private static Random rand = new Random();
    private static String offset;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nth_pixel);
        this.imageView = this.findViewById(R.id.imageView1);
        text = findViewById(R.id.nth);
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

            photo.setPixels(everyNthPixel(pixels), 0, width, 0, 0, width, height);
            imageView.setImageBitmap(photo);
        }
    }

    public int[] everyNthPixel(int[] pixels)
    {
        String num = text.getText().toString();
        int offset = Integer.parseInt(num);
        int length = pixels.length / (offset -1) + 1;
        int [] offsetArray = new int[length];
        int index = 0;
        for(int i = 0; i < pixels.length-offset;i += offset)
        {
            offsetArray[index++] = pixels[i];
        }
        offsetArray = randomizer(offsetArray);
        for(int i = 0; i < pixels.length-offset;i += offset)
        {
            pixels[i] = offsetArray[--index];
        }
        return pixels;
    }
    public int[] randomizer(int[] pixels)
    {
        int length = pixels.length;
        int color;
        int index;
        for(int p = 0; p < length; p++)
        {
            color = pixels[p];
            index = rand.nextInt(length);
            pixels[p] = pixels[index];
            pixels[index] = color;

        }
        return pixels;
    }

}