# Q1. b의 절대값에다가 a를 더하는 함수가 되도록 아래 빈칸을 채워라. 
#     단 abs 함수를 사용하지 않는다.

from operator import add, sub
def a_plus_abs_b(a, b):
    """Return a+abs(b), but without calling abs.

    >>> a_plus_abs_b(2, 3)
    5
    >>> a_plus_abs_b(2, -3)
    5
    """
    if b < 0:
        op = sub(a,b)
    else:
        op = add(a,b)
    return op

# Q2. 양의 정수 3개를 입력 받아, 그 중에서 가장 큰 두 개의 숫자의 
#     제곱의 합을 되돌려주는 함수를 작성하라.

def two_of_three(a, b, c):
    """Return x*x + y*y, where x and y are the two largest of a, b, c.

    >>> two_of_three(1, 2, 3)
    13
    >>> two_of_three(5, 3, 1)
    34
    >>> two_of_three(10, 2, 8)
    164
    >>> two_of_three(5, 5, 5)
    50
    """
    "*** YOUR CODE HERE ***"

    if a>=b:
        x=a
        if b>=c:
            y=b
        else:
            y=c
    else:
        x=b
        if a>=c:
            y=a
        else:
            y=c

    return x*x+y*y

# Q3. 아래 정의된 if_function은 if문과 동일한 역할을 수행하도록 만든 함수이다.
#     하지만 if_function이 if문과 완전히 동일한 역할을 수행하지는 않는다는 수행하지 않는다.
#     그 이유를 밝혀내기 위해 with_if_statement 함수와 with_if_function 함수를 
#     이용한다.
#     with_if_statement()의 실행값과 with_if_function()의 실행값이 다르게 나오도록 
#     c(), t(), f() 세 개의 함수를 정의하라.
#
#     힌트: (1) 예를 들어 with_if_statement()의 실행값은 1인 반면에 with_if_function()의
#     실행값은 에러가 뜨게 c(), t(), f() 세 함수를 정의할 수 있다. 
#     (2) 함수를 호출할 때와 if문에서 표현식(expression)들의 값이 계산되는 과정이 다름에
#     주의할 것.

def if_function(condition, true_result, false_result):
    """Return true_result if condition is a true value, and false_result otherwise."""
    if condition:
        return true_result
    else:
        return false_result


def with_if_statement():
    if c():
        return t()
    else:
        return f()

def with_if_function():
    return if_function(c(), t(), f())

def c():
    "*** YOUR CODE HERE ***"
    return 1

def t():
    "*** YOUR CODE HERE ***"
    return 1

def f():
    "*** YOUR CODE HERE ***"
    return 'a'/2
