#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	int s, b, lr, rr;
	cin >> s >> b;

	while ( s!=0 || b!=0) {
		int ls[s+1];
		int rs[s+1];
	
		for(int i=0; i<=s; i++) {
			ls[i] = i-1;
			rs[i] = i+1;
		}

		for(int i=0; i<b; i++) {
			cin >> lr >> rr;

			if(ls[lr] < 1)
				cout << "* ";
			else cout << ls[lr] << " ";

			if(rs[rr] > s) 
				cout << "*" << endl;
			else
				cout << rs[rr]<<endl;

			ls[rs[rr]] = ls[lr];
			rs[ls[lr]] = rs[rr];
	
		}
	
		cout << '-' << endl;
		cin >> s >> b;
	}
	
}
