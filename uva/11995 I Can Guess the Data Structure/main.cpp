#include <iostream>
#include <queue>
#include <stack>

using namespace std;

int main() {
	
	int n, query, in;
	ios_base::sync_with_stdio(false);

	while (cin >> n) {
		bool isQ = true, isPQ = true, isS = true;
		queue<int> q; 
		stack<int> s;
		priority_queue<int> pq;

		for(int i=0; i<n; i++) {
			cin >> query >> in;
			switch(query) {
				case 1:
					if(isQ) q.push(in);
					if(isPQ) pq.push(in);
					if(isS) s.push(in);
					break;
				case 2:
					if(isQ && (q.empty() || q.front()!=in)) isQ = false; 
					else if(isQ && !q.empty() && q.front() == in) q.pop();

					if(isPQ && (pq.empty() || pq.top()!=in)) isPQ = false;
					else if(isPQ && !pq.empty() && pq.top() == in) pq.pop();

					if(isS && (s.empty() || s.top()!=in)) isS = false;
					else if(isS && !s.empty() && s.top()==in) s.pop();
					break;
			}

		}

		if(!isQ && !isPQ && !isS) cout << "impossible" << endl;
		else if(isQ && !isPQ && !isS) cout << "queue" << endl;
		else if(!isQ && isPQ && !isS) cout << "priority queue" << endl;
		else if(!isQ && !isPQ && isS) cout << "stack" << endl;
		else cout << "not sure" << endl;
				
	}


}
