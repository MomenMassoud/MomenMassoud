import random
import sys
import time

name=str(input("What's your name?"))
print("Are you ready? %s",name)
print("We are looding secret_word!")
time.sleep(2)

words=["hangman","spiderman","superman","tigger","egypt","football","sniper","batman","windows","apple","lenovo","ninja","intel","facebook"]
def choose_words():
    '''
    this are choosing secret_word from 
    list of words
    '''
    return random.choice(words)



def start():
    turns=10
    failed=0
    guesses=""
    secret_word=choose_words()
    while True:
        for char in x:
            if char in guesses:
                print(char)
            else:
                print("-")
                failed+=1
        if failed == 0:
            print("you won %s",name)
            break
        guess=str("Enter your guess:")
        guesses+=guess
        if guess  in secret_word:
            print("Wrong")
            turns-=1
            print("you have %d turns!",turns)
            if turns ==0:
                print("You lose %s",name)
                break    



def game():
   
    start()
    while True:
        print("Are you will play agine?")
        aswer=str(input("Enter yes or no:"))
        if aswer =="yes":
            start(secret_word)
        else:
            print("Thank you %s",name)
            print("goodbye")
            break
game()