#include <iostream>

using namespace std;

struct Object {
    int i;
};

void sample(Object* o) { // 1
    o->i++;
}

void sample(Object const& o) { // 2
    // nothing useful here :)
	
}

void sample(Object & o) { // 3
    o.i++;
}

void sample1(Object o) { // 4
    o.i++;
}

int main() {
    Object obj = { 10 };
    Object const obj_c = { 10 };

    sample(&obj); // calls 1
	cout<<obj.i;
    sample(obj); // calls 3
	cout<<obj.i;
    sample(obj_c); // calls 2
    sample1(obj); // calls 4
	cout<<obj.i;
}
