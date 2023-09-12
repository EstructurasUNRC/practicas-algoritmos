{-|
Module      : StackList
Description : Provides an implementation using lists for the Stack ADT
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
We use haddock style of comments
-}

module StackList  where
import StackADT

instance Stack [] where
    empty xs = []
    push xs x = (x:xs)

-- TODO complete Stack instance