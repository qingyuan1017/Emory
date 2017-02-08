import java.awt.*;
import javax.swing.*;

public class MyCanvas extends Canvas
{
    public MyCanvas()
    {
    }
    public void paint(Graphics g) {
	
    	int x = 100;
    	
    	for(int i = 0; i < 20; i++) {
    		int width = (int) (Math.random() * 30);
    		
    		g.fillRect(x, 100, width, 300);
    		x += width + 5;
    		
    	}
    	
    }
    
    public static void main(String[] args)
    {
        MyCanvas canvas = new MyCanvas();
        
        canvas.setBackground(Color.white);
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
    }
}
