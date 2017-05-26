"""
letter.txt 파일 안에 다음과 같은 연하장 내용이 들어 있다. 

=======
Dear _NAME_,

how are you?
I would like to wish you a happy new year.

Best regards,

Hong.
=======

이 연하장을 James, Julie, Mikey, Sarah에게 각각 동일한 내용으로 보내고자 한다.
예를 들어, Dear _NAME_을 Dear James로 첫 줄만 바꾸어서 James_letter.txt로
저장하여 출력해서 우편으로 보내고자 한다.

이와 같이 이름만 바꿔서 각각의 이름을 딴 파일을 생성하는 코드를 파이썬 코드를 작성하라.

힌트: 
1) print_lol 함수를 replace() 메소를 활용해서 적당하게 수정하여 사용한다.
2) 주어진 리스트로 부터 각각의 인덱스 값을 받아 for문을 이용하여 '인덱스 값.txt'
   파일을 생성하는 방법을 알아내서 활용할 수 한다.

"""

import sys

names = ['James', 'Julie', 'Mikey', 'Sarah']

def print_lol(the_list, s_name='_NAME_', fh = sys.stdout):
    wf=open(name+'_letter.txt','w')
    for each_item in the_list:
        each_item=each_item.replace(s_name,name)
        wf.write(each_item)
    wf.close()

try:
    for name in names:
        rf=open('letter.txt')
        print_lol(rf)
        rf.close()

except IOError:
    print('File error')
