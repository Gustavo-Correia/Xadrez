@echo off
setlocal enabledelayedexpansion

:: Diretório raiz do seu projeto
set projectDir=C:\Users\gucor\Desktop\xadrez\application

:: Diretório de origem dos arquivos .java
set sourceDir=%projectDir%\src

:: Diretório de destino das classes compiladas
set outputDir=%projectDir%\bin

:: Exclui todos os arquivos .class no diretório de destino
for %%f in ("%outputDir%\*.class") do (
    del "%%f"
)

:: Lista todos os arquivos .java na pasta de origem e compila cada um
for %%f in ("%sourceDir%\*.java") do (
    javac -d %outputDir% "%%f"
)

:: Fim do script
echo Compilação concluída.

pause