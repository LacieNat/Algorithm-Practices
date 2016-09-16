#include <iostream>
#include <algorithm>
#include <cstring>

#define ARRSIZE 100000
#define TREESIZE 1000000

using namespace std;

int arr[ARRSIZE];
int countArr[ARRSIZE];
int start[ARRSIZE];
int stree[TREESIZE];


void buildtree(int node, int l, int r) {
	if (l == r) {
		stree[node] = l;
	} else {
		int leftIdx = 2*node, rightIdx = 2*node+1;
		buildtree(leftIdx, l, (l+r)/2);
		buildtree(rightIdx, (l+r)/2+1, r);
		int lcontent = stree[leftIdx], rcontent = stree[rightIdx];

		int lvalue = countArr[lcontent], rvalue = countArr[rcontent];
		stree[node] = lvalue>=rvalue?lcontent:rcontent;
	}
}

int rmq(int node, int b, int e, int i, int j) {

	if(i>e || j<b) return -1;
	if(b>=i && e<=j) return stree[node];

	int p1 = rmq(2*node, b, (b+e)/2, i, j);
	int p2 = rmq(2*node+1,(b+e)/2+1, e, i, j);

	if(p1==-1) return p2;
	if(p2==-1) return p1;

	return countArr[p1]> countArr[p2]?p1:p2;

}

int main() {
	ios_base::sync_with_stdio(false);

	int size, q;

	cin >> size;

	while(size!=0) {
		cin >> q;
		memset(countArr, 0, sizeof (countArr));
		memset(start, 0, sizeof(start));
		memset(stree, 0, sizeof(stree));

		for(int i=0; i<size; i++) {
			cin >> arr[i];

			if(i!=0 && arr[i] == arr[i-1]) {
				start[i] = start[i-1];
			 	countArr[i] = countArr[i-1]+1;

			 	if ( i == size-1) {
			 		for(int j=start[i]; j<i; j++) countArr[j] = countArr[i];
			 	}
			}else {
				start[i] = i;
			 	countArr[i] = 1;

				for(int j=start[i-1]; j<i-1; j++) countArr[j] = countArr[i-1];
			}
		}

		//for(int i=0; i<size; i++) cout << countArr[i] << " " ;  cout << endl; for(int i=0; i<size; i++) cout << start[i] << " " ; cout << endl;

		buildtree(1, 0, size-1);

		for(int i=0; i<q; i++) {
			int j,k; cin >> j >> k; j--; k--;
			if ( arr[j] == arr[k]) cout << k-j+1 << endl;
			else {
				int cn1 = countArr[j], s1 = start[j], e1 = cn1 + s1;
				int cn2 = countArr[k], s2 = start[k];
				int cn3 = countArr[rmq(1, 0, size-1, e1, s2-1)];
				//cout << "cn1: " << e1-j << " cn2: " << k-s2+1 << " cn3: " << cn3 << endl;
				int max = e1-j>k-s2+1?e1-j:k-s2+1;
				max = max>cn3?max:cn3;
				cout << max << endl;
			}
		}

		cin >> size;

	}

}
