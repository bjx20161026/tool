package org.bjx.helper.printBigFront;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.apache.log4j.Logger;

public class PrintBigFront {
	
	Logger logger = Logger.getLogger(PrintBigFront.class);
	
	private String printStr = "Please initialize printStr first !";
	private String filler = "$";
	private int width = 400;
	private int height = 20;
	private String frontName = "宋体";
	private int frontStyle = Font.PLAIN;
	private int frontSize = 16;
	private boolean isPrint = false;

	public void print() {
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	    Graphics2D graph = image.createGraphics();
	    graph.setFont(new Font(frontName, frontStyle, frontSize));
	    graph.drawString(printStr,1,image.getHeight()-2);
	    int[] picture = image.getRGB(0,0,image.getWidth(),image.getHeight(),new int[image.getWidth()*image.getHeight()],0,image.getWidth());
	    String str = "";
	    for(int i=0;i<image.getHeight();i++)
	      for(int j=0;j<image.getWidth();j++) {
	    	  str += picture[i*image.getWidth()+j]==-1?(i%2==0?filler:filler):" "+(j==image.getWidth()-1?"\n":"");
	      }
	    logger.info(str);
	    if(isPrint) System.out.println(str);
	}
	
	
	public boolean isPrint() {
		return isPrint;
	}

	public void setPrint(boolean isPrint) {
		this.isPrint = isPrint;
	}
	
	public String getPrintStr() {
		return printStr;
	}

	public void setPrintStr(String printStr) {
		this.printStr = printStr;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getFrontName() {
		return frontName;
	}

	public void setFrontName(String frontName) {
		this.frontName = frontName;
	}

	public int getFrontStyle() {
		return frontStyle;
	}

	public void setFrontStyle(int frontStyle) {
		this.frontStyle = frontStyle;
	}

	public int getFrontSize() {
		return frontSize;
	}

	public void setFrontSize(int frontSize) {
		this.frontSize = frontSize;
	}
}
