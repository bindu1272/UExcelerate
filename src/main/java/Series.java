package src.main.java;
import java.util.ArrayList;
import java.util.List;

public class Series {
    public static  void main(String args[]){
        int num = 100;
        List<Integer> primeArray = new ArrayList<>();
        for(int i=2;i<num;i++){
            int count =0;
            for(int j=2;j<=i/2;j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if(count==0){
                primeArray.add(i); //PrimeNumbers array
            }
        }
        List<Integer> finalSeries = new ArrayList<>();
        for(int i=0;i<primeArray.size()-1;i++){
            List<Integer> tempArray = new ArrayList<>(); //adding in between numbers in two prime numbers
            for(int j=1;j<num;j++){
                int a = primeArray.get(i);
                int b = primeArray.get(i+1);
                if(j>a && j<b) {
                    tempArray.add(j);
                }
            }
            if(tempArray.size()==1){
                finalSeries.add(tempArray.get(0));
            }
        }
        for(int i : finalSeries){ //Final series
            System.out.print(i+" ");
        }
    }
}
