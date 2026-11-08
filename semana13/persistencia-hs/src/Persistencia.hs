module Persistencia
    ( guardarEstudiantes
    , cargarEstudiantes
    , parsearLinea
    ) where

import System.Directory (doesFileExist)
import Modelo (Estudiante)

-- Convierte un Estudiante a una linea de texto "nombre,nota"
formatearLinea :: Estudiante -> String
formatearLinea (nombre, nota) = nombre ++ "," ++ show nota

-- Parsea una linea "nombre,nota" a Estudiante, o reporta el error (PURA)
parsearLinea :: String -> Either String Estudiante
parsearLinea linea =
    case break (== ',') linea of
        (nombre, ',' : notaTexto)
            | null nombre -> Left ("linea invalida (nombre vacio): " ++ linea)
            | otherwise ->
                case reads notaTexto :: [(Double, String)] of
                    [(nota, "")] -> Right (nombre, nota)
                    _ -> Left ("nota invalida en linea: " ++ linea)
        _ -> Left ("linea sin formato nombre,nota: " ++ linea)

guardarEstudiantes :: FilePath -> [Estudiante] -> IO ()
guardarEstudiantes ruta estudiantes =
    writeFile ruta (unlines (map formatearLinea estudiantes))

cargarEstudiantes :: FilePath -> IO [Either String Estudiante]
cargarEstudiantes ruta = do
    existe <- doesFileExist ruta
    if not existe
        then return []
        else do
            contenido <- readFile ruta
            let lineasNoVacias = filter (not . null) (lines contenido)
            return (map parsearLinea lineasNoVacias)