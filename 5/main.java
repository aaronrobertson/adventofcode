import java.util.regex.*;
import java.io.*;

class main{
    
    public static void main(String[] args){
        
        String file = "input.txt";
        String line = "";
        int niceString = 0;
        
        String a = "(.*[aeiou].*){3,}";               //contains at least three vowels
        String b = ".*([a-z])\\1.*";             //contains at least one letter that appears twice in a row
        String c = ".*((ab)|(cd)|(pq)|(xy)).*";       //does not contain ab,cd,pq, or xy (inverse)
       
        Pattern patA = Pattern.compile(a);
        Pattern patB = Pattern.compile(b);
        Pattern patC = Pattern.compile(c);
        
        /* Matcher matA = patA.matcher(line);
         Matcher matB = patB.matcher(line);
         Matcher matC = patC.matcher(line);
         
         System.out.println(matA.matches() +" "+ matB.matches()+" "+matC.matches());*/
        
        try{
            
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while ((line = bufferedReader.readLine()) != null){
                
                Matcher matA = patA.matcher(line);
                Matcher matB = patB.matcher(line);
                Matcher matC = patC.matcher(line);
                
                if (matA.matches() && matB.matches() && !matC.matches()){
                    niceString++;
                } 
            }
            
        }catch(Exception e){
        
        }
        System.out.println(niceString);
    }
    
}