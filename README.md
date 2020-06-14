# Room-Booking
This code has Create and Get REST API with in memory DB and test cases


===========Read Me============

1) It will consume Json and will give output as a Json

      Url :/api/customer <br />
      Method type : POST <br />
      Payload :
      {
        "id":LONG //Auto Increment, primary key,
        "firstName":STRING max length 50,
        "lastName":STRING max length 50,
        "password" :STRING length 8-10,
        "email":STRING //Unique Key,
        "dob": DATE //yyyy-MM-dd
      }
      Response :
      {
        "id":LONG //Auto Increment, primary key,
        "firstName":STRING max length 50,
        "lastName":STRING max length 50,
        "password" :STRING length 8-10,
        "email":STRING //Unique Key,
        "dob": DATE //yyyy-MM-dd
      }

      Sample Data Input: 
      {
        "id":101,
        "firstName":"sanjeev",
        "lastName":"singh",
        "password" :"sanjeevb",
        "email":"kmr.sanjev103h@gmail.com",
        "dob":"2020-07-21"
      }

      Sample Data Output:
      {
        "id":101,
        "firstName":"sanjeev",
        "lastName":"singh",
        "password" :"sanjeevb",
        "email":"kmr.sanjev103h@gmail.com",
        "dob":"2020-07-21"
      }


2) It will accept Id as a long datatype and will produce a json.

      Url : /api/customer/{Id} <br />
      Method type : GET <br />
      Response :
      {
        "id":LONG //Auto Increment, primary key,
        "firstName":STRING max length 50,
        "lastName":STRING max length 50,
        "password" :STRING length 8-10,
        "email":STRING //Unique Key,
        "dob": DATE //yyyy-MM-dd
      }

      Sample Url : /api/customer/101
      Sample Data Output:
      {
        "id":101,
        "firstName":"sanjeev",
        "lastName":"singh",
        "password" :"sanjeevb",
        "email":"kmr.sanjev103h@gmail.com",
        "dob":"2020-07-21"
      }

==========================Test-Cases======================

It has 13 test cases covering some expected condition check and their expected output status
