user_input = input()
char = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for i in char:
    user_input = user_input.replace(i, '*')

print(len(user_input))