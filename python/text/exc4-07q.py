"""아래 내용을 수행하는 파이썬 코드를 작성한다. 단 재귀함수를 이용한다.

아래 리스트를 이용한다. 

movies = ["The Holy Grail", 1975, "Terry Jones & Terry Gilliam", 91,
          ["Graham Chapman", ["Michael Palin", "John cleese",
                              "Terry Gilliam", "Eric Idle", "Terry Jones"]]]

위 리스트를 아래와 같이 출력한다. 
1) 만약 중첩 정도에 따라 하나의 탭 정도 들여쓰기를 해야 하고 싶으면 들여쓰기를 활용한다.

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

2) 들여쓰기를 사용하고 싶지 않다면 아래 처럼 출력한다.

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
앞 문제에 사용된 print_lol 재귀함수의 인자를 하나 더 추가한다.
추가된 인자는 들여쓰기 여부를 결정하도록 하며, 기본은 들여쓰지 않는 것으로 한다. 
즉, 아래와 같은 모양을 갖는다.
 
def print_lol(the_list, level, indent = False):
  본체

위에서 level은 탭을 사용하는 횟수를 나타내도록 한다. 

그러면 print_lol(movies, 0, True) 를 실행하면 들여쓰기가 되어 출력되고, 
print_lol(movies, 0)을 실행하면 들여쓰기가 없이 출력된다. 
"""

movies = ["The Holy Grail", 1975, "Terry Jones & Terry Gilliam", 91,
          ["Graham Chapman", ["Michael Palin", "John cleese",
                              "Terry Gilliam", "Eric Idle", "Terry Jones"]]]

def print_lol(the_list, level, indent = False):
    for i in the_list:
        if isinstance(i,list):
            print_lol(i,level+1,indent)
        else:
            if indent:
                print('\t'*level,end='')
            print(i)

print_lol(movies, 0, True)
print_lol(movies, 0)
    
