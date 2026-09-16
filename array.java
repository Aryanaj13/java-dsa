import java.util.Scanner;
import java.util.Arrays;
public class array {
    //reverse the array
    public static void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while (i<=j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    // find largest element in array
    public static int largestno(int[] arr){
        int larg = Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]> larg){
                larg = arr[i];
            }
        }
        return larg;
    }
    //find smallest element 
    public static int smallestno(int[] arr){
        int small = Integer.MAX_VALUE;
        for(int i =0;i<= arr.length-1;i++){
            if(arr[i] < small){
                small = arr[i];
            }
        }
        return small;
    }
    //find second largest
    public static int seclarg(int[] arr){
        int larg = Integer.MIN_VALUE;
        int seclarg = Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i] > larg){
                seclarg = larg;
                larg = arr[i];
            }
            else if(arr[i] > seclarg){
                seclarg = arr[i];
            }
        }
        return seclarg;
    }
    //unique pairs in an array
    public static void pairinarr(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+", "+arr[j]+")");
            }
            System.out.println();
        }
    }
    //print subarray
    public static void subarrprint(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    //maximum subarray sum
    public static int maxsubarrsum(int [] arr){
        int sum =0;
        int maxsum =Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                sum =0;
                for(int k = i;k<=j;k++){
                    sum += arr[k];
                }
                if(sum>maxsum){
                    maxsum = sum;
                }
            }
        }
        return maxsum;
    }
    //maxsubarray sum using prifix array optimize approach
    public static int prifixsum(int[] arr){
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        int[] prifix = new int[arr.length];
        prifix[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            prifix[i] = prifix[i-1] + arr[i];
        }
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                if(i==0){
                    sum = prifix[j];
                }else{
                    sum = prifix[j] - prifix[i-1];
                }
                if(sum>maxsum){
                maxsum = sum;
            }
            }
        }
        return maxsum;
    }
    //simple kadans algo(for positive or negative both mixed no)
    public static int kadans(int[] arr){
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-1;i++){
            currsum+=arr[i];
            if(currsum < 0){
                currsum =0;
            }
            maxsum = Math.max(maxsum, currsum);
        }
        return maxsum;
    }
    //kadanes opt(for all pos, or all neg, for mixed)
    public static int kadopt(int[] arr){
        int cs = arr[0];
        int ms = arr[0];
        for(int i=1;i<arr.length;i++){
            cs = Math.max(arr[i], cs+arr[i]);
            ms = Math.max(ms, cs);
        }
        return ms;
    }
    //traping rainwater
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
    //best time to buy and sell the stock
    public static int butandsellstock(int[] arr){
        int buyprice = arr[0];
        int maxprofit = 0;
        int profit =0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] < buyprice){
                buyprice = arr[i];
            }else{
                maxprofit =Math.max(maxprofit, arr[i] - buyprice);
            }
        }
        return maxprofit;
    }
    //two sum (bruit force)
    public static int[] twosum(int[] arr, int target){
        for(int i=0;i<=arr.length-1;i++){
            for(int j =i+1;j<arr.length;j++){
                if((arr[i]+arr[j]) == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    //contaion duplicate element problem
    public static boolean containduplicate(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
                if(arr[i] == arr[i+1])
                    return true;
        }
        return false;
    }
    //majority element(bruit force(0(n2)))
    public static void majorityelement(int[] arr){
        int count = 1;
        for(int i=0;i<=arr.length-1;i++){
            count = 1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>arr.length/2){
                System.out.println("majority element is: "+arr[i]);
                return;
            }
        }
    }
    //majority element (optimized(0(nlogn)))
    public static void majorityoptimized(int[] arr){
        int count = 1;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                count++;
            }else{
                count = 1;
            }
            if(count>arr.length/2){
                System.out.println("majority element is :"+arr[i]);
                return;
            }
        }
    }
    //majority element most optimized (boyer moore voting algo(0(n)))
    public static void boyermoore(int[] arr){
        int candidate = arr[0];
        int count = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == candidate){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                candidate = arr[i];
                count =1;
            }
        }
        System.out.println("majority element is:" +candidate);
    }
    //move zeroes
    public static int[] movezeroes(int[] arr){
        int index = 0;
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i] != 0){
                arr[index] = arr[i];
                index++;
            }
        }
        for(int j = index; j<arr.length;j++){
                arr[j] = 0;
            }
        return arr;
    }
    //remove duplicate from sorted array
    public static int remdupfrmsortarry(int[] arr){
        int index =1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[index-1]){
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }
    //find missing no in array
    public static int missingno(int[] arr){
        for(int i=0;i<=arr.length;i++){
            boolean found = false;
            for(int j = 0;j<arr.length;j++){
                if(i == arr[j]){
                    found = true;
                    break;
            }
        }
         if(found == false){
                return i;
            }
        }
        return 0;
    }
    //optimized missing no approach(0(n))
    public static int optmisingno(int[] arr){
        int sum = arr.length*(arr.length+1)/2;
        for(int i=0;i<=arr.length-1;i++){
            sum-=arr[i];
        }
        return sum;
    }
    //3sum bruit force approach(0(n3))
    public static int[] threesum(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j= i+1;j<arr.length;j++){
                for(int k= j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k] == 0){
                        return new int[]{arr[i], arr[j], arr[k]};
                    }
                }
            }
        }
        return new int[]{0,0,0};
    }
    //subarray sum equals k
    //brute force 0(n3) 
    public static int subarrsumequalk(int[] arr, int target){
        int sum = 0;
        int count = 0;
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                sum =0;
                for(int k = i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum == target){
                    count++;
                }
            }
        }
        return  count;
    }
    //optimized subarray sum equals k 0(n2)
    public static int optsubarrsumeqk(int[] arr, int target){
        int sum =0;
        int count = 0;
        for(int i=0;i<=arr.length-1;i++){
            sum = 0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum == target){
                    count++;
                }
            }
        }
        return count;
    }
    //rotate array brute force n(n2)
public static int[] rotatearr(int[] arr, int k){
    for(int i=0;i<k;i++){
        int temp = arr[arr.length-1];
         for(int j=arr.length-1;j>=1;j--){
            arr[j] = arr[j-1];
    }
    arr[0] = temp;
    }
    return arr;
}
    //rotate array ioptimal app using revrse the array
      public static int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        int st=0;
    int end = nums.length-1;
    while(st<end){
        int temp = nums[st];
        nums[st] = nums[end];
        nums[end] = temp;
        st++;
        end--;
    }
    int left=0;
    int right = k-1;
    while(left<right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
    }
    int start = k;
    int end2 = nums.length-1;
    while(start<end2){
        int temp = nums[start];
        nums[start] = nums[end2];
        nums[end2] = temp;
        start++;
        end2--;
    }
    return nums;
    }
}
    
