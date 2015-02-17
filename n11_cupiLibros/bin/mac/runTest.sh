#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n11_cupiLibros
# Autor: Catalina M. Rodr�guez U - 02-sep-2011
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/cupiLibros.jar:test/lib/junit.jar:test/lib/cupiLibrosTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiLibros.test.BibliotecaTest
	
java -ea -classpath lib/cupiLibros.jar:test/lib/junit.jar:test/lib/cupiLibrosTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiLibros.test.LibroTest
	
java -ea -classpath lib/cupiLibros.jar:test/lib/junit.jar:test/lib/cupiLibrosTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiLibros.test.CategoriaTest
cd bin/mac

stty echo
