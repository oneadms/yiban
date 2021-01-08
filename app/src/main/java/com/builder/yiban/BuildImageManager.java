package com.builder.yiban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.FileNotFoundException;

public class BuildImageManager {

    private static String name;
    private static String studnetID;
    private static String reason;
    private static String date;
    private static Canvas canvas;
    private static Paint paint;

    public static Canvas getCanvas() {
        return canvas;
    }

    public static void build(Context context, ImageDetails imageDetails) {
        name = imageDetails.getName();
        studnetID = imageDetails.getStudnetID();
        reason = imageDetails.getReason();
        date = imageDetails.getDate();


        paint = new Paint();
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inMutable = true;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.yt,opt);



        canvas = new Canvas(bitmap);
        paint.setColor(Color.WHITE);
        paint.setTextSize(45);
        canvas.drawText(name+"的进出校门申请",200,172,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(45);
        canvas.drawText(name+"的进出校门申请",270,313,paint);
        paint.setTextSize(38);
        canvas.drawText(name+"("+studnetID+")",280,560,paint);
        paint.setTextSize(36);
        canvas.drawText(reason, 280, 1030, paint);
        canvas.drawText(date, 280, 1220, paint);
        canvas.drawText(date, 280, 1310, paint);
        canvas.save();
        canvas.restore();

        try {

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, context.openFileOutput("xg.jpg", Context.MODE_PRIVATE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
