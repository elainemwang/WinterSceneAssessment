/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinterSceneAssessment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author elainewang
 */
public class StormySnowFlake extends AbstractShape{
    public StormySnowFlake(int x, int y, int wid, int ht){
        super(x,y,wid,ht,Color.WHITE, 20, 2);
    }
    
    public void draw(Graphics window) {
        //fancy snowflake
        window.setColor(getColor());
        int x = getXPos();
        int y = getYPos();
        int w = getWidth();
        int h = getHeight();
        int hw = w / 2;
        int hh = h / 2;
        int hhe = (int) Math.ceil(hh * .125);
        int hhq = (int) Math.ceil(hh * .35);
        int hhh = (int) Math.ceil(hh * .7);
        int hwe = (int) Math.ceil(hw * .125);
        int hwq = (int) Math.ceil(hw * .35);
        int hwh = (int) Math.ceil(hw * .7);

        int[] xPoints = {x + hwh, x + hwq, x + hwe, x, x + hwe, x + hwq, x + hwh, x + hw / 2, x + hw, x + w - hw / 2, x + w - hwh, x + w - hwq, x + w - hwe, x + w, x + w - hwe, x + w - hwq, x + w - hwh, x + hw + hwq, x + hw, x + hw - hwq};
        int[] yPoints = {y + hh - hhe, y + hh - hhq, y + hh - hhe / 2, y + hh, y + hh + hhe / 2, y + hh + hhq, y + hh + hhe, y + h - hwq, y + h, y + h - hwq, y + hh + hhe, y + hh + hhq, y + hh + hhe / 2, y + hh, y + hh - hhe / 2, y + hh - hhq, y + hh - hhe / 2, y + hwq, y, y + hwq};
        int nPoints = 20;
        Polygon triangle = new Polygon(xPoints, yPoints, nPoints);
        window.drawPolygon(triangle);
        
        //simple snowflake
        window.drawLine(x, y, x + w, y + h);
        window.drawLine(x, y + h, x + w, y);
        window.drawLine(x, y + h / 2, x + w, y + h / 2);
        window.drawLine(x + w / 2, y, x + w / 2, y + h);
    }

    public void moveAndDraw(Graphics window) {
        //draw(window,Color.BLUE);
        /*
        int offset = (int) (Math.random() * 4);
        int rnd = (int) (Math.random() * 2);
        if (rnd == 1) {
            offset = offset * -1;
        }*/
        setXPos(getXPos() + getXSpeed());
        setYPos(getYPos() + getYSpeed());
        draw(window);
    }
    
}
