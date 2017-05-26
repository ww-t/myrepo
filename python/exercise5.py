#8.1

def revers(a):
    for i in range(0,len(a)):
        print(a[len(a)-i-1])

#8.2

def duck():
    prefixes = 'JKLMNOPQ'
    suffix = 'ack'
    for letter in prefixes:
        if letter=='O' or letter=='Q':
            print(letter+'u'+suffix)
        else:
            print(letter+suffix)

#8.3

def fruit():
    fruit='banana'
    print(fruit[:]) #fruit[:]는 문자열 전체를 뜻함

#8.4

def find(word, letter, start):
    index = start
    while index < len(word):
        if word[index] == letter:
            return index
        index = index + 1
    return -1

#8.5

def counter(word,letter):
    count = 0
    for i in word:
        if i == letter:
            count = count + 1
    print(count)

#8.6

def counter1(word,letter):
    count=0
    r=-1
    while 1:
        r=find(word,letter,r+1)
        if r!=-1:
            count=count+1
        else:
            break
    print(count)

#8.7

def count_method():
    word='banana'
    print(word.count('a'))

#8.8

def strip_and_replace():
    word='banana'
    print(word.replace('a','c')) #문자열에서 첫번째 인자로 들어온 것을 두번째 인자로 들어온 것으로 바꿈
    print(word.replace('a','c',1)) #세번째 인자는 바꾸는 수 (왼쪽에서부터 바꿈)
    word='    banana    '
    print(word.strip()) #문자열에서 문자 앞뒤의 스페이스바를 지움
    print(word.strip(' ba')) #인자로 들어온 문자들도 지움

#8.9

def is_reverse(word1, word2):
    if len(word1) != len(word2):
        return False
    i = 0
    j = len(word2)-1
    while j >= 0:
        print(i,j)
        if word1[i] != word2[j]:
            return False
        i = i+1
        j = j-1
    return True

#8.10

def is_palindrome(word):
    print(word==word[::-1])

#8.11

def any_lowercase1(s): #첫번째 문자만 확인하고 참 혹은 거짓을 리턴
    for c in s:
        if c.islower():
            return True
        else:
            return False
        
def any_lowercase2(s): #'c'는 소문자이기 때문에 항상 'True'를 리턴
    for c in s:
        if 'c'.islower():
            return 'True'
        else:
            return 'False'
        
def any_lowercase3(s): #마지막 문자의 판별 결과가 리턴
    for c in s:
        flag = c.islower()
    return flag

def any_lowercase4(s): #소문자가 하나라도 있으면 참을 리턴 없으면 거짓을 리턴
    flag = False
    for c in s:
        flag = flag or c.islower()
    return flag

def any_lowercase5(s): #대문자가 하나라도 있으면 거짓을 리턴 다 소문자면 참을 리턴
    for c in s:
        if not c.islower():
            return False
    return True

#8.12

def rotate_letter(letter, n):
    if letter.isupper():
        start = ord('A')
    elif letter.islower():
        start = ord('a')
    else:
        return letter

    c = ord(letter) - start
    i = (c + n) % 26 + start
    return chr(i)


def rotate_word(word, n):
    res = ''
    for letter in word:
        res += rotate_letter(letter, n)
    return res
