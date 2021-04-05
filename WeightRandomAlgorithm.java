import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WeightRandomAlgorithm {

        Random rand ;
        int[] a ;
        public WeightRandomAlgorithm(int[] w) {
            this.rand = new Random();
            this.a = w.clone();
            for(int i = 1 ; i < a.length; i ++){
                a[i]+=a[i-1];
            }
        }

        public int pickIndex() {
            int guess = rand.nextInt(a[a.length-1])+1;
            int pos = Arrays.binarySearch(a,guess);
            if(pos<0)pos=-(pos+1);
            return pos;
        }
}
