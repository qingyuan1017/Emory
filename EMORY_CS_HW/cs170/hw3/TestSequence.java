/*
 * This program allows you to test out your implementation of the methods in
 * Sequence.java. It runs several methods designed to individually test each
 * method you've implemented. This file must be in the same directory as
 * Sequence.java and kiwi_sequence.txt.
 *
 * If you want to test only a few of the methods, rather than all of them at
 * once (I highly recommend doing this) there's two options I recommend:
 * 1. You can implement a method stub in your program, which involves writing
 * out the method header and returning a value of the correct type, even 
 * though the value is likely wrong. This would look something like
 * public static boolean isPrime(int number){
    return false;
 } //this is not true for all numbers, but it compiles.
 * but for the methods you have to implement.
 * 2. You can comment out the methods in this test program that use the
 * methods you haven't implemented, as well as where they're called in the
 * main method.
 */

/*
 * I referenced
http://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
 * http://docs.oracle.com/javase/7/docs/api/java/io/ByteArrayOutputStream.html
 * http://www.tutorialspoint.com/java/io/inputstream_reset.htm
 *
 * http://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 *
 * http://www.zoology.ubc.ca/~bio336/Bio336/Readings/Cooper2001.pdf
 * which lead to http://www.ncbi.nlm.nih.gov/nuccore/AY016010.1
 * (note this is not a full collaboration statement as you should include)
 */

import java.io.*; //ByteArrayOutputStream for redirecting stdout to String
import java.util.Scanner; //for reading in sequence file

public class TestSequence{
    /**
     * Reports the number of tests passed for a method.
     *
     * Prints something of the form 
     * countChar: 9 correct of 9 tested. (100.0% correct).
     *
     * @param method, the name of the method being reported on
     * @param tested, the number of cases tested
     * @param correct, the number of cases passed (correct)
     */
    public static void reportCorrect(String method, int tested, int correct){
        System.out.println(method + ": " + correct + " correct of " + tested
                           + " tested. (" + ((double) correct)/tested*100
                           + "% correct).");
    }

    /**
     * Tests the implementation of countChar(String, character).
     *
     * Tests several cases and prints out information about any case that
     * fails. Prints overall statistics as well.
     *
     * @return true if and only if all tests are passed
     */
    public static boolean testCountChar(){
        //Test inputs and outputs
        int numTested, numCorrect = 0;
        String[] inputStr = {"", "c", "ccc", "pep", "epe", "ccccc", "CCCCC",
                           "koala", "koala"};
        char[] inputChar = {'c', 'c', 'c', 'p', 'p', 'c', 'c', 'a', 'c'};
        int[] expectedCount = {0, 1, 3, 2, 1, 5, 0, 2, 0};
        numTested = inputStr.length;
        
        //Run tests
        for(int i = 0; i < numTested; i++){
            int outputVal = Sequence.countChar(inputStr[i], inputChar[i]);
            if(outputVal != expectedCount[i]){
                System.out.println("Failed: countChar(\"" + inputStr[i]
                                 + "\", " + inputChar[i] + "). Expected "
                                 + expectedCount[i] + ", got " + outputVal);
            } else {
                numCorrect++;
            }
        }
        
        reportCorrect("countChar", numTested, numCorrect);
        
        return numCorrect == numTested;
    }
    
    /**
     * Tests the implementation of parseChromatogram(String).
     *
     * Tests several cases and prints out information about any case that
     * fails. Prints overall statistics as well.
     *
     * @return true if and only if all tests are passed
     */
    public static boolean testParseChromatogram(){
        //Test inputs and outputs
        int numTested, numCorrect = 0;
        String[] inputStr = {"", "r", "g", "b", "k", " ", "  ", "q", "RGBK", 
                             "rgbk", "kbgrrgbk", " r", "g ", " k r ",
                             " rgbkgbrkkggbrkgbegbarbggk gr ", "ACTG"};
        String[] expectedStr = {"", "T", "A", "C", "G", " ", "  ", "?", "????", 
                                "TACG", "GCATTACG", " T", "A ", " G?T ",
                                " TACGACTGGAACTGAC?AC?TCAAG?AT ", "????"};
        numTested = inputStr.length;
        
        //Run tests
        for(int i = 0; i < numTested; i++){
            String outputVal = Sequence.parseChromatogram(inputStr[i]);
            if(!outputVal.equals(expectedStr[i])){
                System.out.println("Failed: parseChromatogram(\""
                                 + inputStr[i] + "\"). Expected \""
                                 + expectedStr[i] + "\", got \"" 
                                 + outputVal + "\".");
            } else {
                numCorrect++;
            }
        }
        
        reportCorrect("parseChromatogram", numTested, numCorrect);
        
        return numCorrect == numTested;
    }
    
