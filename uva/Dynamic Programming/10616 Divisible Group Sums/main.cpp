#include <iostream>
#include <algorithm>
#include <string>
#include <climits>
#include <cstring>
#include <cmath>

using namespace std;

unsigned long long int dp[201][21][11];
int arr[201];
int n,q,d,m, c;

int solve(int i, int j, int k) {
	//cout << "i: " << i << " j: " << j << " k: " << k << " dp: " << dp[i][j][k]<<endl;

	if(k<0) return 0;

	if(k==0) {
		if (j==0) return 1;
		return 0;
	}

	if(i==n) return 0;

	if(dp[i][j][k]!=-1) return dp[i][j][k];

	dp[i][j][k] = solve(i+1, (j+arr[i+1])%d, k-1) + solve(i+1, j%d, k);

	return dp[i][j][k];
}

int main() {
	c = 1;
	while ( cin >> n >> q) {
		if(n==0 && q==0) break;

		cout << "SET " << c << ":" << endl;
		//memset(dp, 0, sizeof(dp));
		memset(arr, -1, sizeof(arr));

		for(int i=0; i<n; i++) {
			cin >> arr[i];
			//cout << arr[i];
		}
		//cout <<endl;

		for(int i=0; i<q; i++) {
			cin >> d >> m;
			memset(dp, 0, sizeof(dp));

			//solve(0, arr[0], m-1);
			//solve(0, 0, m); 

			cout << "QUERY " << i+1 << ": " << solve(0,0,m) << endl;
		}
		c++;	
	}

}


