module Main (main) where

import Modelo (Estudiante, promedio, aprobados)
import Persistencia (guardarEstudiantes, cargarEstudiantes)
import Control.Monad (replicateM, forM_)

archivoDatos :: FilePath
archivoDatos = "estudiantes.csv"

leerEstudiante :: IO Estudiante
leerEstudiante = do
    putStrLn "Nombre:"
    nombre <- getLine
    putStrLn "Nota:"
    notaTexto <- getLine
    return (nombre, read notaTexto :: Double)

main :: IO ()
main = do
    resultados <- cargarEstudiantes archivoDatos
    forM_ resultados $ \r -> case r of
        Left err -> putStrLn ("Aviso: " ++ err)
        Right _ -> return ()
    let existentes = [e | Right e <- resultados]
    putStrLn ("Estudiantes cargados: " ++ show (length existentes))

    putStrLn "Cuantos estudiantes nuevos vas a agregar?"
    cantidadTexto <- getLine
    nuevos <- replicateM (read cantidadTexto :: Int) leerEstudiante

    let todos = existentes ++ nuevos
    guardarEstudiantes archivoDatos todos

    putStrLn ("Total guardados: " ++ show (length todos))
    putStrLn ("Promedio: " ++ show (promedio todos))
    putStrLn ("Aprobados: " ++ show (aprobados todos))