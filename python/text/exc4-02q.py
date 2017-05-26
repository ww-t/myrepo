"""아래 내용을 수행하는 파이썬 코드를 작성한다. 

   아래 리스트를 이용한다. 

   movies = ["The Holy Grail", "The Life of Brian", "The Meaning of Life"]

   위 리스트에 먼저 아래와 같이 숫자로된 년도를 추가한다. 
   년도를 입력한 후에 리스트는 아래와 같이 바뀌어야 한다.

   movies = ["The Holy Grail", 1975, "The Life of Brian", 1979, "The Meaning of Life", 1983]

   그 다음에 변경된 리스트를 아래와 같이 출력하도록 한다.

   The Holy Grail, 1975
   The Life of Brian, 1979
   The Meaning of Life, 1983
  
"""

movies = ["The Holy Grail", "The Life of Brian", "The Meaning of Life"]
i=0

while i<len(movies):
    year=input(movies[i]+"'s year : ")
    movies.insert(i+1,int(year))
    i=i+2

count = 0
while count < len(movies):
    print(movies[count]+',',movies[count+1])
    count=count+2
