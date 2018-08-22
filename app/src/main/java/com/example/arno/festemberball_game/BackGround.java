package com.example.arno.festemberball_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class BackGround {
    private GamePanel gamePanel;
    private int x = 0;
    private int y = 0;
    private int dx = 0;
    private Bitmap bm;
    int round_x, round_y, size, size2;
    Rect src, dst, dst2;

    public BackGround(Bitmap bm, GamePanel gamePanel) {

        this.bm = bm;
        this.gamePanel = gamePanel;
        dx = GamePanel.moveSpeed;

        round_x = gamePanel.getWidth() / 2;
        round_y = gamePanel.getHeight() / 2;
        size = 0;
        src = new Rect(0, 0, bm.getWidth(), bm.getHeight());
        dst = new Rect();
        dst2 = new Rect();
    }


    public void draw(Canvas canvas) {
        Paint back = new Paint();
        back.setColor(Color.LTGRAY);

        canvas.drawRect(0 , 0 ,gamePanel.getWidth() , gamePanel.getHeight() ,back );

        //canvas.drawBitmap(bm, x, y, null);
        //if (y < 0) {
        //canvas.drawBitmap(bm, x, y + gamePanel.getHeight(), null);
        //}
        dst.left = round_x - size / 2;
        dst.right = round_x + size / 2;
        dst.top = round_y - size / 2;
        dst.bottom = round_y + size / 2;

        size += 5;
        canvas.drawBitmap(bm, src, dst, null);
        if(size > 1000){
            size = 0;
        }

        if (size > 500) {
            size2 = size - 500;
            dst2.left = round_x - size2 / 2;
            dst2.right = round_x + size2 / 2;
            dst2.top = round_y - size2 / 2;
            dst2.bottom = round_y + size2 / 2;
            canvas.drawBitmap(bm, src, dst2, null);
        }

    }

    public void update() {
        Log.d("from back_ground class", "true");
        y = y + dx;
        if (y < (-gamePanel.getHeight())) {
            y = 0;
        }


    }


}
