import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class application {



    public static void main (String[] args){
        Train theTrain = new Train();
        TrainCar car = new TrainCar(20000 , 0 , 0 , false);
        TrainCar car1 = new TrainCar(0,0,3000000 , false);
        TrainCar car2 = new TrainCar(0,0,0,true);
        TrainCar car3 = new TrainCar(0,200000000,0 , false);
        TrainCar car4 = new TrainCar(100,0,0 , false);


        theTrain.addAtAfter(car);
        theTrain.addAtAfter(car1);
        theTrain.addAtAfter(car2);
        theTrain.addAtAfter(car3);
        theTrain.addAtAfter(car4);
        theTrain.addAtAfter(car4);
        theTrain.addAtAfter(car4);
        theTrain.addAtAfter(car4);
        theTrain.addAtAfter(car4);
        System.out.println(theTrain.toString());
        int s = theTrain.drop("oil" , 1);
        System.out.println(theTrain.toString());
        System.out.println(s);

    }






    /***************************************************************
     * get user input from user keyboard and save as file input name
     * @return return file name from userinput file Name;
     ***************************************************************/
    public static String getFileName(){
        String fileName = "";

        Scanner input = new Scanner(System.in);
        fileName = input.nextLine();
        return fileName;
    }

    /****************************************************************
     * Get input from txt file and read stored into a array of String
     * @param fileName: the input from user
     * @return return the input from file.
     * @throws IOException
     *****************************************************************/

    public static String[] readFile(String fileName) throws IOException{
        String[] inputFile = new String[1000];
        int count = 0;

        FileInputStream file = new FileInputStream(fileName);
        InputStreamReader inputReader = new InputStreamReader(file);
        BufferedReader br = new BufferedReader(inputReader);
        String line = "";

        while ((line = br.readLine()) != null){
            if (line.lastIndexOf("---") < 0){
                inputFile[count] = line;
                count++;
            }
        }
        return inputFile;
    }

    /************************************************
     * To get how many value are avariable at input file
     * @param inputFile the String that included input from input file
     * @return
     */

    public static int validElementAtString(String[] inputFile){
        int count = 0;

        for(int i = 0; i < inputFile.length ; i++){
            if (inputFile[i] != null){
                count += 1;
            }
        }
        return count - 1;
    }


}
