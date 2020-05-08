package de.hsos.nelson.morais.ab04.helloworld;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;
    private int breite = 800;
    private int hoehe = 800;
    private final int textsize = 50;
    private Timer timer = new Timer();
    private int grenzeLinks = 10;
    private int grenzeRechts = 200;
    private int grenzenOben = 600;
    private int grenzenUnten = 750;


    private int ballRadius = 20;
    private float ballX = 100f;
    private float ballY = 700f;
    private float velociteX = 0.3f;
    private float velociteY = 4.5f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bitmap = Bitmap.createBitmap(this.breite, this.hoehe, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(this);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();
        setContentView(imageView);
        this.canvas.drawColor(Color.argb(255, 0, 0, 255));
        this.paint.setTextSize(textsize);
        this.helloWelt();
        this.helloNachbar("Hallo Nachbar", 150);
        this.zeichneSmiley(200);
        this.timer.schedule(new TimerTask() {

            @Override
            public void run() {
                derSpringendePunkt();
            }
        }, 0, 17);
    }

    private void helloWelt() {
        String text = "Hallo Welt!";
        float textWidth = this.paint.measureText(text);
        this.paint.setColor(Color.WHITE);
        ;
        this.canvas.drawText(text, breite / 2 - textWidth / 2, 100, this.paint);
    }

    private void textZentrieren(String text, int y) {
        float textWidth = this.paint.measureText(text);
        this.paint.setColor(Color.WHITE);
        this.canvas.drawText(text, breite / 2 - textWidth / 2, y, this.paint);
    }

    private void helloNachbar(String text, int pos) {
        textZentrieren(text, pos);
    }

    public void zeichneSmiley(int radius) {
        this.paint.setColor(Color.YELLOW);
        this.canvas.drawCircle(breite / 2, 500, radius, paint);
        this.paint.setColor(Color.WHITE);
        this.canvas.drawCircle((breite / 2 - radius / 2) - 10, 450, 35, paint);

        this.paint.setColor(Color.BLACK);
        this.canvas.drawCircle((breite / 2 - radius / 2), 450, 25, paint);

        this.paint.setColor(Color.WHITE);
        this.canvas.drawCircle((breite / 2 + radius / 2) + 10, 450, 35, paint);

        this.paint.setColor(Color.BLACK);
        this.canvas.drawCircle((breite / 2 + radius / 2), 450, 25, paint);

        this.canvas.drawLine((breite / 2 - radius / 3), 600, (breite / 2 + radius / 3), 600, paint);
        this.canvas.drawLine((breite / 2 - radius / 3), 601, (breite / 2 + radius / 3), 601, paint);
        this.canvas.drawLine((breite / 2 - radius / 3), 602, (breite / 2 + radius / 3), 601, paint);

        this.canvas.drawLine((breite / 2 - radius / 3), 600, (breite / 2 - radius / 2), 550, paint);
        this.canvas.drawLine((breite / 2 + radius / 3), 600, (breite / 2 + radius / 2), 550, paint);
    }


    private void derSpringendePunkt() {

        this.paint.setColor(Color.BLUE);
        this.canvas.drawCircle(ballX,ballY,this.ballRadius,paint);
        this.ballX = this.ballX+velociteX;
        this.ballY = this.ballY+velociteY;

        this.paint.setColor(Color.RED);
        this.canvas.drawCircle(ballX,ballY,this.ballRadius,paint);

        if(ballX < grenzeLinks){
            velociteX = velociteX*-1;
        }
        if(ballX > grenzeRechts){
            velociteX = velociteX*-1;
        }
        if(ballY < grenzenOben){
            velociteY = velociteY*-1;
        }
        if(ballY > grenzenUnten){
            velociteY = velociteY*-1;
        }

        this.imageView.invalidate();

    }
}
