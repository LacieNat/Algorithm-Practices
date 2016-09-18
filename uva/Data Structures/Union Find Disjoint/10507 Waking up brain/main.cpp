#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <map>

using namespace std;

int N, M;
string activatedAreas, conn;

void printActivated(bool activated[]) {
	cout << "PRINTING ACTIVATED: " <<endl;
	for(int i=0; i<26; i++) cout << activated[i] << " ";
	cout << endl;
}

void printCount(int count[]) {
	cout << "PRINTING COUNT: " <<endl;
	for(int i=0; i<26; i++) cout << count[i] << " ";
	cout << endl;

}

int main() {

	ios_base::sync_with_stdio(false);

	while(cin >> N) {
		cin >> M >> activatedAreas;
		
		bool activated[26] = {false};
		vector<int> m[26];	
		
		for(int i=0; i<activatedAreas.length(); i++) {
			//cout << activatedAreas[i]-65 << endl;
			activated[activatedAreas[i]-65] = true;
		}

		for(int i=0; i<M; i++) {
			cin >> conn;
			m[conn[0]-65].push_back(conn[1]-65);
			m[conn[1]-65].push_back(conn[0]-65);
		}

		int years = 0;
		while(true) {
			int c1 = 0;
			int count[26] = {0};
			bool allActivated = true;
			int numActivated = 0;
			//printActivated(activated);
			for(int i=0; i<26; i++) {
				if(activated[i]) {
					for(int j=0; j<m[i].size(); j++) {
						//cout << m[i][j];
						if(!activated[m[i][j]]) {
							count[m[i][j]]++;
						}
					}
					//cout << endl;
				}
			}

			for(int i=0; i<26; i++) {
				if(count[i] >=3) {
					c1++;
					activated[i] = true;
				}
				
				if(activated[i]) numActivated++;
			}
			
			if(c1!=0)	years++;
			if(numActivated == N) {
				cout << "WAKE UP IN, " << years << ", YEARS" << endl;
				break;
			}

			else if(c1==0) {
				cout << "THIS BRAIN NEVER WAKES UP" << endl;
				break;
			}

		}
	}

}
