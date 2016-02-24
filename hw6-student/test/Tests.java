/********************************
* File: tests.java
* Description: This class provides tests for the
* ConditionalProbabilityTree class
* Author: B. Marlin and M. Lanighan. UMass Amherst CS240.
* Date: Sept. 19, 2015.
*********************************/

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.lang.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Tests { 
    
    public HeartDiseaseNetwork hdn;
    
    @Before // setup()
      public void before() throws Exception {
          hdn = new HeartDiseaseNetwork();
          
          //Set P(CH=0)=0.1, P(CH=1)=0.9
          hdn.setPCH(0.25,0);
          hdn.setPCH(0.75,1);
          
          //Set P(HD=0|CH=0)=0.1, P(HD=0|CH=1)=0.2
          hdn.setPHDgCH(0.65,0,0);
          hdn.setPHDgCH(0.35,1,0);
          hdn.setPHDgCH(0.2,0,1);
          hdn.setPHDgCH(0.8,1,1);
          
          //Set P(CP=0|HD=0)=0.3, P(CP=0|HD=1)=0.4
          hdn.setPCPgHD(0.85,0,0);
          hdn.setPCPgHD(0.15,1,0);
          hdn.setPCPgHD(0.45,0,1);
          hdn.setPCPgHD(0.55,1,1);

          //Set P(HR=0|HD=0)=0.6, P(HR=0|HD=1)=0.7
          hdn.setPHRgHD(0.3,0,0);
          hdn.setPHRgHD(0.7,1,0);          
          hdn.setPHRgHD(0.81,0,1);
          hdn.setPHRgHD(0.19,1,1);
          
      }    
    
    @Test
    public void test00_PCH(){
      //This test is just to display the network you have stored.
      //it does not include any asserts. The asserts are given in
      //the tests below.
      System.out.println("Your Stored Network:");
      hdn.printNetwork();
      System.out.println("----------------------------------");
    }
    
    @Test
    public void test01_PCH(){
      //Test getting and setting for CH
      
      double yourP;
      double trueP;
      int ch;

      System.out.println("Testing getPCH/setPCH");
      
      ch=0; 
      trueP = 0.25;      
      yourP = hdn.getPCH(ch); 
      System.out.println("   Your P(CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   True P(CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);

      ch=1; 
      trueP = 0.75;
      yourP = hdn.getPCH(ch); 
      System.out.println("   Your P(CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   True P(CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
   }

    @Test
    public void test02_PHD(){
      //Test getting and setting for HD    
    
      double yourP;
      double trueP;
      int hd,ch;

      System.out.println("Testing getPHDgCH/setPHDgCH");      
      
      hd=0;ch=0; 
      trueP = 0.65;      
      yourP = hdn.getPHDgCH(hd,ch); 
      System.out.println("   Your P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);

      hd=1;ch=0; 
      trueP = 0.35;      
      yourP = hdn.getPHDgCH(hd,ch); 
      System.out.println("   Your P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      hd=0;ch=1; 
      trueP = 0.2;      
      yourP = hdn.getPHDgCH(hd,ch); 
      System.out.println("   Your P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      hd=1;ch=1; 
      trueP = 0.8;      
      yourP = hdn.getPHDgCH(hd,ch); 
      System.out.println("   Your P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);      
   }
    

    @Test
    public void test03_PCP(){
      //Test getting and setting for CP
    
      double yourP;
      double trueP;
      int cp,hd;

      System.out.println("Testing getPCPgHD/setPCPgHD");      
      
      cp=0;hd=0; 
      trueP = 0.85;      
      yourP = hdn.getPCPgHD(cp,hd); 
      System.out.println("   Your P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);

      cp=1;hd=0; 
      trueP = 0.15;      
      yourP = hdn.getPCPgHD(cp,hd);
      System.out.println("   Your P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      cp=0;hd=1; 
      trueP = 0.45;      
      yourP = hdn.getPCPgHD(cp,hd); 
      System.out.println("   Your P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      cp=1;hd=1; 
      trueP = 0.55;      
      yourP = hdn.getPCPgHD(cp,hd); 
      System.out.println("   Your P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);      
   }
    
    @Test
    public void test04_PHR(){
      //Test getting and setting for HR    
    
      double yourP;
      double trueP;
      int hr,hd;

      System.out.println("Testing getPHRgHD/setPHRgHD");      
      
      hr=0;hd=0; 
      trueP = 0.30;      
      yourP = hdn.getPHRgHD(hr,hd); 
      System.out.println("   Your P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);

      hr=1;hd=0; 
      trueP = 0.70;      
      yourP = hdn.getPHRgHD(hr,hd);
      System.out.println("   Your P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      hr=0;hd=1; 
      trueP = 0.81;      
      yourP = hdn.getPHRgHD(hr,hd); 
      System.out.println("   Your P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      hr=1;hd=1; 
      trueP = 0.19;      
      yourP = hdn.getPHRgHD(hr,hd); 
      System.out.println("   Your P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);      
   }
      
    @Test
    public void test05_Joint(){
      //Test joint probability computations
    
      double yourP;
      double trueP;
      int i=0;

      //Define true joint probs
      double[] trueJoints = new double[]{0.04144,0.09669,0.00731,0.01706,0.03189,0.00748,0.03898,0.00914,0.03825,0.08925,0.00675,0.01575,0.21870,0.05130,0.26730,0.06270};
      
      System.out.println("Testing Joint Distributions");      

      //Print out the joint probability for all
      //joint configurations of all of the variables
      for(int ch=0;ch<=1;ch++){
        for(int hd=0;hd<=1;hd++){
          for(int cp=0;cp<=1;cp++){
            for(int hr=0;hr<=1;hr++){
              yourP = hdn.jointProbability(ch,hd,cp,hr);
              trueP = trueJoints[i];
              
              System.out.println("     Your P(CH=" + ch + ", HD=" + hd + ", CP=" + cp + " HR=" + hr + ")=" + String.format("%.5f",yourP) );

              System.out.println("     True P(CH=" + ch + ", HD=" + hd + ", CP=" + cp + " HR=" + hr + ")=" + String.format("%.5f\n",trueP) );

              org.junit.Assert.assertEquals(trueP,yourP,1e-4);
              i=i+1;
            }
          }
        }
      }        
   }
         
    @Test
    public void test06_Predictive(){
      //Test HD predictive distributions
    
    
      double yourP;
      double trueP;
      int i=0;

      //Define true predictive probs
      double[] truePreds = new double[]{0.43493,0.07182,0.84204,0.34891,0.85114,0.36499,0.97537,0.79924};
      
      System.out.println("Testing Predictive Distributions");      

      //Print out the heart disease probability for all
      //joint configurations of the evidence variables
      for(int ch=0;ch<=1;ch++){
        for(int cp=0;cp<=1;cp++){
          for(int hr=0;hr<=1;hr++){
            yourP = hdn.heartDiseaseProbability(ch,cp,hr);
            trueP = truePreds[i];

            System.out.println("     Your P(HD=1|CH=" + ch + ", CP=" + cp + ", HR=" + hr + ")=" + String.format("%.5f",yourP)); 
            System.out.println("     True P(HD=1|CH=" + ch + ", CP=" + cp + ", HR=" + hr + ")=" + String.format("%.5f\n",trueP));
            org.junit.Assert.assertEquals(trueP,yourP,1e-4);
            i=i+1;
          }
        }
      } 
   }

    @Test
    public void test06b_Predictions(){
      //Test HD predictions
    
    
      boolean yourPred;
      boolean truePred;
      int i=0;

      //Define true predictive probs
      double[] truePs = new double[]{0.43493,0.07182,0.84204,0.34891,0.85114,0.36499,0.97537,0.79924};
      
      System.out.println("Testing Predictions");      

      //Print out the heart disease probability for all
      //joint configurations of the evidence variables
      for(int ch=0;ch<=1;ch++){
        for(int cp=0;cp<=1;cp++){
          for(int hr=0;hr<=1;hr++){
            yourPred = hdn.heartDiseasePrediction(ch,cp,hr);
            truePred = truePs[i]>0.5;

            System.out.println("     Your Prediction for CH=" + ch + ", CP=" + cp + ", HR=" + hr + ": " + String.format("%b",yourPred)); 
            System.out.println("     True Prediction for CH=" + ch + ", CP=" + cp + ", HR=" + hr + ": " + String.format("%b\n",truePred));
            org.junit.Assert.assertEquals(yourPred,truePred);
            i=i+1;
          }
        }
      } 
   }
   
   
    @Test
    public void test07_Estimation_PCH() throws Exception{
      //Test estimation for CH
    
      double yourP;
      double trueP;
      int ch;

      //Read in the training data into a 4x200 integer array   
      int[][] data = MatrixFileReader.readFileInt(200, 4, "data/HDdata.txt");
 
      System.out.println("Testing Estimation for CH");      

      ch=0; 
      trueP = 0.13;      
      yourP = hdn.estimatePCH(data[0], ch);
      System.out.println("   Your Estimated P(CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   True Estimated P(CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);

      ch=1; 
      trueP = 0.87;
      yourP = hdn.estimatePCH(data[0], ch); 
      System.out.println("   Your Estimated P(CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   True Estimated P(CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);      

   }      
      
      
    @Test
    public void test08_Estimation_PHD() throws Exception{
      //Test estimation for HD
      
      double yourP;
      double trueP;
      int hd,ch;

      //Read in the training data into a 4x200 integer array   
      int[][] data = MatrixFileReader.readFileInt(200, 4, "data/HDdata.txt");      
      
      System.out.println("Testing Estimation for HD");      
      
      hd=0;ch=0; 
      trueP = 0.6154;      
      yourP = hdn.estimatePHDgCH(data[1],data[0],hd,ch); 
      System.out.println("   Your Estimated P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);

      hd=1;ch=0; 
      trueP = 0.3846;      
      yourP = hdn.estimatePHDgCH(data[1],data[0],hd,ch); 
      System.out.println("   Your Estimated P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      hd=0;ch=1; 
      trueP = 0.5345;      
      yourP = yourP = hdn.estimatePHDgCH(data[1],data[0],hd,ch); 
      System.out.println("   Your Estimated P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      hd=1;ch=1; 
      trueP = 0.4655;      
      yourP = yourP = hdn.estimatePHDgCH(data[1],data[0],hd,ch); 
      System.out.println("   Your Estimated P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(HD="+ hd +"|CH=" + ch + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);      
   }
      
      
    @Test
    public void test09_PCP() throws Exception{
      //Test estimation for CP
      
      double yourP;
      double trueP;
      int cp,hd;


      //Read in the training data into a 4x200 integer array   
      int[][] data = MatrixFileReader.readFileInt(200, 4, "data/HDdata.txt");        
      
      System.out.println("Testing Estimation for CP");      
      
      cp=0;hd=0; 
      trueP = 0.8349;      
      yourP = hdn.estimatePCPgHD(data[2],data[1],cp,hd);
      System.out.println("   Your Estimated P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);

      cp=1;hd=0; 
      trueP = 0.1651;      
      yourP = hdn.estimatePCPgHD(data[2],data[1],cp,hd);
      System.out.println("   Your Estimated P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      cp=0;hd=1; 
      trueP = 0.3956;      
      yourP = hdn.estimatePCPgHD(data[2],data[1],cp,hd); 
      System.out.println("   Your Estimated P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      cp=1;hd=1; 
      trueP = 0.6044;      
      yourP = hdn.estimatePCPgHD(data[2],data[1],cp,hd);
      System.out.println("   Your Estimated P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(CP="+ cp +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);      
   }
      

    @Test
    public void test10_PHR() throws Exception{
      //Test estimation for HR
      
      double yourP;
      double trueP;
      int hr,hd;

      //Read in the training data into a 4x200 integer array   
      int[][] data = MatrixFileReader.readFileInt(200, 4, "data/HDdata.txt");          
      
      System.out.println("Testing Estimation for HR");      
      
      hr=0;hd=0; 
      trueP = 0.2110;      
      yourP = hdn.estimatePHRgHD(data[3],data[1],hr,hd);
      System.out.println("   Your Estimated P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);

      hr=1;hd=0; 
      trueP = 0.7890;      
      yourP = hdn.estimatePHRgHD(data[3],data[1],hr,hd);
      System.out.println("   Your Estimated P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      hr=0;hd=1; 
      trueP = 0.5275;      
      yourP = hdn.estimatePHRgHD(data[3],data[1],hr,hd);
      System.out.println("   Your Estimated P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);
      
      hr=1;hd=1; 
      trueP = 0.4725;      
      yourP = hdn.estimatePHRgHD(data[3],data[1],hr,hd);
      System.out.println("   Your Estimated P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f",yourP));
      System.out.println("   Your Estimated P(HR="+ hr +"|HD=" + hd + ")=" + String.format("%.4f\n",trueP));
      org.junit.Assert.assertEquals(trueP,yourP,1e-4);      
   }
      
      
      
  public static void main(String [ ] args){
  
    org.junit.runner.JUnitCore.main("Tests");
    
  }  

}
