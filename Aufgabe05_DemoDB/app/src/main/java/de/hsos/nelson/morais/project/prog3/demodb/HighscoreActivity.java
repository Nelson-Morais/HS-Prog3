package de.hsos.nelson.morais.project.prog3.demodb;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;



public class HighscoreActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    ScrollView sv;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        sv = (ScrollView) findViewById(R.id.scrollView_hs);
        myDb = new DatabaseHelper(this);
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            Toast.makeText(HighscoreActivity.this, "No Items in Database.", Toast.LENGTH_SHORT).show();
            return;
        }
        tv=(TextView)findViewById(R.id.textView_hs);

        while (res.moveToNext()) {
            tv.append("Nickname: " + res.getString(0) + "\n");
            tv.append("Game: " + res.getString(1) + "\n");
            tv.append("Score: " + res.getInt(2) + "\n\n");
        }

    }

}
