package paint.com.etc.lenovo.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PaintView extends View{
    Path mPath;
    Paint mPaint;
    final int VIEW_WIDTH = 1400;
    final int VIEW_HEIGHT = 1900;
    Bitmap mForeBitmap;
    Canvas mCanvas;
    float mX, mY;

    public PaintView(Context context, AttributeSet attr){
        super(context, attr);
        mForeBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mForeBitmap);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(12);
        mPaint.setARGB(100, 0 ,0 ,0);
        mPath = new Path();
    }
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mX = x;
                mY = y;
                mPaint.setStyle(Paint.Style.STROKE);
                mPath.reset();
                mPath.moveTo(x,y);
                RectF mRect = new RectF();
                mRect.set(x - 200, y - 200, x + 200, y + 200);
                mPath.addOval(mRect, Path.Direction.CW);
                mCanvas.drawPath(mPath,mPaint);
                break;
            case MotionEvent.ACTION_MOVE:
                if(Math.sqrt((x- mX)*(x- mX) + (y - mY)*(y - mY))>200) {
                    if(x > mX){
                        x = mX + 200 / (1 + ((y - mY)/(x - mX)) * ((y - mY)/(x - mX)));
                        y = mY + (x - mX) * (y - mY)/(x - mX);
                    }
                    if(x < mX){
                        x = mX - 200 / (1 + ((y - mY)/(x - mX)) * ((y - mY)/(x - mX)));
                        y = mY + (x - mX) * (y - mY)/(x - mX);
                    }
                    if(x == mX){
                        if(y > mY){
                            y = mY + 200;
                        }else{
                            y = mY - 200;
                        }
                    }

                }
                mPaint.setStyle(Paint.Style.FILL);
                mPath.reset();
                mPath.moveTo(x,y);
                RectF mRect2 = new RectF();
                mRect2.set(x - 100, y - 100, x + 100, y + 100);
                mPath.addOval(mRect2, Path.Direction.CW);
                break;
            case MotionEvent.ACTION_UP:
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                mCanvas.drawPaint(paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

                mPath.reset();
                mCanvas.drawPath(mPath,paint);

                invalidate();
        }
        invalidate();
        return true;
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mForeBitmap,0, 0, mPaint);
        canvas.drawPath(mPath, mPaint);
    }

}
