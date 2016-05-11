#include <iostream>
#include <string>
#include <set>
#include <algorithm>
#include <sstream>
using namespace std;

int main() {
	string s;
	set<string> dictionary;
	stringstream ss;
	while(cin >> s) {
		for(int i=0; i<s.length(); i++) {
			if(isalpha(s[i])) {
				s[i] = ::tolower(s[i]);
			} else {
				s[i] = ' ';
			}
		}

		ss.clear();
		ss << s;

		while (ss >> s) dictionary.insert(s);

	}
	for(set<string>::iterator it = dictionary.begin(); it!=dictionary.end(); ++it)
		cout<<*it<<endl;

	return 0;
	
}
