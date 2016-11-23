#include <iostream>

using namespace std;
int dp[10000];

int main() {

	long maxstreak = -1;
	long streak = 0;
	int N;
	
	cin >> N;

	while (N!=0) {

		for(int i=0; i<N; i++) {
			cin >> dp[i];
			if (streak+dp[i]>=0) { 
				streak += dp[i];
				if(streak>maxstreak) maxstreak = streak;
			}
			else {
				if(streak>maxstreak) {
					maxstreak = streak;
				}
				streak = 0;
			}
		}
		
		if(streak>maxstreak) cout << "The maximum winning streak is " << streak << "." << endl;
		else if (maxstreak > 0) cout << "The maximum winning streak is " << maxstreak << "." << endl;
		else cout << "Losing streak." << endl;
		
		cin >> N;
		streak = 0;
		maxstreak = -1;
	}

}
