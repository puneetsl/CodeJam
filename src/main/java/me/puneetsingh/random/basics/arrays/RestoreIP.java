package me.puneetsingh.random.basics.arrays;


import java.util.*;

public class RestoreIP {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> arr = new ArrayList<>();
        LinkedList<SemiList> semi = new LinkedList<>();

        if(s.length()<4)
            return arr;
        dot1(semi,s);
        int dSize = semi.size();
        for(int i = 0; i< dSize;i++)
        {
            dot(semi, semi.poll(),6);
        }
        dSize = semi.size();
        for(int i = 0; i< dSize;i++)
        {
            dot(semi, semi.poll(),3);
        }
        checkLast(semi, arr);
        return arr;
    }

    private void checkLast(Queue<SemiList> semi, ArrayList<String> arr) {
        int slen = semi.size();
        for (int i = 0; i < slen; i++) {
            SemiList poll = semi.poll();
            String oneIPStr = poll.semiIP.substring(poll.lastDotPosition,poll.semiIP.length());
            int oneIP = Integer.parseInt(oneIPStr);
            if(oneIP<=255&&String.valueOf(oneIP).length()==oneIPStr.length()) {
                arr.add(poll.semiIP);
            }
        }
    }

    private void dot(Queue<SemiList> semi, SemiList poll, int limit) {
        int minDotLen = Math.min(poll.lastDotPosition+3,poll.semiIP.length()-1);
        for(int i = poll.lastDotPosition+1; i<= minDotLen; i++)
        {
            if(poll.semiIP.length()-i<=limit)
            {
                String temp = poll.semiIP.substring(0,i)+"."+poll.semiIP.substring(i,poll.semiIP.length());
                String oneIPStr = poll.semiIP.substring(poll.lastDotPosition,i);
                int oneIP = Integer.parseInt(oneIPStr);
                if(oneIP<=255&&String.valueOf(oneIP).length()==oneIPStr.length()) {
                    semi.add(new SemiList(temp, i + 1));
                }
            }
        }
    }

    private void dot1(Queue<SemiList> semi, String s) {
        for(int i =1; i<=3; i++)
        {
            if(s.length()-i<=9)
            {
                String temp = s.substring(0,i)+"."+s.substring(i,s.length());
                String oneIPStr = s.substring(0,i);
                int oneIP = Integer.parseInt(oneIPStr);
                if(oneIP<=255&&String.valueOf(oneIP).length()==oneIPStr.length())
                    semi.add(new SemiList(temp,i+1));
            }
        }
    }

    class SemiList
    {
        String semiIP;
        int lastDotPosition;
        public SemiList(String semiIP, int lastDotPosition)
        {
            this.semiIP = semiIP;
            this.lastDotPosition = lastDotPosition;
        }
    }
    public static void main(String[] args) {
        RestoreIP rip = new RestoreIP();
        String s = "010010";
        for (String val : rip.restoreIpAddresses(s)) {
            System.out.println(val);
        }
    }

}
