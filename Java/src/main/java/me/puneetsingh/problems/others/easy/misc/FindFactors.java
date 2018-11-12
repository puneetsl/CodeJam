package me.puneetsingh.problems.others.easy.misc;




public class FindFactors {
    public static void main(String[] args) {
        int num = 139833224;
        printFactors(num);
    }

    private static void printFactors(int num) {
        int pow = (int)Math.pow(num,0.5f);
        int inc = 1;
        if(num%2!=0)
            inc=2;
        for (int i = 2+inc/2; i <= pow; i+=inc) {
            if(num%i==0)
            {
                System.out.println(num/i+"<-->"+i);
            }
        }
    }
}
