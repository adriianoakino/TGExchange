package com.tg.utils;

import java.util.List;

import org.apache.http.message.BasicNameValuePair;

public class ParameterCollection {
	private List<BasicNameValuePair> parameters;

    public ParameterCollection(List<BasicNameValuePair> parameters) {
        this.parameters = parameters;
    }

    public void add(BasicNameValuePair requestParameter) {
        this.parameters.add(requestParameter);
    }

    public void addAll(BasicNameValuePair... requestParameters) {
        for (BasicNameValuePair p : requestParameters) {
            add(p);
        }
    }

    public List<BasicNameValuePair> getParameters() {
        return parameters;
    }

    public void setParameters(List<BasicNameValuePair> parameters) {
        this.parameters = parameters;
    }
}
