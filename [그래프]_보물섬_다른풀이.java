import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    public static void main(String[] args) throws IOException{
        Solve solve = new Solve();
        solve.solve();
    }
}
class Solve{
    int N;
    int M;
    public void solve() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] sArr = s.split(" ");
        N = Integer.parseInt(sArr[0]);
        M = Integer.parseInt(sArr[1]);

        map = new char[N][M];

        int idx = 1;
        for (int i = 0; i < N; i++) {
            s = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        weight = new int[idx][idx];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'L'){
                    visit = new int[N][M];
                    bfs(i,j);
                }
            }
        }

        System.out.println(answer);
    }
    int answer = 0;
    char[][] map;
    int[][] visit;
    int[][] weight;

    class Node{
        int y;
        int x;
        int count;
        public Node(int y,int x,int count){
            this.y =y;
            this.x =x;
            this.count = count;
        }
    }

    private void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r,c,0));
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nY=  cur.y + dy[i];
                int nX = cur.x + dx[i];
                if(!isValid(nY,nX)) continue;
                if(map[nY][nX] != 'L') continue;
                if((nY == r && c == nX) || visit[nY][nX] != 0) continue;
                visit[nY][nX] = visit[cur.y][cur.x] +1;
                queue.add(new Node(nY,nX,cur.count+1));
                answer = Math.max(answer,visit[nY][nX]);
            }
        }
    }
    int[] dy= {-1,1,0,0 };
    int[] dx=  {0,0,-1,1};

    public boolean isValid(int nY,int nX ){
        if(nY < 0 || nX< 0 || nY >= N || nX >= M)return false;
        return true;
    }
}
