# AurosKS-test-task

## **Contents**
1. [Task](#Task)
2. [Features](#Features)
3. [Project structure](#Project-structure)
4. [Technologies](#Technologies)
5. [How to run project](#How-to-run-project)
____

## **Task**

Create a WEB application that allows you to perform operations (Create), read (Read) and
retrieve (Delete) with entities kPac(Knowledge Package) and kPacSet.

[:arrow_up:Contents](#Contents)
____

## **Features**

When you enter the site, you can:
* create/delete K-Pac
* create/delete K-Pacs Set
* add K-Pac to K-Pacs Set
* display all K-Pacs
* display all K-Pacs Sets
* display all K-Pacs by K-Pacs Set id

[:arrow_up:Contents](#Contents)
____

## **Project structure**

### Project built on 3-tier architecture:
1. Data access layer (DAO).
2. Application layer (service).
3. Presentation layer (controllers).

Entities relation: Every K-PAC set can contain multiple K-PACs, every K-PAC can be included
in several K-PAC sets.

[:arrow_up:Contents](#Contents)
____

## **Technologies**

* Java version 11
* Spring core, mvc
* Apache Tomcat (v9.0.50)
* MySQL
* Maven

## **How to run project**

### Tools to run project:
* IntelliJ Idea Ultimate
* Apache Tomcat (v9.0.50)
* MySQL

### How to run
1. Clone this project
2. Add new configuration TomCat Local server
3. Change username and password in db.properties
4. Create schema and tables in MySQL using this [file](src/main/resources/init_db.sql)
5. Insert test data into your DB using this [file](src/main/resources/insert_db.sql)

