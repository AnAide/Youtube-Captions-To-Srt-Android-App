package com.example.getsubtitles;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.R.string;
import android.content.Context;
import android.widget.Toast;



public class ShowLanguages {

	public void getWebPage(String   s ) {
		char [][] code = new char[64][];
		char [][] lang = new char[64][];
       try {
    	   
        //String   s = "http://video.google.com/timedtext?type=list&v=XraeBDMm2PM";
         //  URL url = new URL("http://video.google.com/timedtext?type=list&v=XraeBDMm2PM");
       		URL url = new URL(s);
       		s = s.replaceAll(" ", "%20");
       		URLConnection urlc = url.openConnection();
       		
          BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream()); 
                  
          
           StringBuilder builder = new StringBuilder();
           int byteRead,i = 0, j,k =0;
           char[][] name = new char[512][512];
            
           while ((byteRead = buffer.read()) != -1)
           {
           	j = 0;
           	//System.out.println((char)byteRead);
           	if((char)byteRead=='"')
           	{
           		byteRead = buffer.read();
           		while ((char)byteRead  != '"')
           		{
           			 name[i][j] = (char)byteRead;
           				//System.out.print((char)byteRead);
           				byteRead = buffer.read();
           				j++;
           		}
           		//System.out.print("\n");
           		i++;
           	}
               builder.append((char) byteRead);
           }
           buffer.close();
          
             for(int x = 0 ; x<=i; x++)
           {
           	if(name[x][0] == 'f' && name[x][1] == 'r')
           	{	
           		lang[k] = name[x-1];
           	//	System.out.println(lang[k]);
           		code[k] = name[x] ;
           	//	System.out.println(code[k]);
           		Toast m = Toast.makeText(getBaseContext(),"French", Toast.LENGTH_LONG);
        		m.show();
           		k++;
           	}
           	else
           		if(name[x][0] == 'j' && name[x][1] == 'a')
           		{
           			lang[k] = name[x-1] ;
              // 		System.out.println(lang[k]);
               		code[k] = name[x] ;
               	//	System.out.println(code[k]);
               		Toast m = Toast.makeText(getBaseContext(),"Japanese", Toast.LENGTH_LONG);
            		m.show();
               		k++;
           		}
           		else
           			if(name[x][0] == 'e' && name[x][1] == 'n')
           			{
           				lang[k] = name[x-1] ;
                  // 		System.out.println(lang[k]);
                   		code[k] = name[x] ;
                   	//	System.out.println(code[k]);
                   		Toast m = Toast.makeText(getBaseContext(),"English", Toast.LENGTH_LONG);
                		m.show();
                   		k++;
           			}
           			else
           				if(name[x][0] == 'e' && name[x][1] == 's')
           				{
           					lang[k] = name[x-1] ;
                      // 		System.out.println(lang[k]);
                       		code[k] = name[x] ;
                       	//	System.out.println(code[k]);
                       		Toast m = Toast.makeText(getBaseContext(),"Spanish", Toast.LENGTH_LONG);
                    		m.show();
                       		k++;
           				}
           				else
           					if(name[x][0] == 'i' && name[x][1] ==  't')
           					{
           						lang[k] = name[x-1] ;
                          // 		System.out.println(lang[k]);
                           		code[k] = name[x] ;
                           	//	System.out.println(code[k]);
                           		Toast m = Toast.makeText(getBaseContext(),"Italian", Toast.LENGTH_LONG);
                        		m.show();
                           		k++;
           					}
               				else
               					if(name[x][0] == 'd' && name[x][1] ==  'e')
               					{
               						lang[k] = name[x-1] ;
                              		System.out.println(lang[k]);
                               		code[k] = name[x];
                               		System.out.println(code[k] );
                               		Toast m = Toast.makeText(getBaseContext(),"Jarman", Toast.LENGTH_LONG);
                               		m.show();
                               		k++;
               					}
           }
          } catch (MalformedURLException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
           ex.printStackTrace();
       }
       return;
   }

	private Context getBaseContext() {
		// TODO Auto-generated method stub
		return null;
	}
}
