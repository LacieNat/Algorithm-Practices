#include <iostream>
#include <set>
#include <vector>
#include <algorithm>
using namespace std;

set<int> jack;
set<int> jill;
vector<int> jackAndJill;
int n, m, value;
int main() {

	cin >> n >> m;

	while(n!=0 || m!=0) {
		jack.clear(); jill.clear(); jackAndJill.clear();	
		for(int i=0; i<n; i++){
			cin >> value;
			jack.insert(value);		
		}

		for(int i=0; i<m; i++)	{
			cin >> value;
			jill.insert(value);
		}

		set_intersection(jack.begin(), jack.end(), jill.begin(), jill.end(), inserter(jackAndJill, jackAndJill.end()));

		cout << jackAndJill.size() << endl;
		
		cin >> n >> m;
	}


}
