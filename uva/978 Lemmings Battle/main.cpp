#include <iostream>
#include <algorithm>
#include <string>
#include <set>
#include <functional>

using namespace std;

int t, b, sg, sb;
multiset<int, greater<int> > sg_pow;
multiset<int, greater<int> > sb_pow;
multiset<int, greater<int> > temp1;
multiset<int, greater<int> > temp2;
int main() {

	ios_base::sync_with_stdio(false);

	multiset<int, greater<int> >::iterator it1;
	multiset<int, greater<int> >::iterator it2;
	cin >> t;

	while(t--) {
		cin >> b >> sg >> sb;
		int value;
		sg_pow.clear(); sb_pow.clear();

		for(int i=0; i<sg; i++) {
			cin >> value;
			sg_pow.insert(value);			
		}

		for(int i=0; i<sb; i++) {
			cin >> value;
			sb_pow.insert(value);
		}

		while (!sg_pow.empty() && !sb_pow.empty()) {
			int btemp = b;
			temp1.clear();
			temp2.clear();

			while(btemp-- && !sg_pow.empty() && !sb_pow.empty()) {
				it1 = sg_pow.begin();
				it2 = sb_pow.begin();
				if(*it1 > *it2) {
					temp1.insert(*it1-*it2);
				}
				else if(*it2 > *it1) {
					temp2.insert(*it2-*it1); 
				}
				sg_pow.erase(it1);
				sb_pow.erase(it2);
			} 

			sg_pow.insert(temp1.begin(), temp1.end());
			sb_pow.insert(temp2.begin(), temp2.end());
		}

		if(sg_pow.empty() && sb_pow.empty()) cout << "green and blue died" << endl;
		else if(sg_pow.empty()) {
			cout << "blue wins" << endl;
			for(it1=sb_pow.begin(); it1!=sb_pow.end(); it1++) cout << *it1 << endl;
		} else {
			cout << "green wins" << endl;
			for(it1=sg_pow.begin(); it1!=sg_pow.end(); it1++) cout << *it1 << endl;
		}		
		if(t) cout << endl;
	}

}
