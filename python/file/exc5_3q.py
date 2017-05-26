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

문제 4) 
exc5_1q.py 파일에서 작성된 코드가 아래 새로운 조건을 만족시키도록 수정하라.

5'. man과 other 리스트를 각기 man_data.txt와 other_data.txt 파일에 저장하라.
    저장할 때 내용을 아래와 같이 저장이 되도록 한다.
    (man_data.txt 경우:

    Is this the right room for an argument?
    No you haven't!
    When?
    No you didn't!
    You didn't!
    You did not!
    Ah! (taking out his wallet and paying) Just the five minutes.
    You most certainly did not!
    Oh no you didn't!
    Oh no you didn't!
    Oh look, this isn't an argument!
    No it isn't!
    It's just contradiction!
    It IS!
    You just contradicted me!
    You DID!
    You did just then!
    (exasperated) Oh, this is futile!!
    Yes it is!

6. 저장된 내용이 위와 같이 출력됨을 확인한다. 

힌트: 지난 주 과제에서 사용한 print_lol 함수를 약간 변형하여 이용한다.
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

import sys

def print_lol(the_list, level = 0, indent = False, fh = sys.stdout):
    for each_item in the_list:
        if isinstance(each_item, list):
            print_lol(each_item, level+1, indent, fh)
        else:
            if indent:
                for tab_stop in range(level):
                    print("\t", end='', file=fh)
            print(each_item,file=fh)

try:
    man_file = open('man_data.txt', 'w')
    other_file = open('other_data.txt', 'w')

    print_lol(man,1,True,man_file)
    print_lol(other,1,True,other_file)

    man_file.close()
    other_file.close()
    
except IOError as ioerr1:
    print('File error: '  + str(ioerr1))

try:
    man_file = open('man_data.txt')

    for each_line in man_file:
        print(each_line,end='')

except IOEroor as ioerr2:
    print('File error: ' + str(ioerr2))
