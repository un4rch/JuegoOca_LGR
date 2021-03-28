# JuegoOca_LGR
Para jugar al juego hay que inicializarlo desde el ejecutable exe ya que está configurado para que la consola de comandos inicialice usando UTF-8, ya que sino, no se aprecia el juego correctamente(o bien, inicializar el jar usando en consola el contenido del ejecutable).

Codigo del ejecutable:

@echo off
chcp 65001
cls
java -jar JuegoOca_LGR.jar
pause
exit

