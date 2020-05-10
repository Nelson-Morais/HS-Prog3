package de.hsos.nelson.morais.project.prog3.demodb;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button buttonHighscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        buttonHighscore = findViewById(R.id.highscoreButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        buttonHighscore.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                openHighscore();
            }        } );
    }

    public void openActivity2(){
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }

    public void openHighscore(){
        Intent intent = new Intent(this,HighscoreActivity.class);
        startActivity(intent);
    }
}
