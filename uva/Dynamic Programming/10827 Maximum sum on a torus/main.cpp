#include <iostream>
#include <algorithm>
#include <climits>

int dp[150][150];

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	int T, N, max = -101;
	cin >> T;

	for(int i=0; i<T; i++) {
		cin >> N;

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cin >> dp[i][j];
				dp[i+N][j] = dp[i][j];
				dp[i][j+N] = dp[i][j];
				dp[i+N][j+N] = dp[i][j];
			}
		}

		for(int i=0; i<N*2; i++) {
			for(int j=0; j<N*2; j++) {
				if(i>0) dp[i][j] += dp[i-1][j];
				if(j>0) dp[i][j] += dp[i][j-1];
				if(i>0 && j>0) dp[i][j] -= dp[i-1][j-1];
			}
		}

		int ans=0;
		
		//IMPORTANT TO REVISE
		for(int i=0; i<N*2; i++) {
			for(int j=0; j<N*2; j++) {
				for(int k=i; k< min(N*2, i+N); k++) {	//keeping a maximum of only window size N in rows
					for(int l=j; l< min(N*2, j+N); l++) {	//keeping a maximum of only window size N in columns
						int subRect = dp[k][l];
						if(i>0) subRect -= dp[i-1][l];
						if(j>0) subRect -= dp[k][j-1];
						if(i>0 && j>0) subRect += dp[i-1][j-1];
						ans = ans>subRect?ans:subRect;
					}
				}
			}
		}

		cout << ans << endl;
	}		
}
