package pohlighellman;

public class ChinRem {
  public static int solve(int[] ind, int[] mod) {
	  if(ind.length != mod.length || ind.length == 0) return -1;
	  int ans = ind[0];
	  int m = mod[0];
	  int cnst;
	  int[] eucRes;
	  for(int i = 1; i < ind.length; i++) {
            cnst = ind[i] - ans;
	    while(cnst < 0) cnst += mod[i];
	    eucRes = ExtEuc.extEucAlg(mod[i], (m % mod[i]));
	    if (eucRes[0] != 1) return -1;
            while(eucRes[2] < 0) eucRes[2] += mod[i];
	    cnst = cnst*eucRes[2] % mod[i];
	    ans = ans + cnst*m;
	    m *= mod[i];
	  }
	  return ans;
  }
  public static void main(String[] args){
	  System.out.println(solve(new int[]{3,4}, new int[]{7,9})); // 31
          System.out.println(solve(new int[]{137,87}, new int[]{423,191})); // 27209 
          System.out.println(solve(new int[]{133,237}, new int[]{451,697})); // -1
          System.out.println(solve(new int[]{5,6,7}, new int[]{9,10,11})); // 986
          System.out.println(solve(new int[]{37,22,18}, new int[]{43,49,71})); //11733
  }
}
