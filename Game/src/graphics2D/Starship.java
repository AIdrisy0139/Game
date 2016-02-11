package graphics2D;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Starship {
	BufferedImage sprite;
	private String name;
	int locationX;
	int locationY;
	public Starship(String name, String imgLocation, int locationX, int locationY){
		this.name = name;
		int width = 320;
		int height = 216;
		this.locationX = locationX;
		this.locationY = locationY;
		
		//"desktop/ent.jpg"
		sprite = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imgLocation);
		try {
			BufferedImage original = ImageIO.read(url);
			//draw the image file into a scaled version on sprite canvas
			Graphics2D g = (Graphics2D)sprite.getGraphics();
			int w= original.getWidth();
			int h = original.getHeight();
			g.drawImage(original, 0, 0, width, height, 0, 0,w, h, null);
			/**
			what to draw, where to start, x, y,
			width of canvas relative to start , height of canvas relative to start
			where to start from original x, y
			width of original, height
			null
			**/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public BufferedImage getImage(){
		return sprite;
	}
	public String getName(){
		return name;
	}
	public int getLocationX(){
		return locationX;
	}
	public int getLocationY(){
		return locationY;
	}
	public void moveUp() {
		// TODO Auto-generated method stub
		this.locationY-=10;
	}
	public void moveDown() {
		// TODO Auto-generated method stub
		this.locationY+=10;
	}
	public void moveRight() {
		// TODO Auto-generated method stub
		this.locationX+=10;
		
	}
	public void moveLeft() {
		// TODO Auto-generated method stub
		this.locationX-=10;
		
	}
	//2-11-16 New
	
}
