import java.io.*;
class main{
    
    public static void main(String[] args){
    
        int[][] houses = new int[10000][2];
    
        String file = "input.txt";
        int character = -1;
        int totalVisited = 1;
        try{
            
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            houses[0][0] = 0;
            houses[0][1] = 0;
            for (int i = 1; (character = bufferedReader.read()) != -1 ; i++){
                
                switch(character){
                    case 'v':
                        houses[i][0] = houses[i-1][0];
                        houses[i][1] = houses[i-1][1]-1;
                        break;
                    case '^':
                        houses[i][0] = houses[i-1][0];
                        houses[i][1] = houses[i-1][1]+1;
                        break;
                    case '>':
                        houses[i][0] = houses[i-1][0]+1;
                        houses[i][1] = houses[i-1][1];
                        break;
                    case '<':
                        houses[i][0] = houses[i-1][0]-1;
                        houses[i][1] = houses[i-1][1];
                        break;
                    default: 
                        System.out.println("Invalid Input");
                    break;
                }
                boolean visited = false;
                for(int j = 0; j < i; j++){
                    if((houses[i][0] == houses[j][0]) && (houses[i][1] == houses[j][1])) {
                        visited = true;
                        j=i;
                    }
                }
                if (!visited) { totalVisited++; }
            }
                
        }catch(Exception e){
            
        }
        System.out.println("Houses visited: " + totalVisited);
    }
    
}