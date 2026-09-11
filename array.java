import java.util.Scanner;
import java.util.Arrays;
public class array {
    //linear search
    public static int linearsearch(int[] arr, int key){
        int i;
        for(i=0;i<=arr.length-1;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    //binary search
    public static int binarysearch(int[] arr, int key){
        int st = 0;
        int end = arr.length-1;
    
        while (st<=end) {
            int mid = (st+end)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] < key){
                st = mid+1;

            }else {
                end = mid-1;
            }
        }
        return -1;
    }
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
    //rotated and sorted array
    public static int rotatedsortedarr(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == target){
                return mid;
            } 
            else if(arr[start] <= arr[mid]){
                if(arr[start] <= target && target <arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            else{
                if(arr[mid] <= target && target <= arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
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
    //sorting (bubble sort(0(n2)))
    public static void bubblesort(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            boolean swapped = false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    //selection sort
    public static void selectionsort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minindex = i;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex] = temp;
        }
    }
    //insertion sort
    public static void insertionsort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            while (prev>=0 && arr[prev]>curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    // counting sort
    public static void countingsort(int[] arr){
        int max = arr[0];
        for(int i=1;i<=arr.length-1;i++){
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max+1];
        for(int i=0;i<=arr.length-1;i++){
            count[arr[i]]++;
        }
        int index = 0;
        for(int i=0;i<count.length;i++){
            while(count[i] > 0){
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }
    //print an array for sorrting
    public static void printArray(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
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
    // 2d array 
    // search target in a 2d array
    public static boolean searchin2d(int[][] matrix, int target){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == target){
                    System.out.println("target found at cell ("+i+","+ j+")");
                    return true;
                }
            }
        }
        System.out.println("target not found.");
        return false;
    }
    //largest element in 2d array
    public static int largewst2darr(int[][] matrix){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] > largest){
                    largest = matrix[i][j];
                }
            }
        }
        return largest;
    }
    //spiral matrix
    public static void spiralmatrix(int[][] matrix){
        int sr =0;
        int sc =0;
        int er = matrix.length-1;
        int ec = matrix[0].length-1;
        while(sr<= er && sc <= ec){
            //top
            for(int j=sc;j<=ec;j++){
                System.out.print(matrix[sr][j]+" ");
            }
            //right
            for(int i=sr+1;i<=er;i++){
                System.out.print(matrix[i][ec]+" ");
            }
            //bottom
            if(sr <= er){
            for(int j=ec-1;j>=sc;j--){
                    System.out.print(matrix[er][j]+" ");
                }
            }
            //left
            if(sc <=ec){
            for(int i= er-1;i>=sr+1;i--){
                    System.out.print(matrix[i][sc]+" ");
            }
        }
            sr++;
            sc++;
            er--;
            ec--;

        }
    }
    //diagonal sum 0(n2)
    public static int diagonalsum(int[][] matrix){
        int pd = 0;
        int sd = 0;
        int ds = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==j){
                    pd+=matrix[i][j];
                }else if(i+j == matrix.length-1 && i!=j){
                    sd+=matrix[i][j];
                }
                ds = pd+sd;
            }
        }
        return ds;
    }
    //optimized diagonal sum 0(n)
      public static int diagonalSum(int[][] matrix) {
        int pd=0;
        int sd=0;
        for(int i=0;i<matrix.length;i++){
            pd+=matrix[i][i];
            sd+=matrix[i][matrix.length-i-1];
        }
        if(matrix.length % 2!= 0){
            sd-=matrix[matrix.length/2][matrix.length/2];
        }
            return pd+sd;
}
//search in sorted 2d matrix
public static boolean searchinsort2d(int[][] matrix, int target){
    int st=0;
    int end = matrix.length*matrix[0].length-1;
    while(st<=end){
        int mid = st+(end-st)/2;
        int i = mid/matrix[0].length;
        int j = mid % matrix[0].length;
        if(matrix[i][j] == target){
            return true;
        }else if(matrix[i][j] < target){
            st=mid+1;
        }else{
            end = mid-1;
        }
    }
    return false;
}
//search in sorted 2d array(staircase search)
public static boolean searchin2darr2(int[][] matrix, int target){
    int i= 0;
    int j=matrix[0].length-1;
    while(i < matrix.length && j>= 0){
        if(matrix[i][j] == target){
            return true;
        }else if(matrix[i][j] > target){
            j--;
        }
        else if(matrix[i][j] < target){
            i++;
        }
    }
    return false;
}
//transpose of matrix
public static int[][] transposematrix(int[][] matrix){
    int[][] transpose = new int[matrix[0].length][matrix.length];
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            transpose[j][i] = matrix[i][j];
        }
    }
    return transpose;
}
//set matrix zero
public static void setmatrixzero(int[][] matrix){
    boolean[] row = new boolean[matrix.length];
    boolean[] col = new boolean[matrix[0].length];
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j] == 0){
                row[i] = true;
                col[j] =  true;
            }
        }
    }
     for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(row[i] || col[j]){
                matrix[i][j] = 0;
            }
        }
    }
}
//rotate 2d matrix
public static void rotatematrix(int[][] matrix){
    //transpose
    for(int i=0;i<matrix.length;i++){
        for(int j=i+1;j<matrix[0].length;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    //reverse every row
    for(int i=0;i<matrix.length;i++){
        int st = 0;
        int end = matrix.length-1;
        while(st<end){
            int temp = matrix[i][st];
            matrix[i][st] = matrix[i][end];
            matrix[i][end] = temp;
            st++;
            end--;
        }
    }
}
    public static void main(String[] args) {
    int[][] matrix = { {1,2,3},
                       {4,5,6},
                       {7,8,9}
                     };
    rotatematrix(matrix);

for(int i = 0; i < matrix.length; i++){
    for(int j = 0; j < matrix[0].length; j++){
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}

    }
} 
       

