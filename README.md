# Punto de venta MyStore

## Descripcion
MyStore es un sistema de punto de venta diseñado para gestionar de manera eficiente las operaciones en una tienda. Este sistema permite la administración de productos, el control de inventarios, la generación de reportes y la gestión de empleados, entre otras funcionalidades. 


## Usos del Sistema

#### 1. Gestión de Inventarios
- Alta de Producto: Permite registrar nuevos productos en el sistema, asegurando que toda la mercancía disponible esté correctamente catalogada.

- Movimientos de Almacén: Monitorea los movimientos de entrada y salida de productos, proporcionando un registro detallado de todas las actividades de inventario.

- Control de Existencias: Funciones como "Productos Agotados" y "Modificar Existencia" ayudan a mantener un control preciso sobre las existencias, evitando faltantes y exceso de inventario.

#### 2. Proceso de Ventas
- Consultar Precio: Facilita a los cajeros la consulta rápida del precio de los productos, mejorando la eficiencia en el punto de venta.

- Cobrar Cuenta: Simplifica el proceso de cobro, permitiendo agregar productos a una cuenta y realizar el cobro final, generando tickets de venta automáticamente.

- Corte de Caja: Al final del día, el sistema realiza un corte de caja, ayudando a mantener un control financiero preciso y ordenado.

#### 3. Gestión de Empleados
- Alta de Trabajador: Permite registrar nuevos empleados, facilitando la gestión del personal.

- Editar Empleado: Proporciona la capacidad de actualizar la información de los empleados, asegurando que los registros estén siempre actualizados.

- Dar de Baja Empleado: Facilita la eliminación de empleados que ya no forman parte de la empresa, manteniendo los registros limpios y actualizados.

#### 4. Generación de Reportes y Análisis
- Imprimir Reportes: Genera informes detallados sobre las operaciones de la empresa, proporcionando información valiosa para la toma de decisiones.

- Gráficas: Presenta información visual sobre las tendencias y el rendimiento de la tienda, como los productos más vendidos, ayudando en la planificación estratégica.

#### 5. Gestión de Clientes
- Alta de Clientes: Permite registrar nuevos clientes, creando una base de datos que puede utilizarse para fidelización y marketing.

- Buscar Producto: Facilita la búsqueda de productos por descripción, mostrando su disponibilidad y ayudando a los clientes a encontrar lo que necesitan rápidamente.

## Caracteristicas

#### Modificación de Propiedades Intuitiva
El sistema MyStore permite una modificación fácil y rápida de las propiedades de productos, empleados y clientes a través de una interfaz de usuario intuitiva. Por ejemplo:
- Editar Producto: Simplemente ingrese el código del producto, y el sistema mostrará sus propiedades actuales para que puedan ser modificadas directamente.

#### Visualización Gráfica con IDEs
El uso de entornos de desarrollo integrados (IDEs) como NetBeans facilita la visualización y el diseño de los componentes de la interfaz gráfica del usuario.

- Ejemplo: Al diseñar la ventana de "Alta de Producto" en NetBeans, se puede arrastrar y soltar botones, campos de texto y etiquetas, viendo cómo se alinean y comportan los elementos en tiempo real.


## Requisitos

- JDK 22, java version "22.0.1" o una version superior.
  
- NetBeans IDE 20 ó algun IDE con soporte grafico.
  
**NOTA:** El proyecto fue creado con Windows 11.


## API 

### Paquetes
Para este sistema ocupamos de 6 paquetes, los cuales son: PaqueteModelo, PaqueteVistas, PaqueteControlador, PaqueteBaseDeDatos, PaqueteImagenes y PaqueteEjecutable.
A continuacion se muestra detalladamente los paquetes con sus contenidos.



### Paquete de Modelo
### Clase Cliente
Esta clase representa un cliente y contiene información relevante como su nombre, teléfono, correo electrónico y un identificador único.

#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|`String`	|`nombre`|	`Almacena el nombre del cliente.`|
|`String`	|`telefono`	|`Almacena el número de teléfono del cliente.`|
|`String`|	`correo`	|`Almacena la dirección de correo electrónico del cliente.`|
|`int`	|`id_cliente`	|`Almacena el identificador único del cliente.`|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|`Cliente`	|`()`|	`Constructor de pruebas que inicializa un cliente sin datos específicos.`|
|`Cliente`	|`(int id_cliente, String nombre, String telefono, String correo)`|	`Constructor completo que inicializa un cliente con los valores proporcionados para id_cliente, nombre, telefono y correo.`|

