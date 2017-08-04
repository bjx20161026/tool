package test;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.util.*;
import java.awt.image.*;
 
public class test{
	public test(String str){
		System.out.println("str--->>>"+str);
	}
	public void SayHello(String name){
		System.out.println("Hello "+name+" !");
	}
  public test(){
    BufferedImage image = new BufferedImage(78,20,BufferedImage.TYPE_INT_RGB);
    Graphics2D g = image.createGraphics();
    g.setFont(new Font("宋体", Font.PLAIN, 16));
    g.drawString("安徽大学",2,image.getHeight()-2);
    int[] p = image.getRGB(0,0,image.getWidth(),image.getHeight(),new int[image.getWidth()*image.getHeight()],0,image.getWidth());
    for(int i=0;i<image.getHeight();i++)
      for(int j=0;j<image.getWidth();j++)
        System.out.print(p[i*image.getWidth()+j]==-1?(i%2==0?"*":"*"):" "+(j==image.getWidth()-1?"\n":""));
  }
  public static void main(String args[]){
    new test();
  }
}