#include <iostream>

using namespace std;

int num[200000];
long long v[200000];
int sum_k(int a){
	int sum =0;
	while(a != 0){
		sum += a;
		a--;
	}
	return sum;
}
int main(){
	int a;
	cin >> a;

	int k = sum_k(a);
	for(int i = 1 ; i <= k; i++){
		cin >> num[i];
	}

	for(int i = k; i > k-a; i--){
		v[i] = num[i];
	}
	int start = k-a;
	int check = a-1;
	for(int i = start; i >=1; i--){
		if(i == start - check) {
			start -= check;
			check--;
		}
		v[i] =  max(num[i] + v[i+check],num[i] + v[i+check+1]);
		//cout << "check : " << check << "\n 앞 : " << v[i+check] << " 뒤 : " <<v[i+check+1] << " max : " <<max(v[i+check], v[i+check+1]) << " num : " << num[i] << endl;
		//cout <<"결과 : " <<  v[i] << "\n";
	}
	cout << v[1];
}
