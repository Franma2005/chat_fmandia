# Cliente de Chat TCP

## Descripción
Este proyecto implementa un cliente de chat TCP en Java que se conecta al servidor mencionado anteriormente. Utiliza la arquitectura MVC (Modelo-Vista-Controlador) para organizar el código de forma modular y escalable, permitiendo que las diferentes partes del cliente estén bien separadas. El cliente también utiliza los mismos patrones de diseño que el servidor: **Command**, **Observer** y **Singleton**.

## Características principales
- Conexión TCP con el servidor de chat
- Interfaz gráfica de usuario (GUI) para interacción en tiempo real
- Gestión automática de nombres de usuario
- Procesamiento de mensajes basado en JSON
- Implementación de los patrones de diseño **Command**, **Observer** y **Singleton**

## Arquitectura
El cliente sigue la arquitectura MVC, que se divide en las siguientes capas:

- **Modelo**: Contiene la lógica del negocio y la gestión de datos, como el manejo de mensajes y usuarios.
- **Vista**: Representa la interfaz gráfica del usuario, permitiendo a los usuarios enviar y recibir mensajes.
- **Controlador**: Actúa como intermediario entre el modelo y la vista, gestionando las interacciones del usuario y actualizando la vista según corresponda.

### Patrones implementados
- **Patrón de Comando**: Para la gestión de acciones del usuario, como el envío de mensajes o la creación de salas.
- **Patrón de Observador**: Para la notificación de nuevos mensajes y actualizaciones de estado de la conexión.
- **Patrón Singleton**: Para garantizar una única instancia del cliente conectado al servidor y la gestión de la configuración global.
