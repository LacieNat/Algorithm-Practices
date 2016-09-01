#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

typedef pair<int, int> p;

class compare {
public:
	bool operator()	(const p &A, const p &B) {
		if (A.second < B.second) return false;
		else if (A.second > B.second) return true;
		else {
			if(A.first < B.first) return false;
			else return true;
			
		} 

	}
};

int map[3000];
priority_queue<p, vector<p>, compare> pq;

int main() {

	ios_base::sync_with_stdio(false);
	string input;

	cin >> input;
	int x, y;
	while (input!="#") {
		cin >> x >> y;
		map[x] = y;
		pq.push(p(x, y));
		
		cin >> input;
	}
	int k; cin >> k;
	p top;
	while (k--) {
		top = pq.top();
		cout << top.first << endl;
		
		pq.pop();
		pq.push(p(top.first, map[top.first] + top.second));
	}
	
}
