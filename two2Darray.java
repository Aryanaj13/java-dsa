import java.util.Scanner;

public class two2Darray {
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

    
}
