board = {1: ' ', 2: ' ', 3: ' ',
         4: ' ', 5: ' ', 6: ' ',
         7: ' ', 8: ' ', 9: ' '}
print("Enter Your Character to play!\n1)X\n2)O")
ch=int(input("Your Choose:"))
if ch==1:
    player='X'
    bot='O'
else:
    player='O'
    bot='X'


def notes():
    print("You Enter posistion follow this board!")
    print('-------------')
    print('|',1,'|',2,'|',3,'|')
    print('-------------')
    print('|',4,'|',5,'|',6,'|')
    print('-------------')
    print('|',7,'|',8,'|',9,'|')
    print("\n")


global firstComputerMove
firstComputerMove = True

def printBoard(board):
    print('-------------')
    print('|',board[1] +'|'+ board[2] +'|'+board[3],'|')
    print('-------------')
    print('|',board[4]+'|'+board[5]+'|'+board[6],'|')
    print('-------------')
    print('|',board[7]+'|'+board[8]+'|'+board[9],'|')
    print("\n")

def spaceIsFree(position):
    if board[position] == ' ':
        return True
    else:
        return False

def checkDraw():
    for key in board.keys():
        if (board[key] == ' '):
            return False
    return True

def checkForWin():
    if (board[1] == board[2] and board[1] == board[3] and board[1] != ' '):
        return True
    elif (board[4] == board[5] and board[4] == board[6] and board[4] != ' '):
        return True
    elif (board[7] == board[8] and board[7] == board[9] and board[7] != ' '):
        return True
    elif (board[1] == board[4] and board[1] == board[7] and board[1] != ' '):
        return True
    elif (board[2] == board[5] and board[2] == board[8] and board[2] != ' '):
        return True
    elif (board[3] == board[6] and board[3] == board[9] and board[3] != ' '):
        return True
    elif (board[1] == board[5] and board[1] == board[9] and board[1] != ' '):
        return True
    elif (board[7] == board[5] and board[7] == board[3] and board[7] != ' '):
        return True
    else:
        return False

def checkWhichMarkWon(mark):
    if board[1] == board[2] and board[1] == board[3] and board[1] == mark:
        return True
    elif (board[4] == board[5] and board[4] == board[6] and board[4] == mark):
        return True
    elif (board[7] == board[8] and board[7] == board[9] and board[7] == mark):
        return True
    elif (board[1] == board[4] and board[1] == board[7] and board[1] == mark):
        return True
    elif (board[2] == board[5] and board[2] == board[8] and board[2] == mark):
        return True
    elif (board[3] == board[6] and board[3] == board[9] and board[3] == mark):
        return True
    elif (board[1] == board[5] and board[1] == board[9] and board[1] == mark):
        return True
    elif (board[7] == board[5] and board[7] == board[3] and board[7] == mark):
        return True
    else:
        return False

def insertLetter(letter, position):
    if spaceIsFree(position):
        board[position] = letter
        printBoard(board)
        if (checkDraw()):
            print("Draw!")
            return
        if checkForWin():
            if letter == bot:
                print("Bot wins!")
                return
            else:
                print("Player wins!")
                return

        
    else:
        print("Can't insert there!")
        position = int(input("Please enter new position:  "))
        insertLetter(letter, position)
        return

def minimax(board, depth, isMaximizing):
    if (checkWhichMarkWon(bot)):
        return 1
    elif (checkWhichMarkWon(player)):
        return -1
    elif (checkDraw()):
        return 0
    if (isMaximizing):
        bestScore = -800
        for key in board.keys():
            if (board[key] == ' '):
                board[key] = bot
                score = minimax(board, depth + 1, False)
                board[key] = ' '
                if (score > bestScore):
                    bestScore = score
        return bestScore
    else:
        bestScore = 800
        for key in board.keys():
            if (board[key] == ' '):
                board[key] = player
                score = minimax(board, depth + 1, True)
                board[key] = ' '
                if (score < bestScore):
                    bestScore = score
        return bestScore        


def playerMove():
    position = int(input("Enter the position:"))
    insertLetter(player, position)
    return

def botMove():
    bestScore = -800
    bestMove = 0
    for key in board.keys():
        if (board[key] == ' '):
            board[key] = bot
            score = minimax(board, 0, False)
            board[key] = ' '
            if (score > bestScore):
                bestScore = score
                bestMove = key

    insertLetter(bot, bestMove)
    return

def cheeck(x):
    while True:
        if x==1 or x==2:
            return x
        else:
            print("Error!\nTry Again!")
            print("Play Again!\n1)Yes\n2)No")    


def start():
    notes()
    while not checkForWin():
        if player=='X':
            playerMove()   
            botMove()
        else:    
            botMove()
            playerMove() 


start()
                                                               