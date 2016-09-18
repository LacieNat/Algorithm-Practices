#include <iostream>
#include <string>
#include <algorithm>
#include <sstream>

using namespace std;

int t, numComp, suc=0, unsuc=0;
string in, type;
int c1, c2;
int v[1000000];

int find(int x) {
	if(v[x] == x) {
		return x;
	}
	else return find(v[x]);
}

void un(int x, int y) {
	int xRoot = find(x);
	int yRoot = find(y);
	v[xRoot] = yRoot;
}

void makeSet(int x) {
	v[x] = x;
}

int main() {

	ios_base::sync_with_stdio(false);

	cin >> t;
	cin.ignore();
	int temp = t;
	while(getline(cin, in)) {

		//cout << in << endl;
		if (in == "") {
			//clear all data
			fill_n(v, 1000000, 0);
			cin >> numComp;
			
			for(int i=1; i<=numComp; i++) {
				makeSet(i);
			}
	
			cin.ignore();
			if(temp !=t) {
				cout << suc << "," << unsuc << endl<<endl;
			}
			temp --;
			suc = 0; unsuc = 0;
		}

		else {
			istringstream iss(in);	
			iss >> type >> c1 >> c2;
			//cout << in << type << c1 << c2 << endl;	
			if(type== "c"){
				un(c1, c2);
			}
			else {
				//cout << c1 << " " << find(c1) << " " << c2 << " " << find(c2) << endl;
				if(find(c1) == find(c2)) suc++;
				else unsuc++;
				
			}
		}

	}

	if(suc!=0 || unsuc!=0) {
         cout << suc << "," << unsuc << endl;
    }

}

