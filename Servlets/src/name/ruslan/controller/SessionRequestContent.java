package name.ruslan.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class SessionRequestContent {
	private HashMap<String, Object> requestAttributes;
	private HashMap<String, String[]> requestParameters;
	private HashMap<String, Object> sessionAttributes;
	
	// ������������
	// ����� ���������� ���������� �� �������
	public void extractValues(HttpServletRequest request) {
	// ����������
	}
	
	// ����� ���������� � ������ ������ ��� �������� � jsp
	public void insertAttributes(HttpServletRequest request) {
	// ����������
	}
	
	// some methods
}
