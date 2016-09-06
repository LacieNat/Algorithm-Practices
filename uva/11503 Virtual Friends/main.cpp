#include <iostream>
#include <string>
#include <unordered_map>
#include <set>

using namespace std;

unordered_map<string, pair<int,string> > m;

void printMap() {
	for(auto &x: m) {
		cout << x.first << ": " << x.second.first << " " << x.second.second << endl;
	}

}

void makeset(string x) {
	if(m.find(x)==m.end()) m.insert(pair<string, pair<int, string> >(x, pair<int, string>(0, x)));
}

pair<int,string> * find(string x) {
	if(m[x].second != x) m[x].second = find(m[x].second)->second;
	
	return &((m.find(m[x].second))->second);
}

void un(string x, string y) {
	//printMap();
	//cout << "UNIONING " << x<<" " << y << endl;
	//cout << "w: " << find("w")->first << endl;
	pair<int, string> * xRoot = find(x);
	pair<int, string> * yRoot = find(y);
	//cout << xRoot->second <<xRoot->first << " " << yRoot->second << yRoot->first << endl;
	if (xRoot->second == yRoot->second) return;

	if(xRoot->first < yRoot->first) xRoot->second = yRoot->second;
	else if (xRoot->first > yRoot->first) yRoot->second = xRoot->second;
	else {
		yRoot->second = xRoot->second;
		xRoot->first = xRoot->first + 1;
	}
	//cout << xRoot->second <<xRoot->first << " " << yRoot->second << yRoot->first << endl;
	//cout << "END UNION" <<endl;

}

int main() {

	int t, f;
	string frnd1, frnd2;
	cin >> t;

	for(int i=0; i<t; i++) {
		m.clear();
		cin >> f;

		for(int j=0; j<f; j++) {
			cin >> frnd1 >> frnd2; 
			makeset(frnd1); makeset(frnd2);
			un(frnd1, frnd2);
			set<string> s; s.insert(frnd1); s.insert(frnd2);

			for(unordered_map<string, pair<int, string> >::iterator it = m.begin(); it!=m.end(); it++){
				if(it->first!=frnd1 && it->first!=frnd2) {
					if(*find(it->first) == *find(frnd1)) s.insert(it->first);
					if(*find(it->first) == *find(frnd2)) s.insert(it->first);
				}			
			}
			cout << s.size() << endl;
		}

	}

}
