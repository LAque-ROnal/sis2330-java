module Notas
    ( Estudiante
    , promedio
    , masAlto
    , ordenarPorNota
    , aprobados
    , parsearLinea
    ) where

import Data.List (sortBy)
import Data.Ord (comparing)

-- (nombre, nota)
type Estudiante = (String, Double)

promedio :: [Estudiante] -> Double
promedio [] = 0
promedio xs = sum (map snd xs) / fromIntegral (length xs)

masAlto :: [Estudiante] -> Maybe Estudiante
masAlto [] = Nothing
masAlto xs = Just (foldr1 (\a b -> if snd a >= snd b then a else b) xs)

ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota = sortBy (comparing (negate . snd))

aprobados :: [Estudiante] -> [Estudiante]
aprobados xs = [e | e <- xs, snd e >= 51]

-- "nombre,nota" -> Estudiante, o un mensaje de error
parsearLinea :: String -> Either String Estudiante
parsearLinea linea =
    case break (== ',') linea of
        (nombre, ',' : notaTexto)
            | null nombre -> Left ("nombre vacio: " ++ linea)
            | otherwise ->
                case reads notaTexto :: [(Double, String)] of
                    [(nota, "")] -> Right (nombre, nota)
                    _ -> Left ("nota invalida: " ++ linea)
        _ -> Left ("linea sin formato nombre,nota: " ++ linea)