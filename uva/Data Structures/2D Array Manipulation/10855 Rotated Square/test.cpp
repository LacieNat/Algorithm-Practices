#include <iostream>

using namespace std;

void value(int arr[][3]) {
	arr[0][0] = 3;
}

int main() {
	int t[1][3]={{1,2,3}};
	value(t);
	cout << t[0][0]<<"\n";

}
