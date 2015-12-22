import java.util.Arrays;
import java.io.*;

class partTwo{
    
    public static void main(String[] args){
       
        String file = "input.txt";
        String line = "";
        int totalRibbonLength = 0 ;
        
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
                totalRibbonLength += ribbonLength(dimensions);
            }
            System.out.println(totalRibbonLength);
        }catch(Exception e){
            
        }
    }
    
    public static int ribbonLength(int[] d){
        
        int l = d[0], w = d[1], h = d[2];
        int bow = l*w*h;
        
        Arrays.sort(d);
        
        int length = (d[0]*2)+(d[1]*2);
        
        return length+bow;
        
    }
    
}
