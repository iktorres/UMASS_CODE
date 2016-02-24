/********************************
* File: HeartDiseaseNetwork.java
* Description: This class defines the Heart Disease Network
* Author: Ian Torres
* Date: 12/11/2015
*********************************/

 public class HeartDiseaseNetwork{
 
    //Add class variables as needed
//	private int[][]  binValues        = new int[200][4]; 
//	
//	private int[]    chData           = new int[200];
//	private int[]    hdData           = new int[200];
//	private int[]    cpData           = new int[200];
//	private int[]    hrData           = new int[200];
	
	private double   PCH_0            = 0.0;
	private double   PCH_1            = 0.0;
	
	private double   PHD_0gCH_0       = 0.0;
	private double   PHD_0gCH_1       = 0.0;
	private double   PHD_1gCH_1       = 0.0;
	private double   PHD_1gCH_0       = 0.0;
	
	private double   PCP_0gHD_0       = 0.0;
	private double   PCP_0gHD_1       = 0.0;
	private double   PCP_1gHD_1       = 0.0;
	private double   PCP_1gHD_0       = 0.0;
	
	private double   PHR_0gHD_0       = 0.0;
	private double   PHR_0gHD_1       = 0.0;
	private double   PHR_1gHD_1       = 0.0;
	private double   PHR_1gHD_0       = 0.0;
	
    //Create object constructor as needed
    public HeartDiseaseNetwork(){
      //Replace from here ************
//      try {
//    	binValues = MatrixFileReader.readFileInt(200,4,"data/HDdata.txt");
//		
//	    hdData = binValues[1];
//	    chData = binValues[0];
//	    cpData = binValues[2];
//	    hrData = binValues[3];
////	    for(int i = 0; i < 200; i++) {
////	    	System.out.println(" - > " + chData[i]);
////	    }
//
////		for(int i = 0; i < 200; i++) {
////			System.out.println("-> " + chData[i]);
////		}
//	  } catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}  
      //To here **********************
    }
    
    //Code for getting P(CH=ch)
    public double getPCH(int ch){
      //Replace from here ************
      return (ch == 1)?this.PCH_1:this.PCH_0;    
      //To here **********************    
    }
    
    //Code for getting P(HD=hd|CH=ch)
    public double getPHDgCH(int hd, int ch){
      //Replace from here ************
      return (ch == 0) ? ((hd == 1) ? this.PHD_1gCH_0:this.PHD_0gCH_0):((hd == 1)?this.PHD_1gCH_1:this.PHD_0gCH_1);     
      //To here **********************    
    }
    
    //Code for getting P(CP=cp|HD=hd)    
    public double getPCPgHD(int cp, int hd){
      //Replace from here ************
      return (hd == 0) ? ((cp == 1) ? this.PCP_1gHD_0:this.PCP_0gHD_0):((cp == 1)?this.PCP_1gHD_1:this.PCP_0gHD_1);    
      //To here **********************    
    }
    
    //Code for getting P(HR=hr|HD=hd)        
    public double getPHRgHD(int hr, int hd){
      //Replace from here ************
      return (hd == 0) ? ((hr == 1) ? this.PHR_1gHD_0:this.PHR_0gHD_0):((hr == 1)?this.PHR_1gHD_1:this.PHR_0gHD_1);    
      //To here **********************    
    }
    
    //Code for setting P(CH=ch)
    public void setPCH(double p, int ch){
      //Replace from here ************
      if(ch == 1) {
    	  this.PCH_1 = p;
    	  //this.PCH_0 = 1 - p;
      }else {
    	  this.PCH_0 = p;
    	  //this.PCH_1 = 1 - p;
      }
      //To here **********************    
    }
    
    //Code for setting P(HD=hd|CH=ch)
    public void setPHDgCH(double p, int hd, int ch){
      //Replace from here ************
      if(hd == 0 && ch == 0) {       //0,0 -> 1,0
    	  this.PHD_0gCH_0 = p;
    	  //this.PHD_1gCH_0 = 1 - p; 
      }else if(hd == 0 && ch == 1) { //0,1 -> 1,1
    	  this.PHD_0gCH_1 = p;
    	  //this.PHD_1gCH_1 = 1 - p;
      }else if(hd == 1 && ch == 1) { //1,1 -> 0,1
    	  this.PHD_1gCH_1 = p;
    	  //this.PHD_0gCH_1 = 1 - p;
      }else {                       //1,0 -> 0,0
    	  this.PHD_1gCH_0 = p;
    	  //this.PHD_0gCH_0 = 1 - p;
      }
      //To here **********************    
    }
    
    //Code for setting P(CP=cp|HD=hd) 
    public void setPCPgHD(double p, int cp, int hd){
      //Replace from here ************
      if(cp == 0 && hd == 0) {       //0,0 -> 1,0
          this.PCP_0gHD_0 = p;
      	  //this.PCP_1gHD_0 = 1 - p; 
      }else if(cp == 0 && hd == 1) { //0,1 -> 1,1
      	  this.PCP_0gHD_1 = p;
      	  //this.PCP_1gHD_1 = 1 - p;
      }else if(cp == 1 && hd == 1) { //1,1 -> 0,1
      	  this.PCP_1gHD_1 = p;
      	  //this.PCP_0gHD_1 = 1 - p;
      }else {                        //1,0 -> 0,0
      	  this.PCP_1gHD_0 = p;
      	  //this.PCP_0gHD_0 = 1 - p;
      }
      //To here **********************    
    }
    
    //Code for setting P(HR=hr|HD=hd)  
    public void setPHRgHD(double p, int hr, int hd){
      //Replace from here ************
      if(hr == 0 && hd == 0) {       //0,0 -> 1,0
          this.PHR_0gHD_0 = p;
       	  //this.PHR_1gHD_0 = 1 - p; 
      }else if(hr == 0 && hd == 1) { //0,1 -> 1,1
       	  this.PHR_0gHD_1 = p;
       	  //this.PHR_1gHD_1 = 1 - p;
      }else if(hr == 1 && hd == 1) { //1,1 -> 0,1
       	  this.PHR_1gHD_1 = p;
       	  //this.PHR_0gHD_1 = 1 - p;
      }else {                       //1,0 -> 0,0
       	  this.PHR_1gHD_0 = p;
       	  //this.PHR_0gHD_0 = 1 - p;
      }
      //To here **********************    
    }    
  
    //Code for computing the joint probability P(CH=ch, HD=hd, CP=cp, HR=hr)  
    public double jointProbability(int ch, int hd, int cp, int hr){
      //Replace from here ************
      return this.getPCH(ch)*this.getPHDgCH(hd, ch)*this.getPCPgHD(cp, hd)*this.getPHRgHD(hr, hd);
      //To here **********************    
    }

    //Code for computing the heart disease probability P(HR=1|CH=ch, CP=cp, HR=hr)     
    public double heartDiseaseProbability(int ch, int cp, int hr){
      //Replace from here ************
      double denominator = this.jointProbability(ch, 1, cp, hr)+this.jointProbability(ch, 0, cp, hr);
      return this.jointProbability(ch, 1, cp, hr)/denominator;
      //To here **********************    
    }

    //Code for predicting whether the patient has heart disease 
    //based on whether P(HR=1|CH=ch, CP=cp, HR=hr)> 0.5     
    public Boolean heartDiseasePrediction(int ch, int cp, int hr){
      //Replace from here ************
      return (heartDiseaseProbability(ch,cp,hr) > 0.5)?true:false;
      //To here **********************    
    }  
  
    //Code for estimating P(CH=ch) from data
    public double estimatePCH(int[] chs, int ch){
      //Replace from here ************
      int countOfCH = 0;
      //double division = 0;
//      for(int i = 0; i < chs.length; i++) {
//    	  System.out.println("-> " + chs[i]);
//      }
      for(int i = 0; i < chs.length; i++) {
    	  countOfCH += (chs[i] == ch)?1:0;
      }
      //division = countOfCH/200;
      //System.out.println("Count -> " + countOfCH);
      //System.out.println("Division -> " + division);
      return (((double)countOfCH)/200);
      //To here **********************    
    }

    //Code for estimating P(HD=hd|CH=ch) from data    
    public double estimatePHDgCH(int[] hds, int[] chs, int hd, int ch){
      //Replace from here ************
      int countOfHDgCHNum = 0;
      int countOfHDgCHDen = 0;
      for(int i = 0; i < hds.length; i++) {
    	  countOfHDgCHNum += (hds[i] == hd && chs[i] == ch)?1:0;
    	  countOfHDgCHDen += (chs[i] == ch)?1:0;
      }
      return (double)countOfHDgCHNum/countOfHDgCHDen;
      //To here **********************    
    }
    
    //Code for estimating P(CP=cp|HD=hd) from data        
    public double estimatePCPgHD(int[] cps, int[] hds,  int cp, int hd){
      //Replace from here ************
      int countOfCPgHDNum = 0;
      int countOfCPgHDDen = 0;
      for(int i = 0; i < cps.length; i++) {
    	  countOfCPgHDNum += (cps[i] == cp && hds[i] == hd)?1:0;
    	  countOfCPgHDDen += (hds[i] == hd)?1:0;
      }
      return (double)countOfCPgHDNum/countOfCPgHDDen;
      //To here **********************    
    }
    
    //Code for estimating P(HR=hr|HD=hd) from data            
    public double estimatePHRgHD(int[] hrs, int[] hds, int hr, int hd){
      //Replace from here ************
      int countOfHRgHDNum = 0;
      int countOfHRgHDDen = 0;
      for(int i = 0; i < hds.length; i++) {
    	  countOfHRgHDNum += (hrs[i] == hr && hds[i] == hd)?1:0;
    	  countOfHRgHDDen += (hds[i] == hd)?1:0;
      }
      return (double)countOfHRgHDNum/countOfHRgHDDen;
      //To here **********************    
    }    
  
  
    //This function prints the full heart disease model         
    public void printNetwork(){
    
      //Print P(CH)
      System.out.println("CH:");
      for(int i=0; i<=1;i++){
        double p = getPCH(i);
        System.out.println("  P(CH=" + i + ")=" + String.format("%.5f",p));
      }

      //Print P(HD|CH)
      System.out.println("\nHD:");
      for(int i=0; i<=1;i++){
        for(int j=0; j<=1;j++){
          double p = getPHDgCH(j,i);
          System.out.println("  P(HD=" + j + "|CH=" + i + ")=" + String.format("%.5f",p));
        }  
      }

      //Print P(CP|HD)
      System.out.println("\nCP:");
      for(int i=0; i<=1;i++){
        for(int j=0; j<=1;j++){
          double p = getPCPgHD(j,i);
          System.out.println("  P(CP=" + j + "|HD=" + i + ")=" + String.format("%.5f",p));
        }
      }
      
      //Print P(HR|HD)
      System.out.println("\nHR:");
      for(int i=0; i<=1;i++){
        for(int j=0; j<=1;j++){
          double p = getPHRgHD(j,i);
          System.out.println("  P(HR=" + j + "|HD=" + i + ")=" + String.format("%.5f",p));
        }
      }
    }
 }