#include <iostream>
#include <chrono>
using namespace std;
#include <thread> // Used only for the sleep demo

int main() {
    cout << "Hello World!";
    int a[] = {1,2,3,4,5,6};
    auto start = chrono::steady_clock::now();
    for (int i=0; i< sizeof(a)/sizeof(a[0]); i++ )
        if(a[i]==5){
            cout<<"We found 5!!";
        }
    
    // --- Simulating code execution ---
    std::this_thread::sleep_for(std::chrono::milliseconds(150)); 
    // ---------------------------------        
    auto end = chrono::steady_clock::now();
    auto elapsed = std::chrono::duration_cast<std::chrono::microseconds>(end - start);
    cout << "Total time to run through loop:: ";
    cout << elapsed.count() << endl;
    return 0;
    
}