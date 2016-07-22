#include <iostream>
#include <bitset>

using namespace std;
bitset<1000005> cal;

bool isConflict(int start, int end) {
	
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	int n, m;

	cin >> n >> m;
	int start, end, repeat;

	while (n!=0 || m!=0) {
		bool conflict = false;
		cal.reset();
		for (int i=0; i<n; i++) {
			cin >> start >> end;
			
			for(int j=start; j<end; j++) {
				if (cal[j] == 1) {
					conflict = true;
					break;
				}
					cal.set(j,1);
			}
			//if(conflict) break;
		}

		for (int i=0; i<m; i++) {
			cin >> start >> end >> repeat;
			while (end <= 1000000) {
				for(int j=start; j<end; j++) {
					if (cal[j] == 1) { 
						conflict = true;
						break;
					}
						cal.set(j, 1);
				}
				
				//if(conflict) break;
				start+=repeat;
				end+=repeat;
			}
		}
		
		if(conflict) cout << "CONFLICT" << endl; else cout << "NO CONFLICT" << endl;
		cin >> n >> m;
	}
}
