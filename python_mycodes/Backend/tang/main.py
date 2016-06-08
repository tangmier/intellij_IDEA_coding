"""第一段程序  测试异常"""
from builtins import ZeroDivisionError, input

while True:
    try:
        x = input('Enter the first number:')
        y = input("Enter the second number:")
        value = x / y
        print('x/y is', value)
    except ZeroDivisionError:
        print("Invalid input")
    else:
        break
    finally:
        print("ending")
'''第二段程序  八皇后问题'''
'''def queens(num=8,state=())
    """

    :type state: object
    """
    for pos in range(num):
        if not conflict(state,pos):
            if len(state)==num-1:
                yield(pos,)
            else:
                for result in queens(num,state+(pos,)):
                    yield(pos,)+result
def conflict(state,nextX):
    nextY=len(state)
    for i in range(nextY):
        if abs(state[i]-nextX)in(0,nextY-i):
            return True
    return False'''
'''def conflict(state, nextX):
    nextY = len(state)
    for i in range(nextY):
        if abs(nextX-state[i]) in (0, nextY-i):
            return True
    return False

def queens(side_length, state=()):
    for pos in range(side_length):
        if not conflict(state, pos):
             if side_length-1 == len(state):
                yield (pos,)
             else:
                for result in queens(side_length, state+(pos,)):
                    yield (pos,)+result

def prettyprint(solution):
    def line(pos, length=len(solution)):
        """

        :rtype : object
        """
        return '.'*(pos) + 'X' + '.'*(length-pos-1)
    for pos in solution:
        print(line(pos))


for solution in list(queens(4)):
    prettyprint(solution)'''

