module Main (main) where

import Lib (suma)

main :: IO ()
main = do
    putStrLn "Ingresa el primer numero:"
    linea1 <- getLine
    putStrLn "Ingresa el segundo numero:"
    linea2 <- getLine
    let n1 = read linea1 :: Int
        n2 = read linea2 :: Int
        resultado = suma n1 n2
    putStrLn ("La suma es: " ++ show resultado)