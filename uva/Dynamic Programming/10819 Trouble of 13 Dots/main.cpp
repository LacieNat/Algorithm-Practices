#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;
int m, n, p, f;
int wt[100], val[100];

int max(int a, int b) {return (a>b)?a:b;}

int knapsack(int W, int n) {

	if(n ==0 || W <= 0) return 0;

	//cout << val[n-1] + knapsack(W-wt[n-1], wt, val, n-1, refund) << endl;
	if(used < 1800 && wt[n-1] > W || used >=1800 && W+used) { 
		//cout << wt[n-1] << endl; cout << W << endl; 
		return knapsack(W, n-1);
	}

	else {
		int t = knapsack(W-wt[n-1], n-1);
		//cout << val[n-1] << " " <<val[n-1] + t << " " << W << " " << wt[n-1] << endl;
		return max(val[n-1] + t, knapsack(W, n-1));

	}

}

int main() {

	ios_base::sync_with_stdio(false);
		
	while (cin >> m >>n) {

		for(int i=0; i<n; i++) {
			cin >> p >> f;
			wt[i] = p;
			val[i] = f;
		}

		cout << knapsack(m, n)<<endl;
	}	
	
}
