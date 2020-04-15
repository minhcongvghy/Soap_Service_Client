package com.vsii;

import com.vsii.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class StudentClient extends WebServiceGatewaySupport {

    public GetStudentByIdResponse getStudentById(long studentId) {
        GetStudentByIdRequest request = new GetStudentByIdRequest();
        request.setStudentId(studentId);
        GetStudentByIdResponse response = (GetStudentByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/getStudentByIdRequest"));
        return response;
    }
    public GetAllStudentsResponse getAllStudents() {
        GetAllStudentsRequest request = new GetAllStudentsRequest();
        GetAllStudentsResponse response = (GetAllStudentsResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/getAllStudentsRequest"));
        return response;
    }
    public AddStudentResponse addStudent(String name, String country) {
        AddStudentRequest request = new AddStudentRequest();
        request.setName(name);
        request.setCountry(country);
        AddStudentResponse response = (AddStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/addStudentRequest"));
        return response;
    }
    public UpdateStudentResponse updateStudent(StudentInfo studentInfo) {
        UpdateStudentRequest request = new UpdateStudentRequest();
        request.setStudentInfo(studentInfo);
        UpdateStudentResponse response = (UpdateStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/updateStudentRequest"));
        return response;
    }
    public DeleteStudentResponse deleteStudent(long studentId) {
        DeleteStudentRequest request = new DeleteStudentRequest();
        request.setStudentId(studentId);
        DeleteStudentResponse response = (DeleteStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/deleteStudentRequest"));
        return response;
    }
}
