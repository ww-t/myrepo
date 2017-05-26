"""아래 내용을 수행하는 파이썬 코드를 작성한다. 단 재귀함수를 이용한다.

아래 리스트를 이용한다. 

movies = ["The Holy Grail", 1975, "Terry Jones & Terry Gilliam", 91,
          ["Graham Chapman", ["Michael Palin", "John cleese",
                              "Terry Gilliam", "Eric Idle", "Terry Jones"]]]

위 리스트를 아래와 같이 출력한다.

The Holy Grail
1975
Terry Jones & Terry Gilliam
91
Graham Chapman
Michael Palin
John cleese
Terry Gilliam
Eric Idle
Terry Jones

(힌트)
반드시 재귀함수 이용할 것.
for문을 재귀함수로 만들 수 있다.
재귀함수 이름을 print_lol 이라 하면 인자를 하나 받아서 앞 문제 코드의 for문을 재귀적으로 처리한다. 즉, 아래와 같은 모양을 갖는다.
 
def print_lol(the_list):
  본체

그러면 print_lol(movies) 을 실행하면 원하는 결과가 나올 수 있다.
"""

movies = ["The Holy Grail", 1975, "Terry Jones & Terry Gilliam", 91,
          ["Graham Chapman", ["Michael Palin", "John cleese",
                              "Terry Gilliam", "Eric Idle", "Terry Jones"]]]

def print_lol(the_list):
    for i in the_list:
        if isinstance(i,list):
            print_lol(i)
        else:
            print(i)

print_lol(movies)
    
