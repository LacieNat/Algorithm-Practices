#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <climits>
#include <cstring>
#include <stack>

using namespace std;

vector<int> arr;

int main() {
	ios_base::sync_with_stdio(false);

	int in;

	while(cin >> in) {
		arr.push_back(in);
	}
	
	vector<int> L(arr.size());
	int L_id[arr.size()];
	int parent[arr.size()];

	int lis = 0, lis_end=0;

	for(int i=0; i<arr.size(); i++) {
		int pos = lower_bound(L.begin(), L.begin() + lis, arr[i]) - L.begin();
		L[pos] = arr[i];
		L_id[pos] = i;
		parent[i] = pos?L_id[pos-1]:-1;

		if(pos+1 >= lis) {
			lis = pos+1;
			lis_end = i;
		}
	}	
	
	//for(int i=0; i<arr.size(); i++) cout << arr[i]<< " "; cout << endl;
	//for(int i=0; i<arr.size(); i++) cout << lis[i]<< " "; cout << endl;
	//for(int i=0; i<arr.size(); i++) cout << parent[i]<<" "; cout <<endl;

	cout << lis << endl;
	cout << "-" << endl;
	stack<int> s;
	s.push(arr[lis_end]);
	//cout << "ind: " << ind << endl;;
	while(parent[lis_end] !=-1) {
		lis_end = parent[lis_end];
		//cout << "ind: " << ind << endl;
		s.push(arr[lis_end]);
	}

	while(!s.empty()) { cout << s.top() << endl; s.pop(); }

}
