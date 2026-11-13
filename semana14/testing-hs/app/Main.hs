module Main (main) where

import Notas (promedio, ordenarPorNota, aprobados, parsearLinea)
import Historial (registrarConsulta, consultasDe)
import Control.Monad.State (execState)
import qualified Data.Map as Map

-- Datos de entrada en formato "nombre,nota"
lineas :: [String]
lineas = ["Ana,90", "Luis,45", "Marta,70", "lineamala"]

main :: IO ()
main = do
    let resultados = map parsearLinea lineas
        estudiantes = [e | Right e <- resultados]
    mapM_ (\err -> putStrLn ("Aviso: " ++ err)) [err | Left err <- resultados]
    putStrLn ("Promedio: " ++ show (promedio estudiantes))
    putStrLn ("Ordenados: " ++ show (ordenarPorNota estudiantes))
    putStrLn ("Aprobados: " ++ show (aprobados estudiantes))

    -- Sesion de consultas simulada, sin variables mutables
    let consultas = ["Ana", "Marta", "Ana", "Luis", "Ana"]
        historial = execState (mapM_ registrarConsulta consultas) Map.empty
    mapM_ (\(nombre, _) ->
            putStrLn ("Consultas de " ++ nombre ++ ": "
                ++ show (consultasDe nombre historial)))
        estudiantes