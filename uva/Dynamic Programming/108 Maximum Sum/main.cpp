#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>

int dp[100][100];
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	int N, in;

	while (cin >> N) {

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cin >> in;
			
				dp[i][j] = in;

				if(i>0) dp[i][j] += dp[i-1][j];
				if(j>0) dp[i][j] += dp[i][j-1];
				if(i>0 && j>0) dp[i][j] -= dp[i-1][j-1];	

			}
		}
		
		int res = -127*100*100;

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=i; k<N; k++) {
					for(int m=j; m<N; m++) {
						int sum = dp[k][m];
						if(i>0) sum -= dp[i-1][m];
						if(j>0) sum -= dp[k][j-1];
						if(i>0 && j>0) sum += dp[i-1][j-1];
						res = max(res, sum);						
					}
				}
			}
		}

		cout << res << endl;
	}

}
