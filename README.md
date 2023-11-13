## Camel SOAP Reverse Proxy 
- Description
 
: This example outlines how to implement a reverse proxy that consumes an undertow
  http endpoint and produces to a CXF SOAP http endpoint.

- How To Run

: ``mvn spring-boot:run``

- How to Access
: To access the CXF SOAP endpoint: 
:  https://localhost:8080/cxf/getEntity?wsdl
: To access the http proxy:
: https://localhost:8443/cxf/getEntity?wsdl
 