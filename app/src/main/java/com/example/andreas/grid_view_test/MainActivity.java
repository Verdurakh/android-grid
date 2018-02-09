package com.example.andreas.grid_view_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Button> btns = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridLayout grid = findViewById(R.id.grid);


        for (int i = 1; i <= 10; i++) {
            int id = getResources().getIdentifier("btn" + i, "id", getPackageName());
            Button btn = findViewById(id);
            btns.add(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid.removeView(view);
                }
            });
        }


        Button reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid.removeAllViews();
                for (int i = 0; i < 10; i++) {
                    grid.addView(btns.get(i));
                }
            }
        });

    }
}
