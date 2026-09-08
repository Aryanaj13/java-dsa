public class sorting {
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
    public static void main(String[] args) {
    int[] arr = {2,5,-7,-1,6,3,-4};;
    selectionsort(arr);
    printArray(arr);
   
     
    }
    } 
       


