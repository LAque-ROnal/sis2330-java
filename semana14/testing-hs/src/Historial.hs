module Historial
    ( Conteo
    , registrarConsulta
    , consultasDe
    ) where

import Control.Monad.State
import qualified Data.Map as Map
import Data.Map (Map)

type Conteo = Map String Int

-- Registra una consulta para "nombre", incrementando su contador
registrarConsulta :: String -> State Conteo ()
registrarConsulta nombre = modify (Map.insertWith (+) nombre 1)

-- Cuantas veces se consulto a "nombre" segun el estado actual
consultasDe :: String -> Conteo -> Int
consultasDe nombre conteo = Map.findWithDefault 0 nombre conteo