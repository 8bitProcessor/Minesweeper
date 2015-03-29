
package com.example.qbit.minesweeper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by qbit on 27/03/15.
 */
public class CustomView extends View {
    private static final int mine=3;



    private Paint black, grey, white, blue, green, yellow, red;
    private Rect square;
    private int[][] gameTable;
    private boolean touches[];
    private float touchx[];
    private float touchy[];
    private int first;
    private boolean touch;
    private int cell;
    private int heightWidth;
    public CustomView(Context context) {
        super(context);
        init();
    }
    public CustomView(Context context, AttributeSet as){
        super(context, as);
        init();
    }
    public CustomView(Context c, AttributeSet as, int default_style) {
        super(c, as, default_style);
        init();
    }
    private void init(){
        //initializing colours
        black = new Paint(Paint.ANTI_ALIAS_FLAG);
        black.setStyle(Paint.Style.FILL_AND_STROKE);
        grey = new Paint(Paint.ANTI_ALIAS_FLAG);
        white = new Paint(Paint.ANTI_ALIAS_FLAG);
        white.setStyle(Paint.Style.STROKE);
        white.setStrokeWidth((float) 2.0);
        blue = new Paint(Paint.ANTI_ALIAS_FLAG);
        green = new Paint(Paint.ANTI_ALIAS_FLAG);
        yellow = new Paint(Paint.ANTI_ALIAS_FLAG);
        red = new Paint(Paint.ANTI_ALIAS_FLAG);
        black.setColor(0xff000000);
        grey.setColor(0xff888888);
        white.setColor(0xffffffff);
        blue.setColor(0xff0000ff);
        green.setColor(0xff00ff00);
        yellow.setColor(0xffffff00);
        red.setColor(0xFFFF0000);

    }
    //On measure method to calculate the size of the square
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = width > height ? height : width;
        setMeasuredDimension(size, size);
        cell = size/10;
        heightWidth = height;

    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for (int x=0; x<10; x++){
            for (int i=0; i<10; i++){
                canvas.save();
                canvas.translate(cell*x,cell*i);
                canvas.drawRect(new Rect(0,0, cell,cell),black);
                canvas.drawRect(new Rect(0,0, cell,cell),white);
                canvas.restore();
            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
    public void resetGame(){
        gameTable = new int[10][10];
        for (int i=0; i<20; i++){
            Random rand = new Random();
            
        }





    }

}