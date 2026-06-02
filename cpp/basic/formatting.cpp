#include<iostream>
#include<iomanip>

using namespace std;

int main() {

  cout << left;
  cout << setw(10) << "Course" << setw(10) << "Students" <<endl
        << setw(10) << "C++" << setw(10) << right << 100 << left << endl
        << setw(10) << "Javascript" << setw(10) << right << 50 << left << endl;

  cout << fixed << setprecision(3) << 12.345678 << endl;
}
