package core;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Screen_data_VaginalSwab 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		java.io.File file1 = new java.io.File("/Users/yetingzhang/Desktop/Inputdata_micbiome.txt");
		java.util.Scanner input1 = new java.util.Scanner(file1);
		//java.io.File file2 = new java.io.File("/Users/yetingzhang/Desktop/Feb2015_run_chr1/chr1/cis_eQTL_chr1");
		//java.util.Scanner input2 = new java.util.Scanner(file2);
		java.io.File file2 = new java.io.File("/Users/yetingzhang/Desktop/VaginalSwab_pos");
		java.io.PrintWriter output2 = new java.io.PrintWriter(file2);
		java.io.File file3 = new java.io.File("/Users/yetingzhang/Desktop/Inputdata_microbiome_VaginalSwab");
		java.io.PrintWriter output1 = new java.io.PrintWriter(file3);
		
		String temp1 = new String();
		String temp = new String();
		String temp2 = new String();
		String[] arraytemp = null;
		String[] arraytemp1 = null;
		String[] arraytemp2 = null;
		String ID = null;
		String readsNum = null;
		String strand = null;
		int i = 0;
		int j = 0;
		int k = 0;
		Double d1 = 0.0;
		Double d2 = 0.0;
		Double d3 = 0.0;
		ArrayList<Integer> vagi = new ArrayList<Integer>();
	
		//Extract VaginalSwab columns and filter out *_NA columns, record the original coordinates as well
		temp = input1.nextLine().trim();
		arraytemp = temp.split(" ");
		for (i = 0; i < arraytemp.length; i++)
		{
			if (arraytemp[i].startsWith("VaginalSwab") && !arraytemp[i].contains("_NA"))
			{
				output2.println(i + "\t" + arraytemp[i]);
				vagi.add(i);
				j = i;
			}
		}
		System.out.println(j);
		System.out.println(vagi.size());
		//output1.println(temp);
		
		while (input1.hasNext())
		{
			temp = input1.nextLine().trim();
			arraytemp = temp.split(" ");
		//Check first if this row belongs to PTLG016 patient, if it is mark as class 1, else class 0
			if (arraytemp[0].startsWith("PTLG016"))
			{
				output1.print("1" + "\t");
			}else
			{
				output1.print("0" + "\t");
			}
			
			//Only select the columns with VaginalSwab_* and no *_NA
			
			for (i = 1; i < 18545; i++)
			{
				if (vagi.contains(i))
				{
					if (i == 18544)
					{
						output1.print(Double.parseDouble(arraytemp[i]) + "\n");
					}else
					{
						output1.print(Double.parseDouble(arraytemp[i]) + "\t");
					}
				}
				
			}
		}
		
		output1.close();
		output2.close();
	}

}
