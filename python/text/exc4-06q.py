"""아래 내용을 수행하는 파이썬 코드를 작성한다.

아래 리스트를 이용한다. 

movies = ["The Holy Grail", 1975, "Terry Jones & Terry Gilliam", 91,
          ["Graham Chapman", ["Michael Palin", "John cleese",
                              "Terry Gilliam", "Eric Idle", "Terry Jones"]]]

위 리스트를 아래와 같이 출력한다. 
즉, 중첩 리스트의 경우 중첩 정도에 따라 하나의 탭 정도 들여쓰기를 해야 한다.

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
앞 문제에 사용된 print_lol 재귀함수의 인자를 두 개로 한다.
하나는 리스트의 인자를 다루며, 다른 하나는 들어쓰기 정도를 다루는 
인자를 하나 받아서 앞 문제 코드의 for문을 재귀적으로 처리한다. 
즉, 아래와 같은 모양을 갖는다.
 
def print_lol(the_list, level):
  본체

위에서 level은 탭을 사용하는 횟수를 나타내도록 한다. 

그러면 print_lol(movies, 0) 을 실행하면 원하는 결과가 나올 수 있다.
"""

movies = ["The Holy Grail", 1975, "Terry Jones & Terry Gilliam", 91,
          ["Graham Chapman", ["Michael Palin", "John cleese",
                              "Terry Gilliam", "Eric Idle", "Terry Jones"]]]

def print_lol(the_list, level):
    for i in the_list:
        if isinstance(i,list):
            print_lol(i,level+1)
        else:
            print('\t'*level,i,sep='')

print_lol(movies, 0)
    
