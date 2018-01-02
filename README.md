# Project CWC
CWC Consolidated Workload Calculation is a Java EE project made to manage different tasks inside the bank such as Employees , projects , teams and inventories.
It is described as an inside tool for the bank to manage easily their Employees status , Team management , Assigning task to Employees.. 

It follows this structure:

1-CWC-ear : the EJB archive files that will be deployed to the server

2-CWC-ejb : The Session bean of the application in which there is two packages :

  2,1 : tn.esprit.cwc.entities : Containts the Java classes that define Business elements of the projects (Employee , Inventory , Planning, Bonus..) that through JPA will be transformed to persisted entities.
  
  2,2 : tn.esprit.cwc.services : The Business Layer of the project where you can find Services of each entities , each service implement basic methods (create , read , delete ...) through Local and remote interfaces, and will be interacting with the database.

3-CWC-web : the Web part of the application that contain (under JavaRessources) precisely the package tn.esprit.cwc.beans the Java beans that each one call methods from the its service from "ejb" to be Managed and used later in UI.
Under the "Deployed Ressources" , you can fin different UI Files written in XHTML to be used in MVC architecture under the framework JSF.

# Project CWC : Deployment
1-First you need to make new server (Wildfly 9 or 8 ) and started.

2- You have to deploy the ejb project but running "Clean install" command in the "Maven Build" option or just click "Run on server".

3- Check if hibernate generate your schema in Console.

4-If last step is executed rightfully , Run the web project By a "Run on server" option On the Index.xhtml File or a "clean install" command in "Mavel build" option.

# Tools and requirements
Jboss Developer Studio

EJB : Entreprise Java Bean 3

JDK8

Wildfly 9.x or 8.x (Application Server)

JSF : Java server faces

JPA/Hibernate
