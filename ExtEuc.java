package pohlighellman;

public class ExtEuc {
    public static int[] extEucAlg(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int q = a/b;
        int r = a % b;
	return helper(b, r, 0, 1, 1, (-q));
        // int[] arr = helper(b, r, 0, 1, 1, (-q));
        // String s = "g is --> " + arr[0];
        // s += " u is -->" + arr[1];
        // s += " v is --> " + arr[2];
        // System.out.println(s);
    }
    private static int[] helper(int a, int b, int u_1, int v_1, int u_2, int v_2) {
        int q = a/b;
        int r = a % b;
        if (r == 0) {
            return new int[] {b, u_2, v_2};
        } else {
            return helper(b, r, u_2, v_2, (u_1 - q*u_2), (v_1 - q*v_2));
        }
    }
}
//good tests : 
//extEucAlg(1234, 5678); // 2
//extEucAlg(16127*15383, 15383*16603); // 15383
//extEucAlg(16127, 15383); // 1
