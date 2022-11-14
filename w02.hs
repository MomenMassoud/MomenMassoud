import Data.List(sortBy)
import Data.List(scanl1)
-------------------------------
--Section Week 3
-------------------------------
-- Init data type of Function
elemOf :: Eq a => a -> [a] ->Bool
elemOf x [] = False
elemOf x xs = if x == (head xs)
		then True
		else elemOf x (tail xs)
-------------------------------
last' xs = xs !! (length xs -1)
lastButOne xs = xs !! (length xs -2)
len :: [a] -> Int
len [] = 0
len xs = 1 + len (tail xs)
-------------------------------
--Function duplicate
duplicate :: [a] -> [a]
duplicate [] =[]
duplicate xs = x : x : duplicate ys
	where
		x = head xs
		ys= tail xs
--------------------------------
--Function Replication
rep :: a -> Int -> [a]
rep x 0 = []
rep x n = x : rep x (n-1)
--------------------------------
inBetween []=[]
inBetween xs = tail (take (length xs -1) (xs))
-------------------------------
--Sum Odd Number
addAtOdd :: Num a => [a] -> a
addAtOdd [] = 0
addAtOdd [x]=x
addAtOdd (x:xs) = x + addAtOdd(tail xs)
-------------------------------
split :: [a] -> Int -> ([a],[a])
split xs n = (take n xs , drop n xs )
-------------------------------
slice :: [a] -> Int -> Int -> [a]
slice xs n m = drop n (take m xs)
-------------------------------
isPalindrome [] = True
isPalindrome xs = xs == reverse xs
isPalindrome xs = head xs == last xs && (isPalindrome  (inBetween xs))
-------------------------------
half xs = (length xs) `div` 2
middle xs = drop (half xs) $ reverse $ drop (half xs) xs
middle' xs = xs !! (half xs)
--------------------------------
fact 0 = 1
fact x = x * fact (x-1)
--------------------------------
kth n xs = head ( reverse (take n xs ))
------------------------------
conuter' :: Int -> Int
conuter' 0 = 0
conuter' x = x + conuter' (x-1)
-------------------------------
power :: Float -> Float -> Float
power x 0 =  1
power x y = x * power (x) (y-1)
--------------------------------
area :: Float -> Float
area r = (22/7) * power r 2
--------------------------------
--q1
max' [] xm x = xm
max' xs xm x = if x > head(xs)
            then  max' (tail xs) (x:xm) (head xs) 
            else  max' (tail xs) xm (head xs)          
localMaxima xs = reverse( max' (tail xs) (xm) (head xs))
                where xm = []
---------------------------------------------------------------
--q2
hist :: Eq a => [a] -> [(a, Int)]
hist [] = []
hist [x] = [(x, 1)]
hist (x:xs) = zip [x] [(length $ filter (==x) (x:xs))] ++ hist xs                

---------------------------------------------------------------
--q3
collatz x = if x == 1
            then 0
            else if x `mod` 2 == 0       
                then 1 + collatz(x `div` 2)
                else 1 + collatz xm
            where xm = x * 3 + 1
----------------------------------------------------------------
--q4
hamming [] [] = 0
hamming xs xm = if (head xs) == (head xm)
                then hamming (tail xs) (tail xm)
                else 1 + hamming (tail xs) (tail xm)   
-----------------------------------------------------------------
--q5
mini x y = if x > y
            then y
            else x
set [] [] xr = xr            
set xs xm xr = set (tail xs) (tail xm) (mini (head xs) (head xm) : xr)           
smaller xs xm = reverse( set xs xm xr) 
                where xr = []             
------------------------------------------------------------------
--count in list
countList [] x = 0
countList xs x = if x == head xs 
                then 1 + countList(tail xs) x
                else countList(tail xs) x    
-------------------------------------------------------------------
--AreaCircle
areaCircle r = r * x * r 
            where x = 22 / 7        
-------------------------------------------------------------------
--sizeCircle
sizeCircle r = 2.0 * r * 22.0 / 7.0
-------------------------------------------------------------------
--Section Week 5
rotate :: [a] -> Int ->[a]
rotate xs n = if n >= 0
            then drop n xs ++ take n xs
            else drop m xs ++ take m xs
            where m = length xs + n
---------------------------------------------------------------------
--Or
rotate' :: [a] -> Int ->[a]
rotate' xs n | n >=0 = drop n xs ++ take n xs
            | otherwise = drop m xs ++ take m xs
            where m = length xs + n
---------------------------------------------------------------------
--Remove the kTH
removeAT :: Int -> [a] -> ( a , [a]) 
removeAT n xs = (x , ys)
            where
                x = xs !! n 
                ys = take n xs ++ drop (n+1) xs
--------------------------------------------------------------------
--insertAT
insertAT :: a -> [a] -> Int -> [a]
insertAT x xs n = if n < 0 || n > length xs
        then error "Index Out Of Boundry"
        else (\ (q,g) -> q ++ [x] ++ g) tup
        where
            tup = splitAt n xs
----------------------------------------------------------------------
thrd :: (a,b,c) -> c
thrd (_,_,z) = z
----------------------------------------------------------------------
comparator :: Ord a => [a] -> [a] -> Ordering
comparator xs ys = if length xs == length ys 
                then compare xs ys 
                else compare (length xs) (length ys)
lSort :: Ord a => [[a]] -> [[a]]
lSort xss = sortBy comparator xss
---------------------------------------------------------------------
primesR :: Int -> Int -> [Int]
factor n = [x|x <- [1..n],n `mod` x ==0]
prime n = factor n == [1 , n]
primesR a b = [x | x <- [a..b],prime x]
-----------------------------------------------------------------
palProduct a b =[x*y | x <- [a..b], y <- [a..b] ]
----------------------------------------------------------------
gcd' a 0 = a
gcd' a b = gcd' b (a `mod` b)
------------------------------------------------------------------
coprime a b = if gcd' a b == 1
            then True
            else False
------------------------------------------------------------------
intersperse :: a -> [a] -> [a]
intersperse _ [] = []
intersperse _ [x] = [x]
intersperse x (y:xs) = y:x:intersperse x xs
-----------------------------------------------------------------