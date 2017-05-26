def square(x):
    """Return x squared."""
    return x * x

# Q1.

def product(n, term):
    """ 앞서 수업시간에 다뤘던 summation 함수와 비슷한 방식으로 작동하는
    product 함수 작성. 즉, term(1) * ... * term(n)을
    리턴하는 함수.

    term -- 인자를 하나 받는 함수

    >>> product(4, square)
    576
    """
    "*** YOUR CODE HERE ***"
    if n==1:
        return 1
    else:
        r=term(n)*product(n-1,term)
        return r

def factorial(n):
    """product 함수를 이용하여 팩토리얼 함수 작성

    >>> factorial(4)
    24
    """
    "*** YOUR CODE HERE ***"
    def nn(x):
        return x
    return product(n,nn)

# Q2.

# summation과 product 보다 일반적인 함수 accumulate를 작성할 수 있다. 
# 즉, accumulate의 특수한 경우로서 summation과 product를 구할 수 있도록 해야 한다. 
from operator import add,mul

def accumulate(combiner, start, n, term):
    """term(1), ..., term(n)을 연결하는 함수 combiner를 이용한다.
    start는 시작값. 예를 들어 summation의 정의에서 total의 시작값은 0이다.
    앞서 product에서의 start 값은 1이어야 한다. """
    "*** YOUR CODE HERE ***"
    if n==0:
        return start
    else:
        start=combiner(start,term(n))
        return accumulate(combiner,start,n-1,term)


def summation_using_accumulate(n, term):
    """An implementation of summation using accumulate.

    >>> summation_using_accumulate(4, square)
    30
    """
    "*** YOUR CODE HERE ***"
    return accumulate(add,0,n,term)

def product_using_accumulate(n, term):
    """An implementation of product using accumulate.

    >>> product_using_accumulate(4, square)
    576
    """
    "*** YOUR CODE HERE ***"
    return accumulate(mul,1,n,term)

# Q3.

def double(f):
    """함수 f를 두 번 적용하는 함수 리턴.

    f -- a function that takes one argument

    >>> double(square)(2)
    16
    """
    "*** YOUR CODE HERE ***"
    def g(x):
        return f(f(x))
    return g


# Q4.

def repeated(f, n):
    """함수 f를 n번 적용하는 함수 리턴.

    f -- a function that takes one argument
    n -- a positive integer

    >>> repeated(square, 2)(5)
    625
    >>> repeated(square, 4)(5)
    152587890625
    """
    "*** YOUR CODE HERE ***"
    def g(x):
        k=n
        while k:
            x=f(x)
            k=k-1
        return x;
    return g


def compose1(f, g):
    """함수합성:
    Return a function h, such that h(x) = f(g(x))."""
    def h(x):
        return f(g(x))
    return h
