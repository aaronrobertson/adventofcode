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
                int [] box = new int[4];
                if (delimited[0].compareTo("toggle") == 0){
                    
                    String[] temp = delimited[1].split(",");
                    box[0] = Integer.parseInt(temp[0]);
                    box[1] = Integer.parseInt(temp[1]);
                    temp = delimited[3].split(",");
                    box[2] = Integer.parseInt(temp[0]);
                    box[3] = Integer.parseInt(temp[1]);
                    lightIns(lights,box,0);
                    
                } else if(delimited[0].compareTo("turn") == 0){
                    
                    String[] temp = delimited[2].split(",") ;
                    box[0] = Integer.parseInt(temp[0]);
                    box[1] = Integer.parseInt(temp[1]);
                    temp = delimited[4].split(",");
                    box[2] = Integer.parseInt(temp[0]);
                    box[3] = Integer.parseInt(temp[1]);
                    
                    if (delimited[1].compareTo("on") == 0){
                        
                        lightIns(lights,box,2);
                        
                    } else if (delimited[1].compareTo("off") == 0){
                        
                        lightIns(lights,box,1);
                        
                    }
                }
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        int count = 0;
        for(boolean[] i : lights){
            for(boolean j : i){
                if (j) {count++;}  
            }
        }
        System.out.println("Total Lights On: "+count);
    }
    public static void lightIns(boolean[][] lights, int[] box, int operation){
        
        if(operation==0){//toggle
            for (int i = box[0]; i <= box [2]; i++){
                for (int j = box[1]; j <= box[3]; j++){
                    lights[i][j] = !(lights[i][j]);
                }
            }
        }else{
            boolean newState=false;//off
            if (operation == 2){//on
                newState=true;
            }
            for (int i = box[0]; i <= box [2]; i++){
                for (int j = box[1]; j <= box[3]; j++){
                    lights[i][j]=newState;
                }
            }
        }
            
    }
}