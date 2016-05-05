#include <iostream>
#include <cmath>
#include <stdio.h>
#include <cstring>
using namespace std;


int main()
{	
	int n;	
	bool seq[3000];
	while(scanf("%d", &n)!=EOF) {
		bool jolly = true;
		int arr[n];
		int total;

		memset(seq, false, sizeof(seq));
		cin >> arr[0];
		for(int i=1; i<n; i++) {
			cin >> arr[i];	
			total = abs(arr[i]-arr[i-1]);
			if (total>n-1 || total==0 || seq[total]) {
				//cout << "Not jolly" << endl;
				jolly = false;
			}	
			seq[total] = true;
		}
		
		if(jolly)
			cout<< "Jolly"<<endl;
		else
			cout << "Not jolly"<<endl;

	}

	return 0; 
}
