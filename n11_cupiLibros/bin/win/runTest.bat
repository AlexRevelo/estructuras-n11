@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n11_cupiLibros
REM Autor: Catalina M. Rodr�guez U - 02-sep-2011
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/cupiLibros.jar;test/lib/junit.jar;test/lib/cupiLibrosTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiLibros.test.BibliotecaTest
	
java -ea -classpath lib/cupiLibros.jar;test/lib/junit.jar;test/lib/cupiLibrosTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiLibros.test.LibroTest
	
java -ea -classpath lib/cupiLibros.jar;test/lib/junit.jar;test/lib/cupiLibrosTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiLibros.test.CategoriaTest
cd bin/win