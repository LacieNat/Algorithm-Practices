#include <iostream>
#include <unordered_set>


using namespace std;

int main() {

	int t, n, flake;
	unordered_set<int> s;
	cin >> t;

	for(int i=0; i<t; i++) {
		cin >> n;
		s.clear();

		for(int j=0; j<n; j++) {
			cin >> flake;
			s.insert(flake);
		}
		
		cout << s.size() << endl;
	}
}
