package com.builder.yiban;

import android.content.Context;
import android.graphics.Canvas;

import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;


public class ShowImageView extends AppCompatImageView {
    public ShowImageView(Context context) {
        super(context);
    }

    public ShowImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShowImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

    }

    @Override
    public void onDrawForeground(Canvas canvas) {

        super.onDrawForeground(canvas);
    }
}
