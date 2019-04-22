# UserController
## post /signup/
### Parameters
	{
		"username":"",
		"password":"",
		"repasswordd":"",
		“name”:"",
		"mail":"",
		"phonenumber":"",
		"age":"",
		"sex":""
	}
### response
code=0 data存在

	{
	"code":"",
	"error_msg":"",
	"data":{
			"username":"",
			“name”:"",
			"mail":"",
			"phonenumber":"",
			"age":"",
			"sex":""
			}
	}


## post /signin/
### Parameters

	{
		"username":"",
		"password":""
	}

### response

	{
	"code":"",
	"error_msg":"",
	"data":{
			"username":"",
			“name”:"",
			"mail":"",
			"phonenumber":"",
			"age":"",
			"sex":""
			}
	}

## post /update

### Parameters

	{
		"username":"",
		"oldusername":"",
		"password":"",
		"oldpassword":"",
		"repasswordd":"",
		“name”:"",
		"mail":"",
		"phonenumber":"",
		"age":"",
		"sex":""
	}

### response

	{
	"code":"",
	"error_msg":"",
	"data":{
			"username":"",
			“name”:"",
			"mail":"",
			"phonenumber":"",
			"age":"",
			"sex":""
			}
	}


# CourseController
## get/courses/
### Parameters
{
	
}
### response

	{

	"code":"",
	"error_msg":"",
	"data":
	[
	{
		"id":"",
		"name":"",
		
		"coachName":"",
		"coachID":"",
		
		"gymName":"",
		"gymID":"",
		"address":"",
		
		"cost":"",
		"content:":"",
		
		"Time":""
	},
	{
		"id":"",
		"name":"",
		
		"coachName":"",
		"coachID":"",
		
		"gymName":"",
		"gymID":"",
		"address":"",
		
		"cost":"",
		"content:":"",
		
		"Time":""
	},
	...
	]
	}
## post/course/
### Parameters
	{
	"id":""
	}
### response
	{
	"code":"",
	"error_msg":"",
	"data":
	{
		"id":"",
		"name":"",
		"coach":
				{
					"id":"",
					"name":"",
					"sex":"",
					"age":"",
					"phoneNumber":"",
					"mail":"",
					"content":""
				},
		"gym":
			{
				"id":"",
				"name":"",
				"address":""
			},
		"cost":"",
		"content:":"",	
		"time":""
	}
	}
## post/mycourses
### Parameters
	{
	"id":""
	}
### response
	{
	"code":"",
	"error_msg":"",
	"data":
	[
	{
		"id":"",
		"name":"",
		
		"coachName":"",
		"coachID":"",
		
		"gymName":"",
		"gymID":"",
		"address":"",
		
		"cost":"",
		"content:":"",
		
		"Time":"",
	},
	{
		"id":"",
		"name":"",
		
		"coachName":"",
		"coachID":"",
		
		"gymName":"",
		"gymID":"",
		"address":"",
		
		"cost":"",
		"content:":"",
		
		"Time":"",
	}
	]
	}
## post/coaches
### Parameters
	{
	"id":"",
	"name":""
	}
### response
	{
	"code":"",
	"error_msg":"",
	"data":
	{
		"id":"",
		"name":"",
		"age":"",
		"sex":"",
		"phoneNumber":"",
		"mail":"",
		"content":"",
		"courses":
		[
		{
			"id":"",
			"name":"",
			
			"coachName":"",
			"coachID":"",
			
			"gymName":"",
			"gymID":"",
			"address":"",
			
			"cost":"",
			"content:":"",
			
			"Time":"",
		},
		{
			"id":"",
			"name":"",
			
			"coachName":"",
			"coachID":"",
			
			"gymName":"",
			"gymID":"",
			"address":"",
			
			"cost":"",
			"content:":"",
			
			"Time":"",
		},
		...
		]
	}
	}