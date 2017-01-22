#include <iostream>
#include <cmath>
#include <climits>
#include <iomanip>
#include <algorithm>
#include <cstring>

using namespace std;

int x[8], y[8];
int arr[8];
int ans[8];
double dist(int x1, int y1, int x2, int y2) {

	return sqrt(pow(x2-x1, 2) + pow(y2-y1, 2));

}

int main() {

	ios_base::sync_with_stdio(false);
	cout << fixed << setprecision(2);	
	int n; cin >> n;
	int cn = 1;
	while (n != 0) {
		for(int i=0; i<n; i++) {
			cin >> x[i] >> y[i];
			arr[i] = i;
		}
		
		double min = LONG_MAX;
	
		do {
			double sum = 0;
			
			for(int i=0; i<n-1; i++) {
				sum += dist(x[arr[i]], y[arr[i]], x[arr[i+1]], y[arr[i+1]]);
			}

			if(sum < min) {
				min = sum;
				memcpy(ans, arr, sizeof(arr));
			}
		} while(next_permutation(arr, arr+n));
		

		cout << "**********************************************************" << endl;
		cout << "Network #" << cn << endl;
		for(int i=0; i<n-1; i++) {
			cout << "Cable requirement to connect ("<<x[ans[i]] << "," << y[ans[i]] << ") to (" << x[ans[i+1]] << "," << y[ans[i+1]] << ") is " << dist(x[ans[i]], y[ans[i]], x[ans[i+1]], y[ans[i+1]])+16 << " feet."<<endl;
		}

		cout << "Number of feet of cable required is " << min + 16*(n-1) <<"." << endl;

		cin >> n;
		cn++;
	}


}






























