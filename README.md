# ids-hiwi-baydoun

* Clone the master branch of the project ;
* setting up postgres database after entering the psql mode on ubuntu terminal ( "sudo -i -u postgres" and then run "psql")
* after that run the script testSet.sql throught the command "\i your_local_path_of_local_repo/testSet.sql"
* create the table with fill.sql script through "\i your_local_path_of_local_repo/fill.sql" command
* import the project to eclipse as maven project ;
* install tomcat server  ;
* add tomcat server to ther servers tab on eclipse;
* Run the server  ;
* To test the fill end point copy the following url to your browser http://localhost:8080/IDS and then press on  the fill link on the page 
* To test the listing endpoint after filling ,copy the following url to your browser http://localhost:8080/IDS/REST/ListWithName


