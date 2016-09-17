#include <iostream>
#include <string>

using namespace std;

int stree[270000];
int arr[100000];

int sign(int x) {
	if(x>0) return 1;
	else if(x==0) return 0;
	else return -1;
}

char outputMap(int x) {
	if(x<0) return '-';
	else if(x==0) return '0';
	else return '+';
}

int buildtree(int n, int l, int r) {

	if(l==r) {
		stree[n] = sign(arr[l]);
		return stree[n];
	}

	stree[n] = buildtree(n*2, l, (l+r)/2) * buildtree(n*2+1, (l+r)/2+1, r);
	return stree[n];
}

int change(int n, int i, int v, int l, int r ) {

	if(i<l || i>r) {
		return stree[n];
	}

	if (l==r && l==i) {
		stree[n] = v;
		return v;
	}

	stree[n] = change(n*2, i, v, l, (l+r)/2) * change(n*2+1, i, v, (l+r)/2+1, r);
	return stree[n];

}

int product(int n, int i, int j, int l, int r) {

	if(l==i && j==r) return stree[n];
	
	if(j<=(l+r)/2) return product(n*2, i, j, l, (l+r)/2);

	if(i>(l+r)/2) return product(n*2+1, i, j, (l+r)/2+1, r);

	return product(n*2, i, (l+r)/2, l, (l+r)/2) * product(n*2+1, (l+r)/2+1, j, (l+r)/2+1, r);
}

int main() {

	int n, q, in1, in2;
	char c;

	while(cin >> n >> q) {
		for(int i=0; i<n; i++) cin >> arr[i];

		buildtree(1, 0, n-1);

		for(int i=0; i<q; i++) {
			cin >> c >> in1 >> in2;
			in1--;
			switch(c) {
				case 'C':
					change(1, in1, sign(in2), 0, n-1);
					break;
				case 'P':
					in2--;
					cout << outputMap(product(1, in1, in2, 0, n-1));
					break;
			}
		}

		cout << endl;

	}

}







