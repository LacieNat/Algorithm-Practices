#include <iostream>
#include <set>

using namespace std;

int main() {
	int days;
	int bills;
	int bill;
	
	cin >> days;
	multiset<int> s;
	while (days) {
		long sum = 0;
		for(int i=0; i<days; i++) {
			cin >> bills;

			for(int j=0; j<bills; j++) {
				cin >> bill;
				s.insert(bill);
			}
			
			multiset<int>::iterator low = s.begin();
			multiset<int>::iterator hi = s.end();
			--hi;
			sum += (*hi - *low);
			s.erase(low);
			s.erase(hi);
		}
		
		cout << sum <<endl;
		cin >> days;
		s.clear();
	}

	return 0;
}
