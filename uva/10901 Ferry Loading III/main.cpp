#include <iostream>
#include <queue>
#include <string>
#include <limits>
#include <algorithm>

using namespace std;

int order[10000];

int main() {
	ios_base::sync_with_stdio(false);

	int tests, n, t, m;
	queue< pair<int, int> > LQ, RQ;
	cin >> tests;

	for (int i=tests-1; i>=0; i--) {
		cin >> n >> t >> m;
		fill_n(order, 10000, 0);

		for(int j=0; j<m; j++) {
			int k; string side;
			cin >> k >> side;

			if(side == "left") LQ.push(make_pair(j,k));
			else RQ.push(make_pair(j,k));
		}	
	
		int pos = 0; // 0 for left
		int start = 0;

		while(!LQ.empty() || !RQ.empty()) {
			queue<pair<int, int> > *l = pos==0?&LQ:&RQ;
            queue<pair<int, int> > *r = pos==0?&RQ:&LQ;

            int next = l->empty()? r->front().second: r->empty()? l->front().second: min(l->front().second, r->front().second);
            start = max( start, next );
			int k = 0;
			while(!l->empty() && k<n && l->front().second <= start) {
                order[l->front().first] = start + t;
                l->pop();
                k++;
            }

            start += t;
			pos = pos ^ 1;

		}	

		for(int j=0; j<m; j++) cout << order[j] << endl;

		if(i) {cout << endl;}

	}	

}
