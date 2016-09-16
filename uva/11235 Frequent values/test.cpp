#include <cstdio>
#include <cstring>
#include <algorithm>
#include <iostream>
using namespace std;

const int maxn = 100005;
int a[maxn];
int value[maxn], coun[maxn];
int num[maxn], le[maxn], ri[maxn];
int d[maxn][400];
int maxnum;//最大编号

void RMQ_init() {
	for(int i = 0; i < maxnum+1; i++) d[i][0] = coun[i];
	for(int j = 1; (1 << j) <= maxnum+1; j++)
		for(int i = 0; i + (1<<j) - 1 < maxnum+1; i++)
			d[i][j] = max(d[i][j-1], d[i + (1 << (j-1))][j-1]);
}

int RMQ(int l, int r) {
	int k = 0;
	while((1<<(k+1)) <= r - l + 1) k++;
	return max(d[l][k], d[r-(1<<k) +1][k]);
}

int main() {
	int n, q;
	while(scanf("%d", &n) && n!=0) {
		scanf("%d", &q);
		for(int i = 0; i < n; i++) 
			scanf("%d", &a[i]);
		
		maxnum = 0;
		int cnt = 1;//当前出现次数 
		value[0] = a[0], coun[0] = cnt, num[0] = 0, le[0] = 0, ri[0] = 0;
		for(int i = 1; i < n; i++) {
			if(a[i] != a[i-1]) {
				ri[maxnum] = i - 1;
				cnt = 1; maxnum++;
				le[maxnum] = i; ri[maxnum] = i;
				num[i] = maxnum;
				value[maxnum] = a[i];
				coun[maxnum] = cnt;
			} 
			else {
				cnt++;
				coun[maxnum] = cnt;
				num[i] = maxnum;
				ri[maxnum] = i;
			}
		} 

		RMQ_init();
			
		for(int i = 0; i < q; i++) {
			int l, r;
			scanf("%d %d", &l, &r);
			l--; r--;
			//printf("%d %d %d\n", ri[num[l]]-l+1, r-le[num[r]]+1, RMQ(num[l]+1, num[r]-1));
			if(num[l] == num[r]) printf("%d\n", r - l + 1);
			else if(num[r] - num[l] == 1) printf("%d\n", max(ri[num[l]]-l+1, r-le[num[r]]+1));
			else printf("%d\n", max(max(ri[num[l]]-l+1, r-le[num[r]]+1), RMQ(num[l]+1, num[r]-1)));
		}
	}
	return 0;
} 
