
//Ian Torres
//November 2, 2015
//Computations
//Professor Marlin
import java.util.Arrays;

class Computations{

  //Computes P(X_ij=x|D=d)
  public static double conditionalProbabilityXijgD(Model M, int i, int j,int x, int d){
	  return (x == 1)? ( M.getPXijeq1gD(i, j, d)):(1 - M.getPXijeq1gD(i, j, d));
  }

  //Computes P(X=x|D=d)  
  public static double conditionalProbabilityXgD(Model M, int[][] x, int d){
	  double product = 1;
	  for(int i = 0; i < 12; i++) {
		  for(int j = 0; j < 12; j++) {
			  product *= conditionalProbabilityXijgD(M,i,j,x[i][j],d);
		  }
	  }
    return product;
  }

  //Computes P(X=x,D=d)    
  public static double jointProbabilityXD(Model M, int[][] x, int d){
    return M.getPD(d) * conditionalProbabilityXgD(M, x, d);
  }

  //Computes P(X=x)      
  public static double marginalProbabilityX(Model M, int[][] x){
	  double sum = 0;
	  for(int i = 0; i < 10; i++) {
		  sum += jointProbabilityXD(M,x,i); 
	  }
    return sum;
  }

  //Computes P(D=d|X=x)        
  public static double conditionalProbabilityDgX(Model M, int d, int[][] x){
    return ((jointProbabilityXD(M,x,d))/(marginalProbabilityX(M,x)));
  }

  //Computes the most likely digit type for image x          
  public static int classify(Model M, int[][] x){
	//long start = System.nanoTime();
	int d = 0;
	for(int i = 0; i < 10; i++) {
		d = (conditionalProbabilityDgX(M,d,x) < conditionalProbabilityDgX(M,i,x))? i : d;
	}
	//long end = System.nanoTime();
	//System.out.println(end - start);
    return d;
  }
  
  //Computes the most likely digit type for image x 
  //as fast as possible: classifies digit ~ 5 x's faster on average per 10000 calls than classify
  public static int fastClassify(Model M, int[][] x){
	  //long start = System.nanoTime();
	  int    d      = 0;
	  for(int i = 0; i < 10; i++) {
		  d = (jointProbabilityXD(M,x,d) < jointProbabilityXD(M,x,i))? i : d;
	  }
	  //long end = System.nanoTime();
	  //System.out.println(end - start);
	  return d;
  }
        
}