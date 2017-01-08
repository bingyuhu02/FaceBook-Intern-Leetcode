public class Solution {
    public String intToRoman(int num) {
        String A[] = {"", "M", "MM", "MMM"};
        String B[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String C[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String D[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return A[num/1000] + B[(num%1000)/100] + C[(num%100)/10] + D[num%10];
    }
}