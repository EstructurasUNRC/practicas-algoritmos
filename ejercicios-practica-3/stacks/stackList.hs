{-|
Module      : StackList
Description : Provides an implementation using lists for the Stack ADT
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
This an exampl of a class for ADT, only for educational purposes
We use haddock style of comments
-}

module StackList where
import StackADT

instance Stack [] where
    empty = []
    pop [] = error "pop: empty stack"
    pop (x:xs) = xs
    push xs x = (x:xs)
    isEmpty xs = (length xs == 0)
    top [] = error "top: empty stack"
    top (x:xs) = x
