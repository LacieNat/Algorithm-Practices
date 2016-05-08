#include <iostream>
#include <string>

using namespace std;

void dfs(string s1, string s2, string st, string path, string res, int n) {
	if(n == s2.size()*2) {
		if(res ==s2) {
			cout<<path.substr(0, path.size()-1)<<endl;
		}
		return;
	}
		
	//push
	if(s1.size()>0){
		dfs(s1.substr(1, s1.size()-1), s2, st+s1[0], path+"i ", res, n+1);
	}

	//pop
	if(st.size()>0 && st[st.size()-1] == s2[res.size()]) {
		dfs(s1, s2, st.substr(0, st.size()-1), path+"o ", res+st[st.size()-1], n+1);
	}
}


int main() {
	string in, out;

	while(cin >> in >> out) {
		//cout<<in<<" " << out<<endl;
		cout<< "[" <<endl;
		if(in.size() == out.size())
			dfs(in, out, "", "", "", 0);
		cout<<"]"<<endl;
	}
}


