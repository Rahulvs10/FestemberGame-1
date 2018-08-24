package com.example.arno.festemberball_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class BackGround {
    private GamePanel gamePanel;
    private Tunnel tunnel, tunnel2, tunnel3;
    private int x = 0;
    private int y = 0;
    private int dx = 0;
    private Bitmap bg;
    int round_x, round_y;
    RectF dst, dst2;
    Rect src;

    public BackGround(Bitmap bm, Bitmap bg, GamePanel gamePanel) {

        this.bg = bg;
        this.gamePanel = gamePanel;
        dx = GamePanel.moveSpeed;


        round_x = gamePanel.getWidth() / 2;
        round_y = gamePanel.getHeight() / 2;
        src = new Rect(0, 0, bm.getWidth(), bm.getHeight());
        dst = new RectF();
        tunnel = new Tunnel(src, dst, round_x, round_y, bm);
        tunnel2 = new Tunnel(src, dst, round_x, round_y, bm);
        tunnel3 = new Tunnel(src, dst, round_x, round_y, bm);
        dst2 = new RectF();
    }


    public void draw(Canvas canvas) {
        Paint back = new Paint();
        back.setColor(Color.BLACK);

        canvas.drawRect(0 , 0 ,gamePanel.getWidth() , gamePanel.getHeight() ,back );
//
//        canvas.drawBitmap(bg, x, y, null);
//        if (y < 0) {
//        canvas.drawBitmap(bg, x, y + gamePanel.getHeight(), null);
//        }

        tunnel.draw(canvas);

        if(tunnel.next)
            tunnel2.draw(canvas);

        if (tunnel2.next)
            tunnel3.draw(canvas);
    }

    public void update() {
        Log.d("from back_ground class", "true");
        y = y + dx;
        if (y < (-gamePanel.getHeight())) {
            y = 0;
        }
    }
}
