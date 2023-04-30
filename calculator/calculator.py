def add(summand_a, summand_b):
    return summand_a + summand_b


def subtract(minuend, subtrahend):
    return minuend - subtrahend


def factorial(x):
    if x < 0:
        raise ValueError("factorial undefined for negative values.")
    result = 1
    for i in range(1, x+1):
        result *= i
    return result
