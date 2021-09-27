{-|
Module      : TADBooleano
Description : Provee clases para el TAD Booleano
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
-}

module TADBooleano where

-- | Una clase para Booleanos:
class Booleano a where 
    -- | Operacion generadora de Verdadero.
    verdadero ::  a 
    -- | Operacion generadora de Falso.
    falso ::   a 
    -- | Retorna la Negacion de un Booleano
    negacion ::   a ->  a 
    -- | Retorna la Conjuncion de dos Booleanos
    conjuncion ::   a ->  a ->  a
    -- | Retorna la Disyuncion de dos Booleanos
    disyuncion ::   a ->  a ->  a
    -- | Retorna la Implicacion de dos Booleanos
    implicacion ::   a ->  a ->  a
    -- | Retorna la representación abstracta de Booleanos
    toString ::   a  ->  String
    



