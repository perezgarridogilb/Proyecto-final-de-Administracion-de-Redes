## Proyecto final de Administración de Redes

**Proyecto de Administración de redes.**

Estimado estudiante, a continuación, se describe el proyecto que deberás desarrollar como parte final del curso de administración de redes. Se describe a modo de situarte en un contexto real. Tú eres el especialista en seguridad.

Usted es uno de los administradores de la red de una universidad, específicamente **eres el encargado del área de seguridad**, hemos llegado al final del periodo escolar y es momento de entregar calificaciones finales a los estudiantes.

Has programado una aplicación segura, **que ofrece confidencialidad y autenticación** para la entrega de calificaciones, la aplicación solo necesita que los estudiantes envíen su nombre completo y obtendrán de regreso su calificación.

El **nombre** de los estudiantes se transmite **cifrado** hasta llegar al servidor de la escuela. Una vez que la solicitud llega al servidor ahí se deberá **descifrar** el nombre del estudiante y **autenticar** al estudiante. Una vez pasada la prueba de autenticación, entonces la aplicación buscará la calificación del estudiante, la **cifrará** y la transmitirá al estudiante.

Finalmente, el estudiante recibirá su calificación, pero cifrada, el estudiante la **descifrará** y podrá conocer su calificación del curso.

*El administrador decidió usar Java para la programación, ya que tiene todos los recursos criptográficos que necesita.*

*El algoritmo que usó para cifrar y descifrar fue RSA.*

*La función Hash que usó fue: MD5, pero podría usar cualquier otra que tenga Java.*

**Productos para entregar:**

1. Un video donde expliques tu código, así como muestres y explique paso a paso la ejecución de tu aplicación.

2. Reporte escrito (adjunto se encuentra el formato a seguir)

Nota: Debes hacer pruebas con dos estudiantes diferentes.