#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

unsigned long long int dp[30001];
int c[5] = {1, 5, 10, 25, 50};


int main() {

	int n;
	dp[0] = 1;

	for(int i=0; i<5; i++) {
        for( int j=c[i]; j<30001; j++) {
            dp[j] += dp[j-c[i]];
        }
    }

	while(cin >> n) {
		
		if(dp[n]>1) cout << "There are " << dp[n] << " ways to produce " << n << " cents change."<<endl;
		else cout << "There is only 1 way to produce "<< n << " cents change." << endl;

	}


}
