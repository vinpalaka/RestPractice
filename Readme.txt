Rest is stateless. That means there is no session saved in the server side.
You have to pass it to the server to retrieve current state.
Rest uses unique uri for calls.
You may also use JSON, xml etc.
You can add new methods etc, it won't break anything.
There is no session data. You can't store things in session.



Pagination: https://developer.atlassian.com/server/confluence/pagination-in-the-rest-api/
https://www.moesif.com/blog/technical/api-design/REST-API-Design-Filtering-Sorting-and-Pagination/
https://www.javatpoint.com/spring-mvc-pagination-example



Soap uses wsdl to make contract between server and client.
Soap can be stateful. Dependent on xml.
Soap, you make a change, then everything has to updated or client/server will break.
WSDL can be used to generate code using IDE's.
You can store things in session so you can share information on differnt pages.

@CookieValue: you need to add cookie to use