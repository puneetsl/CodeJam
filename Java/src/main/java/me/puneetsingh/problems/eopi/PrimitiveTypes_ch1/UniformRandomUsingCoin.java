package me.puneetsingh.problems.eopi.PrimitiveTypes_ch1;

public class UniformRandomUsingCoin {
    int max = 0;

    public static void main(String[] args) {
        UniformRandomUsingCoin uruc = new UniformRandomUsingCoin(10);
        long[] l = new long[10];
        for (int i = 0; i < 1000000; i++) {
            l[uruc.getRandom()]++;
        }
        for (long m : l) {
            // Histogram test
            System.out.println(Math.log(m));
        }
    }
    public UniformRandomUsingCoin(int max) {
        this.max = max;
    }

    public int getRandom() {
        int res = 0;
        int bits = (int) (Math.log(max) / Math.log(2) + 1);
        for (int i = 0; i < bits; i++) {
            res += (randomBoolean()==true?1:0)*Math.pow(2,i);
        }
        if (res>=max) return getRandom();
        else return res;
    }

    public boolean randomBoolean() {
        return Math.random() < 0.5;
    }
}

