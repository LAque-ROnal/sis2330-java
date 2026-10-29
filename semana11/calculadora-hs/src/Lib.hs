module Lib
    ( suma
    , doble
    , promedio
    ) where

-- Suma dos enteros
suma :: Int -> Int -> Int
suma a b = a + b

-- Duplica un entero
doble :: Int -> Int
doble x = x * 2

-- Promedio de una lista de Double (lista vacia devuelve 0)
promedio :: [Double] -> Double
promedio [] = 0
promedio xs = sum xs / fromIntegral (length xs)