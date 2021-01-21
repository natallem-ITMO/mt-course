#include <stdio.h>
#include <stdbool.h>

int fib2;
int fib1;
int n;
int fib;

int main()
{
	fib1 = 1;
	fib2 = 1;
	scanf("%d", &n);
	printf("%d\n",fib1);
	printf("%d\n",fib2);
	if (n>2) {
		for (int i=2; i<n; i++) {
			fib = fib1;
			fib1 = fib2;
			fib2 = fib+fib2;
			printf("%d\n",fib2);
		}
	}
	return 0;
}

