#include <stdio.h>
#include <stdbool.h>

int a;
int b;
int t;

int main()
{
	scanf("%d", &a);
	scanf("%d", &b);
	t = 10;
	while (a!=b) {
		if (a>b) {
			a = a-b;
		} else {
			b = b-a;
		}
	}
	printf("%d\n",a);
	return 0;
}

