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
        TrainCar initialEngine = new TrainCar(0,0,0,true); // there have engine at begging
        theTrain.addAtHead(initialEngine);
        int validElement = validElementAtString(inputFile);

        for(int i = 0; i < validElement  ; i++){
            int addedEngine = 0;// count total count of engine added in the train
            int addedTrain = 0;// count total count of train added in the train


            if (inputFile[i].indexOf("PICKUP") != -1){
                System.out.println("Processing command: " + inputFile[i]);
                String withoutChar = inputFile[i].replace("PICKUP " , "");
                int pickupNum = Integer.valueOf(withoutChar).intValue();

                for(int j = i ; j < pickupNum + 1 + i ; j++){

                    if(inputFile[j].indexOf("engine") != -1){   //search engine first and add engine first
                        TrainCar addEngine = new TrainCar(0,0,0,true);
                        theTrain.addAtHead(addEngine);
                        addedEngine++;
                    }

                    if(inputFile[j].indexOf("oil") != -1){
                        String withoutOilChar = inputFile[j].replace("oil " , "");
                        int oilNum = Integer.valueOf(withoutOilChar).intValue();
                        TrainCar addOilCar = new TrainCar(oilNum , 0 , 0 , false);
                        theTrain.addAtAfter(addOilCar);
                        addedTrain++;
                    }

                    if(inputFile[j].indexOf("wheat") != -1){
                        String withoutWheatChar = inputFile[j].replace("wheat " , "");
                        int wheatNum = Integer.valueOf(withoutWheatChar).intValue();
                        TrainCar addWheatCar = new TrainCar(0 , wheatNum , 0 , false);
                        theTrain.addAtAfter(addWheatCar);
                        addedTrain++;
                    }

                    if(inputFile[j].indexOf("lumber") != -1){
                        String withoutLumberChar = inputFile[j].replace("lumber " , "");
                        int lumberNum = Integer.valueOf(withoutLumberChar).intValue();
                        TrainCar addLumberCar = new TrainCar(0 , 0 , lumberNum , false);
                        theTrain.addAtAfter(addLumberCar);
                        addedTrain++;
                    }
                }
                i = i + pickupNum + 1;
                System.out.println(addedEngine + " engines and " + addedTrain + " cars added to train");

            }

            if(inputFile[i].indexOf("PRINT") != -1){
                int currentEngineNum = theTrain.totalEngine();
                int currentCargoNum = theTrain.totalCargo();
                int currentTotalValue = theTrain.totalValue();
                String str = "Total number of engines: " + currentEngineNum + ", Total number of cargo cars: " + currentCargoNum + ", Total value of cargo: $" + currentTotalValue;
                System.out.println("Processing command: PRINT");
                System.out.println(str);
                System.out.println(theTrain.toString());
                //System.out.println("==============================================");
            }

            if(inputFile[i].indexOf("DROPLAST") != -1){
                String dropValueWithoutChar = inputFile[i].replace("DROPLAST " , "");
                int dropIndex = Integer.valueOf(dropValueWithoutChar).intValue();
                int totalBeforeDropped = theTrain.totalCargo();
                theTrain.dropFromLast(dropIndex);
                int totalAfterDropped = totalBeforeDropped - theTrain.totalCargo();
                System.out.println("Processing command: " + inputFile[i]);
                System.out.println(totalAfterDropped + " cars dropped from train");
            }

            if(inputFile[i].indexOf("DROPFIRST") != -1){
                String dropValueWithoutChar = inputFile[i].replace("DROPFIRST " , "");
                int dropIndex = Integer.valueOf(dropValueWithoutChar).intValue();
                int totalBeforeDropped = theTrain.totalCargo();
                theTrain.dropFromFirst(dropIndex);
                int totalAfterDropped = totalBeforeDropped - theTrain.totalCargo();
                System.out.println("Processing command: " + inputFile[i]);
                System.out.println(totalAfterDropped + " cars dropped from train");
            }

            if(inputFile[i].indexOf("DROP ") != -1){
                String dropTheDropChar = inputFile[i].replace("DROP " , "");
                System.out.println("Processing command: " + inputFile[i]);

                if(dropTheDropChar.indexOf("oil ") != -1){
                    String dropIndexStr = dropTheDropChar.replace("oil " , "");
                    int dropIndex = Integer.valueOf(dropIndexStr).intValue();
                    int droppedNum = theTrain.drop("oil" , dropIndex);
                    System.out.println(droppedNum + " cars dropped from train");
                }else if(dropTheDropChar.indexOf("wheat ") != -1){
                    String dropIndexStr = dropTheDropChar.replace("wheat " , "");
                    int dropIndex = Integer.valueOf(dropIndexStr).intValue();
                    int droppedNum = theTrain.drop("wheat" , dropIndex);
                    System.out.println(droppedNum + " cars dropped from train");
                }else if(dropTheDropChar.indexOf("lumber ") != -1){
                    String dropIndexStr = dropTheDropChar.replace("lumber " , "");
                    int dropIndex = Integer.valueOf(dropIndexStr).intValue();
                    int droppedNum = theTrain.drop("lumber" , dropIndex);
                    System.out.println(droppedNum + " cars dropped from train");
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
        return count ;
    }


}
