#include <iostream>
#include <unistd.h>
using namespace std;

int main() {
  fork();
  fork();
  int a = getpid();
  cout << "GeeksforGeeks " << a << endl;

  return 0;
}
