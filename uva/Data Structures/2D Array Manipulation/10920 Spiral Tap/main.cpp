#include <iostream>
#include <cmath>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	int sz;
	unsigned long long p;
	
	cin >> sz >> p ;

	while(sz!=0 || p !=0) {
		//cartesian coordinates of starting square 1
		unsigned long long startx = (sz/2) + 1;
		unsigned long long starty = (sz/2) + 1;		
		
	    unsigned long long cnt = floor(sqrt(p));
		cnt = cnt%2==0?cnt-1:cnt;
		p -= pow(cnt,2);			
		startx += (cnt-1)/2;
		starty += (cnt-1)/2;

		unsigned long long mul = p/(cnt+1);
		unsigned long long rem = p%(cnt+1);

		switch (mul)	{
			case 0:
				startx = rem==0?startx:(startx+1);
				starty = rem==0?starty:(starty+1-rem);
				break;
			case 1:
				startx = startx+1-rem;
				starty = starty-cnt;
				break;
			case 2:
				startx = startx-cnt;
				starty = starty-cnt+rem;
				break;
			case 3:
				startx = startx-cnt+rem;
				starty+=1;
				break;
		}	

		cout << "Line = " << startx << ", column = " << starty << "." << endl;


		cin >> sz >> p;
	}

}
