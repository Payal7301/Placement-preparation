class Solution { 
    public int numEnclaves(int[][] grid) {
    int n=grid.length;
    int m=grid[0].length;
    boolean[][] vis=new boolean[n][m];
    for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
    if(i==0||j==0||i==n-1||j==m-1){
    if(!vis[i][j]&&grid[i][j]==1){
    dfs(i,j,grid,vis);
    }    
    }
    }
    }
    int cnt=0;
    for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
    if(vis[i][j]==false&&grid[i][j]==1)cnt++;
    }
    }
    return cnt;
    }
    int[][] temp={{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(int i,int j,int[][] arr,boolean[][] vis){
    
    vis[i][j]=true;
    for(int k=0;k<4;k++){
    int nr=i+temp[k][0];
    int nc=j+temp[k][1];
    if(nr>=0&&nc>=0&&nr<arr.length&&nc<arr[0].length&&!vis[nr][nc]&&arr[nr][nc]==1){
    dfs(nr,nc,arr,vis);
    }
    }
    
    
    }
}