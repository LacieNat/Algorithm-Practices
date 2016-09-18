#include <iostream>
#include <algorithm>
#include <string>
#include <sstream>
#include <cstdlib>
#include <climits>
#include <cstring>

using namespace std;

long long dp[100][100];
int seq[100];

int maxPdt(int i, int j) {
	if(dp[i][j]!=-1) return dp[i][j];

	if(i==j){
		dp[i][j] = seq[i];
		return seq[i];
	}

	if(i>j) {
		dp[i][j] = maxPdt(j, i);
		return dp[i][j];
	}

	dp[i][j] = maxPdt(i, j-1) * maxPdt(j,j);
	return dp[i][j];	

}

int main() {

	ios_base::sync_with_stdio(false);
	string in;

	while(getline(cin, in)) {
		memset(dp, -1, sizeof(dp));

		stringstream ss(in);
		int i=0, num;
		string numStr;
		ss >> numStr; num = stoi(numStr);

		while(num!= -999999) {
			seq[i] = num;
			i++;
			ss >> numStr;
			num = stoi(numStr);
		}
		i--;
		for(int j=0; j<=i; j++) {
			for(int k=j; k<=i; k++) {
				if(dp[j][k]==-1) {
					maxPdt(j, k);
				}
			}
		}
		
		long long res = LLONG_MIN;
		for(int j=0; j<=i; j++) {
			for(int k=0; k<=i; k++) {
				res = max(res, dp[j][k]);
			}
			//cout << endl;
		}
		//cout << endl;
		cout << res << endl;
	}

}
