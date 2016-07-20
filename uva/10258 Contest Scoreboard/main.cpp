#include <iostream>
#include <string>
#include <cstring>
#include <sstream>
#include <algorithm>
#include <vector>
#include <numeric>
#include <utility>

using namespace std;
int solved[110][10] = {0};
int penalty[110][10] = {0};
bool pl[110] = {false};

vector< std::pair<int,int> > total;


vector<size_t> sort_indexes(const vector<std::pair<int,int> > &v) {

    vector<size_t> idx(v.size());
    iota(idx.begin(), idx.end(), 0);

	sort(idx.begin(), idx.end(),
	       [&v](size_t i1, size_t i2) {
	
	    if (v[i1].first < v[i2].first) return false;
	    else if (v[i1].first == v[i2].first) {
	        if (v[i1].second < v[i2].second) return true;
	        else if(v[i1].second > v[i2].second) return false;
	        else return i1<i2;
	    }
	    return true;
	
	});

    return idx;
}


int main() {
	ios_base::sync_with_stdio(false);

	int numTests;
	cin >> numTests;
	cin.ignore();

	for(int i=0; i<=numTests; i++) {
		if(i!=0 && i!=1) cout<<endl;		

		string next;
		total.clear();
		memset(solved, 0, sizeof(solved[0][0]) * 110*10);
		memset(penalty, 0, sizeof(penalty[0][0]) * 110*10);
		fill_n(pl, 110, false);

		while(getline(cin,next)) {
			if(next == "") { break; }

			istringstream iss(next);		
			string tok;
			
			getline(iss, tok, ' ');
			int player = stoi(tok);
			getline(iss, tok, ' ');
			int qns = stoi(tok);
			getline(iss, tok, ' ');
			int time = stoi(tok);
			getline(iss, tok, ' ');
			string result = tok;
			
			pl[player] = true;
			if (!solved[player][qns]) {
				if(result == "I") {
					penalty[player][qns] += 20;
				}

				else if(result == "C") {
					penalty[player][qns] += time;
					solved[player][qns] = 1;
				}
			}
		}

		//count total solved problems and penalty
		for(int j=1; j<110; j++) {
			int totalSolved = 0;
			int totalPenalty = 0;

			for (int k=1; k<10; k++) {
				if(solved[j][k]) {
					totalSolved++;
					totalPenalty += penalty[j][k];
				}
			}

			total.push_back(make_pair(totalSolved, totalPenalty));
		}

		for(auto i: sort_indexes(total)) {
			if (pl[i+1]) {
				cout << i+1<< " "<<total[i].first << " " << total[i].second << endl;
			}
		}
	}

}


