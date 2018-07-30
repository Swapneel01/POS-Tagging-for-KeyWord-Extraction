package brillTaggerStanford;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class TagText {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		
		// Initialize the tagger
		MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
		
		
		//The sample string
		String sample = "Prime witness in the Best Bakery case";
	

		//The tagged string
		String tagged1 = tagger.tagString(sample);
		tagged1.split(" ");
		 
		//output the tagged sample string onto your console
		System.out.println("Input: " + sample);
		System.out.println("Output: " + tagged1);
		
		//added from here
		int li=sample.length();
		System.out.println("Total Length of the Input : "+li);
		
		int lo=tagged1.length();
		System.out.println("Total Length of the Output : "+lo);
		
		
		//working
		//block to read the query.txt file and filter the titles and store it in a file as well as display it on the console
		
		try {
			File file = new File("E:\\Internships\\NIT-P 2018\\query.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			FileWriter fw = new FileWriter("E:\\Internships\\NIT-P 2018\\title.txt");
			while ((line = bufferedReader.readLine()) != null)
			{
				if(line.charAt(0)=='<' && line.charAt(1)=='t' && line.charAt(2)=='i') 
				{
					line=line.substring(line.indexOf("<title>")+7);
					line=line.substring(0, line.indexOf("</title>"));
					//System.out.println(line);
					String tagged=tagger.tagString(line);
					tagged.split(" ");
					System.out.println(tagged);
					fw.write(tagged);
					fw.write("a a ");
					fw.write("\n");
				}
				else
				{
					line=bufferedReader.readLine();
				}
			}
			fileReader.close();
			fw.close();
			} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
				
		
		/* //working
		//block for determining when a noun or an adjective is encountered and for nuber of passes through the string.
		int k=lo-3;
		for(int i=0;i<k;i++)
		{
			if(tagged.charAt(i)==tagged.charAt(k))
			{
				System.out.println("Last Element of the String reached");
			}
		
			else if(tagged.charAt(i)=='_')
			{			
				if(tagged.charAt(i+1)=='N' && tagged.charAt(i+2)=='N')
				{
					if(tagged.charAt(i+3)==' ')
					{
						System.out.println("Noun");
					}					
					else if(tagged.charAt(i+3)=='P')// || tagged.charAt(i+3)=='S')
					{
						if(tagged.charAt(i+4)==' ')
						{
							System.out.println("Noun");
						}
						else if(tagged.charAt(i+4)=='S')
						{
							System.out.println("noun");
						}
					}
				}
				else if(tagged.charAt(i+1)=='J' && tagged.charAt(i+2)=='J')						
				{
					if(tagged.charAt(i+3)==' ')
					{
						System.out.println("Adjective");
					}
					else if(tagged.charAt(i+3)=='R' || tagged.charAt(i+3)=='S')
					{
						System.out.println("Adjective");
					}
				}			
			}}*/
		
		/*
		//to split the words separately 
		String[] words=tagged1.split("\\_NN|NNS|NNP|NNPS|JJ|JJR|JJS");
		for(String w:words)
			{  
			System.out.println(w);  
			} 
	    */
		
        //for (String val: tagged.split(" "))
          //  System.out.println(val);		
				
		// Call the API to parse your sentence.
		//jList words = tagger.tagSentence( tagged );

		// For each word tagged in the sentence...
		//for( tagged word : words ) {
		  //String tag = word.tag();

		  // Check the part-of-speech directly, without having to parse the string.
		  //if( "NN".equalsIgnoreCase( tag ) ) {
		    //System.out.printf( "%s is a noun\n", word.word() );
		
		/*
		//storing the processed words with tags in file   
		try 
			{
            FileWriter writer = new FileWriter("E:\\Internships\\NIT-P 2018\\ProcessedFile.txt", true);
    		File file1 = new File("E:\\Internships\\NIT-P 2018\\title.txt");
    		FileReader fileReader1 = new FileReader(file1);
    		BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
    		String line1;
    		while ((line1 = bufferedReader1.readLine()) != null)
    		{
                for (String val: line1.split(" "))//to split
                {
                	System.out.println(val);
            		writer.write(val);
                	writer.write("\r\n");
                	line1=bufferedReader1.readLine();
                }
                writer.close();
                bufferedReader1.close();
          	}
            //writer.write(tagged);
            //BufferedWriter bw=new BufferedWriter(writer);
            //PrintWriter out=new PrintWriter(bw);
            } 
		catch (IOException e)
		    {
            e.printStackTrace();
		    }*/
	
		/*
		//block to store the words retrieved from the strings
		try
	       {
	         File dir = new File("E:\\Internships\\NIT-P 2018\\query.txt");
		     for (File fn : dir.listFiles())
		     {
		        FileInputStream fstream = new FileInputStream(fn);
		        DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		        String strLine;
		        while ((strLine = br.readLine()) != null)
		        {
		        String[] words1 = strLine.split("\\s+");
		        for (String s: words1)
		        {
		          System.out.println(s);
	            }
	            }
	        br.close();
	        in.close();
	        }
	        }
	    catch (FileNotFoundException e)
	        {
	        e.printStackTrace();
	        }
        catch (IOException e)
            {
	        e.printStackTrace();
	        }*/
			
		  
		  /*
		  //block for splitting up the sentence word by word and storing only the words which are required
	      String s2 = "Sachin_NNP Tendulkar_NNP 's_POS record_NN of_IN runs_NNS in_IN Test_NN Cricket_NN";
	      String[] arr = s2.split(" ");    
	      String stringAr[] = null;
	      int i=0;
	      for ( String ss : arr)
	      {
	    	  //added from here
	    	  boolean retval;
	    	  if((retval=ss.endsWith("_NN"))==true)
	    	  {
	    		  stringAr[i]=ss;
	    		  i++;
	    		  if((retval=ss.endsWith("_NNS"))==true)
	    				  {
	    			  		if((retval=ss.endsWith("_NNP"))==true)
	    			  		{
	    			  		System.out.println(ss);
	    			  		}
	    				    System.out.println(ss);
	    				  }
	    		  System.out.println(ss);
	    	  }
	    	  else
	    	  {
	    		  continue;
	    	  }
 	      }
	      
	      //block to get rid of the Parts-of-speech suffix present at the end of every word
	      String line = "Mahatma_NNS";
	      line = line.replace("_NNS","");
	      System.out.println(line);
	      
	      String abcde="Mahatma_NNS";
	      abcde=abcde.replaceAll("_NNS", "");
	      System.out.println(abcde);
		  */
		
		
		//required file
		// block to seperate out the words from the tags and store it in desired way
		try
		{
			//experiment to remove the words which are not required
			//List<String> ignoreAll=Arrays.asList("POS","IN","DT","CC");
			//
			File file1 = new File("E:\\Internships\\NIT-P 2018\\title.txt");
			FileReader fileReader1 = new FileReader(file1);
			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
			StringBuffer stringBuffer1 = new StringBuffer();
			String line;
			FileWriter fw1 = new FileWriter("E:\\Internships\\NIT-P 2018\\reqfile.txt");
			while ((line = bufferedReader1.readLine()) != null)
			{
				String[] x = line.split(" ");
			    ArrayList<String> list = new ArrayList<String>();  
			    
			    // for the length of the array index variable so that i+2 statement doesn't cause array out of bound exception
			    int e=x.length-2;
			    for(int i=0;i<e;i++)
			    {
			    	if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("N"))
			      {   
			        	fw1.write(x[i].split("_")[0]); 
			        	fw1.write("\n");
			        	if(x[i+1].substring(x[i+1].lastIndexOf("_")+1).startsWith("N"))
			        	{	fw1.write(x[i+1].split("_")[0]);
			        		fw1.write("\n");
			        		fw1.write(x[i].split("_")[0]);
			        		fw1.write(" ");
			        		fw1.write(x[i+1].split("_")[0]);
			        		fw1.write("\n");
			        		if(x[i+2].substring(x[i+2].lastIndexOf("_")+1).startsWith("N"))
			        		{
			        			fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
				        		fw1.write(x[i+1].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
				        		
				        		fw1.write(x[i].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+1].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
			        		/*	
			        			list.add(x[i].split("_")[0]);
					        */
			        		}
			        		else
			        		{
			        			i=i+1;
			        			continue;
			        		}
			        	
			        	}
			        	/*
			        	fw1.write(x[i].split("_")[0]);	
			       		fw1.write("\n");
			        	list.add(x[i].split("_")[0]);
			        	 */
			        	else
		        		{
			        		continue;
		        		}
			      }
			        
			      else if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("J"))
			      {   
			        	fw1.write(x[i].split("_")[0]);
			        	fw1.write("\n");
			        	if(x[i+1].substring(x[i+1].lastIndexOf("_")+1).startsWith("J"))
			        	{	fw1.write(x[i+1].split("_")[0]);
			        		fw1.write("\n");
			        		fw1.write(x[i].split("_")[0]);
			        		fw1.write(" ");
			        		fw1.write(x[i+1].split("_")[0]);
			        		fw1.write("\n");
			        		if(x[i+2].substring(x[i+2].lastIndexOf("_")+1).startsWith("J"))
			        		{
			        			fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
				        		fw1.write(x[i+1].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
				        		
				        		fw1.write(x[i].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+1].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
			        		}
			        		else
			        		{
			        			i=i+1;
			        			continue;
			        		}
			        	}
			        	else
			        	{
			        		continue;
			        	}
			      }
			        
			      else if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("V"))
			        {   
			        	fw1.write(x[i].split("_")[0]);
			        	fw1.write("\n");
			        	if(x[i+1].substring(x[i+1].lastIndexOf("_")+1).startsWith("V"))
			        	{	fw1.write(x[i+1].split("_")[0]);
			        		fw1.write("\n");
			        		fw1.write(x[i].split("_")[0]);
			        		fw1.write(" ");
			        		fw1.write(x[i+1].split("_")[0]);
			        		fw1.write("\n");
			        		if(x[i+2].substring(x[i+2].lastIndexOf("_")+1).startsWith("V"))
			        		{
			        			fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
				        		fw1.write(x[i+1].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
				        		
				        		fw1.write(x[i].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+1].split("_")[0]);
				        		fw1.write(" ");
				        		fw1.write(x[i+2].split("_")[0]);
				        		fw1.write("\n");
			        		}
			        		else
			        		{
			        			i=i+1;
			        			continue;
			        		}
			        	}
			        	else 
			        	{
			        		continue;
			        	}
			        }
			      			    	
			    //  else if(x[i].substring(x[i].lastIndexOf("_")+1).startsWith("POS")||x[i].substring(x[i].lastIndexOf("_")+1).startsWith("IN")||x[i].substring(x[i].lastIndexOf("_")+1).startsWith("DT")||x[i].substring(x[i].lastIndexOf("_")+1).startsWith("CC"))
			     // {
			    	
			    	 
			    //	continue;
			     //}
			    	
			       else
			        {
			        	continue;
			        }
			    }
			}
			
			fileReader1.close();
			fw1.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		/*
		// The sample string
	    String s = "An_DT Indian_JJ wins_VBZ the_DT Nobel_NNP Prize_NNP for_IN Chemistry_NNP";
	    //String sample1 = s.replaceAll("\\W", " ");
	    String[] x = s.split(" ");
	    ArrayList<String> list = new ArrayList<String>();  

	    for(int i=0;i<x.length;i++)
	    {
	        if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("N"))
	        {   
	            	list.add(x[i].split("_")[0]); 
	        }
	        //added from here
	        else if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("J"))
	        {
	        	list.add(x[i].split("_")[0]);
	        }
	        //added till here
	    }
	    for(int i=0;i<list.size();i++)
	    {
	        System.out.println(list.get(i));
	    } 
	    */
	
		
				
		//trial block to store consecutive words together
				/*String line="Michael_NNP Jackson_NNP 's_POS untimely_JJ death_NN";
				String[] x = line.split(" ");
				int flag=0;
				int k=x.length-2;
				for(int i=0;i<k;i++)
			    {	//System.out.println(x[i]);
			        //System.out.println(x[i].split("_")[0]+" ");
			    	{
			    	if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("N"))
			        {	x[i].split("_");
			        	if(x[i+1].substring(x[i+1].lastIndexOf("_")+1).startsWith("N"))
			        	{
			        		//x[i+1].split("_");
			        		flag=1;			        	
			        	}
			        }
			    	
			    	//added from here for adjectives
			    	if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("J"))
			        {	x[i].split("_");
			        	if(x[i+1].substring(x[i+1].lastIndexOf("_")+1).startsWith("J"))
			        	{
			        		x[i+1].split("_");
			        		flag=2;			        	
			        	}
			        }			    	
			    		    	
			    	//added from here for verbs
			    	if (x[i].substring(x[i].lastIndexOf("_")+1).startsWith("V"))
			        {	x[i].split("_");
			        	if(x[i+1].substring(x[i+1].lastIndexOf("_")+1).startsWith("V"))
			        	{
			        		x[i+1].split("_");
			        		flag=3;			        	
			        	}
			        }			    	
			    	
			    	{
			    	if(flag==1)
			        {
			      		System.out.print(x[i].split("_")[0]+" ");
			        	System.out.print(x[i+1].split("_")[0]+" ");
			        	System.out.println(x[i+2].split("_")[0]+" ");
			        }
			      	
			    	else if(flag==2)
			        {
			      		System.out.println(x[i].split("_")[0]+" ");
			        	System.out.println(x[i+1].split("_")[0]+" ");
			        	System.out.println(x[i+2].split("_")[0]+" ");
			        }
			    	
			    	//else
			    	if(flag==2)
			        {
			      		System.out.print(x[i].split("_")[0]+" ");
			        	System.out.print(x[i+1].split("_")[0]+" ");
			        	System.out.print(x[i+2].split("_")[0]+" ");
			      
			        }
			    	}
			    	}
			   }*/
				}}
	









