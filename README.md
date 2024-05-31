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
|Nombre|	Parámetros	|Descripción|
| :------------ |---------------| -----|
|`Empleado`|	`()`|	`Constructor de prueba que inicializa un empleado con valores predeterminados.`|
|`Empleado`|	`(int nivel)`|	`Constructor de prueba que inicializa un empleado con valores predeterminados y asigna un nivel de usuario.`|
|`Empleado`|	`(int idEmpleado, String nombre, String apellidoP, String apellidoM, String usuario, String contraseña, int id_puesto)`|	`Constructor completo que inicializa un empleado con los valores proporcionados para idEmpleado, nombre, apellidoP, apellidoM, usuario, contraseña e id_puesto.`|
|`Empleado`	|`(int idEmpleado, String nombre, String apellidoP, String apellidoM, String usuario, String contraseña, Puesto puesto)`	|`Constructor completo que inicializa un empleado con los valores proporcionados para idEmpleado, nombre, apellidoP, apellidoM, usuario, contraseña, y un objeto puesto.`|


#### Metodos
|Tipo	|Return	|Nombre|	Parámetros	|Descripción|
| :--------| :------------ |---------------| --------| --------|
|`public`|	`int`	|`getIdEmpleado`| `()`|	`Devuelve el identificador único del empleado.`|
|`public`	|`void`|	`setIdEmpleado`|	`(int idEmpleado)`	|`Establece el identificador único del empleado.`|
|`public`|	`String`|	`getNombre`|	`()`|	`Devuelve el nombre del empleado.`|
|`public`|	`void`	|`setNombre`	|`(String nombre)`	|`Establece el nombre del empleado.`|
|`public`	|`String`|	`getApellidoP`|	`()`	|`Devuelve el apellido paterno del empleado.`|
|`public`	|`void`|	`setApellidoP`|	`(String apellidoP)`|	`Establece el apellido paterno del empleado.`|
|`public`|	`String`|	`getApellidoM`	|`()`|	`Devuelve el apellido materno del empleado.`|
|`public`|	`void`|	`setApellidoM`	|`(String apellidoM)`|	`Establece el apellido materno del empleado.`|
|`public`	|`int|	`getId_puesto`|	`()`	|`Devuelve el identificador del puesto del empleado.`|
|`public`|	`void`	|`setId_puesto`	|`(int id_puesto)`|	`Establece el identificador del puesto del empleado.`|


### Clase Producto
Esta clase representa un producto y contiene información relevante como nombre, descripción, código, existencia, categoría, precio de compra y precio de venta.
#### Variables

|Tipo|	Nombre	|Descripción|
| :------------ |---------------| -----|
|String	|nombre	|Almacena el nombre del producto.|
|String|	descripcion|	Almacena la descripción del producto.|
|int	|codigo	|Almacena el código del producto.|
|int	|existencia|	Almacena la cantidad de productos en existencia.|
|int|	categoria	|Almacena la categoría del producto.|
|double	|precioC|	Almacena el precio de compra del producto.|
|double|	precioV	|Almacena el precio de venta del producto.|

#### Constructor
|Nombre|	Parámetros	|Descripción|
| :------------ |---------------| -----|
|Producto|	()	|Constructor de prueba que inicializa un producto con valores predeterminados.|
|Producto	|(int codigo, String nombre, double precioC, double precioV, int categoria, String descripcion, int existencia)	|Constructor completo que inicializa un producto con los valores proporcionados para codigo, nombre, precioC, precioV, categoria, descripcion y existencia.|

#### Metodos
|Tipo	|Return	|Nombre|	Parámetros	|Descripción|
| :--------| :------------ |---------------| --------| --------|
|public	|String	|getNombre	|()	|Devuelve el nombre del producto.|
|public	|void	|setNombre	|(String nombre)	|Establece el nombre del producto.|
|public|	String	|getDescripcion	|()|	Devuelve la descripción del producto.|
|public|	void|	setDescripcion	|(String descripcion)	|Establece la descripción del producto.|
|public|	int|	getCategoria|	()	|Devuelve la categoría del producto.|
|public|	void	|setCategoria|	(int categoria)	|Establece la categoría del producto.|
|public|	int	|getCodigo|	()	|Devuelve el código del producto.|
|public	|void|	setCodigo	|(int codigo)|	Establece el código del producto.|
|public|	int	|getExistencia	|()|	Devuelve la cantidad de productos en existencia.|
|public|	void|	setExistencia|	(int existencia)	|Establece la cantidad de productos en existencia.|
|public	|double	|getPrecioC|	()|	Devuelve el precio de compra del producto.|
|public	|void|	setPrecioC	|(double precioC)	|Establece el precio de compra del producto.|
|public	|double	|getPrecioV|	()|	Devuelve el precio de venta del producto.|
|public|	void|	setPrecioV	|(double precioV)	|Establece el precio de venta del producto.|


### Clase Puesto
Esta clase representa un puesto dentro de una organización, incluyendo detalles como el identificador del puesto, nombre, descripción, sueldo y nivel.
#### Variables

|Tipo|	Nombre	|Descripción|
| :------------ |---------------| -----|
|int|	id_puesto	|Almacena el identificador único del puesto.|
|int	|nivel	|Almacena el nivel asignado al puesto, que puede ser usado para determinar jerarquías o permisos.|
|String|	nombre|	Almacena el nombre del puesto.|
|String	|descripcion|	Almacena la descripción del puesto.|
|double	|sueldo|	Almacena el sueldo asociado al puesto.|

#### Constructor
|Nombre|	Parámetros	|Descripción|
| :------------ |---------------| -----|
|Puesto|	()|	Constructor de prueba que inicializa un puesto sin valores.|
|Puesto	|(int id_puesto, String nombre, String descripcion, double sueldo, int nivel)	|Constructor completo que inicializa un puesto con los valores proporcionados para id_puesto, nombre, descripcion, sueldo y nivel.|

#### Metodos
|Tipo	|Return	|Nombre|	Parámetros	|Descripción|
| :--------| :------------ |---------------| --------| --------|
|public|	int	|getId_puesto	|()|	Devuelve el identificador único del puesto.|
|public	|void	|setId_puesto	|(int id_puesto)	|Establece el identificador único del puesto.|
|public	|String	|getNombre	|()	|Devuelve el nombre del puesto.|
|public|	void	|setNombre	|(String nombre)|	Establece el nombre del puesto.|
|public	|String|	getDescripcion	|()|	Devuelve la descripción del puesto.|
|public	|void|	setDescripcion|	(String descripcion)|	Establece la descripción del puesto.|
|public|	double|	getSueldo|	()|	Devuelve el sueldo asociado al puesto.|
|public|	void|	setSueldo|	(double sueldo)|	Establece el sueldo asociado al puesto.|
|public|	int|	getNivel|	()	|Devuelve el nivel asignado al puesto.|
|public	|void|	setNivel|	(int nivel)	|Establece el nivel asignado al puesto.|


### Clase Usuario
Esta clase representa un usuario del sistema, incluyendo detalles como el nombre de usuario, contraseña y nivel de acceso.
#### Variables

|Tipo|	Nombre	|Descripción|
| :------------ |---------------| -----|
|String|	usuario|	Almacena el nombre de usuario.|
|String|	contraseña	|Almacena la contraseña del usuario.|
|int|	nivel	|Almacena el nivel de acceso del usuario.|

#### Constructor
|Nombre|	Parámetros	|Descripción|
| :------------ |---------------| -----|
|Usuario	|()|	Constructor de prueba que inicializa un usuario con valores predeterminados.|
|Usuario|	(int nivel)|	Constructor de prueba que inicializa un usuario con un nivel de acceso especificado y valores predeterminados para el nombre de usuario y contraseña.|
|Usuario|	(String usuario, String contraseña, int nivel)	|Constructor completo que inicializa un usuario con los valores proporcionados para usuario, contraseña y nivel.|

#### Metodos
|Tipo	|Return	|Nombre|	Parámetros	|Descripción|
| :--------| :------------ |---------------| --------| --------|
|public	|String	|getUsuario|	()	|Devuelve el nombre de usuario.|
|public|	void	|setUsuario|	(String usuario)|	Establece el nombre de usuario.|
|public	|String	|getContraseña	|()	|Devuelve la contraseña del usuario.|
|public|	void	|setContraseña|	(String contraseña)	|Establece la contraseña del usuario.|
|public|	int	getNivel|	()	|Devuelve el nivel de acceso del usuario.|
|public|	void	|setNivel|	(int nivel)|	Establece el nivel de acceso del usuario.|
|public	|boolean	validarUsuario|	(String nombreUsuario, String contrasena)|	Comprueba si las credenciales proporcionadas coinciden con las del usuario.|


### Clase Venta

#### Variables

|Tipo|	Nombre	|Descripción|
| :------------ |---------------| -----|
|int	|folio_venta	|Almacena el folio de la venta, un identificador único.|
|int	|id_empleado	|Almacena el identificador del empleado que realizó la venta.|
|int|	id_cliente	|Almacena el identificador del cliente que realizó la compra.|
|Date|	fecha	|Almacena la fecha en que se realizó la venta.|
|Time	|hora|	Almacena la hora en que se realizó la venta.|

#### Constructor
|Nombre|	Parámetros	|Descripción|
| :------------ |---------------| -----|
|Venta|	()|	Constructor vacío utilizado para pruebas.|
|Venta	|(int folio_venta, Date fecha, Time hora, int id_empleado, int id_cliente)	|Constructor completo que inicializa una venta con los valores proporcionados para folio_venta, fecha, hora, id_empleado e id_cliente.|

#### Metodos
|Tipo	|Return	|Nombre|	Parámetros	|Descripción|
| :--------| :------------ |---------------| --------| --------|
|public	|int	|getFolio_venta|	()	|Devuelve el folio de la venta.|
|public	|void	|setFolio_venta	|(int folio_venta)	|Establece el folio de la venta.|
|public|	int	|getId_empleado	|()	|Devuelve el identificador del empleado que realizó la venta.|
|public|	void|	setId_empleado	|(int id_empleado)	|Establece el identificador del empleado que realizó la venta.|
|public|	int|	getId_cliente|	()	|Devuelve el identificador del cliente que realizó la compra.|
|public|	void|	setId_cliente|	(int id_cliente)|	Establece el identificador del cliente que realizó la compra.|
|public|	Date|	getFecha	|()	|Devuelve la fecha en que se realizó la venta.|
|public	|void|	setFecha	|(Date fecha)|	Establece la fecha en que se realizó la venta.|
|public|	Time|	getHora|	()|	Devuelve la hora en que se realizó la venta.|
|public|	void	|setHora	|(Time hora)|	Establece la hora en que se realizó la venta.|


### Paquete de Controlador.

### Clase ControladorAlfa
Esta clase actúa como controlador para manejar las interacciones de la vista con el modelo, específicamente para la autenticación y la asignación de vistas basadas en los niveles de usuario.

#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|login|	vLogin	|Instancia de la vista de login.|
|vistaGeneral	|vGeneral	|Instancia de la vista general de la aplicación.|
|vistaInicial|vInicio|	Instancia de la vista inicial de la aplicación.|
|JPanel	|pL|	Panel lateral para la vista de login.|
|JPanel	|pG|	Panel general para la vista principal.|
List<Empleado>|	listaEmpleados	|Lista de empleados para verificación de credenciales.|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|ControladorAlfa|	()	|Constructor vacío utilizado para pruebas.|
|ControladorAlfa	|(vistaInicial vInicio, login vLogin, vistaGeneral vGeneral, List<Empleado> listaEmpleados)|	Constructor completo que inicializa el controlador con las vistas y la lista de empleados proporcionados.|

#### Metodos
| Tipo	| Return	| Nombre	| Parámetros	| Descripción|
| :--------| :------------ |---------------| --------| --------|
|public|  void|	iniciar|	()|	Hace visible la vista de inicio con el panel de login.|
|public|	void	|definirVista|	(int nivel)|	Define la vista según el nivel de usuario proporcionado.|
|public|	void|	verificarUsuario	|(String usuario, String contraseña)	|Verifica las credenciales del usuario y muestra las vistas correspondientes si las credenciales son correctas.|
|public|	void|	iniciarVista	|(int nivel)|	Inicia la vista principal reemplazando la vista de login.|
|public|	void|	actionPerformed|	(ActionEvent e)|	Método sobrescrito para manejar el evento de acción del botón "Entrar".|


### Clase ControladorBD
Esta clase actúa como controlador para interactuar con la base de datos y realizar operaciones de búsqueda, inserción, edición y eliminación de datos.
#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|Connection	|con|	Objeto de conexión a la base de datos.|
|BaseDeDatos|	BD	|Instancia de la clase BaseDeDatos para acceder a los datos.|
|int|	nCliente	|Número total de clientes en la base de datos.|
|int	|nVenta	|Número total de ventas en la base de datos.|
|int|	nEmpleado|	Número total de empleados en la base de datos.|
|int|	nPuesto|	Número total de puestos en la base de datos.|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|ControladorBD	|(BaseDeDatos BD)	|Constructor que inicializa el controlador con una instancia de BaseDeDatos.|
|ControladorBD|	()|	Constructor de prueba que establece una nueva conexión y obtiene los datos de la base de datos.|

#### Metodos
| Tipo	| Return	| Nombre	| Parámetros	| Descripción|
| :--------| :------------ |---------------| --------| --------|
|public|	Producto	|buscarProducto	|(int id)	|Busca un producto por su ID en la base de datos.|
|public	|Empleado|	buscarEmpleado|	(int id)	|Busca un empleado por su ID en la base de datos.|
|public|	Cliente	buscarCliente	|(int id)	|Busca un cliente por su ID en la base de datos.|
|public	|Cliente|	buscarTelefonoCliente	|(String tel)	|Busca un cliente por su número de teléfono en la base de datos.|
|public|	Puesto|	buscarPuesto	|(int id)|	Busca un puesto por su ID en la base de datos.|
|public|	Venta|buscarVenta	|(int folio)|	Busca una venta por su folio en la base de datos.|
|public|	List<DescripcionVenta>	|getDescripcionesXventa	|(int folio)	|Obtiene las descripciones de venta para un folio de venta dado.|
|public|	int|	getnCliente|	()|	Obtiene el número total de clientes en la base de datos.|
|public|	int|	getnVenta	|()|	Obtiene el número total de ventas en la base de datos.|
|public|	int|	getnEmpleado|	()|	Obtiene el número total de empleados en la base de datos.|
|public	|int|	getnPuesto|	()	|Obtiene el número total de puestos en la base de datos.|
|public|	int	|getNPCategoria	|(int n)|	Obtiene el número total de productos por categoría en la base de datos.|
|public	|void|	insertarProducto|	(Producto producto)|	Inserta un nuevo producto en la base de datos.|
|public|	void	|insertarCliente|	(Cliente cliente)	|Inserta un nuevo cliente en la base de datos.|
|public|	void|	insertarPuesto	|(Puesto puesto)|	Inserta un nuevo puesto en la base de datos.|
|public	|void	|insertarEmpleado	|(Empleado empleado)	|Inserta un nuevo empleado en la base de datos.|
|public	|void	|insertarVenta|	(Venta venta)|	Inserta una nueva venta en la base de datos.|
|public|	void	|insertarDescripcionVenta	|(DescripcionVenta dVenta)	|Inserta una nueva descripción de venta en la base de datos.|
|public|	void|	editarProducto	|(Producto x)|	Edita un producto en la base de datos.|
|public|	void|	cambiarExistenciaxProducto	|(int id, int existencia)	|Cambia la existencia de un producto en la base de datos.|
|public	|void	|editarPuesto|	(Puesto x)	|Edita un puesto en la base de datos.|
|public|	void	|editarCliente	|(Cliente cliente)	|Edita un cliente en la base de datos.|
|public	|void	|editarEmpleado	|(Empleado empleado)|	Edita un empleado en la base de datos.|
|public|	void	|editarVenta	|(Venta venta)	|Edita una venta en la base de datos.|
|public	|void|	eliminarProducto|(int id)|	Elimina un producto de la base de datos.|
|public	|void	|eliminarEmpleado	|(int id)|	Elimina un empleado de la base de datos.|
|public	|void|	eliminarPuesto|	(int id)	|Elimina un puesto de la base de datos.|
|public|	void|	eliminarCliente|	(int id)|	Elimina un cliente de la base de datos.|
|public|	void|	eliminarVenta	|(int id)	|Elimina una venta de la base de datos.|

### Clase ControladorProducto
Esta clase actúa como controlador para interactuar con la lista de productos y realizar operaciones de búsqueda y verificación.
#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|List<Producto>|	productos	|Lista de productos disponibles.|
|Producto	|producto	|Producto actual seleccionado.|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|ControladorProducto|	()	|Constructor que inicializa el controlador sin conexión, obteniendo la lista de productos de la base de datos.|
|ControladorProducto	|(List<Producto> productos)	|Constructor que inicializa el controlador con una lista de productos proporcionada.|

#### Metodos
| Tipo	| Return	| Nombre	| Parámetros	| Descripción|
| :--------| :------------ |---------------| --------| --------|
|public|	Producto|	buscarProducto	|(int id)|	Busca un producto por su ID en la lista de productos.|
|public|	Producto	|buscarProducto|	(String id)	|Busca un producto por su ID en la lista de productos.|
|public|	boolean|	existeProducto	|(int id)	|Verifica si un producto existe en la lista por su ID.|
|public|	boolean|	existeProducto|	(String id)|	Verifica si un producto existe en la lista por su ID.|

### Clase ControladorUsuarioLogin
Esta clase actúa como controlador para manejar las interacciones entre la vista de login, el modelo de usuario y la vista general de la aplicación.
#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|login|	vLogin|	Instancia de la vista de login.|
|Usuario	|mUsuario|	Instancia del modelo de usuario.|
|vistaGeneral|	vGeneral	|Instancia de la vista general de la aplicación.|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|ControladorUsuarioLogin|	(Usuario mUsuario, login vLogin, vistaGeneral vGeneral)|	Constructor que inicializa el controlador con las instancias proporcionadas de usuario, vista de login y vista general. También agrega un ActionListener al botón de entrada en la vista de login.|

#### Metodos
| Tipo	| Return	| Nombre	| Parámetros	| Descripción|
| :--------| :------------ |---------------| --------| --------|
|public|	void	|iniciar	|()	|Hace visible la vista de login.|
|public|	void|	actionPerformed	|(ActionEvent e)|	Método sobrescrito para manejar el evento de acción del botón "Entrar" en la vista de login.|
|public|	void|	verificarUsuario|	(String usuario, String contraseña)|	Verifica las credenciales del usuario proporcionadas y muestra la vista general si son correctas, de lo contrario, muestra un mensaje de error en la vista de login.|

### Clase controladorInicio
Esta clase actúa como controlador para manejar las interacciones entre la vista inicial de sesión, la vista de login, el modelo de usuario y la vista general de la aplicación.
#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|login|	vLogin	|Instancia de la vista de login.|
|Usuario	|mUsuario	|Instancia del modelo de usuario.|
|vistaGeneral|	vGeneral	|Instancia de la vista general de la aplicación.|
|vistaInicial	|vInicio	|Instancia de la vista inicial de sesión.|
|JPanel	|pL|	Panel lateral para la vista de login.|
|JPanel|	pG	|Panel general para la vista principal.|
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|controladorInicio	|(vistaInicial vInicio, login vLogin, Usuario mUsuario, vistaGeneral vGeneral)|	Constructor que inicializa el controlador con las instancias proporcionadas de la vista inicial, la vista de login, el modelo de usuario y la vista general. Además, agrega un ActionListener al botón de entrada en la vista de login.|
#### Metodos
| Tipo	| Return	| Nombre	| Parámetros	| Descripción|
| :--------| :------------ |---------------| --------| --------|
|public|	void	|iniciar|	()	|Hace visible la vista inicial de sesión con el panel de login.|
|public	|void	|definirVista|	()|	Define la vista según el nivel de usuario proporcionado.|
|public|	void|	verificarUsuario|	(String usuario, String contraseña)|	Verifica las credenciales del usuario proporcionadas y muestra la vista general si son correctas, de lo contrario, muestra un mensaje de error en la vista de login.|
|public	|void	|actionPerformed	|(ActionEvent e)	|Método sobrescrito para manejar el evento de acción del botón "Entrar" en la vista de login. Llama a los métodos definirVista() y verificarUsuario() para cambiar la vista y verificar las credenciales respectivamente.|


### Paquete de DataBase

### Clase ConexionBD
Esta clase se encarga de establecer la conexión con la base de datos MySQL utilizada por la aplicación.

#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|Connection|	con|	Objeto de conexión utilizado para interactuar con la base de datos.|
|String	|URL|	URL de conexión a la base de datos MySQL.|
|String|	USER|	Nombre de usuario para acceder a la base de datos.|
|String|	CLAVE|	Contraseña para acceder a la base de datos.|

#### Metodos
| Tipo	| Return	| Nombre	| Parámetros	| Descripción|
| :--------| :------------ |---------------| --------| --------|
|public|	Connection	|conectar	|()	|Establece la conexión con la base de datos utilizando la URL, nombre de usuario y contraseña especificados. Retorna el objeto de conexión establecido. Si ocurre algún error durante la conexión, muestra un mensaje de error en la consola.|

### Clase BaseDeDatos
Esta clase se encarga de gestionar la conexión con la base de datos y cargar los datos necesarios en listas de objetos correspondientes a las entidades de la base de datos.
#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|ConexionBD	|conexion	|Objeto para establecer la conexión con la base de datos.|
|Connection|	con	|Objeto de conexión utilizado para interactuar con la base de datos.|
|List<Producto>	|productos	|Lista de productos cargados desde la base de datos.|
|List<Empleado>	|empleados	|Lista de empleados cargados desde la base de datos.|
|List<Puesto>|	puestos	|Lista de puestos cargados desde la base de datos.|
|List<Venta>	|ventas	|Lista de ventas cargadas desde la base de datos.|
|List<Cliente>|	clientes	|Lista de clientes cargados desde la base de datos.|
|List<DescripcionVenta>|	descripcionesVentas|	Lista de descripciones de ventas cargadas desde la base de datos.|
#### Constructor
| Nombre	| Descripción|
| :------------ | -----|
|BaseDeDatos()|	Constructor |que inicializa las listas de objetos y carga los datos desde la base de datos.



### Paquete de Vistas
### Clase centroAdministracion
Esta clase representa la vista del centro de administración en la interfaz de usuario.

#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|BaseDeDatos	|BD|	Objeto para acceder a la base de datos.|
|List<Empleado>	|empleados	|Lista de empleados.|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|centroAdministracion()|	-	|Constructor predeterminado. Inicializa la interfaz y carga los empleados desde la base de datos.|
|centroAdministracion(BaseDeDatos bd)	|BaseDeDatos bd	|Constructor que inicializa la interfaz y utiliza una instancia específica de la base de datos para cargar los empleados.|
|centroAdministracion(List<Empleado> empleados)|	List<Empleado> empleados	|Constructor que inicializa la interfaz con una lista preexistente de empleados.|

### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 00 50 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/971aa41b-49e7-4ce9-8607-b30736baa2ee)

### Clase centroAlmacen
Esta clase representa la vista del centro de almacenamiento en la interfaz de usuario.

#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|BaseDeDatos|	BD|	Objeto para acceder a la base de datos.|
|List<Producto>	|productos|	Lista de productos en el almacen.|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|centroAlmacen()|	-	|Constructor predeterminado. Inicializa la interfaz y carga los productos desde la base de datos.|
|centroAlmacen(BaseDeDatos bd)|	BaseDeDatos bd|	Constructor que inicializa la interfaz y utiliza una instancia específica de la base de datos para cargar los productos.|
|centroAlmacen(List<Producto> productos)|	List<Producto> productos	|Constructor que inicializa la interfaz con una lista preexistente de productos.|

### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 10 59 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/83e1a269-a5d7-43c9-ae54-d9800abdb160)

### Clase centroCajero
Esta clase representa la vista del centro de cajero en la interfaz de usuario.
#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|JPanel|	jPanel1|	Panel principal que contiene los elementos de la interfaz.|
|JLabel|	jLabel42	|Etiqueta para mostrar el símbolo de moneda.|
|JLabel	|jLabel43|	Etiqueta para mostrar el texto "TOTAL".|
|JTable	|tablaCentroCajero	|Tabla que muestra los elementos relacionados con las transacciones del cajero.|
|JLabel|	lblresultado|Etiqueta para mostrar el total de la transacción.|
|JSeparator	|jSeparator4|	Separador para dividir visualmente los elementos.|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|centroCajero()	|-	|Constructor predeterminado que inicializa la interfaz.|
### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 13 42 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/7a1e7e12-9a4b-4641-9518-7ff7f6e995c8)

### Clase dialogoTabla
Esta clase representa un diálogo que muestra una tabla con un título.
#### Variables
| Tipo	| Nombre	| Descripción  |
| :------------ |---------------| -----|
|JPanel|	panelTabla|	Panel principal que contiene la tabla y otros componentes.|
|JLabel	|lblTitulo	|Etiqueta para mostrar el título de la tabla.|
|JLabel|	jLabel1|	Etiqueta para diseño visual.|
|JTable|	tabla	|Tabla que muestra los datos.|
|JScrollPane|jScrollPane1	|Panel de desplazamiento para la tabla.|
|JSeparator|	jSeparator1	|Separador visual.|
|JLabel|	jLabel5|	Etiqueta para diseño visual.|
|JLabel	|jLabel9|	Etiqueta para diseño visual.|

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dialogoTabla(Frame parent, boolean modal)|	Frame parent, boolean modal|	Constructor que inicializa el diálogo con un padre y establece si es modal o no.|

### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 20 55 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/d65a1571-b6b5-4d33-b3cc-f6747ff23e8c)


### Clase dlaBuscarProducto
Esta clase representa un diálogo para buscar un producto en el sistema.

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dlaBuscarProducto(Frame parent, boolean modal)|	Frame parent, boolean modal|	Constructor que inicializa el diálogo con un padre y establece si es modal o no.|
### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 26 55 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/5af9adc1-6e64-4362-b406-89d64107f3af)


### Clase dlcAplicarDescuento
Esta clase representa un diálogo para aplicar un descuento a un producto en el sistema.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dlcAplicarDescuento|	Frame parent, boolean modal|	Constructor que inicializa el diálogo con un padre y establece si es modal o no.|
### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 30 01 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/a6d1352b-8da1-4171-9456-53c7803e3127)

### Clase dlcCambiarCliente
Esta clase representa un diálogo para cambiar el cliente en el sistema.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dlcCambiarCliente	|Frame parent, boolean modal	|Constructor que inicializa el diálogo con un padre y establece si es modal o no.|
### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 32 15 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/7aacd534-4198-4066-9a9c-e209eb14c229)

### Clase dlcCobrarCuenta
Esta clase representa un diálogo para cobrar una cuenta en el sistema.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dlcCobrarCuenta	|Frame parent, boolean modal	|Constructor que inicializa el diálogo con un padre y establece si es modal o no.|
### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 33 44 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/01ae5ddc-0519-4658-96ae-b37edeaa21ab)


### Clase dlcTicket
Esta clase representa un diálogo para mostrar un ticket de compra.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dlcTicket	|Frame parent, boolean modal	|Constructor que inicializa el diálogo del ticket.|
### Vista previa del diseño
![WhatsApp Image 2024-05-30 at 11 37 02 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/0120399f-c2d0-49a8-9660-7ce3991e2712)


### Clase dlcVerDisponibilidad
Esta clase representa un diálogo para verificar la disponibilidad de un producto.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dlcVerDisponibilidad	|(java.awt.Frame parent, boolean modal)	|Constructor que inicializa el diálogo de disponibilidad con el frame principal y el estado modal.|
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 11 33 20 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/a48459e2-cd5d-499e-b2a9-cf177460c2c9)


### Clase dldBajaEmpleado
Esta clase representa un diálogo para dar de baja a un empleado.

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dldBajaEmpleado	|(java.awt.Frame parent, boolean modal)	|Constructor que inicializa el diálogo con el frame principal y el estado modal.|
|dldBajaEmpleado	|(java.awt.Frame parent, boolean modal, ControladorBD con)|	Constructor que inicializa el diálogo con el frame principal, el estado modal y un controlador de base de datos.|
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 11 36 24 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/40c8a84f-1661-4c3a-ae0b-9377960ab2b3)


### Clase dldBuscarEmpleado
Esta clase representa un diálogo para buscar un empleado.

#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dldBuscarEmpleado	|(java.awt.Frame parent, boolean modal)	|Constructor que inicializa el diálogo con el frame principal y el estado modal.|
|dldBuscarEmpleado	|(java.awt.Frame parent, boolean modal, ControladorBD cbd)	|Constructor que inicializa el diálogo con el frame principal, el estado modal y un controlador de base de datos.|
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 11 38 55 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/84a8e2a1-5635-4a3e-90ce-30bb3c4d4270)



### Clase dldEditarEmpleado
Esta clase representa un diálogo para editar la información de un empleado en la base de datos.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dldEditarEmpleado|	(java.awt.Frame parent, boolean modal)	|Constructor que inicializa el diálogo con el frame principal y el estado modal.|
|dldEditarEmpleado|	(java.awt.Frame parent, boolean modal, ControladorBD cbd)	|Constructor que inicializa el diálogo con el frame principal, el estado modal y un controlador de base de datos.|

### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 11 46 34 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/a460fb9f-632e-47d2-bc75-dffe400a2f62)


### Clase dvgAltaCliente
Esta clase representa un diálogo para registrar un nuevo cliente en la base de datos.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dvgAltaCliente	|(java.awt.Frame parent, boolean modal)|	Constructor que inicializa el diálogo con el frame principal y el estado modal.|
|dvgAltaCliente	|(java.awt.Frame parent, boolean modal, ControladorBD controlbd)	|Constructor que inicializa el diálogo con el frame principal, el estado modal y un controlador de base de datos.|
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 11 49 14 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/5c839680-1574-4031-baed-7c2b53b9a48e)


### Clase dvgAltaEmpleado
Esta clase representa un diálogo para dar de alta a un nuevo empleado en la base de datos.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dvgAltaEmpleado	|java.awt.Frame parent, boolean modal	|Constructor que inicializa el diálogo con el frame principal y el estado modal.|
|dvgAltaEmpleado	|java.awt.Frame parent, boolean modal, ControladorBD cbd	|Constructor que inicializa el diálogo con el frame principal, el estado modal y un controlador de base de datos.|
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 11 51 20 AM (3)](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/1669ba99-cf48-41a7-8f74-8371ac5000a9)


### Clase dvgAltaProducto
Esta clase representa un diálogo para registrar un nuevo producto en la base de datos.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dvgAltaProducto	|java.awt.Frame parent, boolean modal|	Constructor que inicializa el diálogo con el frame principal y el estado modal, y crea una nueva instancia del controlador de base de datos |(ControladorBD).
|dvgAltaProducto	|java.awt.Frame parent, boolean modal, ControladorBD cbd	|Constructor que inicializa el diálogo con el frame principal, el estado modal y un controlador de base de datos proporcionado.|
### Vista previa del diseño
 ![WhatsApp Image 2024-05-31 at 11 57 23 AM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/b0570a32-64d5-4d89-9894-2261e0801c4b)

### Clase dvgConsultarPrecio
Esta clase representa un diálogo para consultar el precio de un producto en la base de datos.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
|dvgConsultarPrecio	|java.awt.Frame parent, boolean modal	|Constructor que inicializa el diálogo con el frame principal y el estado modal.|
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 18 12 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/4b3e9c5e-3250-40bf-8602-05bcfed83686)

### Clase dvgMovimientosAlmacen
Esta clase representa un diálogo para visualizar los movimientos realizados en el almacén.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
| dvgMovimientosAlmacen| java.awt.Frame parent, boolean modal | Constructor que inicializa el diálogo con el frame principal y el estado modal. |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 21 03 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/af554c37-e634-4207-b988-679c1b99c2e1)


### Clase dvgOpciones
Esta clase representa un diálogo de opciones especializadas para el sistema de punto de venta.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
| dvgOpciones          | java.awt.Frame parent, boolean modal | Constructor que inicializa el diálogo con el frame principal y el estado modal. |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 22 44 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/0948471b-c998-4e87-b180-3a4afe9be7ba)


### Clase dvgSuper
Esta clase representa un diálogo para cambiar el nivel de usuario en el sistema.
#### Constructor
| Nombre	| Parámetros	| Descripción|
| :------------ |---------------| -----|
| dvgSuper        | java.awt.Frame parent, boolean modal, vistaGeneral vG | Constructor que inicializa el diálogo con el frame principal, el estado modal y una instancia de `vistaGeneral`. |

#### Métodos
| Nombre          | Parámetros                    | Descripción                                           |
| :-------------- | ---------------------------- | ---------------------------------------------------- |
| cambiarNivel    | int n                         | Cambia el nivel de usuario según el parámetro `n`.  |
| revalidarVista  | Ninguno                       | Elimina y vuelve a dibujar los componentes de la vista general. |

### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 24 37 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/60028d5d-d720-410d-b0ef-06367772472a)


### Clase dvlRecuperarContraseña

Esta clase representa un diálogo para recuperar la contraseña de acceso al sistema.

#### Constructor
| Nombre                | Parámetros                   | Descripción                                           |
| :-------------------- | ---------------------------- | ---------------------------------------------------- |
| dvlRecuperarContraseña| java.awt.Frame parent, boolean modal | Constructor que inicializa el diálogo con el frame principal y el estado modal. |

#### Métodos
| Nombre          | Parámetros                    | Descripción                                           |
| :-------------- | ---------------------------- | ---------------------------------------------------- |
| btnAceptar      | java.awt.event.ActionEvent evt | Abre un nuevo diálogo para recuperar la contraseña del usuario. |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 26 18 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/01e1eb04-1d27-433b-ac05-c3af3cfa1362)


### Clase dvlRecuperarContraseñaUsuario

Esta clase representa un diálogo que muestra una lista de usuarios para recuperar sus contraseñas.

#### Constructor
| Nombre                            | Parámetros                   | Descripción                                           |
| :-------------------------------- | ---------------------------- | ---------------------------------------------------- |
| dvlRecuperarContraseñaUsuario     | java.awt.Frame parent, boolean modal | Constructor que inicializa el diálogo con el frame principal y el estado modal. |

#### Métodos
| Nombre                   | Parámetros                    | Descripción                                           |
| :----------------------- | ---------------------------- | ---------------------------------------------------- |
| btnMostrarContraseña     | java.awt.event.ActionEvent evt | Abre un nuevo diálogo para mostrar la contraseña del usuario seleccionado. |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 28 43 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/fad71d0f-077b-4d65-a54f-77209f458dda)


### Clase dvlValoresIniciales

Esta clase representa un diálogo para ingresar los valores iniciales de la caja.

#### Constructor
| Nombre               | Parámetros                  | Descripción                                           |
| :------------------- | --------------------------- | ---------------------------------------------------- |
| dvlValoresIniciales  | java.awt.Frame parent, boolean modal | Constructor que inicializa el diálogo con el frame principal y el estado modal. |

#### Métodos
| Nombre              | Parámetros                    | Descripción                                           |
| :------------------ | ---------------------------- | ---------------------------------------------------- |
| btnAceptar          | java.awt.event.ActionEvent evt | Obtiene el dinero ingresado y abre un nuevo diálogo de confirmación con el monto. |
| btnCancelar         | java.awt.event.ActionEvent evt | Cierra el diálogo actual. |
| txtDineroEnCajaActionPerformed | java.awt.event.ActionEvent evt | Método de acción para el campo de texto del dinero en caja. |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 30 01 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/b7794cf0-5a22-40ec-a419-bc6f0a77fd86)


### Clase dvlValoresInicialesConfirmacion

Esta clase representa un diálogo de confirmación para los valores iniciales de la caja.

#### Constructor
| Nombre                                 | Parámetros                                          | Descripción                                           |
| :------------------------------------- | --------------------------------------------------- | ---------------------------------------------------- |
| dvlValoresInicialesConfirmacion        | java.awt.Frame parent, boolean modal                | Constructor que inicializa el diálogo con el frame principal y el estado modal. |
| dvlValoresInicialesConfirmacion        | java.awt.Frame parent, boolean modal, String valor | Constructor que inicializa el diálogo con el frame principal, el estado modal y el valor ingresado para mostrar en el diálogo. |

#### Métodos
| Nombre          | Parámetros                    | Descripción                                           |
| :-------------- | ---------------------------- | ---------------------------------------------------- |
| btnCancelar     | java.awt.event.ActionEvent evt | Cierra el diálogo actual. |

### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 32 17 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/1c3e93c4-a48f-4bcf-9afb-fd15f33b066d)



### Clase finalRecuperarContraseña

Esta clase representa una ventana que muestra la contraseña recuperada del usuario.

#### Constructor
| Nombre                        | Parámetros | Descripción                                                  |
| :---------------------------- | ---------- | ----------------------------------------------------------- |
| finalRecuperarContraseña      |            | Constructor que inicializa la ventana y sus componentes.    |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 33 31 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/d7556ae7-3c8b-4bc7-a241-7b65bb532150)


### Clase lateralAdministracion

Esta clase representa una ventana que muestra las opciones de administración.

#### Constructor
| Nombre               | Parámetros | Descripción                                                  |
| :------------------- | ---------- | ----------------------------------------------------------- |
| lateralAdministracion|            | Constructor que inicializa la ventana y sus componentes.    |

#### Métodos
| Nombre                     | Parámetros                 | Descripción                                                  |
| :------------------------- | -------------------------- | ----------------------------------------------------------- |
| getPanelLateralAdministracion |                            | Retorna el panel lateral de administración.              |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 34 41 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/8a05e416-8772-4c91-a212-272c2a4a55a4)


### Clase lateralAlmacen

Esta clase representa una ventana que muestra las opciones de almacenamiento.

#### Constructor
| Nombre               | Parámetros | Descripción                                                  |
| :------------------- | ---------- | ----------------------------------------------------------- |
| lateralAlmacen       |            | Constructor que inicializa la ventana y sus componentes.    |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 35 55 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/1377cb6c-f6a3-4eb8-ab18-a502f88385d4)


### Clase lateralCajero

Esta clase representa una ventana que muestra las opciones de caja para un cajero.
#### Constructor
| Nombre               | Parámetros | Descripción                                                  |
| :------------------- | ---------- | ----------------------------------------------------------- |
| lateralCajero       |            | Constructor que inicializa la ventana y sus componentes.    |

### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 37 31 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/3bffab68-6db8-462c-82e1-0a0fa35edd2f)



### Clase login

Esta clase representa la ventana de inicio de sesión.
### Constructor
| Nombre       | Parámetros | Descripción                               |
| :----------- | ---------- | ---------------------------------------- |
| login        |            | Constructor que inicializa la ventana y sus componentes. |
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 40 01 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/3b1a4479-4cce-4b10-b83c-14539e41442a)


### Clase valoresIniciales

Esta clase representa la ventana para ingresar los valores iniciales al abrir la caja.
### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 41 40 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/2948abaf-c212-4f42-968a-1198edf0f87c)



### Clase vistaGeneral
Esta clase representa la interfaz principal de un sistema de gestión de tienda. Permite al usuario acceder a diferentes funcionalidades como ventas, gestión de clientes, gestión de productos, movimientos de almacén, impresión de reportes y generación de gráficos.
### Constructor
| Nombre       | Parámetros | Descripción                               |
| :----------- | ---------- | ---------------------------------------- |
|vistaGeneral	|Ninguno|	Constructor que inicializa la interfaz de usuario y establece el estado inicial de los componentes.|
|vistaGeneral(boolean b)	|boolean b|	Constructor utilizado para realizar pruebas, permitiendo establecer el estado de visibilidad de los botones.|

### Vista previa del diseño
![WhatsApp Image 2024-05-31 at 12 47 34 PM](https://github.com/WilverAFS/MyStore_PuntoVenta/assets/168376977/96cfa7fc-0ab6-4084-96d0-6347e7001103)





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




