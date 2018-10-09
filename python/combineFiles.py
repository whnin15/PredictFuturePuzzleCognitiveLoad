import os
import statistics

writeFile = open('data/allPuzPred.csv', 'w')

count = 0
# getting the cogload values by user
for f in os.listdir('data/nextPuzzlePredicted/'):
	if '.DS_Store' in f:
		continue
	print(f)
	count += 1

	with open('data/nextPuzzlePredicted/' + f, 'r') as readFile:
		user = f.split('.csv')[0]
		for line in readFile:
			if 'puzzle' in line:
				if count == 1:
					writeFile.write('user,' + line)
				else:
					continue
			else:
				writeFile.write(f+','+line + '\n')

writeFile.close()