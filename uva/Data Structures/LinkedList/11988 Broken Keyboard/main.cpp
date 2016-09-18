#include <iostream>
#include <list>
#include <string>

using namespace std;
string t; 
list<char> sen;
int main() {
	ios_base::sync_with_stdio(false);

	while(getline(cin,t)) {
		sen.clear();
		list<char>::iterator it = sen.begin();
		
		for(int i=0; i<t.length(); i++) {
			if (t[i] =='[') {
				it = sen.begin();
			} else if (t[i] == ']') {
				it = sen.end();
			} else {
				sen.insert(it, t[i]);
			}
		}

		for(list<char>::iterator ite=sen.begin(); ite!=sen.end(); ite++) {
			cout << *ite;
		}
		cout << endl;
	
	} 

	//for(list<char>::iterator it=sen.begin(); it!=sen.end(); it++) {
	//	cout << *it << endl;
	//}
}
