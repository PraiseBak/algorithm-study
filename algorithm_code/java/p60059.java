public 
class Solution
{
    boolean solution(int[][] key,int[][] lock)
    {
        int offset = key.length-1;
        for(int row=0;row<offset + lock.length;row++)
        {
            for(int c=0;c<offset + lock.length;c++)
            {
                for(int rot = 0; rot < 4;rot++)
                {
                    int[][] expandedArr = new int[lock.length + key.length * 2][lock.length + key.length * 2];
                    
                    for(int i=0;i<lock.length;i++)
                    {
                        for(int j=0;j<lock.length;j++)
                        {
                            expandedArr[offset+i][offset+j] = lock[i][j];
                        }
                    }

                    fillKey(expandedArr,row,c,rot,key);
                    if(check(expandedArr,offset,lock.length))
                    {
                        return true;
                    }
                }
            }

        }
        System.out.println("false");
        return false;
    }

    private boolean check(int[][] expandedArr, int offset,int len) 
    {
        
        for(int i=0;i<len;i++)
        {
            for (int j = 0; j < len; j++) 
            {
                if(expandedArr[i+offset][j+offset] != 1)
                {
                    return false;
                }
            }  
            System.out.println();
        }
        return true;

    }

    private void fillKey(int[][] expandedArr, int row, int c, int rota,int[][] key) 
    {
        int n = key.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(rota == 0){
                    expandedArr[i+row][j+c] += key[i][j];       
                }else if(rota == 1 ){
                    expandedArr[i+row][j+c] += key[j][n-i-1];
                }else if(rota == 2){
                    expandedArr[i+row][j+c] += key[n-i-1][n-j-1];
                }else{
                    expandedArr[i+row][j+c] += key[n-j-1][i];
                }
            }
            
        }
    }


    public static void main(String[] args) 
    {
        Solution solu = new Solution();
        int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
        solu.solution(key, lock);
    }

    
}class p60059 {
    
}
