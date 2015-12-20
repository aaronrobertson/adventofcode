import java.util.Scanner;
import java.util.Arrays;
class main{
    
    public static void main(String[] args){
       
        int[] dimensions = {0,0,0};
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter package length: ");
        dimensions[0] = in.nextInt();
        System.out.println("Enter package width: ");
        dimensions[1] = in.nextInt();
        System.out.println("Enter package height: ");
        dimensions[2] = in.nextInt();
        
        
        System.out.println("Total required wrapping paper (sqft): "+surfaceArea(dimensions));
        
    }
    
    public static int surfaceArea(int[] d){
        
        int l = d[0], w = d[1], h = d[2];
        int SA = 2*((l*w)+(w*h)+(h*l));
        
        Arrays.sort(d);
        
        int EXTRA = d[0]*d[1];
        
        return SA+EXTRA;
        
    }
    
}
