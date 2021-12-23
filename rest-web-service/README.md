# REST Web Service using Oracle JDeveloper 12c

This application includes the following two projects:

- *CustomEJBModel* is a EJB project, which includes JPA/EJB components.
- *CustomWebService* is a RESt Web Service project including Java JAX-RS classes for exposing various REST resources.

## Prerequisites

- Oracle Autonomous Transaction Processing (ATP)
- Oracle JDeveloper 12c
- Oracle WebLogic 12

In our case we will use the following Java EE specifications:
- JPA
- EJB 3.1
- JAX-RS Jersey 2.x

## Installation

To open the application from JDeveloper click on the **File** > **Open** menu and open the `*.jws` file of the newly cloned repository.


###
### ATP database connection and configuration

If you plan to use ATP Database you can follow the next steps:

1. Create an ATP Database. [See tutorial](https://blogs.oracle.com/weblogicserver/post/creating-an-autonomous-transaction-processing-atp-database)
2. Run the `sample-script-for-database.sql` in ATP Database
3. The Data Source for the ATP database must be created in WebLogic Server. [See tutorial](https://blogs.oracle.com/weblogicserver/post/atp-database-use-with-weblogic-server?xd_co_f=3ff35843-ce09-4dca-b6d5-ede98565a1ea) (JDNI Name: dbatp). The JDNI Name of the data source is used in the *javax.persistence.jtaDataSource* property of the `persistence.xml` file.


If you are creating a project web with a connection to an ATP database from JDeveloper it may be necessary to follow steps similar to the following:
1. Create an **EJB project** in JDeveloper
2. Invoke the **Etities From Tables** wizard.
3. Under Connection Type select: **Connection to Application Server Data Source**
4. Under Database Connection select the Data Source created earlier and enter the user and password of the ATP Database user.

If you do not want to use ATP Database you can choose to use Oracle Database XE.

## Deployment

To deploy from JDeveloper click **Application** > **Deploy** menu. 


### Guides

* https://blogs.oracle.com/pcoe/post/building-simple-java-ee-rest-service-using-oracle-jdeveloper-12c
* https://docs.oracle.com/cd/E53569_01/tutorials/tut_rest_ws/tut_rest_ws.html
