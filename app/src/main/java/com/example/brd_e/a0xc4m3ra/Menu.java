package com.example.brd_e.a0xc4m3ra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btn1 = findViewById(R.id.test);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, BackgroundTest.class));
            }
        });
        Button btn2 = findViewById(R.id.lumin);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Lumen.class));
            }
        });
        Button btn3 = findViewById(R.id.random);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Rando.class));
            }
        });

        Button btn4 = findViewById(R.id.everyNth);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, NthPixel.class));
            }
        });
        Button btn5 = findViewById(R.id.generate);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Generate.class));
            }
        });

        Button btn6 = findViewById(R.id.rgb);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, RGB.class));
            }
        });

        Button btn7 = findViewById(R.id.nthsort);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, nthsort.class));
            }
        });
    }

}
