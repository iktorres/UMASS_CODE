import java.io.BufferedReader;
import java.util.Arrays;
import java.io.FileReader;

/********************************
* File: MatrixReader.java
* Description: This class provides static methods for reading matrices of numbers
* from text files. 
* Author: B. Marlin, UMass CS240.
* Date: Sept. 15, 2012.
*********************************/

public class MatrixFileReader {
 
    /********************************
    * method: readFileDouble
    * Description: This method reads a nRows x nCols matrix of numbers stored in the
    * given text file into a 2D array of doubles. The numbers must be separated by
    * spaces in the text file. The text file must have nRows rows and each row must
    * have exactly nCols numbers. 
    *
    * inputs: int nRows - number of rows in matrix
    *         int nCols - number of columns in matrix
    *         String dataFileName - file containing matrix 
    * output: double[nRows][nCols] - 2D array containing matrix
    *********************************/

    public static double[][] readFileDouble(int nRows, int nCols,  String dataFileName) throws Exception {

        String line; //String to hold one line of file 
        int r=0; //row counter 
        //declare array to hold result
        double[][] double_array = new double[nCols][nRows];

        //Open text file
        BufferedReader bReader = new BufferedReader(new FileReader(dataFileName));

        //read file line by line
        while ((line = bReader.readLine()) != null) {
            //Split line into strings for each number
            String datavalue[] = line.split(" ");
            //Convert each number string into a double and store
            for (int c=0;c<datavalue.length;c++){
              double_array[c][r] = Double.parseDouble(datavalue[c]); 
            }
            r++;//increment row counter
        }
        bReader.close();//close file reader
        return double_array; //return result array
    }


    /********************************
    * method: readFileInt
    * Description: This method reads a nRows x nCols matrix of numbers stored in the
    * given text file into a 2D array of ints. The numbers must be separated by
    * spaces in the text file. The text file must have nRows rows and each row must
    * have exactly nCols numbers. 
    *
    * inputs: int nRows - number of rows in matrix
    *         int nCols - number of columns in matrix
    *         String dataFileName - file containing matrix 
    * output: int[nRows][nCols] - 2D array containing matrix
    *********************************/

    public static int[][] readFileInt(int nRows, int nCols,  String dataFileName) throws Exception {

        String line; //String to hold one line of file 
        int r=0; //row counter 
        //declare array to hold result
        int[][] int_array = new int[nCols][nRows];

        //Open text file
        BufferedReader bReader = new BufferedReader(new FileReader(dataFileName));

        //read file line by line
        while ((line = bReader.readLine()) != null) {
            //split line into number strings
            String datavalue[] = line.split("\t");
            //convert each number string into an int and store
            for (int c=0;c<datavalue.length;c++){
              int_array[c][r] = Integer.parseInt(datavalue[c].trim()); 
            }
            r++; //increment row counter
        }
        bReader.close(); //close file
        return int_array; //return array
    }

}