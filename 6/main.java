import java.io.*;

class main{
    
    public static void main(String[] args){
        
        boolean[][] lights = new boolean[1000][1000];
        
        String file = "input.txt";
        String line = "";
        
        try{
            
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while ((line = bufferedReader.readLine()) != null){
                String[] delimited = line.split(" ");
                if (delimited[0].equals("toggle")){
                    
                } else if(delimited[0].equals("turn")){
                    if (delimited[1].equals("on"){
                        
                    } else if (delimited[1].equals("off")){
                        
                    }
                }
            }
            
        }catch(Exception e){
        
        }
    }
    public void lightIns(boolean[][] lights, int[] box, int operation){
        
        if(operation==0){//toggle
            for (int i = box[0]; i < box [3]; i++){
                for (int j = box[3]; j<box[4]; j++){
                    lights[i][j] = !(lights[i][j]);
                }
            }
        }else{
            boolean newState=false;//off
            if (operation==2){//on
                newState=true;
            }
            for (int i = box[0]; i < box [3]; i++){
                for (int j = box[3]; j<box[4]; j++){
                    lights[i][j]=newState;
                }
            }
        }
            
    }
}