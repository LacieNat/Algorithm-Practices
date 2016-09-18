#include <iostream>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);

	int numCoaches;	
	int next;
	stack<int> st;
	cin >> numCoaches;

	while (numCoaches != 0) {
		cin >> next;
		
		while (next != 0) {
			for(int i=1; i<= numCoaches; i++) {
				st.push(i);

				if(next == i) {
					while(!st.empty() && st.top() == next) {
						st.pop();
						cin >> next;
					}
				}
			}
	
			if (st.empty()) cout << "Yes"<<endl;
			else cout << "No" << endl;
			
			while (!st.empty()) { st.pop(); cin >> next;} 
		}

		cin >> numCoaches;
		cout << endl;
	}

}
