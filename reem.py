from turtle import position


player1="X"
player2="O"
bord={1:"",2:"",3:"",
4:"",5:"",6:"",
7:"",8:"",9:""}


def win():
    if bord[1]==bord[2] and bord[1]==bord[3] and bord[1] !="":
        return True
    elif bord[4]==bord[5] and bord[4]==bord[6] and bord[4] !="":
        return True
    elif bord[7]==bord[8] and bord[7]==bord[9] and bord[7] !="":
        return True    
    elif bord[1]==bord[4] and bord[1]==bord[7] and bord[1] !="":
        return True    
    elif bord[2]==bord[5] and bord[2]==bord[8] and bord[2] !="":
        return True    
    elif bord[3]==bord[6] and bord[3]==bord[9] and bord[3] !="":
        return True    
    elif bord[1]==bord[5] and bord[1]==bord[9] and bord[1] !="":
        return True    
    elif bord[3]==bord[5] and bord[3]==bord[7] and bord[3] !="":
        return True    
    else:
        return False


def free(posi):
    while True:
        if(bord[posi]==""):
            return posi
        else:
            print("Can't Add your char in this position!")
            print("Try Again!")
            x=int(input("Enter Your Position:"))
            posi=x                

def in_player1():
    print("Turn Of Player1:")
    position=int(input("Enter Your Position:"))
    position=free(position) 
    bord[position]=player1     


def in_player2():
    print("Turn Of Player2:")
    position=int(input("Enter Your Position:"))
    position=free(position)       
    bord[position]=player2

def note():
    print("--------")
    print("|1|2|3|")
    print("--------")
    print("|4|5|6|")
    print("--------")
    print("|7|8|9|")
    print("--------")


def draw():
    print("--------")
    print("|",bord[1],"|",bord[2],"|",bord[3],"|")
    print("--------")
    print("|",bord[4],"|",bord[5],"|",bord[6],"|")
    print("--------")
    print("|",bord[7],"|",bord[8],"|",bord[9],"|")
    print("--------")




def her(letter):
    cou=0
    copy={1:"",2:"",3:"",
    4:"",5:"",6:"",
    7:"",8:"",9:""}
    for key in bord:
        copy[key]=bord[key]
    for key in bord:
        if copy[key]=="":
            copy[key]=letter
    if copy[1]==copy[2] and copy[1]==copy[3] and copy[1] !="":
        cou=cou+1
    if copy[4]==copy[5] and copy[4]==copy[6] and copy[4] !="":
        cou=cou+1
    if copy[7]==copy[8] and copy[7]==copy[9] and copy[7] !="":
        cou=cou+1    
    if copy[1]==copy[4] and copy[1]==copy[7] and copy[1] !="":
        cou=cou+1   
    if copy[2]==copy[5] and copy[2]==copy[8] and copy[2] !="":
        cou=cou+1    
    if copy[3]==copy[6] and copy[3]==copy[9] and copy[3] !="":
        cou=cou+1    
    if copy[1]==copy[5] and copy[1]==copy[9] and copy[1] !="":
        cou=cou+1    
    if copy[3]==copy[5] and copy[3]==copy[7] and copy[3] !="":
        cou=cou+1
    return cou                



state=int(input("Enter State To Cala H():"))
c=0
note()
draw()
while True:
    in_player1()
    draw()
    if(win()):
        print("Player 1 Win!")
        break
    in_player2()
    draw()      
    if(win()):
        print("Player 2 Win!")
        break       
    c=c+1
    if state==c:
        m=her(player1)
        n=her(player2)
        y=m-n
        print("H(n)=",m,"-",n,"=",y)

if c<state:
    m=her(player1)
    n=her(player2)
    y=m-n
    print("H(n)=",m,"-",n,"=",y)
    