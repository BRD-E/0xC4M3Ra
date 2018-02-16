package com.example.brd_e.a0xc4m3ra;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.os.Bundle;
import android.util.Log;
import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

public class BackgroundTest extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_test);
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
            int color = photo.getPixel(0,0);
            int a = Color.alpha(color);
            int r = Color.red(color);
            int g = Color.green(color);
            int b = Color.blue(color);
            for(int x = 0; x < width;x++)
            {
                for(int y = 0; y < height; y++)
                {
                    photo.setPixel(x,y, Color.CYAN);
                }
            }
            color = photo.getPixel(0,0);
            a = Color.alpha(color);
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            Log.i("test","a: " + a + ",r: " + r + ",b: " + b + ",g: " + g);
            imageView.setImageBitmap(photo);
        }
    }
}