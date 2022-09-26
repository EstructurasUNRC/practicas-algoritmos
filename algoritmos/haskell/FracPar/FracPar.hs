{-|
Module      : FracPar
Description : Provee una implementacion del TAD Fractional usando pares de enteros
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
Ejemplo de implementacion de ADT Fractional
usamos el estilo haddock de comentarios
-}

module FracPair where
import Data.Ratio

-- | definimos un tipo nuevo para representar los racionales
data FracPar = Integer :/ Integer deriving Show -- | escribir un mejor Show!

instance Num FracPar where  -- | Implementamos la clase Num, ya que los Frac son Num 
    (p :/ q) + (n :/ m) = ((p*m)+(n*q)) :/ (q*m) 
    (p :/ q) * (n :/ m) = (p*n) :/ (q*m) 
    negate (p :/ q) = (- p) :/ q
    (p :/ q) - (n :/ m) = (p :/ q) + (negate (n :/ m))
    abs (p :/ q) = (abs p) :/ (abs q)
    fromInteger p = (p :/ 1) 
    signum (p :/ q) = ((signum p) * (signum q)) :/ 1

instance Fractional FracPar where -- | implementamos la division
    (p :/ q) / (n :/ m) = (p*m) :/ (q*n)  
    fromRational r =  (numerator r) :/ (denominator r)
   

