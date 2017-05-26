"""
 9개의 코드자석이 아래와 같이 있다.
 (코드자석: 코드의 일부를 의미하며,
 코드자석들을 적절히 조합하여 실행할 수
 있는 코드를 생성할 수 있다.)

+ if role == 'Man':
+ elif role == 'Other Man':
+ line_spoken = line_spoken.strip()
+ print(other)
+ print(man)
+ man = []
+ other = []
+ man.append(line_spoken)
+ other.append(line_spoken)

문제 3) 
exc5_1q.py 파일에서 작성된 코드가 아래의 새로운 조건을 만족시키도록 수정하라.

5'. man과 other 리스트를 각기 man_data.txt와 other_data.txt 파일에 저장하라.
"""

man=[]
other=[]

try:
    data = open('sketch.txt')

    for each_line in data:
        try:
            (role, line_spoken) = each_line.split(':', 1)
            line_spoken=line_spoken.strip()
            if role=='Man':
                man.append(line_spoken)
            elif role=='Other Man':
                other.append(line_spoken)

        except ValueError:
            pass

    data.close()
except IOError as err:
    print('File Error: ' + str(err))

try:
    man_file = open('man_data.txt', 'w')
    other_file = open('other_data.txt', 'w')

    print(man,file=man_file)
    print(other,file=other_file)    

    man_file.close()
    other_file.close()
    
except IOError as err:
    print('File error:'  + str(err))

