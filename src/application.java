import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.IOException;
import java.util.Scanner;

public class application {


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




}
