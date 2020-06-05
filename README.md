# GCP SPRINGBOOT TUTORIAL

Now, we are going to learn about GCP (Google Cloud Platform). There are multiple products available in GCP which can be use in several
applications. here we will see GCP SQL, Storage, PUB/Sub and all. Let start:

First we create project in spring boot and Java8 through [start.spring.io](start.spring.io).

### Adding Dependency

* Spring Web
* Spring Data JPA

## How to User MYSQL on GCP

Here we are going to use MySQL server on Google-Cloud-Platform. As you know GCP is very popular and famous platform to use there project.
So we will use to store SQL server on GCP. for that, we need to create a account on GCP and create a project. You can get the account with
the help of this main website of the [Google-Cloud](https://console.cloud.google.com/).

We need to create SQL instances from [here](https://console.cloud.google.com/sql/instances). here you got the project name instance connection 
name which is used in application.properties file. and from here you can create a database by either database section or by connect using **Cloud Shell**.

Before go to start the coding we should have to spring.cloud.gcp.sql.instance-connection-name and spring.cloud.gcp.sql.database-name. 

**Adding dependency : GCP MySQL**

Spring Cloud GCP adds integrations with Spring JDBC so you can run your MySQL databases in Google Cloud SQL using Spring JDBC, or other libraries 
that depend on it like Spring Data JPA.

*Spring-cloud-gcp-starter-sql-mysql* dependency can be taken from [Spring-Cloud](https://cloud.spring.io/spring-cloud-gcp/multi/multi__spring_jdbc.html)

	<!-- Add CloudSQL Starter for MySQL -->
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-gcp-starter-sql-mysql</artifactId>
	</dependency>   
	
**Spring Cloud GCP Bill of Materials (BOM)**

Actually there is no given any version details so we need to manage version through dependencyManagement which is given below:

	<dependencyManagement>
	    <dependencies>
	        <dependency>
	            <groupId>org.springframework.cloud</groupId>
	            <artifactId>spring-cloud-gcp-dependencies</artifactId>
	            <version>1.2.3.RELEASE</version>
	            <type>pom</type>
	            <scope>import</scope>
	        </dependency>
	    </dependencies>
	</dependencyManagement>
	
**Spring Milestones Maven Repository**

The latest non-GA Maven artifacts for the project are only available in the Spring Milestones repository. You will want to make sure that the repository is added to your pom.xml file or globally in your settings.xml file.

	<repositories>
	    <repository>
	        <id>spring-milestones</id>
	        <name>Spring Milestones</name>
	        <url>https://repo.spring.io/milestone</url>
	    </repository>
	</repositories> 

Now we are able to make MySQL connection from you project to GCP. 

**Application.properties**

Needs to mention the sql configuration in applicaiton.properties. Here **instance-connection-name** is that whose we create a project there would be mentioned connection name.
and database name which we had created same time. 

	spring.cloud.gcp.sql.instance-connection-name= vikashmart:asia-south1:mysql-demo-instance
	spring.cloud.gcp.sql.database-name=vikashmart
	
	spring.jpa.hibernate.ddl-auto=create
	
	spring.datasource.username=root
	spring.datasource.password=root

**Authentication**

WE need to authorize or get permission through **google cloud SDK shell** by this commond

		gcloud auth application-default login

**Run Application**

Now, we are good and ready to test our application. So to save or fetch user, I have created three api which is given below:
	
	Post: 'api/user'			// To save user with username and password 
	Get : 'api/user/{username}'	// to find user by username
	Get : 'api/user' // To find all user