package src.main.java;
import java.util.Scanner;

public class DatesPalindrome {
        static int MAX_YEAR= 9999;
        static int MIN_YEAR = 1800;
        static boolean isLeapYear(int year)
        {
            return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
        }
        static boolean isDateValidate(int d, int m, int y)
        {
            if (y > MAX_YEAR || y < MIN_YEAR)
                return false;
            if (m < 1 || m > 12)
                return false;
            if (d < 1 || d > 31)
                return false;
            if (m == 2)
            {
                if (isLeapYear(y))
                    return (d <= 29);
                else
                    return (d <= 28);
            }
            if (m == 4 || m == 6 || m == 9 || m == 11)
                return (d <= 30);
            return true;
        }
        static void palindrome(int y1, int y2)
        {
            for (int year = y1; year <= y2; year++)
            {
                String str = String.valueOf(year);
                String rev = str;
                rev = reverseYear(rev);
                int day = Integer.parseInt(rev.substring(0, 2));
                int month = Integer.parseInt(rev.substring(2, 2 + 2));
                if (isDateValidate(day, month, year))
                {
                    if(day<10 && month>=10){
                        System.out.print("0"+day+"-"+month+"-"+str+"\n");
                    }if(month<10 && day>=10){
                        System.out.print(day+"-"+"0"+month+"-"+str+"\n");
                    }if(month<10 && day<10){
                    System.out.print("0"+day+"-"+"0"+month+"-"+str+"\n");
                    } if(day>=10 && month>=10){
                    System.out.print(day + "-" + month + "-" + str + "\n");
                }
                }
            }
        }
        static String reverseYear(String input)
        {
            char[] array = input.toCharArray();
            int low, high = array.length - 1;
            for (low = 0; low < high; low++, high--)
            {
                char temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
            return String.valueOf(array);
        }
        public static void main(String[] args)
        {
            System.out.println("Date format should be 10-02-2001");
            Scanner sc = new Scanner(System.in);
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String st1 = str1.substring(6);
            String st2 = str2.substring(6);
            int year1 = Integer.parseInt(st1);
            int year2 = Integer.parseInt(st2);
            palindrome(year1, year2);
        }
    }
