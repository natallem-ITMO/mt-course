
fib1 = 1
fib2 = 1
n = int(input())
print(fib1)

print(fib2)


if n > 2:
    for i in range(2, n):
        fib = fib1
        fib1 = fib2
        fib2 = fib + fib2
        print(fib2)
