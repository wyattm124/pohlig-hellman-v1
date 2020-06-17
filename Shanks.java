package pohlighellman;

import java.util.Arrays;
import java.util.Comparator;
import java.math.BigInteger;

public class Shanks {
    public static int shanks(int g, int h, int p) {
        int n = 1 + ((int) Math.sqrt(p));
        Indexed[] baby = new Indexed[n];
        Indexed[] giant = new Indexed[n];
        baby[0] = new Indexed(0, BigInteger.ONE);
        giant[0] = new Indexed(0, BigInteger.valueOf(h));
        int gInverse = ExtEuc.extEucAlg(p, g)[2];
        while(gInverse < 0) gInverse += p;
	gInverse = gInverse % p;
        int gIPow = FastMult.expr(gInverse, n, p);
	BigInteger G = BigInteger.valueOf(g);
	BigInteger GIP = BigInteger.valueOf(gIPow);
	BigInteger P = BigInteger.valueOf(p);
        for(int i = 1; i < n; i++) {
            baby[i] = new Indexed(i, baby[i-1].getV().multiply(G).mod(P));
            giant[i] = new Indexed(i, giant[i-1].getV().multiply(GIP).mod(P));
        }
        Arrays.sort(baby, baby[0]);
        Arrays.sort(giant, giant[0]);
        int k;
        for (int j = 0; j < n; j++) {
            k = Arrays.binarySearch(giant, baby[j]);
            if(k > 0) { return ((baby[j].getI() + (giant[k].getI())*n) % (p - 1)); }
        }
        return -1;
    }
}


//public class Shanks {
//    public static void main(String[] args) {
//        Group Ga = new Group(71);
//        Group Gb = new Group(593);
//        Group Gc = new Group(3571);
//        int DLP1 = Ga.shanks(11, 21);    // should be 37
//        int DLP2 = Gb.shanks(156, 116);  // should be 355
//        int DLP3 = Gc.shanks(650, 2213); //  should be 2359
//        System.out.println("shanks 1 : " + DLP1 + " shanks 2 : " + DLP2 + " shanks 3 : " + DLP3);
//    }
//}
