def iter_solve(guess, done, update):
    while not done(guess):
        guess = update(guess)
    return guess

def newton_solve(func, deriv, start, tolerance):
    def close_enough(x):
        return abs(func(x)) < tolerance
    def newton_update(x):
        return x - func(x) / deriv(x)
    return iter_solve(start, close_enough, newton_update)

def square_root(a):
    if a < 0:
        raise ValueError("square root of negative value")
    return newton_solve(lambda x: x*x - a, lambda x: 2*x, a/2, a * 1e-10)

def cube_root(a):
    return newton_solve(lambda x: x**3 - a, lambda x: 3*x*x, a/3, a * 1e-10)

print(square_root(10))
print(cube_root(10))
