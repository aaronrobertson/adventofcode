import java.io.*;
import java.util.Arrays;
class partTwo{
    
    public static void main(String[] args){
    
        int[][][] houses = new int[2][10000][2];
        
    
        String file = "input.txt";
        int character = -1;
        int totalVisited = 1;
        try{
            
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            
            for (int h = 1; (character = bufferedReader.read()) != -1; h++){
                int parity = h % 2;
                int i = (h / 2) + parity;
                switch(character){
                    case 'v':
                        houses[parity][i][0] = houses[parity][i-1][0];
                        houses[parity][i][1] = houses[parity][i-1][1]-1;
                        break;
                    case '^':
                        houses[parity][i][0] = houses[parity][i-1][0];
                        houses[parity][i][1] = houses[parity][i-1][1]+1;
                        break;
                    case '>':
                        houses[parity][i][0] = houses[parity][i-1][0]+1;
                        houses[parity][i][1] = houses[parity][i-1][1];
                        break;
                    case '<':
                        houses[parity][i][0] = houses[parity][i-1][0]-1;
                        houses[parity][i][1] = houses[parity][i-1][1];
                        break;
                    default: 
                        System.out.println("Invalid Input");
                    break;
                }
                boolean visited = false;
                for(int k = 0; k < 2; k++){
                    for(int j = 0; j < i; j++){
                        if((houses[parity][i][0] == houses[k][j][0]) && (houses[parity][i][1] == houses[k][j][1])) {
                            
                            visited = true;
                            j=i;k=3;
                            
                        }
                    }
                }
                if (!visited) { totalVisited++; }
            }
                
        }catch(Exception e){
            System.out.println(e.toString());
        }
        //System.out.println(Arrays.deepToString(houses));
        System.out.println("Houses visited: " + totalVisited);
    }
    
}