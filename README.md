# Room-Booking
This code has Create and Get REST API with in memory DB and test cases


===========Read Me============

1) It will consume Json and will give output as a Json

      <b>URL</b> :/api/customer <br />
      <b>Method type</b> : POST <br />
      <b>Payload</b> :
      {
        "id":LONG //Auto Increment, primary key,
        "firstName":STRING max length 50,
        "lastName":STRING max length 50,
        "password" :STRING length 8-10,
        "email":STRING //Unique Key,
        "dob": DATE //yyyy-MM-dd
      }
      <b>Response</b> :
      {
        "id":LONG //Auto Increment, primary key,
        "firstName":STRING max length 50,
        "lastName":STRING max length 50,
        "password" :STRING length 8-10,
        "email":STRING //Unique Key,
        "dob": DATE //yyyy-MM-dd
      }

      <b>Sample Input Data </b>: 
      {
        "id":101,
        "firstName":"sanjeev",
        "lastName":"singh",
        "password" :"sanjeevb",
        "email":"kmr.sanjev103h@gmail.com",
        "dob":"2020-07-21"
      }

     <b> Sample Output Data</b> :
      {
        "id":101,
        "firstName":"sanjeev",
        "lastName":"singh",
        "password" :"sanjeevb",
        "email":"kmr.sanjev103h@gmail.com",
        "dob":"2020-07-21"
      }


2) It will accept Id as a long datatype and will produce a json.

      <b>URL</b> : /api/customer/{Id} <br />
      <b>Method type</b> : GET <br />
      <b>Response</b> :
      {
        "id":LONG //Auto Increment, primary key,
        "firstName":STRING max length 50,
        "lastName":STRING max length 50,
        "password" :STRING length 8-10,
        "email":STRING //Unique Key,
        "dob": DATE //yyyy-MM-dd
      }</br>

      <b>Sample Url</b> : /api/customer/101 </br>
     <b> Sample Data Output</b>:
      {
        "id":101,
        "firstName":"sanjeev",
        "lastName":"singh",
        "password" :"sanjeevb",
        "email":"kmr.sanjev103h@gmail.com",
        "dob":"2020-07-21"
      }

==========================Test-Cases======================

It has some test cases covering some expected condition check and their expected output status



<b>Assumption</b> : <br/><br/>
Id will be auto generated, passing id in json will be ignored, It will return the generated Id,That will used for get API<br/>
firstName/lastName should have only string or blank is allowed.<br/>
Password length must be 8-10 charector.<br/>
Email should have proper validation.<br/>
DOB should have in given format(yyyy-MM-dd) else won't accept.<br/>


