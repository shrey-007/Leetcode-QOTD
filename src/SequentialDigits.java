import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    // Hint1 = Generate all numbers with sequential digits and check if they are in the given range.
    // Hint2 = Fix the starting digit then do a recursion that tries to append all valid digits.

    public static ArrayList<Integer> func(int num,int low,int high,ArrayList<Integer> list){
        //add current number in the list
        if(low<=num && num<=high){list.add(num);}
        if(num>high){return list;}

        //find the last digit of number
        int lastDigit=num%10;
        if(lastDigit==9){
            //means this is end of all numbers starting with 1
            return list;}

        //find next number
        int nextNum=num*10+(lastDigit+1);

        //do recursive work
        return func(nextNum,low,high,list);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=9;i++){
            ArrayList temp=func(i,low,high,list);
        }
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {

    }
}
