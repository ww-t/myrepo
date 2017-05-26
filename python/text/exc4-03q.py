"""아래 내용을 수행하는 파이썬 코드를 작성한다. 

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
['Michael Palin', 'John cleese', 'Terry Gilliam', 'Eric Idle', 'Terry Jones']

(힌트)
isinstance 활용
"""

movies = ["The Holy Grail", 1975, "Terry Jones & Terry Gilliam", 91,
          ["Graham Chapman", ["Michael Palin", "John cleese",
                              "Terry Gilliam", "Eric Idle", "Terry Jones"]]]

for each_item in movies:
    if isinstance(each_item, list):
        for i in each_item:
            print(i)
    else:
        print(each_item)
    
