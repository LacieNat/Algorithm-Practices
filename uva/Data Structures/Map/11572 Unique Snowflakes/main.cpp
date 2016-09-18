#include <iostream>
#include <unordered_map>
#include <utility>
#include <algorithm>
using namespace std;
long segStart[1000001];
long segEnd[1000001];
unordered_map<long, long> m;

int main() {

	long t, n, flake;
	cin >> t;
	ios_base::sync_with_stdio(false);
	
	for(long i=0; i<t; i++) {
		cin >> n;
		m.clear();		

		fill_n(segStart, n, -1);
		fill_n(segEnd, n, -1);
		for(long j=0; j<n; j++) {
			cin >> flake;
			if (m.find(flake) != m.end()) {
				long prev = m.at(flake);
				segStart[prev] = j;
				segEnd[j] = prev;
				m.at(flake) = j;
			} else {
				m.insert(pair<long,long>(flake, j));
			}
		}
		
		long maxlen = 0;
	    for(long j=0; j<n; j++) {
			long end = segStart[j];
			long len;

			if(end == -1) {
				segStart[j] = n;
				
			} 
			
			len = segStart[j] - j;	
			
			for(long k=j+1; k<segStart[j]; k++) {
				if(segEnd[k]!= -1 && segEnd[k]>j) {
					len = k-j;
					break;
				}
			}
			maxlen = len>maxlen?len:maxlen;

		}
		
		cout << maxlen << endl;
	}

	return 0;
}
