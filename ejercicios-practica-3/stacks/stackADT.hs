{-|
Module      : StackADT
Description : Provides the class for the Stack ADT
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
We use haddock style of comments
-}

module StackADT where

-- | A class for stacks:
-- s is a type constructor lists, etc.
class Stack s where 
    -- | empty Stack
    empty :: s a
    -- | pop an element onto the Stack
    pop :: s a -> s a
    -- | push an element into the Stack
    push :: s a -> a -> s a
    -- | it says if the stack is empty
    isEmpty :: s a -> Bool
    -- | returns the top of a stack
    top :: s a -> a