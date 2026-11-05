# calculadora-hs

Calculadora hecha en Haskell con Stack. Separa la logica pura (Lib.hs)
de la interaccion con el usuario (Main.hs).

## Como correr

Ubicarse en la carpeta del proyecto, la que contiene package.yaml:

    cd sis2330-java/semana11/calculadora-hs
    stack build
    stack run

Al ejecutar, ingresar dos numeros enteros y el programa muestra su suma.
Para probar las funciones puras de forma interactiva:

    stack ghci

## Modulos

- src/Lib.hs: funciones puras suma, doble y promedio (sin IO).
- app/Main.hs: programa IO que lee dos numeros por consola y usa suma de Lib.

## Que hace el programa

Pide dos numeros por consola, calcula su suma con la funcion pura suma
y muestra el resultado.