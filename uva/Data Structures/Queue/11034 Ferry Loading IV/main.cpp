#include <iostream>
#include <queue>
#include <string>
#include <limits>
#include <algorithm>

using namespace std;
queue<int> Q[2];

int main() {
	ios_base::sync_with_stdio(false);

	int tests, l, m;
	queue< pair<int, int> > LQ, RQ;
	cin >> tests;

	for (int i=tests-1; i>=0; i--) {
		cin >> l >> m;
		l *= 100;
		for(int j=0; j<m; j++) {
			int k; string side;
			cin >> k >> side;

			if(side == "left") Q[0].push(k);
			else Q[1].push(k);
		}	
		
		int pos = 0;
		int cnt = 0;
		
		while(!Q[0].empty() || !Q[1].empty()) {
			int spaceLeft = l;
			while(!Q[pos].empty() && spaceLeft - Q[pos].front() >= 0) {
				spaceLeft -= Q[pos].front();
				Q[pos].pop();
			} 
			
			pos = pos ^ 1;
			cnt++;
		}
		cout << cnt<<endl;	
	}	

}
