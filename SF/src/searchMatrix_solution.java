/**
 * 写出一个高效的算法来搜索 m × n矩阵中的值。

 这个矩阵具有以下特性：

 每行中的整数从左到右是排序的。
 每行的第一个数大于上一行的最后一个整数。
 [
 [1, 3, 5, 7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 */


/**
 * Created by xwh12 on 2016/8/10.
 */


public class searchMatrix_solution {

    /**
     * 时间有要求使用二分法
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
            // write your code here
        if(matrix == null){
            return false;
        }
        if(matrix.length == 0){
            return false;
        }
        int n = matrix[0].length;
        int mid =0;
        int m = matrix.length;
        if(target > matrix[m-1][n-1]||target < matrix[0][0]){
            return false;
        }
        if(target == matrix[m-1][n-1]||target == matrix[0][0]){
            return true;
        }
        int start =0;
        int end = n*m-1;
        while(start< end -1){
            mid = start +(end -start)/2;
            int num = matrix[mid/n][mid%n];
            if(num == target){
                return true;
            }
            else{
                if(num <target){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        if(matrix[end/n][end%n] == target){
            return  true;
        }
        if(matrix[start/n][start%n] == target){
            return  true;
        }
        return false;
    }
    public static void main(String []args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
//        for(int i = 0; i<3 ;i++){
//            for(int j=0; j<3;j++){
//                matrix[i][j] = (int)(Math.random()*100);
//                System.out.print(matrix[i][j]+"--");
//            }
//        }

        System.out.print(searchMatrix(matrix,7));

    }




}
