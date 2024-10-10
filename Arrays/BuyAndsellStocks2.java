import java.util.*;

public class BuyAndSellStocks2{

    public static void getProfit(int prices[]){
        int maxProfit=0;
        int buyPrice=Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            if(buyPrice<prices[i]){
                int profit = prices[i]-buyPrice;
                maxProfit+= profit;
            }
            buyPrice = prices[i];
        }

        System.out.print("Max profit: "+ maxProfit);
    }

    public static void main(String [] arg){
        int prices[]={7, 2, 5, 3, 6, 4, 1, 15};
        getProfit(prices);
    }
}