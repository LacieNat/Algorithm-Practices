#include <iostream>
#include <algorithm>
#include <string>
#include <climits>
#include <cstring>
#include <cmath>

using namespace std;

int dp[201][21][11];
int arr[201];
int n,q,d,m, c;

void solve(int i, int j, int k) {
	dp[i][abs(j)][k]++;
	//cout << "i: " << i << " j: " << j << " k: " << k << " dp: " << dp[i][j][k]<<endl;

	if(i==n-1) return;

	solve(i+1, (j+arr[i+1])%d, k-1);
	solve(i+1, j, k);
}

int main() {
	c = 1;
	while ( cin >> n >> q) {
		if(n==0 && q==0) break;

		cout << "SET " << c << ":" << endl;
		//memset(dp, 0, sizeof(dp));
		memset(arr, 0, sizeof(arr));

		for(int i=0; i<n; i++) {
			cin >> arr[i];
			//cout << arr[i];
		}
		//cout <<endl;

		for(int i=0; i<q; i++) {
			cin >> d >> m;
			memset(dp, 0, sizeof(dp));

			solve(0, arr[0]%d, m-1);
			solve(0, 0, m); 

			cout << "QUERY " << i+1 << ": " << dp[n-1][0][0] << endl;
		}
		c++;	
	}

}


