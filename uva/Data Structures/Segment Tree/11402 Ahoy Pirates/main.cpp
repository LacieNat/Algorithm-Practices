#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

struct node {
	int action;
	int value;

	node(): action(0) {}
};

node stree[2100000];
int pirates[1024000];

void buildtree(int n, int l, int r) {
	stree[n].action = 0;
	stree[n].value = 0;
	if(l==r) {
		stree[n].value = pirates[l];
	}
	else if(l<r) {
		buildtree(n*2, l, (l+r)/2);
		buildtree(n*2+1, (l+r)/2+1, r);
		stree[n].value = stree[n*2].value + stree[n*2+1].value;
	}
	
}

void updateNode(int n, int l, int r) {

	if(stree[n].action == 0) return;

	switch(stree[n].action) {
		case 1:
			stree[n].value = r-l+1;
			break;
		case 2:
			stree[n].value = 0;
			break;
		case 3:
			stree[n].value = (r-l+1)-stree[n].value;
			break;
	}

	if (l<r) {
		if (stree[n].action == 3) {
			stree[n*2].action = 3-stree[n*2].action;
			stree[n*2+1].action = 3-stree[n*2+1].action;
		} else {
			stree[n*2].action = stree[n].action;
			stree[n*2+1].action = stree[n].action;
		}
	}

	stree[n].action = 0;
}

void act(int n, int idx1, int idx2, int l, int r, int action) {
	if(l==idx1 && r==idx2) {
		if(action == 3) stree[n].action = 3-stree[n].action;
		else stree[n].action = action;
		updateNode(n, l, r);
		return;
	}

	updateNode(n, l, r);

	if(idx2<=(l+r)/2) act(n*2, idx1, idx2, l, (l+r)/2, action);
	else if (idx1 > (l+r)/2) act(n*2+1, idx1, idx2, (l+r)/2+1, r, action);
	else {
		act(n*2, idx1, (l+r)/2, l, (l+r)/2, action);
		act(n*2+1, (l+r)/2+1, idx2, (l+r)/2+1, r, action);
	}

	updateNode(n*2, l, (l+r)/2);
	updateNode(n*2+1, (l+r)/2+1, r);
	stree[n].value = stree[n*2].value + stree[n*2+1].value;
}

int query(int n, int idx1, int idx2, int l, int r) {
	updateNode(n, l, r);

	if(idx1 == l && idx2 == r) return stree[n].value;

	if(idx2<=(l+r)/2) return query(n*2, idx1, idx2, l, (l+r)/2);
	else if(idx1>(l+r)/2) return query(n*2+1, idx1, idx2, (l+r)/2+1, r);
	else {
		return query(n*2, idx1, (l+r)/2, l, (l+r)/2) + query(n*2+1, (l+r)/2+1, idx2, (l+r)/2+1, r);
	}

}

int main() {

	ios_base::sync_with_stdio(false);

	int tests, m, t, q, idx1, idx2, n; cin >> tests;
	string pir;
	char action;

	for(int v=1; v<=tests; v++) {
		cout << "Case " << v  << ":" << endl;

		cin >> m;

		n=0;
		for(int i=0; i<m; i++) {
			cin >> t >> pir;

			for(int j=0; j<t; j++){
				for(int k=0; k<pir.length(); k++, n++) {
					pirates[n] = pir[k]-'0';
				}
			}
		}

		buildtree(1, 0, n-1);

		//for(int i=0; i<19; i++) cout << pirates[i] << " "; cout << endl;
		//for(int i=0; i<19; i++) cout << stree[i].value << " "; cout << endl;
		//cout << n << endl;
		cin >> q;

		int cnt = 1;

		for(int i=0; i<q; i++) {
			cin >> action >> idx1 >> idx2;

			switch(action) {
				case 'F':
					act(1, idx1, idx2, 0, n-1, 1);
					break;
				case 'E':
					act(1, idx1, idx2, 0, n-1, 2);
					break;
				case 'I':
					act(1, idx1, idx2, 0, n-1, 3);
					break;
				case 'S':
					cout << "Q" << cnt << ": " << query(1, idx1, idx2, 0, n-1) << endl;
					cnt++;
					break;
			}
		}
	}

}


























