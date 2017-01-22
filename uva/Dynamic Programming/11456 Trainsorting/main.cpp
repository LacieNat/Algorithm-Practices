#include <iostream>
#include <cstring>

using namespace std;
int lis[2500];
int lds[2500];
int w[2500];
int T,N;

void findLIS() {
	lis[N-1] = 1;
	int ans = 1;
	for(int i=N-2; i>=0; i--) {
		ans = 1;
		for(int j=N-1; j>i; j--) {
			if(w[i]<w[j]) {
				ans = (1+lis[j])>ans?(1+lis[j]):ans;
			}
		}
		lis[i] = ans;
	}

}

void printLIS() {
	for(int i=0; i<N; i++) cout << lis[i] << " ";

	cout << "LIS END" << endl;

}

void printLDS() {
	for(int i=0; i<N; i++) cout << lds[i] << " ";

	cout << "LDS END" << endl;

}

void findLDS() {
	lds[N-1] = 1;
	int ans = 1;
	for(int i= N-2; i>=0; i--) {
		ans = 1;
		for(int j=N-1; j>i; j--) {
			if(w[i]>w[j]) {
				ans = (1+lds[j])>ans?(1+lds[j]):ans;
				
			}
		}

		lds[i] = ans;
	}
}

int main() {

	cin >> T;
	ios_base::sync_with_stdio(false);

	while (T--) {
		cin >> N;
		
		for(int i=0; i<N; i++) {
			cin >> w[i];
		}

		findLIS();
		findLDS();
		//printLIS();	
		//printLDS();
		int max = 0;

		for(int i=0; i<N; i++) {
			max = (lis[i]+lds[i]-1)>max?(lis[i]+lds[i]-1):max;
		}

		cout << max << endl;
		
	}
}


