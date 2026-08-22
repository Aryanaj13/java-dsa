public class TrappingRainWater {
     public static int trappingrainwater(int[] arr){
       int trapwater = 0;
        //leftmax boundary
        int[] leftmax = new int[arr.length];
        leftmax[0] = arr[0];
        for(int i = 1;i<arr.length;i++){
            leftmax[i] = Math.max(arr[i], leftmax[i-1]);
        }

        //rightmax boundary
        int[] rightmax = new int[arr.length];
        rightmax[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            rightmax[i] = Math.max(arr[i], rightmax[i+1]);
        }
        for(int i=0;i<=arr.length-1;i++){
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trapwater += (waterlevel - arr[i])*1;
        }
        return trapwater;
    }
    public static void main(String[] args){
    int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trappingrainwater(arr));
}
}
