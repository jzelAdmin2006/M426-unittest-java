def mean(numbers):
    number_sum = 0
    mean = 0.0

    for number in numbers:
        number_sum += number

    mean = float(number_sum) / len(numbers)
    return mean
