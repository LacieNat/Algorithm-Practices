#include <iostream>
#include <map>
#include <string>
#include <iomanip>

using namespace std;

int main() {

	ios_base::sync_with_stdio(false);

	int t, total;

	cin >> t;
	cin.ignore();
	cin.ignore();
	map<string, int> m;
	string tree;

	while (t) {
		m.clear();
		total = 0;

		while(getline(cin, tree)) {
			if (tree == "") break;

			if(m.find(tree) == m.end())
				m.insert(pair<string, int>(tree, 1));
			else {
				m.at(tree)+=1;
			}
			total++;
		}	
	
		t--;

		for(map<string, int>::iterator it = m.begin(); it!=m.end(); it++) {
			cout << it->first<<" "<< fixed << setprecision(4) << ((float) it->second)/total*100.0 << endl;
		}

		if(t) cout << endl;
	}

}
