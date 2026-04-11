class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row : matrix) {
            int l=0;
            int r=row.length-1;
            System.out.println("l:"+l+",r:"+r);
            while(l<=r) {
                int mid = l+(r-l)/2;
                if(row[mid] == target){
                    return true;
                }else if(row[mid] < target) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }

        }
        return false;
    }
}
