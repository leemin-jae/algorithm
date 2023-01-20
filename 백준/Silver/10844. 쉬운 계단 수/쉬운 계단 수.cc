#include <iostream>

using namespace std;
#define mod 1000000000;
long long a[101][11];

int main(){

	for(int i = 1; i < 10 ; i++){
		a[1][i] = 1;
	}

	int k;
	cin >> k;

	for(int i = 2; i <=k; i ++){
		a[i][0] = a[i-1][1];
		for(int j = 1; j < 10; j++){
			a[i][j] = (a[i-1][j-1] + a[i-1][j+1])%mod;
		}
	}

	int sum = 0;
	for(int i =0; i < 10; i++){
		sum = (sum + a[k][i])%mod;
	}

	cout << sum;
}
