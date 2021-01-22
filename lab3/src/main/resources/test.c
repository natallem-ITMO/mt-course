#include <stdio.h>
#include <stdbool.h>

int dd;
int t;
int x;
int y;

int main()
{
	x = 10;
	y = 30;
	t = 10;
	dd = 2;
	for (int i=1; i<10; i+=dd) {
		printf("%d\n",i);
	}
	return 0;
}

