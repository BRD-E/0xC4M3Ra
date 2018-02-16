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
            int color;
            int a;
            int r;
            int g;
            int b;
            int width = photo.getWidth();
            int height = photo.getHeight();
            int[] pixels1 = new int[width*height];
            int[] pixels2 = new int[width*height];
            for(int x = 0; x < width;x++)
            {
                for(int y = 0; y < height; y++)
                {
                    color = photo.getPixel(x,y);
                    a = Color.alpha(color);
                    r = Color.red(color);
                    g = Color.green(color);
                    b = Color.blue(color);
                    pixels1[x*height+y] = (int) Math.sqrt(0.299 * r*r + 0.587 * g*g + 0.114 * b*b);
                    pixels2[x*height+y] = color;

                }
            }
            Object[] test = SelectionSort(pixels1,pixels2);
            photo.setPixels(pixels2, 0, width, 0, 0, width, height);
            imageView.setImageBitmap(photo);
        }
    }

    public static Object[] SelectionSort(int[] arr, int arr2[]){

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;

            int smallerNumber2 = arr2[index];
            arr2[index] = arr2[i];
            arr2[i] = smallerNumber2;
        }
        return new Object[] {arr, arr2};
    }

}