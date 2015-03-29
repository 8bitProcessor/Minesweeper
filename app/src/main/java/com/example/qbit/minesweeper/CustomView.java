
package com.example.qbit.minesweeper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by qbit on 27/03/15.
 */
public class CustomView extends View {
    private Paint black, grey, white, blue, green, yellow, red;
    private Rect square;
    private int[][] gameTable;
    private boolean touches[];
    private float touchx[];
    private float touchy[];
    private int first;
    private boolean touch;
    private double cellwidth,cellheight;
    private int viewHeight, viewWidth;
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
        square = new Rect(-100,-100,100,100);
    }
    //On measure method to calculate the size of the square
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int desiredWidth = 300;
        int desiredHeight = 300;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int height;
        int width;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;

        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }
        cellwidth= widthSize/10;
        cellheight=heightSize/10;
        viewHeight= height;
        viewWidth = width;
        setMeasuredDimension(width, height);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int cw = (int)Math.floor(cellwidth);
        int ch= (int)Math.floor(cellheight);
        int offsetX =(viewWidth - cw*10)/2;
        int offsetY = (viewHeight - ch*10)/2;
        for (int x=0; x<10; x++){
            for (int i=0; i<10; i++){
                int dx = x*cw+offsetX;
                int dy= i*ch+offsetY;
                canvas.drawRect(new Rect(dx+1,dy+1, dx+cw-2,dy+ch-2),black);
            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
    public void resetGame(){






    }

}