import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

class main{
    
    public static void main(String[] args){
       
        String file = "input.txt";
        String line = "";
        int totalSurfaceArea = 0 ;
        
        try{
            
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while ((line = bufferedReader.readLine()) != null){
                String[] dimensionsString = new String[3];
                dimensionsString = line.split("x");
                int[] dimensions = new int[3];
                for(int i = 0; i < dimensionsString.length; i++){
                    dimensions[i]=Integer.parseInt(dimensionsString[i]);
                }
                totalSurfaceArea += wrappingSurfaceArea(dimensions);
            }
            System.out.println(totalSurfaceArea);
        }catch(Exception e){
            
        }
    }
    
    public static int wrappingSurfaceArea(int[] d){
        
        int l = d[0], w = d[1], h = d[2];
        int SA = 2*((l*w)+(w*h)+(h*l));
        
        Arrays.sort(d);
        
        int EXTRA = d[0]*d[1];
        
        return SA+EXTRA;
        
    }
    
}
