module Main (main) where

import Estadisticas (Estudiante, promedio, masAlto, ordenarPorNota, aprobados)
import Control.Monad (replicateM)

leerEstudiante :: IO Estudiante
leerEstudiante = do
    putStrLn "Nombre:"
    nombre <- getLine
    putStrLn "Nota:"
    notaTexto <- getLine
    let nota = read notaTexto :: Double
    return (nombre, nota)

main :: IO ()
main = do
    putStrLn "Cuantos estudiantes vas a ingresar?"
    cantidadTexto <- getLine
    let cantidad = read cantidadTexto :: Int
    estudiantes <- replicateM cantidad leerEstudiante
    if null estudiantes
        then putStrLn "No se ingresaron estudiantes."
        else do
            putStrLn ("Promedio del grupo: " ++ show (promedio estudiantes))
            putStrLn ("Mas alto: " ++ show (masAlto estudiantes))
            putStrLn ("Ordenados por nota: " ++ show (ordenarPorNota estudiantes))
            putStrLn ("Aprobados: " ++ show (aprobados estudiantes))