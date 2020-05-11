package de.hsos.nelson.morais.project.prog3.demodb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private TextView nicknameInput, gameInput, highscoreInput;
    private Button submitButton;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nicknameInput = (TextView)findViewById(R.id.nicknameInput);
        gameInput = (TextView) findViewById(R.id.gameInput);
        highscoreInput = (TextView) findViewById(R.id.highscoreInput);
        submitButton = (Button)findViewById(R.id.submitButton);

        db = new DatabaseHelper(this);

        submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                boolean isInserted =  db.insertData(nicknameInput.getText().toString(),gameInput.getText().toString(),Integer.valueOf(highscoreInput.getText().toString()));
                if(isInserted){
                    Toast.makeText(Activity2.this,"Values added to Database", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Activity2.this,"Values NOT added to Database", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
