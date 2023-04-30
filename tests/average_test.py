from calculator import average


def test_mean_of_two_numbers():
    numbers = [1, 4]
    expected = 2.5

    actual = average.mean(numbers)

    assert actual == expected
