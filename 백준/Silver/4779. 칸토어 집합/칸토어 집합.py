def cantor(s):
	s_length = len(s)

	if s_length == 1:
		return s
	else:
		return cantor(s[:s_length//3]) + ' '*(s_length//3) + cantor(s[:s_length//3])
		
while True:
	try:
		n = int(input())
		n = 3**n
		print(cantor('-'*n))
        
	except:
		break