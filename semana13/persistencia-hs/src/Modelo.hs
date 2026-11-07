module Modelo
    ( Estudiante
    , promedio
    , aprobados
    ) where

-- (nombre, nota)
type Estudiante = (String, Double)

promedio :: [Estudiante] -> Double
promedio [] = 0
promedio xs = sum (map snd xs) / fromIntegral (length xs)

aprobados :: [Estudiante] -> [Estudiante]
aprobados xs = [e | e <- xs, snd e >= 51]