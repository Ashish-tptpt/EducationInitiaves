import java.util.Scanner;
import java.util.ArrayList;

public class Education_Initiavites_project {

    static boolean cango(int[][] array, int dir,int xcord,int ycord){
        boolean answer =true ;
        if(dir ==1 && ycord==0){answer =false;}
        else if(dir ==2 && xcord==(array[0].length-1)){answer =false;}
        else if(dir ==3 && ycord==array.length-1){answer =false;}
        else if(dir ==4 && xcord==0){answer =false;}
        else{answer =true;}
        return answer;
    }
    

    static int getdirno(char xyz){
        int rover_dir_no=0;
        switch (xyz) {
            case 'N':
                rover_dir_no = 1;
                break;
            case 'E':
                rover_dir_no = 2;
                break;
            case 'S':
                rover_dir_no = 3;
                break;
            case 'W':
                rover_dir_no = 4;
                break;
            default:
                break;
        }
        return rover_dir_no;
    }
    static char getdirchar(int xyz){
        char rover_dir_char='N';
        switch (xyz) {
            case 1:
                rover_dir_char = 'N';
                break;
            case 2:
                rover_dir_char = 'E';
                break;
            case 3:
                rover_dir_char = 'S';
                break;
            case 4:
                rover_dir_char = 'W';
                break;
            default:
                break;
        }
        return rover_dir_char;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        int grid_rows,grid_cols ;
        System.out.println("Grid Size:");
        grid_rows = scanner.nextInt(); grid_cols = scanner.nextInt();
        
        int rover_xcord,rover_ycord ;
        char rover_direction ;
        System.out.println("Starting Position:");
        rover_xcord = scanner.nextInt(); rover_ycord = scanner.nextInt();rover_direction = scanner.next().charAt(0);
        
        ArrayList<Character> commands = new ArrayList<Character>();
        System.out.println("Enter number of commands:");
        int a = scanner.nextInt();
        System.out.println("Enter Commands:");
        for (int i = 0; i < a; i++) {
            commands.add(scanner.next().charAt(0));
        }
               
        int[][] twoDArray = new int[grid_rows][grid_cols];
        System.out.println("Enter number of obstacle:");
        int b = scanner.nextInt();
        for (int i = 0; i < b; i++) {
            int r1 =scanner.nextInt(),r2 = scanner.nextInt();
            twoDArray[r1-1][r2-1] = 1;
        }

        scanner.close();
        int currdir = getdirno(rover_direction);
        for (int i = 0; i < a; i++) {
            if(commands.get(i) =='M' && cango(twoDArray,currdir,rover_xcord,rover_ycord)){
                switch (currdir) {
                    case 1:
                        rover_ycord -=1;
                        break;
                    case 2:
                        rover_xcord +=1;
                        break;
                    case 3:
                        rover_ycord +=1;
                        break;
                    case 4:
                        rover_xcord -=1;
                        break;
                    default:
                        break;
                }
            }
            else if(commands.get(i)=='R'){
                currdir = (currdir+1)%4;
            }
            else if(commands.get(i)=='L'){
                currdir = (currdir+3)%4;
            }
            else{
        System.out.printf("Status Report: Rover is at (%d, %d) facing %s.", rover_xcord , rover_ycord , rover_direction);
        System.out.printf("Obstacles detected.\n");                
            }
        }
    
    System.out.printf("Final Position : ( %d , %d , %c )\n", rover_xcord , rover_ycord , rover_direction);
    System.out.printf("Final Status Report: Rover is at (%d, %d) facing %s.\n", rover_xcord , rover_ycord , rover_direction);         
    }
}