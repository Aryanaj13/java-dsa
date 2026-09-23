public class searching {
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
    
        //searxh inserrt position
public static int searinspos(int[] arr, int target){
    int st =0;
    int end = arr.length-1;
    while(st<=end){
        int mid = st+(end-st)/2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            st = mid+1;
        }else{
            end = mid-1;
        }
    }
    return st;
}
    //find min in rotated sorted array
    public static int minrotsortarr(int[] arr){
        int st = 0;
        int end = arr.length-1;
        while(st<end){
            int mid = st+(end-st)/2;
            if(arr[mid] > arr[end]){
                st = mid+1;
            }else{
                end = mid;
            }
        }
    return arr[st];
    }
}
