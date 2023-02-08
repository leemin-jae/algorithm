#include <iostream>

using namespace std;

int v[10001];

int main(){
	int a;
	cin >> a;
	int b[a+1];
	for(int i = 1 ; i <= a ; i ++){
		cin >> b[i];
		if(i == 1){
			v[1] = b[1];
		}
		if(i == 2){
			v[2] = b[1] + b[2];
		}
	}
	for(int i = 3; i <= a; i++){
		v[i] = max(max(v[i-1],b[i] + v[i-2]),b[i] + b[i-1] + v[i-3]);
	}
	cout << v[a];

}
