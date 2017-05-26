"""년도 데이터를 리스트에 추가해야 하는 경우에 어떤 전략을 사용해야 할지
   생각해 보자.
   아래는 리스트를 만드는 코드이다.

   movies = ["The Holy Grail", "The Life of Brian", "The Meaning of Life"]

   위 리스트에 숫자로된 년도를 추가하기 위해 필요한 파이썬 코드를 작성하라.
   년도를 입력한 후에 리스트는 아래와 같이 바뀌어야 한다.

   movies = ["The Holy Grail", 1975, "The Life of Brian", 1979, "The Meaning of Life", 1983]

   힌트: insert 메쏘드 활용 가능."""

movies = ["The Holy Grail", "The Life of Brian", "The Meaning of Life"]
i=0

while i<len(movies):
    year=input(movies[i]+"'s year : ")
    movies.insert(i+1,int(year))
    i=i+2

print(movies)
