#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
char code[50];

int main() {
	ios_base::sync_with_stdio(false);
	while(true) {
		gets(code);
		if(code[0] == '#') break;

		if(!next_permutation(code, code+strlen(code))) {
			puts("No Successor");
		} else {
			puts(code);
		}

	}

}
