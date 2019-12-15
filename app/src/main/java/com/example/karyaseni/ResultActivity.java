package com.example.karyaseni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {
    public static final String EXTRA_RESULT = "extra_image_result";
    ImageView preview;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        preview = findViewById(R.id.imagePreview);
        backButton = findViewById(R.id.btnBack);

        if(getIntent().hasExtra(EXTRA_RESULT)){
            Bitmap bitmap = getIntent().getParcelableExtra(EXTRA_RESULT);
            preview.setImageBitmap(bitmap);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(i);
            }
        });
    }
}