    /**
     * Loosely tests the result of calling printInfo.
     *
     * Checks to see if the output of printInfo contains the right
     * information. The check is strictly a simple containment check, and does
     * not guarantee fully correct implementation.
     *
     * @param output, the ouput from running printInfo
     * @param sequence, the DNA sequence that was input to printInfo
     * @param length, the expected length of the DNA sequence
     * @param counts, the expected counts of each character in the output
     * @param countChar, the corresponding characters to the counts
     * @return true if and only if all checks are passed, false otherwise
     */
    public static boolean checkPrintInfo(String output, String sequence,
                                         int length, int[] counts,
                                         char[] countChar)
    {
        //Check that the sequence is in the output
        boolean passed = true;
        if(!output.contains(sequence)){
            passed = false;
            System.out.println("printInfo does not contain the DNA sequence.");
        }
        
        //Check that the sequence's length is in the output
        if(!output.contains("" + length)){
            System.out.print("printInfo: DNA sequence length not reported.");
            passed = false;
        }
        
        //Check that the counts for each character is in the output
        for(int i = 0; i < counts.length; i++){
            if(!output.contains("" + counts[i])){
                System.out.println("printInfo: count reported wrong for '"
                                 + countChar[i] + "'.");
            }
            passed = false;
        }
        
        return passed;
    }
    
    /**
     * Loosely tests the implementation of printInfo with two inputs.
     *
     * Checks the implementation of printInfo using two input sequences. If
     * any values are missing from either case, information will be printed
     * to the terminal. Overall statistics for the cases are printed as well.
     *
     * @return true if and only if both cases are passed; false otherwise
     */
    public static boolean testPrintInfo(){
        //Create our new streams
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        PrintStream redirect = new PrintStream(byteOutStream);
        
        PrintStream stdout = System.out; //This saves stdout, like a temp. var.
        
        //Redirect standard out to our stream
        System.setOut(redirect);
        
        //Print info to our stream
        String sequence1 = " TACGACTGGAACTGAC?AC?TCAAG?AT ";
        Sequence.printInfo(sequence1);
        
        //Make sure the data is actually written to our stream, then grab data
        System.out.flush();
        String out1 = byteOutStream.toString();
        
        //Clear our stream so we can try another output
        byteOutStream.reset();
        
        String sequence2 = "TGG?CAGA?GCTCGG?CAAA?TGCAAAAGGCTTAAG";
        Sequence.printInfo(sequence2);
        //Flush it again, then grab
        System.out.flush();
        String out2 = byteOutStream.toString();
        
        //Reset our output stream to use stdout
        System.setOut(stdout);
        
        //Check the method
        int nRight = 0;
        char[] outChar = {'T', 'A', 'C', 'G', '?'};
        int[] outCount1 = {5, 9, 6, 5, 3};
        int[] outCount2 = {5, 11, 6, 10, 4};
        
        nRight += checkPrintInfo(out1, sequence1, 30, outCount1, outChar)? 0:1;
        nRight += checkPrintInfo(out2, sequence2, 36, outCount2, outChar)? 0:1;
        
        reportCorrect("printInfo", 2, nRight);
        return nRight == 2;
    }
    
    /**
     * Loads the DNA sequence contained in ./kiwi_sequence.txt into a String.
     *
     * Loads all lines of kiwi_sequence.txt into a single string without
     * newline characters. If the file is not found, prints an error message
     * and returns a "flag" empty string.
     *
     * @return the DNA sequence as a string or "" if the file does not exist
     */
    public static String loadSequence(){
        try{
            //Attempt to open the file
            File sequenceFile = new File("kiwi_sequence.txt");
            Scanner sequenceReader = new Scanner(sequenceFile);
            
            String sequence = "";
            
            //Read in each line, discarding \n
            while(sequenceReader.hasNextLine()){
                sequence += sequenceReader.nextLine();
            }
            
            return sequence;

        } catch(FileNotFoundException except){
            //If the file isn't found, report as such and return error value
            System.err.println("Error: kiwi_sequence.txt must be in the same"
                             + " directory. File not found.");
            return "";
        }
        
    }
    
