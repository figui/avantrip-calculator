# avantrip-calculator

Realizar el diseño de objetos necesarios para representar una operación matemática contemplando las operaciones básicas (suma, resta, multiplicación y división). La estructura debe permitir componer expresiones con cantidades arbitrariamente grandes de parámetros y anidamientos. <br /><br />
Las expresiones se deberán poder construir a través de código Java, no es necesarios crear un parser de expresiones, pero si lo desea puede hacerlo.  <br /> <br />
Se requiere que una expresión pueda calcular su valor o devolver una excepción  adecuada en caso contrario. La expresión deberá ser capaz de mostrarse a sí misma en forma de texto. 

#Diagrama de Clases

![alt tag](https://raw.githubusercontent.com/figui/avantrip-calculator/master/class-diagram.png)

#Uso

Para poder crear una operacion matematica hay que instanciar una clase "OperacionMatematica", luego hay que llamar al metodo comenzar, pasandole un numero con el cual comience la operacion y seguido se le pueden concatenar las operaciones de mas(), menos(), por() y dividido() pasandole como argumentos o un numero u otra OperacionMatematica, por ejemeplo <br /><br />

OperacionMatematica o = new OperacionMatematica(); <br />
o.comenzar(5).por(3).mas(2).dividido(8) <br /> <br />

o mismo <br />

OperacionMatematica o = new OperacionMatematica(); <br /> 
OperacionMatematica o2 = new OperacionMatematica()M <br /><br />

o2.comenzar(2).dividido(8); <br />
o.comenzar(5).por(3).mas(o2) <br /> <br />

Luego para obtener el resultado de la operacion hay que llamar al metodo igual() de la operacion: <br /><br />

System.out.println(o.igual());

