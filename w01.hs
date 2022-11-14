last' xs =xs !! (length xs -1)
last'' xs = head(reverse xs)
last''' xs= head $ reverse xs
b =head.reverse
lastButOne   =  head.reverse.init
kth n xs =xs !!(n-1)
len' xs = 1 + len'(tail xs)
len' [] = 0
len'' xs = if xs ==[]
		then 0
		else 1 + len'' (tail xs)
inBetween xs = if length xs < 2 
			then []
			else tail (init xs)
drop'' n xs =if n==0
			then xs
			else drop'' (n-1) (tail xs)