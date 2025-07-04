💳 Plataforma de Pagos - Sistema Modular con Jakarta EE 10
Este repositorio contiene el desarrollo de una plataforma de pagos digital creada como parte del curso Taller de Sistemas de Información en la UTEC. El sistema ha sido diseñado de forma modular, promoviendo la escalabilidad, el mantenimiento sencillo y la posibilidad de evolucionar hacia una arquitectura de microservicios.

⚙️ Tecnologías Utilizadas
Jakarta EE 10: Incluye CDI, JPA, REST, Interceptores, Seguridad y Mensajería.

Java SE 21

WildFly como servidor de aplicaciones.

Docker para contenerización del ecosistema.

InfluxDB + Grafana para monitoreo y visualización de métricas.

Bucket4j para control de tráfico y protección frente a abuso de recursos.

🧠 Propósito del Proyecto
El sistema busca representar una Pasarela de Pagos, es decir, un intermediario que conecta comercios, clientes y entidades financieras para gestionar transacciones electrónicas de manera segura y centralizada. Esto permite a los comercios aceptar múltiples medios de pago de forma unificada y sin complejidades técnicas.

✨ Funcionalidades Principales
Alta y mantenimiento de comercios registrados.

Procesamiento de pagos a través de terminales (POS).

Reportes de actividad comercial (diarios o por rango de fechas).

Transferencias de fondos al banco del comercio.

Registro y seguimiento de eventos del sistema y reclamos.

🏗️ Arquitectura Modular
El sistema está dividido en componentes bien definidos, cada uno con una responsabilidad clara dentro del negocio. Esta separación facilita su futura evolución como microservicios independientes.

📦 Módulos del Sistema
Comercios: Gestión de comercios, terminales y reclamos.

Compras: Procesamiento de pagos y generación de reportes.

Transferencias: Comunicación con entidades financieras.

Monitoreo: Seguimiento de eventos y observabilidad.

Autenticación: Validación y autorización de operaciones.

📋 Requisitos Funcionales
Registro de comercios con información bancaria asociada.

Procesamiento de pagos electrónicos mediante POS.

Generación de informes por día o por período.

Transferencias y cálculo de comisiones.

Gestión de reclamos con integración a cola de mensajes y procesamiento inteligente.

🔐 Requisitos No Funcionales
Manejo eficiente de grandes volúmenes de reportes (procesamiento asincrónico).

Persistencia optimizada de transacciones y montos.

Seguridad robusta: contraseñas cifradas, sin almacenamiento de datos sensibles como tarjetas.

Control de abuso mediante límites de uso y penalizaciones automáticas.

🧠 El sistema penaliza el abuso del límite de transacciones mediante un aumento progresivo en la comisión.

🧱 Organización del Proyecto
Cada módulo sigue una estructura estandarizada:

kotlin
Copiar
Editar
└── nombre-modulo/
    ├── aplicacion/
    │   ├── dto/
    │   └── impl/
    ├── dominio/
    │   └── repo/
    ├── infraestructura/
    │   └── persistencia/
    └── interface/
        ├── evento/
        │   ├── in/
        │   └── out/
        └── remote/
            └── rest/
aplicacion: lógica de casos de uso.

dto: clases para transferencia de datos.

dominio: reglas de negocio.

repo: abstracciones de acceso a datos.

infraestructura: implementación técnica.

interface: puntos de integración con otros módulos o servicios.

evento: definición de eventos entrantes y salientes.

remote/rest: exposición de servicios vía HTTP.

🔄 Casos de Uso Destacados
procesarPago(datos)

altaComercio(infoComercio)

resumenVentasDiarias(comercioId)

consultarDepositos(rangoFechas)

realizarReclamo(texto)

notificarPago, notificarPagoOk, notificarPagoError

recibirNotificacionTransferencia(datos)

✅ Pruebas
Pruebas unitarias centradas en la lógica de negocio.

Pruebas de integración entre capas y módulos.

Mocks de servicios externos para testeo aislado.

🐋 Contenerización
El sistema está preparado para ejecutarse en contenedores Docker mediante docker-compose. Puedes levantar todos los servicios con:

bash
Copiar
Editar
docker-compose up --build
Incluye configuración para bases de datos, monitoreo y ejecución de servicios.

