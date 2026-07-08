#include <bits/stdc++.h>
using namespace std;

// bfs 
vector<int> v[50005];
int dist[50005];
bool check[50005] = {0, };

int solution(int n, vector<vector<int>> edge) {
     // 양방향 인접리스트
    for(int i=0; i<edge.size(); i++){
        int a = edge[i][0];
        int b = edge[i][1];
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    
    queue<int> q;
    q.push(1);
    check[1]=1;
    dist[1] =0;
    int i =0;
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        cout<<'\n';
        for(auto c : v[cur]){
            if(check[c]) continue;
            dist[c] = (dist[cur]+1);
            check[c]=1;
            q.push(c);
            i= max(i, dist[c]);
        }
    }
    int total=0;
    for(int j=1; j<=n; j++){
        if(dist[j] == i) total++;
    }
    return total;
}