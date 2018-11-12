package me.puneetsingh.problems.eopi.PrimitiveTypes_ch1;

public class ParityCheck {
    static short load[] = new short[Short.MAX_VALUE];
    public static void main(String[] args) {
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            load[i] = getParityFast(i);
        }
        for (int i = 0; i < 128; i++) {
            System.out.println(getParityFaster(i) + ", " + getParitySlow(i) + " -- " + Integer.toBinaryString(i));
        }
    }
    public static short preloaded(short x)
    {
        return load[x];
    }
    public static short getParitySlow(long x) {
        // O(logn)
        long y;
        int res = 0;
        if (x == 0) return 0;
        while (x > 0) {
            y = x % 2;
            x /= 2;
            res += (int) y;
        }
        return (short) (res % 2);
    }

    public static short getParityFast(long x) {
        // O(k) ; where k is set bits
        short res = 0;
        while (x > 0) {
            res ^= 1;
            x &= (x-1);
        }
        return res;
    }
    public static short getParityFaster(long x) {
        // O(n/16)
        short res = 0;
        int BitMask = 0XFFFF;
        for(short i=0;i<4;i++)
        {
            res ^= preloaded((short)((x>>>(16*i))&BitMask));
        }
        return res;
    }
}
