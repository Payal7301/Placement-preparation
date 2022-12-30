// just a change that while adding in q mark that vis bcoz that is not vis and value is not changed 
// so that can create issue.
class Solution
{
    class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
    this.row=row;
    this.col=col;
    this.time=time;
    }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] arr)
    {
    int[][] temp={{-1,0},{1,0},{0,-1},{0,1}};   
    boolean[][] vis=new boolean[arr.length][arr[0].length];
    Queue<Pair> q=new LinkedList<>();
    for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr[0].length;j++){
    if(arr[i][j]==2){
    q.add(new Pair(i,j,0));
    }
    }
    }
    int ans=0;
    while(q.size()>0){
    Pair rem=q.remove();
    int row=rem.row;
    int col=rem.col;
    int time=rem.time;
    ans=Math.max(ans,time);
    for(int k=0;k<4;k++){
    int nr=row+temp[k][0];
    int nc=col+temp[k][1];
    if(nr>=0&&nr<arr.length&&nc>=0&&nc<arr[0].length&&arr[nr][nc]==1&&!vis[nr][nc]){
    vis[nr][nc]=true;
    q.add(new Pair(nr,nc,time+1));
    }
    }
    }
    for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr[0].length;j++){
    if(arr[i][j]==1&&!vis[i][j])return -1;
    }
    }
    return ans;
    }
}