#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int main() {
	int numtests, numchars, numlines;
	cin >> numtests;
	unordered_map<char, int> um;
	string text;
	unsigned long long cents;

	for(int i=0; i<numtests; i++) {
		cin >> numchars;
		cents = 0;
		um.clear();
		for(int j=0; j<numchars; j++) {
			char key;
			int val;
			cin.ignore();
			cin.get(key);
			cin >> val;
			um.insert(make_pair(key, val));
		}
		
		cin >> numlines;
		cin.ignore();
		for(int k=0; k<numlines; k++) {
			getline(cin, text); 
			for(int x=0; x<text.length(); x++) {
				if(um.find(text[x])!=um.end()) {
					cents+=um.at(text[x]);	
				}
			}
		}

		printf("%.2lf$\n", cents / 100.0);
	}
}
