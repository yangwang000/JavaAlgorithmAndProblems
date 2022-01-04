package com.java.adawang.DataStructure.Recursion;

import java.io.File;

public class DiskUsage {
	public static long diskUsage(File root){
		long total = root.length();
		if(root.isDirectory()){
			for(String childname: root.list()){
				File child = new File(root, childname);
				total += diskUsage(child);
			}
		}
		return total;
	}
}
