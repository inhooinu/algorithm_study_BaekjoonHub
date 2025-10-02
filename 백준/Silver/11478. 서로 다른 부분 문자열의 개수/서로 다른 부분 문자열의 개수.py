S = input()
sub_str = []
for i in range(len(S)):
    # [0:1], [0:2], [0:3], ..., [0, 5]
    # [1:2], [1:3], [1:4], ..., [1, 5]
    # [4:5]
    for j in range(i+1, len(S)+1):
        sub_str.append(S[i:j])

sub_str = list(set(sub_str))
print(len(sub_str))