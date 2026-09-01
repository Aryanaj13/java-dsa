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
       


