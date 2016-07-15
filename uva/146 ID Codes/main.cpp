#include <iostream>
#include <string>
#include <cstring>
using namespace std;
char code[50];

int main() {
	ios_base::sync_with_stdio(false);
	
	string input;

	getline(cin, input);
	strcpy(code, input.c_str());

	while(code[0] != '#') {
		bool flag = true;
		int last = input.length()-1;
		
		for(int i=input.length()-2; i>=0; i--) {
			if (code[last] == code[i]) {
				last--;
				i = last;
			}	
	
			else if (code[last] > code[i]) {
				flag = false;
				if(i==0) {
					cout<<code[last];
					for(int j=0; j<input.length(); j++) {
						if (j!=last) {
							cout<<code[j];
						}
					}
					cout<<"\n";
				} else {
				
					for(int j=0; j<i; j++) {
						cout << code[j];
					}
					cout<<code[last];
	
					for(int j=i; j<input.length(); j++){
						if(j!=last) {
							cout<<code[j];
						}
					}
					cout<<"\n";
				}
				break;
			}
		}
	
		if(flag) cout << "No Successor" << endl;
		getline(cin, input);
		strcpy(code, input.c_str());
	}
}
