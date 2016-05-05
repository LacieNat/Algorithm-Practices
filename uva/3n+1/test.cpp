#include <iostream>
using namespace std;
int main() {
	int i;
	cout << "Enter number: ";
	cin >> i;
	int arr[i];
	arr[0] = 3;
	arr[1] = 4;
	std::cout << *(arr+1)<<std::endl;

	return 0;
}
