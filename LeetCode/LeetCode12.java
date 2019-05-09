package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LeetCode12 {
    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"I");
        hashMap.put(4,"IV");
        hashMap.put(5,"V");
        hashMap.put(9,"IX");
        hashMap.put(10,"X");
        hashMap.put(40,"XL");
        hashMap.put(50,"L");
        hashMap.put(90,"XC");
        hashMap.put(100,"C");
        hashMap.put(400,"CD");
        hashMap.put(500,"D");
        hashMap.put(900,"CM");
        hashMap.put(1000,"M");
        if(num < 1 || num >3999)
            return "";
        if(hashMap.get(num) != null)
            return hashMap.get(num);
        else{
            //1_3999
            int bit_4 = num / 1000;
            num -= bit_4*1000;
            //bit_4个1000
            while (bit_4--!=0){ // 先执行表达式
                stringBuilder.append(hashMap.get(1000));
            }
            int bit_3 = num / 100;
            num -= bit_3*100;
            if(bit_3 < 5){
                while (bit_3--!=0){ // 先执行表达式
                    stringBuilder.append(hashMap.get(100));
                }
            }else {
                stringBuilder.append(hashMap.get(500));
                while (bit_3--!=5){ // 先执行表达式
                    stringBuilder.append(hashMap.get(100));
                }
            }
            int bit_2 = num / 10;
            num -= bit_2*10;
            if(bit_2 < 5){
                while (bit_2--!=0){ // 先执行表达式
                    stringBuilder.append(hashMap.get(10));
                }
            }else {
                stringBuilder.append(hashMap.get(50));
                while (bit_2--!=5){ // 先执行表达式
                    stringBuilder.append(hashMap.get(10));
                }
            }
            int bit_1 = num;
            if(bit_1 < 5){
                while (bit_1--!=0){ // 先执行表达式
                    stringBuilder.append(hashMap.get(1));
                }
            }else {
                stringBuilder.append(hashMap.get(5));
                while (bit_1--!=5){ // 先执行表达式
                    stringBuilder.append(hashMap.get(1));
                }
            }
            //stringBuilder.append(bit_4);
            //stringBuilder.append(bit_3);
            //stringBuilder.append(bit_2);
            //stringBuilder.append(bit_1);
        }
        return stringBuilder.toString();
    }

    public static String intToRoman2(int num) {
        HashMap<Integer,String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        StringBuilder s = new StringBuilder();
        if(num < 1 || num > 3999){
            return null;
        }
        while (num > 0){
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if(num >= entry.getKey()){
                    s.append(entry.getValue());
                    num -= entry.getKey();
                    break;
                }
            }
        }
        return s.toString();
    }

    public static String intToRoman3(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String res="";
        for(int i=0; i<13; i++){
            while(num>=values[i]){
                num -= values[i];
                res += reps[i];
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(intToRoman3(new Scanner(System.in).nextInt()));
    }
}