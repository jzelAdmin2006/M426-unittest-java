import pytest

from calculator import calculator


def test_add_three_to_two_is_five():
    # Arrange
    a = 2
    b = 3
    expected = 5

    # Act
    actual = calculator.add(a, b)

    # Assert
    assert actual == expected


def test_subtract_four_from_six_is_two():
    # Given
    a = 6
    b = 4
    expected = 2

    # When
    actual = calculator.subtract(a, b)

    # Then
    assert actual == expected


def test_factorial_of_zero_is_one():
    #  Arrange
    x = 0
    expected = 1

    # Act
    actual = calculator.factorial(x)

    # Assert
    assert actual == expected


def test_factorial_of_one_is_one():
    # Arrange
    x = 1
    expected = 1

    # Act
    actual = calculator.factorial(x)

    # Assert
    assert actual == expected


def test_factorial_of_two_is_two():
    # Arrange
    x = 2
    expected = 2

    # Act
    actual = calculator.factorial(x)

    # Assert
    assert actual == expected


def test_factorial_of_five_is_120():
    # Arrange
    x = 5
    expected = 120

    # Act
    actual = calculator.factorial(x)

    # Assert
    assert actual == expected


def test_factorial_of_negative_is_undefined():
    # Arrange
    x = -1

    # Act/Assert
    with pytest.raises(ValueError) as e:
        calculator.factorial(x)
        assert 'undefined' in str(e)
