package de.hsos.nelson.morais.project.prog3.demossamp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(this,new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart = findViewById(R.id.buttonStart);

        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);






        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGame();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        overridePendingTransition(0, 0);
    }

    public void openGame(){
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);

    }


}
