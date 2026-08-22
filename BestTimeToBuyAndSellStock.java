public class BestTimeToBuyAndSellStock {
    public static int buyandsellstock(int[] arr){
        int buyprice = arr[0];
        int maxprofit = 0;
        int profit =0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] < buyprice){
                buyprice = arr[i];
            }else{
                maxprofit = Math.max(maxprofit, arr[i]-buyprice);
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
    int prices[] = {7,1,5,3,6,4};
    System.out.println(buyandsellstock(prices));
   
    }
}
