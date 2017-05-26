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

문제 1) 
위 코드자석들을 이용하여 아래 코드를 완성하라.
단, 아래 다섯 가지 요구사항을 만족시키는 코드이어야 한다.

1. man이라는 빈 리스트를 만든다.
2. other라는 빈 리스트를 만든다.
3. line_spoken 변수에서 불필요한 공백 문자를 제거한다.
4. role 값에 따라 line_spoken을 올바를 리스트에 추가한다.
5. man과 other 리스트를 각기 화면에 출력한다.

문제 2) 
아래 코드에서 'except IOError as err' 문장은 무엇을 의미하는가?
예를 들어 missing.txt 파일을 열려고 하면 어떤 결과가 나오는짖를 설명하라.
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

print(man)
print(other)
