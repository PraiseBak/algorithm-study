#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
const int MAX = 1001;

struct
{
	int num;



}



void Graph::connectEdge(int v,int e)
{
	graph[v].push_back(e);
	if(v == e)
	{
		return;
	}
	graph[e].push_back(v);
}



void Graph:: BFS(int startV)
{
	queue<int> que;
	que.push(startV);
	int curV = 0;
	int notVisited = 1;
	int houseCount = 1;
	visit[startV] = true;

	if(graph[startV].size() == 1)
	{
		houseSet.push_back(houseCount);
		return;
	}
	while(que.size()!=0)
	{
		curV = que.front();
		que.pop();
		////cout << "현재 정점 : " << curV << "\n";
		for(int i=0;i<graph[curV].size();i++)
		{
			
			if(visit[graph[curV][i]] == 1)
			{
				continue;
			}

			notVisited = 0;
			que.push(graph[curV][i]);
			visit[graph[curV][i]] = true;

			houseCount++;
		}
	}

	if(!notVisited)
	{
		houseSet.push_back(houseCount);
		//doSomeThing(); 
	}

}


void solve()
{
	int n = 0;
	cin >> n;
	Graph g = Graph();
	fill_n(g.visit,MAX,0);
	int maxSize = n*n;
	int num[maxSize];
	for(int i=0;i<maxSize;i++)
	{
		vector<int> nodeTmp;
		g.graph.push_back(nodeTmp);
	}

	int idx = 0;

	for(int row = 0;row < n;row++)
	{
		char input[n];
		char prevRow[n];

		for(int cal = 0;cal<n;cal++,idx++)
		{
			cin >> input[cal];
			if(input[cal] - '0')
			{
				if(cal == 0)
				{
					g.connectEdge(idx,idx);
				}
				else if(input[cal-1] - '0')
				{
					g.connectEdge(idx,idx-1);
				}
				else
				{
					g.connectEdge(idx,idx);
				}
			}
			
			if(row != 0)
			{
				if(prevRow[cal]  - '0' && input[cal] - '0')
				{
					g.connectEdge(idx - n,idx);
				}

			}
		}

		for(int i=0;i<n;i++)
		{
			prevRow[i] = input[i];
		}

	}
	for(int i=0;i<maxSize;i++)
	{
		if(g.visit[i])
		{
			continue;
		}
		g.BFS(i);
	}
	cout << g.houseSet.size() <<"\n";
	sort(g.houseSet.begin(),g.houseSet.end());
	if(g.houseSet.size() == 0)
	{
		cout << "0";
	}
	for(int i=0;i<g.houseSet.size();i++)
	{
		cout << g.houseSet[i] << "\n";
	}

}

int main()
{
	solve();
}
