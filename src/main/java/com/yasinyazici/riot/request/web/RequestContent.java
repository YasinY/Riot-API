package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by Yasin on 19/02/2016.
 * <p>Reads the Input stream request by the method {@link Request#makeRequest()} ()}</p>
 */
public class RequestContent {

    private InputStream stream;


    public RequestContent(InputStream stream) {
        this.stream = stream;
    }

    /**
     * Creates a {@link BufferedReader(new InputStreamReader)} with the {@code stream}, concluding
     * the lines into a {@link String} array, then casting {@link Collectors#joining()} with {@link System#lineSeparator} as parameter
     * concenating each {@link String} in the lines array of {@code stream} resulting into a return of a String displaying the whole
     * lines
     * @return the raw properties of {@link InputStream stream} converted to a String
     */
    public String getContent() throws DataException {
        if(stream == null) {
            throw new DataException("Stream is null!");
        }
        return new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