#### Metodos
| Tipo	| Return	| Nombre	| Parámetros	| Descripción|
| :--------| :------------ |---------------| --------| --------|
|`public`|	`int`	|`getId_cliente`	|`()`|	`Devuelve el identificador único del cliente.``|
|`public`|	`void`|	`setId_cliente`	|`(int id_cliente)`|	`Establece el identificador único del cliente.`|
|`public`|	`String`	|`getNombre`|	`()`|	`Devuelve el nombre del cliente.`|
|`public`|	`void`|	`setNombre`|	`(String nombre)`|	`Establece el nombre del cliente.`|
|`public`|	`String`|	`getTelefono`|	`()`|	`Devuelve el número de teléfono del cliente.`|
|`public`|	`void`|	`setTelefono`|	`(String telefono)`|	`Establece el número de teléfono del cliente.`|
|`public`|	`String`	|`getCorreo`|	`()`|	`Devuelve la dirección de correo electrónico del cliente.`|
|`public`|	`void`|	`setCorreo`|	`(String correo)`|	`Establece la dirección de correo electrónico del cliente.`|


### Clase DescripcionVenta
Esta clase representa la descripción de una venta y contiene detalles como el folio de la venta, código del producto, cantidad vendida y una descripción adicional.
#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|`int`|	`folio_venta`	|`Almacena el folio de la venta.`|
|`int`|	`codigo_producto`	|`Almacena el código del producto vendido.`|
|`int`|	`cantidad`	|`Almacena la cantidad del producto vendido.`|
|`String`|	`descripcion`	|`Almacena una descripción adicional de la venta.`|


#### Constructor
|Nombre|	Parámetros	|Descripción|
| :------------ |---------------| -----|
|`DescripcionVenta`	|`()`	|`Constructor de prueba que inicializa una descripción de venta con valores predeterminados.`|
|`DescripcionVenta`|	`(int folio_venta, int codigo_producto, String descripcion, int cantidad)`|	`Constructor completo que inicializa una descripción de venta con los valores proporcionados para folio_venta, codigo_producto, descripcion y cantidad.`|

#### Metodos

|Tipo	|Return	|Nombre|	Parámetros	|Descripción|
| :--------| :------------ |---------------| --------| --------|
|`public`|	`int`|	`getFolio_venta`|	`()`|	`Devuelve el folio de la venta.`|
|`public`|	`int`|	`getCodigo_producto`|	`()`	|`Devuelve el código del producto vendido.`|
|`public`|	`int`|	`getCantidad`	|`()`	|`Devuelve la cantidad del producto vendido.`|
|`public`|	`String`|	`getDescripcion`|	`()`|	`Devuelve la descripción adicional de la venta.`|
|`public`|	`void`|	`setFolio_venta`|	`(int folio_venta)`|	`Establece el folio de la venta.`|
|`public`|	`void`|	`setCodigo_producto`|	`(int codigo_producto)`|	`Establece el código del producto vendido.`|
|`public`|	`void`|	`setCantidad`|	`(int cantidad)`|	`Establece la cantidad del producto vendido.`|
|`public`|	`void`|	`setDescripcion`	|`(String descripcion)`|	`Establece la descripción adicional de la venta.`|


### Clase Empleado
Esta clase representa a un empleado y extiende la clase Usuario. Contiene información relevante como nombre, apellidos, identificador del empleado y del puesto, así como detalles de autenticación heredados de Usuario.
#### Variables

|Tipo|	Nombre	|Descripción|
| :------------ |---------------| -----|
|`String`	|`nombre`|	`Almacena el nombre del empleado.`
|`String`	|`apellidoP`	|`Almacena el apellido paterno del empleado.`|
|`String`|	`apellidoM`|	`Almacena el apellido materno del empleado.`|
|`int`	|`idEmpleado`	|`Almacena el identificador único del empleado.`|
|`int`	|`id_puesto`|	`Almacena el identificador del puesto del empleado.`|
|`Puesto`	|`puestoE`	|`Almacena el objeto puesto relacionado con el empleado.`|

#### Constructor

#### Metodos












## Instalacion
Para hacer uso de este componete puedes:
1. Descargar desde github el proyecto `.ZIP` 
2. Obtener el repositorio clon desde github.
Despues simplemente extrae el proyecto en tu ordenar y abrelo desde NetBeans (o el IDE de tu preferencia), luego compila el proyecto verificando que no haya errores.
![WhatsApp Image 2024-05-29 at 7 47 53 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/cb867cd1-ca53-4464-93ce-64a586c87848)

Para decargarlo con archivo .zip, una vez descragada la carpta, nos dirijimos a la ruta de descarga para descomprimirlo.
![WhatsApp Image 2024-05-29 at 7 48 33 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/c62116a5-bae5-44cf-8045-f6c3898f31d1)
![WhatsApp Image 2024-05-30 at 8 36 55 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/ed534883-5825-4fb9-ad3d-beef02324f43)

Ahora copiamos y pegamos la carpeta del proyecto en los proyectos de netbeans.
![WhatsApp Image 2024-05-29 at 8 00 16 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/c1619d2d-591c-4c75-b1d9-cb9cee40a43a)

Abrimos nuestro netbeans y abrimos nuestro proyecto.
![WhatsApp Image 2024-05-29 at 8 03 09 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/8ac93056-07d3-4edc-a174-5f169f693e57)

En caso de que el proyecto te salga en rojo o tengas algun problema, debes dar click en el proyecto y seleccionar la opcion de solucionar problemas.
![WhatsApp Image 2024-05-30 at 9 15 59 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/a874962a-e0cb-4de8-a0b8-457eb7c76749)
![WhatsApp Image 2024-05-30 at 9 17 27 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/dd60a814-fda5-498b-a1de-4339b640c187)
![WhatsApp Image 2024-05-30 at 9 18 05 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/fff723e7-f577-463a-9774-a367f2fc41f4)

Una vez que ya todo este bien, solo necesitas ejecutar la clase de Prueba que esta en el paquete de Ejecutable.
![WhatsApp Image 2024-05-30 at 9 20 20 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/89269100-d4a1-48ff-a3b1-6879fb7afc86)





## Autores
- Flores Santiago Wilver Alfredo - *Estudiante* 
- Roque Hernández Diego Misael- *Estudiante* 
### Final
Gracias por ver ;)




