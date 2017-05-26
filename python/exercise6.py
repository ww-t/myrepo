#9.1

def read_words():
    fin=open('words.txt')
    for i in fin:
        word=i.strip()
        if len(word)>20:
            print(word)

#9.2

def has_no_e(word):
    if 'e' in word:
        return False
    return True

def has_no_e_words():
    fin=open('words.txt')
    total=0
    no_e=0
    for i in fin:
        total+=1
        word=i.strip()
        if has_no_e(word):
            print(word)
            no_e+=1
    print(no_e/total*100,'%')

#9.3

def avoids(word,letters):
    for i in letters:
        if i in word:
            return False
    return True

def has_no_letters_words():
    fin=open('words.txt')
    count=0
    letters=input('input letters : ')
    for i in fin:
        word=i.strip()
        if avoids(word,letters):
            print(word)
            count+=1
    print(count)
    
#9.4

def uses_only(word,letters):
    for i in word:
        if i not in letters:
            return False
    return True

#9.5

def uses_all(word,letters):
    for i in letters:
        if i not in word:
            return False
    return True

def uses_all_words():
    fin=open('words.txt')
    count=0
    letters=input('input letters : ')
    for i in fin:
        word=i.strip()
        if uses_all(word,letters):
            print(word)
            count+=1
    print(count)

#9.6

def is_abecedarian(word):
    for i in range(1,len(word)):
        if word[i-1]>word[i]:
            return False
    return True

def is_abecedarian_words():
    fin=open('words.txt')
    count=0
    for i in fin:
        word=i.strip()
        if is_abecedarian(word):
            print(word)
            count+=1
    print(count)

#9.7

def is_triple_double(word):
    i=0
    count=0
    while i<len(word)-1:
        if word[i]==word[i+1]:
            count+=1
            i+=2
            if count==3:
                return True
        else:
            count=0
            i+=1
    return False

def find_triple_double():
    fin=open('words.txt')
    for i in fin:
        word=i.strip()
        if is_triple_double(word):
            print(word)

#9.8

def has_palindrome(i,start,lens):
    s=str(i)[start:start+lens]
    return s==s[::-1]

def check(i):
    return (has_palindrome(i,2,4) and has_palindrome(i+1,1,5) and has_palindrome(i+2,1,4) and has_palindrome(i+3,0,6))

def check_all():
    for i in range(100000,999997):
        if check(i):
            print(i)

#9.9

def str_fill(i, len):
    return str(i).zfill(len)


def are_reversed(i, j):
    return str_fill(i,2) == str_fill(j,2)[::-1]


def num_instances(diff, flag=False):
    daughter = 0
    count = 0
    while True:
        mother = daughter + diff
        if are_reversed(daughter, mother) or are_reversed(daughter, mother+1):
            count = count + 1
            if flag:
                print(daughter,mother)
        if mother > 120:
            break
        daughter = daughter + 1
    return count
    

def check_diffs():
    diff = 10
    while diff < 70:
        n = num_instances(diff)
        if n > 0:
            print(diff,n)
        diff = diff + 1
