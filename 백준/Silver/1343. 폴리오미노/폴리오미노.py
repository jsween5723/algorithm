import sys


def main():
    board = sys.stdin.readline().rstrip()
    cnt = 0
    answer = ""
    for i in range(len(board)):
        if board[i] == '.':
            if not cnt % 2 == 0:
                return -1
            answer += 'AAAA' * int(cnt / 4)
            if cnt % 4 == 2:
                answer += 'BB'
            answer += '.'
            cnt = 0
        else:
            cnt += 1
    if not cnt % 2 == 0:
        return -1
    answer += 'AAAA' * int(cnt / 4)
    if cnt % 4 == 2:
        answer += 'BB'
    return answer


if __name__ == '__main__':
    print(main())
