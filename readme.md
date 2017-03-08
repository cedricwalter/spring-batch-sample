Hellow world running in spring batch

This repository exist to show how to integrate spring-batch into your application without too much issues. 
**It was a battle to make this work**, I hope to help some of you by publishing a working example.

## Databases
### Mysql
* Running with mysql? add a `-DENVIRONMENT=mysql` to your JVM
* Adapt database credential in src/main/resources/META-INF/spring/batch/override/data-source-context.xml
* Ensure that `src/main/resources/batch-mysql.properties` exist in classpath
### Oracle
* Running with oracle? add a `-DENVIRONMENT=oracle` to your JVM
* Adapt database credential in src/main/resources/META-INF/spring/batch/override/data-source-context.xml
* Override job-repository so `isolation-level-for-create="READ_COMMITTED"`
* Ensure that `src/main/resources/batch-oracle.properties` exist in classpath

### Initializing datase
Ensure that at leas once in `src/main/resources/batch-oracle.properties` or `src/main/resources/batch-mysql.properties` the key
`batch.data.source.init=true`
or leave it always to false and run manually once the sql file `schema-oracle10g.properties` or `schema-mysql.properties`

## Running spring batch ui not in context path root
so intead of `https://localhost/dev/` you want to run spring batch admin ui in `https://localhost/dev/batch`

adapt web.xml
```<servlet-mapping>
        <servlet-name>Batch Servlet</servlet-name>
        <url-pattern>/batch/*</url-pattern>
</servlet-mapping>
```
and uncomment in `src/main/resources/META-INF/spring/batch/override/servlet-context.xml`
    
## Job
Should be located in `classpath*:/META-INF/spring/jobs/*.xml` one file per job is recommended

## Scheduler
You can use Quartz but Spring > 3.0.2 offer a scheduler. Do not mix job and scheduler in the same file r you may have 2 instances of scheduler
bean running at the same time in UI and in spring context, you can see the tricks in web.xml.

official samples are at 
https://github.com/spring-projects/spring-batch/tree/master/spring-batch-samples