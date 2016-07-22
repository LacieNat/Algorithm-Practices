#include <iostream>
#include <cmath>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);

	int input;

	while(true) {
		cin >> input;

		if(input == 0) break;
		
		int a = 0;
		int b = 0;
		int numIs = 1;
		int k;
		for (int c =0; c<=31; c++) {
			k = input >> c;

			if ( k & 1 ) {
				if ( numIs %2 == 1) {
					a += pow(2, c);
				} else {
					b += pow(2, c);
				}
				numIs++;
			}
		}

		cout << a << " " << b << endl;
	}

}
