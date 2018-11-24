/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package complextesterproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author swarm8383
 */
public class ComplexTesterProject extends JFrame {
    //paramaters
    int width = 1000;
    int height = 800;
    
    double maxA = 1;
    double maxB = 1.5;
    double minA = -3;
    double minB = -1.5;
    double Xinterval = (maxA - minA)/width;
    double Yinterval = (maxB - minB)/height;
    
    Color InSet = Color.BLACK;
    Color NotInSet = Color.WHITE;
    
            
    public void paint(Graphics g){
        Image img = createImage(); 
        g.drawImage(img, 8, 30, this);
    }
    
    public Image createImage(){
        BufferedImage bufferedImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        
        for (double i = minA; i < maxA; i += Xinterval){
            for (double j = minB; j < maxB; j += Yinterval){
                ComplexNumber c = new ComplexNumber(i,j);
                if(inSet(c)){
                    g.setColor(InSet);
                }
                else{
                    g.setColor(NotInSet);
                }
                g.fillRect(getXScreenValue(c.a), getYScreenValue(c.b), 1, 1);
                
            }
            
        }
        return bufferedImage;
    }
    public Boolean inSet(ComplexNumber c){
        ComplexNumber z = new ComplexNumber(c.a,c.b);
        int n = 1;
        while (z.absoluteValue() < 2 && n < 200){
            z = z.multiply(z).add(c);
            n++;
        }
        if (n < 200){
            return false;
        }
        else{
            return true;
        }
    }
    
    public void initializeWindow(){
        setTitle("Mandelbrot Set");
        setSize(width,height);
        setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        
    }
    
    public int getXScreenValue(double a){
        int y;
        y = (int) Math.round((width * a - width * minA)/(maxA - minA));
        return y;
        
    }
    
     public int getYScreenValue(double b){
        int y;
        y = (int) Math.round(((height * b - height * minB)/(maxB - minB)));
        return y;
        
     }
    public static void main(String[] args) {
        ComplexTesterProject ct = new ComplexTesterProject();
        ct.initializeWindow();
        
        
        ComplexNumber q = new ComplexNumber(3,2);
        ComplexNumber r = new ComplexNumber(-3,2);
        ComplexNumber s = new ComplexNumber(3,-2);
        ComplexNumber g = new ComplexNumber(4,6);
        ComplexNumber p = new ComplexNumber(-4,6);
        ComplexNumber t = new ComplexNumber(4,1);
        ComplexNumber j = new ComplexNumber(4,5);
        ComplexNumber k = new ComplexNumber(3,14);
        
        ComplexNumber PplusG = g.add(p);
        ComplexNumber TtimesJ = t.multiply(j);
        ComplexNumber KdividedbyJ = k.divide(j);
        
        q.display();
        r.display();
        s.display();
        
        PplusG.display();
        TtimesJ.display();
        KdividedbyJ.display();
        
    }
}
