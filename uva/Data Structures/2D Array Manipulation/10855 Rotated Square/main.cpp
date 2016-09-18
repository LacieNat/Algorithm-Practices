#include <iostream>

using namespace std;
int N, n;
char big[10000][10000];
char small[4][10000][10000];

void rotate() {
	for(int i=1; i<4; i++) {
		for(int j=0; j<n; j++) {
			for(int k=0; k<n; k++) {
				small[i][j][k] = small[i-1][n-k-1][j];
			}
		}
	}	

}

bool exists(int i, int j, int o) {
	for(int x=i; x<i+n; x++) {
		for(int y=j; y<j+n; y++) {
			if(big[x][y]!=small[o][x-i][y-j]) return false;
		}
	} 

	return true;
}

int getCount(int o) {
	int c = 0;	
	
	for(int i=0; i<N-n+1; i++) {
		for(int j=0; j<N-n+1; j++) {
			if(exists(i,j,o)) c++;
		}
	}
	
	return c;
}
int main() {
	ios_base::sync_with_stdio(false);

	cin >> N >> n;

	while(N!=0 || n!=0) {
		
		cin.ignore();	
		//get big array
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cin.get(big[i][j]);
			}
			cin.ignore();
		}

		//get small array
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				cin.get(small[0][i][j]);
			}
			cin.ignore();
		}
		
		rotate();

		for(int i=0; i<3; i++) {
			cout<<getCount(i)<<" ";
		}

		cout<<getCount(3)<<"\n";

		cin >> N >> n;
	}

}

