package de.hsos.nelson.morais.project.prog3.demossamp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.util.DisplayMetrics;
import android.view.View;

public class GameView extends View {
    private Bitmap form,form2,form3,form4, backgroundImage, gamefield, scoreStar;

    private int formX;
    private int formY;
    private int formSpeed;
    private int canvasWidth, canvasHeight;
    private int formWidth = 40;
    private int formHeight = 40;
    private Paint scorePaint = new Paint();
    private int startY,drawY;



    MediaPlayer mediaPlayer;


    public GameView(Context context) {
        super(context);



        DisplayMetrics dpm = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(dpm);

        form = BitmapFactory.decodeResource(getResources(), R.drawable.square);
        form = Bitmap.createScaledBitmap(form, formWidth, formHeight, false);




        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background_main);

        gamefield = BitmapFactory.decodeResource(getResources(), R.drawable.gamefield);
        gamefield = Bitmap.createScaledBitmap(gamefield,dpm.widthPixels/2, dpm.heightPixels/2,false);

        scoreStar = BitmapFactory.decodeResource(getResources(), R.drawable.scorestar);
        scoreStar = Bitmap.createScaledBitmap(scoreStar,dpm.widthPixels/10,dpm.widthPixels/10,false);


        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(50);
        scorePaint.setTypeface(Typeface.DEFAULT);
        scorePaint.setAntiAlias(true);







        formY = (dpm.heightPixels/2)/3;
        formX = (getScreenWidth() / 2) - (form.getWidth() / 2);
        startY = (dpm.heightPixels/2)/3;
        drawY = (dpm.heightPixels/2)/3;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        //Background Draw
        backgroundImage = Bitmap.createScaledBitmap(backgroundImage, canvasWidth, canvasHeight, false);
        Rect frameToDrawBG = new Rect(0, 0, backgroundImage.getWidth(), backgroundImage.getHeight());
        RectF whereToDrawBG = new RectF(0, 0, canvasWidth, canvasHeight);
        canvas.drawBitmap(backgroundImage, frameToDrawBG, whereToDrawBG, null);

        //Gamefield Draw
        canvas.drawBitmap(gamefield, (canvasWidth/2)/2,(canvasHeight/2)/3 , null);

        //Form Draw and Fall
        formY = formY + formSpeed;
        formSpeed = 1;
        if (formSpeed > 10) {
            formSpeed = 10;
        }
        if (formY+formHeight >= ((canvasHeight/2)/3)+gamefield.getHeight()) {
            formY = (canvasHeight/2)/3;
            startY = (canvasHeight/2)/3;
        }




        if(formY >= startY+formHeight) {
            canvas.drawBitmap(form, formX, formY, null);
            canvas.drawBitmap(form, formX+formWidth, formY, null);
            canvas.drawBitmap(form, formX+(formWidth*2), formY, null);
            canvas.drawBitmap(form, formX+(formWidth*2), formY-formHeight, null);
            startY = startY+formHeight;
            drawY = formY;
        }else{
            canvas.drawBitmap(form, formX+formWidth, drawY, null);
            canvas.drawBitmap(form, formX+(formWidth*2), drawY, null);
            canvas.drawBitmap(form, formX+(formWidth*2), drawY-formHeight, null);
            canvas.drawBitmap(form,formX,drawY,null);
        }





        //Score
        canvas.drawBitmap(scoreStar, canvasWidth/20,canvasHeight/20,null);
        canvas.drawText("1232", canvasWidth/6,canvasHeight/11, scorePaint);
    //    canvas.drawBitmap(life[0], 580, 10, null);
     //   canvas.drawBitmap(life[1], 680, 10, null);

    }


}
