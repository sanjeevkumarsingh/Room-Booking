# Room-Booking
This code has Create and Get REST API with in memory DB and test cases


===========Read Me============

1) It will consume Json and will give output as a Json

      Url : <host>:<port>/api/customer
      Method type : POST
      Payload :
      {
        "id":<Long> //Auto Increment, primary key
        "firstName":<String> max length 50
        "lastName":<String> max length 50
        "password" :<String> length 8-10 
        "email":<String>@<String>.<String> //Unique Key
        "dob": <yyyy-MM-dd>
      }
      Response :
      {
        "id":<Long>,
        "firstName":<String> max length 50,
        "lastName":<String> max length 50,
        "password" :<String> length 8-10,
        "email":<String> <String>@<string>.<charector>,
        "dob": <yyyy-MM-dd>
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

      Url : <host>:<port>/api/customer/{Id}
      Method type : GET
      Response :
      {
        "id":<Long>,
        "firstName":<String> max length 50,
        "lastName":<String> max length 50,
        "password" :<String> length 8-10,
        "email":<String> <String>@<string>.<charector>,
        "dob": <yyyy-MM-dd>
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

==========================Test-Cases======================

It has 13 test cases covering some expected condition check and their expected output status
