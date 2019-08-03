package core;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TCGA_MAF_filtering 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		java.io.File file1 = new java.io.File("/Users/yetingzhang/Desktop/TCR-T_trial/gdc_download_20190621_140748.034310/3e48014d-ce4a-4937-bba4-13eaf631a64a/TCGA.OV.somaticsniper.3e48014d-ce4a-4937-bba4-13eaf631a64a.DR-10.0.somatic.maf");
		java.util.Scanner input1 = new java.util.Scanner(file1);
		//java.io.File file2 = new java.io.File("/Users/yetingzhang/Desktop/runTotal.txt");
		//java.util.Scanner input2 = new java.util.Scanner(file2);
		java.io.File file3 = new java.io.File("/Users/yetingzhang/Desktop/TCGA_OV_maf_filtered");
		java.io.PrintWriter output1 = new java.io.PrintWriter(file3);
		ArrayList<String> info = new ArrayList<String>();
		ArrayList<String> gene = new ArrayList<String>();
		String temp;
		String temp1;
		String outputname;
		String next = null;
		int i = 0;
		int k = 0;
		Double value;
		String[] arraytemp = null;
		String[] arraytemp1 = null;
		boolean arrival = false;
		
		while (input1.hasNext())
		{
			temp = input1.nextLine().trim();
			if (!temp.startsWith("#"))
			{
				arraytemp = temp.split("\t");
				if (arraytemp[13].equals("novel"))
				{
					if (arraytemp[8].contains("Intron") || arraytemp[8].contains("UTR")
							|| arraytemp[8].contains("Silent") || arraytemp[8].contains("RNA") ||
							arraytemp[8].contains("Flank"))
					{
						
					}else
					{
						output1.println(temp);
					}
				}
			}
		}
		
		output1.close();
	}

}