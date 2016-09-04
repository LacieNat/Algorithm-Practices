#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

//vector<vector<int> > v(1000010);

int main() {

	ios_base::sync_with_stdio(false);

	int n, m, input, qnum, qin;
	
	while(cin >> n >> m) {
		vector<vector<int> > v(1000010);
		for(int i=0; i<n; i++) {
			cin >> input;	
			v[input].push_back(i+1);
		}

		for(int i=0; i<m; i++) {
			cin >> qnum >> qin;

			if(qnum <= v[qin].size())
				cout << v[qin][qnum-1] << endl;
			else
				cout << 0 << endl;
		}
	}

}
