#include<iostream>
#include<algorithm>
using namespace std;
int arr[10000];

int main() {

	ios_base::sync_with_stdio(false);

	int n;
	int size = 0;
	int median = 0;
	while (cin >> n) {
		arr[size] = n;
		sort(arr, arr+size+1);		
		if(size%2 == 0) {
			cout << arr[median]<<endl;
		} else {
			cout << (arr[median] + arr[median+1])/2<<endl;
			median++;
		}
		size++;
	}
}
