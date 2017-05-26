"""아래 내용을 수행하는 파이썬 코드를 작성한다. 

아래 문장들을 sketch.txt 파일에 저장한다. 

Man: Is this the right room for an argument? 
Other Man: Oh I'm sorry: or the full half hour? 
Man: Ah! Just the five minutes.

sketch.txt 파일에 저장된 문장들을 읽어 들인 후 아래 처럼 출력하도록 한다. 

Man said:  Is this the right room for an argument? 
Other Man said:  Oh I'm sorry: or the full half hour? 
Man said:  Ah! Just the five minutes.

(힌트)
+ 파일을 읽어 들이기 위해 open 함수 이용
+ split 메소드 활용. 단, split 메소드 옵션에 주의한다.
  (두 번째 줄 문장에 ":" 기호가 두 번 들어가 있음에 주의한다.
  옵션을 1로 주어야 한다.)
"""

data=open('sketch.txt','w')

w="""Man: Is this the right room for an argument? 
Other Man: Oh I'm sorry: or the full half hour? 
Man: Ah! Just the five minutes."""

data.write(w)

data.close()

data = open('sketch.txt')

for each_line in data:
    each_line=each_line.split(':',1)
    each_line=each_line[0]+' said:'+each_line[1]
    print(each_line,end='')

data.close()
