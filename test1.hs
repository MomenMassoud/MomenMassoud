drop' n xs = drop' (n-1) (tail xs)
drop' 0 xs = xs