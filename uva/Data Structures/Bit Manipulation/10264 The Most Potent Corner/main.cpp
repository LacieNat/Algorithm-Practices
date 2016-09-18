/*
A N-Dimensional cube is usually termed as a hypercube.
The number of corners a N cube has is 2^n.
*/
#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>
#define arr_size 20000
using namespace std;


int weights[arr_size];
int potencies[arr_size];
int n, corners;
vector< vector<int> > neighbours(arr_size, vector<int>(0));

void fillNeighbours() {
	for(int i=0; i<corners; i++) {
		neighbours[i].clear();
		potencies[i] = 0;
		for(int j=0; j<n; j++) {
			neighbours[i].push_back((i ^ (1<<j)));
			potencies[i] += weights[(i ^ (1<<j))];
		}
	}
}

int findMax() {
	int max = 0;
	for(int i=0; i<corners; i++) {
		vector<int> curr = neighbours[i];

		for(vector<int>::iterator it = curr.begin(); it!=curr.end(); it++) {
			int total = potencies[i] + potencies[*it];
			max = total > max? total: max;
		}
	}

	return max;
}

int main() {

	ios_base::sync_with_stdio(false);
	
	while (cin >> n) {
		corners = pow(2, n);

		for(int i=0; i<corners; i++) {
			cin >> weights[i];
		}
		
		fillNeighbours();
		
		cout << findMax() << endl;
	}
}
