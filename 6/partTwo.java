import java.io.*;

class partTwo{
    
    public static void main(String[] args){
        
        int[][] lights = new int[1000][1000];
        
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
                        
                        lightIns(lights,box,1);
                        
                    } else if (delimited[1].compareTo("off") == 0){
                        
                        lightIns(lights,box,2);
                        
                    }
                }
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        int count = 0;
        for(int[] i : lights){
            for(int j : i){
                count+=j;  
            }
        }
        System.out.println("Total Brightness: "+count);
    }
    public static void lightIns(int[][] lights, int[] box, int operation){
        
        if(operation==0){//toggle
            for (int i = box[0]; i <= box [2]; i++){
                for (int j = box[1]; j <= box[3]; j++){
                    lights[i][j] += 2;
                }
            }
        }else if(operation==1){
           for (int i = box[0]; i <= box [2]; i++){
                for (int j = box[1]; j <= box[3]; j++){
                    lights[i][j]+=1;
                }
            }
        }else if(operation==2){
            for (int i = box[0]; i <= box [2]; i++){
                for (int j = box[1]; j <= box[3]; j++){
                    if(lights[i][j]>0){
                        lights[i][j]-=1;
                    }
                }
            }
        }
            
    }
}