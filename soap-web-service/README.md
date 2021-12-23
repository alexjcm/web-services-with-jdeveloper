# SOAP Web Service with Oracle JDeveloper 12c

Send email with Jakarta Mail via an SMTP server.

## Prerequisites

- Oracle JDeveloper 12c
- Oracle WebLogic 12c
- Mailtrap (or similar)

In our case we will use the following Java EE specifications and libraries:
- JAX-WS Web Services
- Jakarta Mail 1.6

## Installation

1. Sample config properties SMTP Server. Create a file named **config.properties** in the `EmailProject/` folder and add the following parameters of your SMTP Server:

```
HOST=smtp.mailtrap.io
PORT=465
USERNAME=XXXXXXXXXX
PASSWORD=XXXXXXXXXX
```

2. To open the application from JDeveloper click on the **File** > **Open** menu and open the `*.jws` file of the newly cloned repository.


## Deployment

From JDeveloper right click on the project and then click **Deploy**.


### Tutorials

* https://docs.oracle.com/cd/E37547_01/tutorials/tut_web_services/tut_web_services_2.html
* https://mailtrap.io/blog/sending-email-using-java/#Simple-Jakarta-Mail-message-via-an-SMTP-server
