#include <iostream>
#include <algorithm>
#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    
    int T;
    
    cin >> T;
    for(int t=0; t<T; t++) {
        
        priority_queue<int> max_heap;
        priority_queue <int, vector<int>, greater<int> > min_heap;
        
        int i=1;
        while(true) {
            int n;
            cin >> n;
            
            if(n == 0) break;
            if(n == -1) {
                cout << max_heap.top() << "\n"; 
                max_heap.pop();
                
                if((i-1)%2 == 0) {
                    max_heap.push(min_heap.top());
                    min_heap.pop();
                }
                
                i--;
            } else {
                max_heap.push(n);
                
                if(max_heap.empty() == false && min_heap.empty() == false && max_heap.top() > min_heap.top()) {
                    int e1 = max_heap.top();
                    int e2 = min_heap.top();
                    
                    max_heap.pop();
                    min_heap.pop();
                    
                    max_heap.push(e2);
                    min_heap.push(e1);
                }
                
                if(i%2 == 0) {
                    min_heap.push(max_heap.top());
                    max_heap.pop();
                }
                
                i++;
            }
        }
        cout << "\n";
    }
	return 0;
}
