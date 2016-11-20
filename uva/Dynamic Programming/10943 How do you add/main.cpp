#include <iostream>

using namespace std;
long long dp[101][101];

int main() {
	ios_base::sync_with_stdio(false);
	
	int N,K;
	cin >> N >> K;
	
	for(int i=0; i<101; i++) {
		dp[0][i] = 0;
		dp[1][i] = 1;
	}

	for(int i=1; i<101; i++) dp[i][0] = 1;

	for(int i=1; i<101; i++) {
		for(int j=1; j<101; j++) {
			dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000;
		}
	}

	
	while(N!=0 || K!=0) {
		cout << dp[K][N] <<endl;
		//cout << dp [100][100] << endl;
		cin >> N >> K;
	}
}
