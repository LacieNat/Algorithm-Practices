#include <iostream>
#include <queue>

using namespace std;

priority_queue<int, vector<int>, greater<int> > p;


int main() {

	ios_base::sync_with_stdio(false);
	int n, x, sum;
	cin >> n;

	while ( n!=0) {
		
		for(int i=0; i<n; i++) {
			cin >> x;
			p.push(x);
		}

		sum = 0;
		while(!p.empty()) {
			int x = p.top();
			p.pop();
			int y = p.top();
			p.pop();
			int z = x+y;
			sum+=z;
			
			if(!p.empty())
			p.push(z);
		}		
	
		cout << sum << endl;
		cin >> n;
	}

}
