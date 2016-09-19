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
	
	int lis[arr.size()];
	int parent[arr.size()];

	memset(parent, -1, sizeof(parent));;
	
	lis[0] = 1;	
	
	int ans = 1;
	int ind = 0;

	for(int i=1; i<arr.size(); i++) {
		int max = 1;
		for(int j=i-1;j>=0; j--) {
			if(arr[j] < arr[i]) {
				if(lis[j] + 1 > max) {
					parent[i] = j;
					max = lis[j]+1;
				}
			} 
		}
		lis[i] = max;
		if(lis[i]>=ans) {
			ans = lis[i];
			ind = i;
		}
	}
	
	//for(int i=0; i<arr.size(); i++) cout << arr[i]<< " "; cout << endl;
	//for(int i=0; i<arr.size(); i++) cout << lis[i]<< " "; cout << endl;
	//for(int i=0; i<arr.size(); i++) cout << parent[i]<<" "; cout <<endl;

	cout << lis[ind] << endl;
	cout << "-" << endl;
	stack<int> s;
	s.push(arr[ind]);
	//cout << "ind: " << ind << endl;;
	while(parent[ind] !=-1) {
		ind = parent[ind];
		//cout << "ind: " << ind << endl;
		s.push(arr[ind]);
	}

	while(!s.empty()) { cout << s.top() << endl; s.pop(); }

}
