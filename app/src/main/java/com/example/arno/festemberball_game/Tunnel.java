package com.example.arno.festemberball_game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class Tunnel {

    Rect src;
    RectF dst;
    int round_x;
    int round_y;
    float size = 25;
    float increase=2;
    Bitmap bm;
    boolean next = false;
    boolean over = false;

    public Tunnel(Rect src, RectF dst, int round_x, int round_y, Bitmap bm){
        this.dst = dst;
        this.src = src;
        this.round_x = round_x;
        this.round_y = round_y;
        this.bm = bm;
    };

    void draw(Canvas canvas){

        dst.left = round_x - size / 2;
        dst.right = round_x + size / 2;
        dst.top = round_y - size / 2;
        dst.bottom = round_y + size / 2;

        increase+=0.5;
        size += increase;
        canvas.drawBitmap(bm, src, dst, null);

        if(size>((round_y*2-25)/5)){
            next = true;
        }

        if(size > round_y*2){
            size = 25;
            increase = 2;
            over = !over;
        }
    }
}
