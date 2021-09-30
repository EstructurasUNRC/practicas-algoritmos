{-|
Module      : BooleanoParImpar
Description : Provee una instancia de la clase Booleano usando valores pares e impares.
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
-}

module BooleanoParImpar where
import TADBooleano

instance  Booleano Integer where 
    verdadero  = 1
    falso = 0
    negacion p = mod (p + 1) 2
    conjuncion p q = p * q 
    disyuncion p q = negacion (conjuncion (negacion p) (negacion q))
    {- Definicion alternativa:
        disyuncion p q | (par p) && (par q) = 0
                | not (par p) = 1
                | otherwise = 1
            where par x = (mod x 2 == 0)
    -}
    implicacion p q = disyuncion (negacion p) q
    toString p | (mod p 2 == 0) =  "Falso"
               | otherwise =  "Verdadero"