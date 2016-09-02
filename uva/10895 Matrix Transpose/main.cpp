#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <utility>

using namespace std;
int m, n;
int s, in, input;
vector<int> v;

int main() {

	ios_base::sync_with_stdio(false);
	
	while (cin >> m >> n) {

	vector<pair<int, int> > rows[10010];
	for(int i=0; i<m; i++) {
		v.clear();
		cin >> s;
		
		for(int j=0; j<s; j++) {
			cin >> in;
			v.push_back(in);
		}
		
		for(int j=0; j<s; j++) {
			cin >> input;
			rows[v[j]].push_back(pair<int,int>(input, i+1));
			
		}
	}

	cout << n << " " << m << endl;

	for(int i=1; i<=n; i++) {
		vector<pair<int, int> > rw = rows[i];
		cout << rw.size();

		for(vector<pair<int, int> >::iterator it = rw.begin(); it!=rw.end(); it++) {
			cout << " " << it->second;
		}

		cout << endl;

		for(vector<pair<int, int> >::iterator it = rw.begin(); it!=rw.end(); it++) {
            cout << it->first;
			if(it!=rw.end()-1) cout << " ";
        }

		cout << endl;
	}
	
	//delete rows;
	
	}

}