    /**
     * Tests the implementation of findIndex.
     *
     * Uses the kiwi DNA sequence to test the implementation of findIndex with
     * various marker strings. Will not work without kiwi_sequence.txt
     *
     * @return true if and only if all test cases passed.
     */
    public static boolean testFindIndex(){
        //Load the input data from the sequence file
        String sequence = loadSequence();
        if(sequence.equals("")){
            return false;
        }
        
        //Other inputs and outputs
        String[] substrings = {"ATC", "AAAAGGCTT", "TTC", "A", "a",
                               "TCTAATAGTT", "AAAAG", "AGAA", "CAAT", "T",
                               "T", "ATAAAAAA"};
        int[] expectedOut = {0, 200, 7, 0, -1, 12250, 73, 137, 19, 1, 1, 12261};
        int numCorrect = 0, numTested = substrings.length;
        
        //Run tests
        for(int i = 0; i < numTested; i++){
            int outputVal = Sequence.findIndex(sequence, substrings[i]);
            
            if(outputVal != expectedOut[i]){
                System.out.println("Failed: findIndex("+ substrings[i] + ")."
                                 + " Expected " + expectedOut[i] + ", got " 
                                 + outputVal + ".");
            } else {
                numCorrect++;
            }
        }
        
        reportCorrect("findIndex", numTested, numCorrect);
        
        return numCorrect == numTested;
    }
    
    /**
     * Tests the implementation of findIndex.
     *
     * Uses the kiwi DNA sequence to test the implementation of
     * findSubsequence with various marker strings. Will not work without
     * kiwi_sequence.txt in the current directory.
     *
     * @return true if and only if all test cases passed.
     */
    public static boolean testFindSubsequence(){
        //Load the input data from the sequence file
        String sequence = loadSequence();
        if(sequence.equals("")){
            return false;
        }
        
        //Other inputs and outputs
        String[] startMarkers = {"ATC", "AAAAGGCTT", "TTC", "A", "a",
                                 "TCTAATAGTT"};
        String[] endMarkers = {"AAAAG", "AGAA", "CAAT", "T", "T", "ATAAAAAA"};
        String[] expectedOut 
            = {"ATCTGAGTTCAGACCGGAGCAATCCAGGTCGGTTTCTAT"
               +"CTATGCAACACTCTTCCCAGTACGAAAGGACCGGAAAAG", "",
               "TTCAGACCGGAGCAAT", "AT", "", "TCTAATAGTTTATAAAAAA"};
        int numCorrect = 0, numTested = startMarkers.length;
        
        //Run tests
        for(int i = 0; i < numTested; i++){
            String outputVal = Sequence.findSubsequence(sequence, 
                                                        startMarkers[i],
                                                        endMarkers[i]);
            
            if(!outputVal.equals(expectedOut[i])){
                System.out.println("Failed: findSubsequence(\""
                                 + startMarkers[i] + "\", \"" + endMarkers[i]
                                 + "\"). Expected \""
                                 + expectedOut[i] + "\", got \"" 
                                 + outputVal + "\".");
            } else {
                numCorrect++;
            }
        }
        
        reportCorrect("findSubsequence", numTested, numCorrect);
        
        return numCorrect == numTested;
    }
    
    /**
     * Runs all tests.
     *
     * Expected output for correct implementation:
     * countChar: 9 correct of 9 tested. (100.0% correct).
     * parseChromatogram: 16 correct of 16 tested. (100.0% correct).
     * printInfo: 2 correct of 2 tested. (100.0% correct).
     * findIndex: 12 correct of 12 tested. (100.0% correct).
     * findSubsequence: 6 correct of 6 tested. (100.0% correct).
     *
     * You passed all of the tests! Great job!!!
     */
    public static void main(String[] args){
        //Run all of the tests
        boolean allPassed = true;
        allPassed = testCountChar() && allPassed;
        allPassed = testParseChromatogram() && allPassed;
        allPassed = testPrintInfo() && allPassed;
        allPassed = testFindIndex() && allPassed;
        allPassed = testFindSubsequence() && allPassed;
        
        //Special message if all are passed
        if(allPassed){
            System.out.println("\nYou passed all of the tests! Great job!!!");
        }
    }
}
