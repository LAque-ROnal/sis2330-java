module Estadisticas
    ( Estudiante
    , promedio
    , masAlto
    , ordenarPorNota
    , aprobados
    ) where

import Data.List (sortBy)
import Data.Ord (comparing)

type Estudiante = (String, Double)

promedio :: [Estudiante] -> Double
promedio [] = 0
promedio xs = sum (map snd xs) / fromIntegral (length xs)

masAlto :: [Estudiante] -> Estudiante
masAlto [x] = x
masAlto (x : xs)
    | snd x >= snd mejorResto = x
    | otherwise = mejorResto
    where mejorResto = masAlto xs
masAlto [] = error "lista vacia no tiene el mas alto"

ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota = sortBy (comparing (negate . snd))

aprobados :: [Estudiante] -> [Estudiante]
aprobados xs = [e | e <- xs, snd e >= 51]