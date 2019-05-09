package LeetCode;

import java.util.Scanner;

public class LeetCode6 {
    public static String convert(String s, int numRows) {
        if(s.length() <= 0 || numRows <= 0)
            return "";
        if(numRows == 1 && s.length() ==1)
            return s;
        char[] strArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        //第一行
        for(int i=0;i<strArray.length;i+=2*numRows-2){
            stringBuilder.append(strArray[i]);
        }
        System.out.println(stringBuilder);
        //中间情况
        for(int i=1;i<numRows-1;i++){
            boolean k = true;
            for(int j=i;j<s.length();j+=(k)?2*i:2*(numRows-i-1),k=!k) {
                stringBuilder.append(strArray[j]);
            }
        }
     //   System.out.println(stringBuilder);
        //最后一行
        for(int i=numRows-1;i<strArray.length;i+=2*numRows-2){
            stringBuilder.append(strArray[i]);
        }
      //  System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
 //       String s = scanner.next();
  //      int nunRows = scanner.nextInt();
        String s = "PAYPALISHIRING";
        int nunRows =  3;
        System.out.println(convert(s,nunRows));
    }
}