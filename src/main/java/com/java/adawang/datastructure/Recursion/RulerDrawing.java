package com.java.adawang.datastructure.Recursion;

public class RulerDrawing {
	public static void main(String[] args){
		drawRuler(5,1);
	}

	public static void drawRuler(int nInches,
								 int majorLength){
		drawLine(majorLength, 0);
		for(int j=1;j<=nInches;j++){
			drawInterval(majorLength-1);
			drawLine(majorLength, j);
		}
	}

	private static void drawInterval(int centralLength){
		if(centralLength>=1){
			drawInterval(centralLength-1);
			drawLine(centralLength);
			drawInterval(centralLength-1);
		}
	}

	private static void drawLine(int tickLength,
								 int tickLable){
		for(int j=0; j<tickLength; j++)
			System.out.print("-");
		if(tickLable>=0)
			System.out.print(" "+tickLable);
		System.out.print("\n");
	}

	private static void drawLine(int tickLength){
		drawLine(tickLength, -1);
	}
}
