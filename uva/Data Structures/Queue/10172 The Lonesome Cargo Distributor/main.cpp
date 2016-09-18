#include <iostream>
#include <queue>
#include <stack>

using namespace std;

int main() {

	ios_base::sync_with_stdio(false);

	int set, n, s, q;
	queue<int> platformB[105];
	stack<int> cargo;

	cin >> set;

	for(int i=0; i<set; i++) {

		cin >> n >> s >> q;

		int time = 0;
		
		int t, item;
		for(int j=1; j<=n; j++) {
			cin >> t;

			for(int k=0; k<t; k++) {
				cin >> item;
				platformB[j].push(item);
			}
		}
		
		while(true) {
			bool done;
			for(int j=1; j<=n; j++) {
				//unload cargo onto platform A of station j
				while(!cargo.empty()) {
					if (cargo.top() == j) {
						cargo.pop();
						time++;
					}
					else if(platformB[j].size() <q) {
						platformB[j].push(cargo.top());
						cargo.pop();
						time++;		
					} else break;
				}

				//load cargo from platform B of station j
				while(cargo.size() < s && !platformB[j].empty()) {
					cargo.push(platformB[j].front());
					platformB[j].pop();
					time++;
				}
				
				done = cargo.empty();
				for(int k=1; k<=n; k++) done = done & platformB[k].empty();
				if (done) break;
				time += 2;
			}
			
			if(done) break;
		}

		cout << time << endl;		
	}


}
