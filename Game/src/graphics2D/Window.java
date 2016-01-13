package graphics2D;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Window extends JFrame implements KeyListener {
	int width = 640;
	int height = 640;
	private Starship enterprise;
	BufferedImage landscape; 
	boolean itemPickedUp;
	private Starship kbop;
	public static void main(String[] args){
		new Window();
	}
	public Window(){
		//the following are JFrame methods
		enterprise = new Starship("Enterprise", "/starship/ent.jpg",300,300);
		kbop = new Starship("Klingon Bird of Prey", "/starship/bop.jpg",50,50);
		//g.drawImage(enterprise.getImage(), enterprise.getLocationX(), enterprise.getLocationY(), null);
		landscape = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		itemPickedUp=false;
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		drawLand(g2);
		setVisible(true);
		setSize(width,height);//Size of thing
		setLocation(200,150);//Top left is origin
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//static constant reference for special close operation
		addKeyListener(this);
	}
	public void drawLand(Graphics2D g2){
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, width, height);
		
	}
	public void paint(Graphics g){
		//Graphics be a crayon box
		//Graphics 2D is art kit, more cool shit
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2 =(Graphics2D)image.getGraphics();
		g2.setColor(Color.BLACK);
		g2.setColor(Color.GREEN);
		g2.fillRect(0, 0, 200, 200);
		g2.drawImage(landscape, 0,0,null);
		
		g2.fillOval(0, 0, 200, 200);
		g2.setColor(Color.GRAY);
		g2.drawOval(0, 0, 200, 200);
		
		g2.drawArc(50,200,200,200,0,90);//x,y,width,height, startDegree lengthDegree
		g2.setColor(Color.BLUE);
		g2.fillRect(20, 50, 200, 50);//x, y, width, height
		g2.setColor(Color.BLUE);
		g2.drawString("Goodbye World",300,300);
		g2.drawLine(0, 0, width, height);//start coords, end coord
//		g2.drawOval(360, 500, 100, 100);
//		g2.drawOval(260, 500, 100, 100);
//		g2.drawLine(400, 500, 400, 200);
//		g2.drawLine(300, 500, 300, 200);
//		g2.drawArc(300, 100, 100, 200, 0, 180);
//		g2.drawArc(300, 100, 100, 200, 0, -180);
		//y1 and x2 are the only ones that change;
//		int y1=height;
//		for(int x2 =0;x2<width;x2++){
//			y1--;
//			g2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
//			
//			g2.drawLine(0, y1, x2, 0);
//		}
//		
//		int squareD = 20;
//		int margin = 10;
//		for(int x =0; x < width;x+=squareD+margin){
//			for(int y=0;y<height;y+=squareD+margin){
//				/**
//				if(x<256){
//					g2.setColor(new Color(0,0,x));
//				}
//				else{
//					x=0;
//				}**/
//				g2.fillRect(x, y, squareD, squareD);
//			}
//		}
		// draw bufferedImage on the canvas
		g.drawImage(image, 0, 0, null);
//		enterprise = new Starship("Enterprise", "/starship/ent.jpg",300,300);
		g.drawImage(enterprise.getImage(), enterprise.getLocationX(), enterprise.getLocationY(), null);
		//g.drawImage(image, 0, 0, null);
		//Starship kbop = new Starship("Klingon Bird of Prey","/starship/bop.jpg,", 50,50);
	//	Starship kbop = new Starship("Klingon Bird of Prey", "/starship/bop.jpg",50,50);
		if(Math.abs(enterprise.getLocationX()-kbop.getLocationX())<10 && Math.abs(enterprise.getLocationY()-kbop.getLocationY())<10 ){
			itemPickedUp=true;
		}
		if(!itemPickedUp){
			
			g.drawImage(kbop.getImage(), kbop.getLocationX(), kbop.getLocationY(), null);
		}
	}
	public void keyPressed(KeyEvent arg0){
		int key=arg0.getKeyCode();
		if(key==KeyEvent.VK_UP){
			enterprise.moveUp();
		}
		else if(key==KeyEvent.VK_DOWN){
			enterprise.moveDown();
			
		}else if(key==KeyEvent.VK_RIGHT){
			enterprise.moveRight();
			
		}else if(key==KeyEvent.VK_LEFT){
			enterprise.moveLeft();
			
		}
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//Client Change
}
