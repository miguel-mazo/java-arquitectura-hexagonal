select  id, nombre_persona, fecha_reserva, valor_alquiler, estado
from reserva
where estado = 'ACTIVA'