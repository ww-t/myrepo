from re import sub

s='Somewhere on the rainbow.'

print(s)
print(s.replace('on','over'))
print(s.replace('.',''))
print(sub('on','over',s))



a='a\nb\nc\nd\n'

print(a)
print(a.count('\n'))



s='/usr/local/bin/python'

s=s.split('/')

for i in s:
    if i:
        print(i)



s='spam ham'

a=s[5:]+s[4]+s[:4]

print(a)



s='spam Spam SpaM egg eGG Egg ham hAm'
s=s.lower()

a=s.count('spam')

print(a)



s='spam'
a=''
i=len(s)-1

while i>=0:
    a=a+s[i]
    i=i-1

print(a)



s="""noriko:x:524:500:유화정:/home/noriko:/bin/bash
sky1004mu:x:525:500:김청:/home/sky1004mu:/bin/bash
muu20:x:527:500:이현복:/home/muu20:/bin/bash"""

s=s.splitlines()

for i in s:
    i=i.split(':')
    print(i[4])



a=('a','b','c')

a='|'.join(a)

print(a)



import urllib.request

page=urllib.request.urlopen("http://www.beans-r-us.appspot.com/prices.html")
text=page.read().decode("utf8")

text=text.split('>')

for i in text:
    i=i.split('<')
    if i[0] and i[0]!='\n':
        print(i[0])
