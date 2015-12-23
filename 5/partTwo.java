import java.util.regex.*;
import java.io.*;

class partTwo{
    
    public static void main(String[] args){
        
        String file = "input.txt";
        String line = "";
        int niceString = 0;
        
        String a = ".*([a-z]{2,}).*\\1.*";               //contains a pair of any two letters that appears at least twice in the string without overlapping
        String b = ".*([a-z]).\\1.*";             //contains at least one letter which repeats with exactly one letter between them
       
        Pattern patA = Pattern.compile(a);
        Pattern patB = Pattern.compile(b);
        
        /* Matcher matA = patA.matcher(line);
         Matcher matB = patB.matcher(line);
         
         System.out.println(matA.matches() +" "+ matB.matches());*/
        
        try{
            
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while ((line = bufferedReader.readLine()) != null){
                
                Matcher matA = patA.matcher(line);
                Matcher matB = patB.matcher(line);
                
                if (matA.matches() && matB.matches()){
                    niceString++;
                } 
            }
            
        }catch(Exception e){
        
        }
        System.out.println(niceString);
    }
    
}