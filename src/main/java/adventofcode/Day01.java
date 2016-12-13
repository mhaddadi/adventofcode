package adventofcode;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Day01 {

	public static void main(String[] args) throws Exception {
		
		double x = 0;
		double y = 0;
		String previousDirection = "N";
		
		List<Line2D.Double> lines = new ArrayList<Line2D.Double>();
		
		String[] split = args[0].split(",");
		
		for (int i = 0; i < split.length; i++) {

			double xPrev = x;
			double yPrev = y;
			
			String move = split[i].trim();
			
			String direction = move.substring(0, 1);
			int steps = Integer.valueOf(move.substring(1));
			
			switch (previousDirection) {
				
				case "N" :
					x = x + steps * ("L".equals(direction) ? -1 : 1);
					previousDirection = "L".equals(direction) ? "W" : "E";
					break;
				case "S" :
					x = x + steps * ("L".equals(direction) ? 1 : -1);
					previousDirection = "L".equals(direction) ? "E" : "W";
					break;
				case "W" :
					y = y + steps * ("L".equals(direction) ? -1 : 1);
					previousDirection = "L".equals(direction) ? "S" : "N";
					break;
				case "E" :
					y = y + steps * ("L".equals(direction) ? 1 : -1);
					previousDirection = "L".equals(direction) ? "N" : "S";
					break;
			}
			
			int X_OFFSET = 500; //500;
			int Y_OFFSET = 500; //200;
			int SCALE = 2;
			
			lines.add(new Line2D.Double(X_OFFSET + SCALE * xPrev, Y_OFFSET + SCALE * yPrev, X_OFFSET + SCALE * x, Y_OFFSET + SCALE * y));
			
			System.out.println("move : " + move + ", X = " + x + ", Y = " + y + ", Xprev = " + xPrev + ", Yprev = " + yPrev + ", ANSWER = " + (Math.abs(x) + Math.abs(y)));
			
		}
		
		
		JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graph graph = new Graph(lines);
        myFrame.add(graph);
        myFrame.setBounds(100, 100, 900, 900);
        myFrame.setVisible(true);
        myFrame.setResizable(true);
        
	}
	
}

class Graph extends JPanel {
	
	private static final long serialVersionUID = 5708785555705794126L;
	List<Line2D.Double> lines ;
	
    public Graph(List<Line2D.Double> lines) {
    	super(new GridLayout(10,10));
    	this.lines = lines;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D gr = (Graphics2D) g; // This is if you want to use Graphics2D

        // Now do the drawing here
        for (Line2D line : lines) {
            gr.drawLine((int)line.getX1(), (int)line.getY1(), (int)line.getX2(), (int)line.getY2());
		}
        
    }
}
