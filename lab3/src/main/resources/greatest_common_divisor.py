a = int(input())
b = int(input())

t = 10
while a != b:
    if a > b:
        a = a - b
    else:
        b = b - a

print(a)
