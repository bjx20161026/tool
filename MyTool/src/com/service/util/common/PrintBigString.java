package com.service.util.common;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.apache.log4j.Logger;

public class PrintBigString {
	public Logger logger = Logger.getLogger(PrintBigString.class);
	public int length = 78;
	public int width = 20;
	public String font = "宋体";
	public int style = Font.PLAIN;
	public int size = 16;
	public char  pack = '*';
	public void Print(String str){
	    BufferedImage image = new BufferedImage(length,width,BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = image.createGraphics();
	    g.setFont(new Font(font, style, size));
	    g.drawString(str,1,image.getHeight()-2);
	    int[] p = image.getRGB(0,0,image.getWidth(),image.getHeight(),new int[image.getWidth()*image.getHeight()],0,image.getWidth());
	    StringBuilder stb = new StringBuilder();
	    for(int i=0;i<image.getHeight();i++)
	      for(int j=0;j<image.getWidth();j++)
	    	  stb.append(p[i*image.getWidth()+j]==-1?(i%2==0?pack:pack):" "+(j==image.getWidth()-1?"\n":""));
	    logger.info(stb.toString());
	}
	
	public String Get(String str){
	    BufferedImage image = new BufferedImage(length,width,BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = image.createGraphics();
	    g.setFont(new Font(font, style, size));
	    g.drawString(str,1,image.getHeight()-2);
	    int[] p = image.getRGB(0,0,image.getWidth(),image.getHeight(),new int[image.getWidth()*image.getHeight()],0,image.getWidth());
	    StringBuilder stb = new StringBuilder();
	    for(int i=0;i<image.getHeight();i++)
	      for(int j=0;j<image.getWidth();j++)
	    	  stb.append(p[i*image.getWidth()+j]==-1?(i%2==0?pack:pack):" "+(j==image.getWidth()-1?"\n":""));
	    return stb.toString();
	}
	
	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}
	
	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public char getPack() {
		return pack;
	}

	public void setPack(char pack) {
		this.pack = pack;
	}


	public static void main(String[] args){
		PrintBigString printBigString = new PrintBigString();
		printBigString.setPack('*');
		printBigString.setStyle(Font.PLAIN);
		printBigString.Print("MyTool");
	}
}
