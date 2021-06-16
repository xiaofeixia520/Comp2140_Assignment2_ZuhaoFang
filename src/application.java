import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class application {



    public static void main (String[] args) throws IOException{
        System.out.println("Please enter the input file name (.txt files only):");
        String inputFileName = getFileName() ;
        getOutPut(readFile(inputFileName));
        System.out.println("End of processing");
    }

    public static void getOutPut(String[] inputFile){
        Train theTrain = new Train();
        for(int i = 0; i < validElementAtString(inputFile) ; i++){

            if (inputFile[i].indexOf("PICKUP") != -1){
                System.out.println("Processing command: " + inputFile[i]);
                String withoutChar = inputFile[i].replace("PICKUP " , "");
                int pickupNum = Integer.valueOf(withoutChar).intValue();
                int engine = 0;
                int addTrain = 0;
                for(int j = 1 ; j < pickupNum ; j++){

                }
            }
        }
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
        String[] inputFile = new String[100000];
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
